# BiblioTech

Sistema de gerenciamento de acervo e empréstimos de uma biblioteca universitária, desenvolvido em Java como trabalho final da disciplina de Programação Orientada a Objetos.

- **Instituição:** Universidade Franciscana (UFN)
- **Curso:** Sistemas de Informação
- **Disciplina:** Programação Orientada a Objetos
- **Professor:** Rafael Bisogno
- **Aluno:** Guilherme Londero de Souza

## Tema e descrição do sistema

O BiblioTech controla o acervo e os empréstimos de uma biblioteca universitária. O sistema trabalha com três tipos de itens (livros, periódicos e mídias digitais) e três perfis de usuário (alunos, professores e funcionários).

O problema que ele resolve é comum em bibliotecas que ainda usam planilhas ou fichas de papel: não saber em tempo real o que está disponível, não respeitar os prazos diferentes de cada perfil de usuário, errar no cálculo de multa e perder o histórico de quem pegou cada item. O BiblioTech organiza tudo isso em um fluxo único.

Funcionalidades principais:

- Cadastro de itens (livro, periódico, mídia digital) e de usuários (aluno, professor, funcionário).
- Empréstimo com prazo automático conforme o perfil do usuário (aluno 7 dias, funcionário 15 dias, professor 30 dias).
- Limite de empréstimos por perfil, impedindo que um usuário passe do permitido.
- Devolução com cálculo automático de multa por atraso, usando um valor por dia diferente para cada tipo de item.
- Listagem de itens, usuários e empréstimos.
- Bloqueio de operações inválidas (emprestar item já emprestado, usuário acima do limite, buscar item/usuário que não existe), tratado por exceções próprias.

A aplicação roda no terminal, por meio de um menu simples, e mantém todos os dados em memória durante a execução.

O sistema já inicia com alguns itens e usuários de exemplo, então é possível testar os empréstimos e devoluções na hora. Para ver a multa funcionando, faça um empréstimo e depois informe uma data de devolução bem à frente do prazo.

## Estrutura dos arquivos

| Arquivo | Funcionalidade |
|---|---|
| `Main.java` | Menu do terminal e dados iniciais de teste |
| `Biblioteca.java` | Regras de negócio e armazenamento em memória |
| `Emprestavel.java` | Interface dos itens que podem ser emprestados |
| `ItemAcervo.java` | Classe abstrata base dos itens |
| `Livro.java`, `Periodico.java`, `MidiaDigital.java` | Tipos de item do acervo |
| `Usuario.java` | Classe abstrata base dos usuários |
| `Aluno.java`, `Professor.java`, `Funcionario.java` | Perfis de usuário |
| `Emprestimo.java` | Registro de um empréstimo e cálculo de multa |
| `ItemIndisponivelException.java`, `LimiteEmprestimoException.java`, `EntidadeNaoEncontradaException.java` | Exceções próprias do sistema |

## Mapeamento dos 7 pré-requisitos

### 1. Classes, objetos e atributos
As entidades do problema estão modeladas em classes próprias: `Livro`, `Periodico`, `MidiaDigital`, `Aluno`, `Professor`, `Funcionario`, `Emprestimo` e `Biblioteca`. Cada uma tem atributos com tipos adequados (por exemplo, `int codigo`, `String titulo`, `boolean disponivel`). Os objetos são criados no método `carregarDadosIniciais()` da classe `Main`, que instancia vários itens e usuários antes do menu começar.

### 2. Construtores (com sobrecarga)
Todas as classes inicializam seus objetos em um estado válido pelo construtor. A sobrecarga aparece na classe `Livro`, que tem dois construtores: um completo, com código, título, autor e ano, e outro sem o ano, que chama o primeiro com `this(...)`. As classes abstratas `ItemAcervo` e `Usuario` também têm construtores, chamados pelas subclasses através de `super(...)`.

### 3. Encapsulamento e modificadores de acesso
Todos os atributos são `private` e o acesso a eles é feito por getters. Além disso, o estado dos objetos só muda através de métodos de negócio que validam antes de alterar. Por exemplo, na classe `Biblioteca`, o método `emprestar()` confere se o item está disponível e se o usuário está dentro do limite antes de marcar o item como emprestado. A disponibilidade de um item só é alterada pelos métodos `marcarComoEmprestado()` e `marcarComoDisponivel()`, em `ItemAcervo`.

### 4. Herança
O sistema tem duas hierarquias claras com a relação "é um":

- `Livro`, `Periodico` e `MidiaDigital` herdam de `ItemAcervo` (um livro **é um** item do acervo).
- `Aluno`, `Professor` e `Funcionario` herdam de `Usuario` (um aluno **é um** usuário).

As subclasses reaproveitam os atributos e métodos da superclasse e adicionam o que é específico de cada tipo.

### 5. Polimorfismo
As subclasses reescrevem (override) métodos da superclasse para terem comportamento próprio: `getMultaPorDia()` em cada tipo de item e `getPrazoDias()`, `getLimiteEmprestimos()` e `getTipo()` em cada tipo de usuário. O polimorfismo de inclusão aparece na classe `Biblioteca`, que guarda os dados em `ArrayList<ItemAcervo>` e `ArrayList<Usuario>` e trata todos os tipos pelo tipo da superclasse. A classe `Emprestimo` também usa isso: ela chama `usuario.getPrazoDias()` e `item.getMultaPorDia()` sem precisar saber qual é o tipo concreto.

### 6. Classes abstratas e interfaces
- **Interface:** `Emprestavel` define o contrato dos itens que podem ser emprestados (`isDisponivel`, `marcarComoEmprestado`, `marcarComoDisponivel`, `getMultaPorDia`). Ela é implementada por `ItemAcervo`.
- **Classes abstratas:** `ItemAcervo` e `Usuario` servem de base conceitual e não podem ser instanciadas diretamente. Cada uma tem pelo menos um método abstrato (`getTipo()` e `getMultaPorDia()` em `ItemAcervo`; `getPrazoDias()`, `getLimiteEmprestimos()` e `getTipo()` em `Usuario`), que obriga cada subclasse a definir o seu próprio comportamento.

### 7. Tratamento de exceções
O sistema usa `try-catch-finally` no método `realizarEmprestimo()` da `Main`, onde o `finally` sempre informa que a operação terminou. Há também `try-catch` na leitura de números (`lerInteiro()`) e na conversão da data de devolução, evitando que uma entrada errada quebre o programa. Por fim, foram criadas três exceções próprias para proteger as regras de negócio:

- `ItemIndisponivelException`, lançada ao tentar emprestar um item já emprestado.
- `LimiteEmprestimoException`, lançada quando o usuário já atingiu o limite de empréstimos.
- `EntidadeNaoEncontradaException`, lançada ao buscar um item ou usuário que não existe.