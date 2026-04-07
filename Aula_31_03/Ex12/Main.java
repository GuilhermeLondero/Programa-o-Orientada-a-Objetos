package pkg12;

public class Main {
    public static void main(String[] args) {
        Livro livro = new Livro("Clean Code", "Robert C. Martin");
        livro.exibirInfo();

        System.out.println("---");

        Ebook ebook = new Ebook("O Poder do Hábito", "Charles Duhigg", 3.5);
        ebook.exibirInfo();
    }
}