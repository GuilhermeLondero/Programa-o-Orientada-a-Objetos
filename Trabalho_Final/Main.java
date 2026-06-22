import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static Biblioteca biblioteca = new Biblioteca();

    public static void main(String[] args) {
        carregarDadosIniciais();

        int opcao = -1;
        while (opcao != 0) {
            mostrarMenu();
            opcao = lerInteiro("Escolha uma opcao: ");

            switch (opcao) {
                case 1: listarItens(); break;
                case 2: listarUsuarios(); break;
                case 3: cadastrarItem(); break;
                case 4: cadastrarUsuario(); break;
                case 5: realizarEmprestimo(); break;
                case 6: realizarDevolucao(); break;
                case 7: listarEmprestimos(); break;
                case 0: System.out.println("Encerrando o sistema."); break;
                default: System.out.println("Opcao invalida.");
            }
        }

        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("\n--- BiblioTech ---");
        System.out.println("1 - Listar itens");
        System.out.println("2 - Listar usuarios");
        System.out.println("3 - Cadastrar item");
        System.out.println("4 - Cadastrar usuario");
        System.out.println("5 - Realizar emprestimo");
        System.out.println("6 - Realizar devolucao");
        System.out.println("7 - Listar emprestimos");
        System.out.println("0 - Sair");
    }

    // le um inteiro tratando entrada invalida
    private static int lerInteiro(String mensagem) {
        System.out.print(mensagem);
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Valor invalido, digite um numero inteiro.");
            return -1;
        }
    }

    private static void listarItens() {
        System.out.println("\n--- Itens do acervo ---");
        if (biblioteca.getItens().isEmpty()) {
            System.out.println("Nenhum item cadastrado.");
            return;
        }
        // a mesma lista trata Livro, Periodico e MidiaDigital (polimorfismo)
        for (ItemAcervo item : biblioteca.getItens()) {
            System.out.println(item.descricao());
        }
    }

    private static void listarUsuarios() {
        System.out.println("\n--- Usuarios ---");
        if (biblioteca.getUsuarios().isEmpty()) {
            System.out.println("Nenhum usuario cadastrado.");
            return;
        }
        for (Usuario u : biblioteca.getUsuarios()) {
            System.out.println(u.descricao());
        }
    }

    private static void listarEmprestimos() {
        System.out.println("\n--- Emprestimos ---");
        if (biblioteca.getEmprestimos().isEmpty()) {
            System.out.println("Nenhum emprestimo registrado.");
            return;
        }
        for (Emprestimo e : biblioteca.getEmprestimos()) {
            System.out.println(e.descricao());
        }
    }

    private static void cadastrarItem() {
        System.out.println("Tipo: 1-Livro  2-Periodico  3-Midia Digital");
        int tipo = lerInteiro("Escolha o tipo: ");
        int codigo = lerInteiro("Codigo: ");
        System.out.print("Titulo: ");
        String titulo = scanner.nextLine();

        ItemAcervo item;
        switch (tipo) {
            case 1:
                System.out.print("Autor: ");
                String autor = scanner.nextLine();
                int ano = lerInteiro("Ano: ");
                item = new Livro(codigo, titulo, autor, ano);
                break;
            case 2:
                int edicao = lerInteiro("Edicao: ");
                item = new Periodico(codigo, titulo, edicao);
                break;
            case 3:
                System.out.print("Formato (DVD, MP3, PDF...): ");
                String formato = scanner.nextLine();
                item = new MidiaDigital(codigo, titulo, formato);
                break;
            default:
                System.out.println("Tipo invalido.");
                return;
        }
        biblioteca.adicionarItem(item);
        System.out.println("Item cadastrado.");
    }

    private static void cadastrarUsuario() {
        System.out.println("Tipo: 1-Aluno  2-Professor  3-Funcionario");
        int tipo = lerInteiro("Escolha o tipo: ");
        int matricula = lerInteiro("Matricula: ");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        Usuario usuario;
        switch (tipo) {
            case 1:
                System.out.print("Curso: ");
                usuario = new Aluno(matricula, nome, scanner.nextLine());
                break;
            case 2:
                System.out.print("Departamento: ");
                usuario = new Professor(matricula, nome, scanner.nextLine());
                break;
            case 3:
                System.out.print("Setor: ");
                usuario = new Funcionario(matricula, nome, scanner.nextLine());
                break;
            default:
                System.out.println("Tipo invalido.");
                return;
        }
        biblioteca.adicionarUsuario(usuario);
        System.out.println("Usuario cadastrado.");
    }

    private static void realizarEmprestimo() {
        int codigo = lerInteiro("Codigo do item: ");
        int matricula = lerInteiro("Matricula do usuario: ");

        // try-catch-finally com as excecoes customizadas
        try {
            Emprestimo e = biblioteca.emprestar(codigo, matricula);
            System.out.println("Emprestimo realizado. Devolucao prevista para " + e.getDataPrevista() + ".");
        } catch (ItemIndisponivelException | LimiteEmprestimoException | EntidadeNaoEncontradaException ex) {
            System.out.println("Nao foi possivel emprestar: " + ex.getMessage());
        } finally {
            System.out.println("Operacao de emprestimo finalizada.");
        }
    }

    private static void realizarDevolucao() {
        int codigo = lerInteiro("Codigo do item devolvido: ");
        System.out.print("Data de devolucao (dd/MM/yyyy) ou Enter para hoje: ");
        String texto = scanner.nextLine();

        LocalDate data;
        if (texto.isBlank()) {
            data = LocalDate.now();
        } else {
            try {
                DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                data = LocalDate.parse(texto, formato);
            } catch (Exception e) {
                System.out.println("Data invalida, usando a data de hoje.");
                data = LocalDate.now();
            }
        }

        try {
            double multa = biblioteca.devolver(codigo, data);
            if (multa > 0) {
                System.out.printf("Item devolvido com atraso. Multa: R$ %.2f%n", multa);
            } else {
                System.out.println("Item devolvido no prazo. Sem multa.");
            }
        } catch (EntidadeNaoEncontradaException e) {
            System.out.println(e.getMessage());
        }
    }

    // dados exemplos
    private static void carregarDadosIniciais() {
        biblioteca.adicionarItem(new Livro(1, "Engenharia de Software", "Sommerville", 2011));
        biblioteca.adicionarItem(new Livro(2, "Java Como Programar", "Deitel")); // usa o construtor sobrecarregado
        biblioteca.adicionarItem(new Periodico(3, "Revista Tech", 42));
        biblioteca.adicionarItem(new MidiaDigital(4, "Curso de Algoritmos", "MP4"));

        biblioteca.adicionarUsuario(new Aluno(100, "Maria", "Sistemas de Informacao"));
        biblioteca.adicionarUsuario(new Professor(200, "Carlos", "Computacao"));
        biblioteca.adicionarUsuario(new Funcionario(300, "Ana", "Biblioteca"));
    }
}