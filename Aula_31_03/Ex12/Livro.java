package pkg12;

public class Livro {
    String titulo;
    String autor;

    public Livro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
    }

    public void exibirInfo() {
        System.out.println("Título: " + titulo + " | Autor: " + autor);
    }
}