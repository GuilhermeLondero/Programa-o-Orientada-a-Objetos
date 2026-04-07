import pkg1.Animal;
import pkg1.Cachorro;
import pkg1.Gato;
import pkg2.Pessoa;
import pkg2.Aluno;
import pkg3.Veiculo;
import pkg3.Carro;
import pkg4.Funcionario;
import pkg4.Gerente;
import pkg4.Vendedor;
import pkg5.Produto;
import pkg5.ProdutoEletronico;
import pkg6.Forma;
import pkg6.Circulo;
import pkg7.Eletronico;
import pkg7.Smartphone;
import pkg8.Conta;
import pkg8.ContaPoupanca;
import pkg10.Instrumento;
import pkg10.Violao;
import pkg10.Piano;
import pkg11.ItemMenu;
import pkg11.Sobremesa;
import pkg12.Livro;
import pkg12.Ebook;

public class MainGeral {

    static void titulo(String texto) {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("  " + texto);
        System.out.println("=".repeat(50));
    }

    public static void main(String[] args) {

        titulo("EX01 - Animal, Cachorro, Gato");
        Animal animal = new Animal();
        Animal cachorro = new Cachorro();
        Animal gato = new Gato();
        animal.emitirSom();
        cachorro.emitirSom();
        gato.emitirSom();

        titulo("EX02 - Pessoa e Aluno");
        Aluno alunoEx02 = new Aluno("Guilherme", 24, "2024001");
        alunoEx02.exibirDados();

        titulo("EX03 - Veiculo e Carro");
        Carro carro = new Carro(0);
        carro.acelerar(50);
        carro.acelerar(30);

        titulo("EX04 - Funcionario, Gerente, Vendedor");
        Funcionario f = new Funcionario("Funcionario Padrao");
        Gerente g = new Gerente("Ana");
        Vendedor v = new Vendedor("Bruno", 1500.0);
        System.out.println("Funcionario Padrao - Salario: R$ " + f.calcularSalario());
        System.out.println("Ana (Gerente)      - Salario: R$ " + g.calcularSalario());
        System.out.println("Bruno (Vendedor)   - Salario: R$ " + v.calcularSalario());

        titulo("EX05 - Produto e ProdutoEletronico");
        Produto p = new Produto("Caneta", 5.99);
        ProdutoEletronico pe = new ProdutoEletronico("Notebook", 4500.00, 12);
        p.exibirInfo();
        pe.exibirInfo();

        titulo("EX06 - Forma e Circulo");
        Circulo c = new Circulo("Vermelho", 5.0);
        c.exibirInfo();

        titulo("EX07 - Eletronico e Smartphone");
        Eletronico e = new Eletronico();
        e.ligar();
        Smartphone s = new Smartphone("Galaxy S23");
        s.ligar();
        s.conectar4G();

        titulo("EX08 - Conta e ContaPoupanca");
        Conta conta = new Conta(1000.0);
        conta.exibirSaldo();
        conta.render();
        conta.exibirSaldo();
        ContaPoupanca cp = new ContaPoupanca(1000.0);
        cp.exibirSaldo();
        cp.render();
        cp.exibirSaldo();

        titulo("EX09 - Aluno com toString()");
        pkg9.Aluno alunoEx09 = new pkg9.Aluno("Guilherme", 24, "2024001");
        System.out.println(alunoEx09);

        titulo("EX10 - Instrumento, Violao, Piano");
        Instrumento inst = new Instrumento();
        Violao violao = new Violao();
        Piano piano = new Piano();
        inst.tocar();
        violao.tocar();
        piano.tocar();

        titulo("EX11 - ItemMenu e Sobremesa");
        ItemMenu item = new ItemMenu("Hamburguer", 35.90);
        item.exibirInfo();
        Sobremesa sob = new Sobremesa("Bolo de Chocolate", 18.00, true);
        sob.exibirInfo();

        titulo("EX12 - Livro e Ebook");
        Livro livro = new Livro("Clean Code", "Robert C. Martin");
        livro.exibirInfo();
        Ebook ebook = new Ebook("O Poder do Habito", "Charles Duhigg", 3.5);
        ebook.exibirInfo();

        titulo("PARTE 2 - Excecoes (sem input do usuario)");
        try {
            String texto = null;
            System.out.println(texto.length());
        } catch (NullPointerException ex) {
            System.out.println("[NullPointerException] Objeto null capturado.");
        }
        try {
            int[] nums = {10, 20, 30};
            System.out.println(nums[5]);
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("[ArrayIndexOutOfBoundsException] " + ex.getMessage());
        }
        try {
            Integer.parseInt("abc");
        } catch (NumberFormatException ex) {
            System.out.println("[NumberFormatException] " + ex.getMessage());
        }
        try {
            int r = 10 / 0;
        } catch (ArithmeticException ex) {
            System.out.println("[ArithmeticException] " + ex.getMessage());
        }
        try {
            infinito(1);
        } catch (StackOverflowError ex) {
            System.out.println("[StackOverflowError] Recursao infinita detectada.");
        }

        System.out.println("\n" + "=".repeat(50));
        System.out.println("  TODOS OS TESTES CONCLUIDOS!");
        System.out.println("=".repeat(50));
    }

    static void infinito(int n) { infinito(n + 1); }
}