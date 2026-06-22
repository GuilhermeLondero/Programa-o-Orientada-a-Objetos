public class Livro extends ItemAcervo {
    private String autor;
    private int ano;

    // construtor completo
    public Livro(int codigo, String titulo, String autor, int ano) {
        super(codigo, titulo);
        this.autor = autor;
        this.ano = ano;
    }

    // construtor sobrecarregado, sem o ano
    public Livro(int codigo, String titulo, String autor) {
        this(codigo, titulo, autor, 0);
    }

    public String getAutor() {
        return autor;
    }

    public int getAno() {
        return ano;
    }

    @Override
    public String getTipo() {
        return "Livro";
    }

    @Override
    public double getMultaPorDia() {
        return 1.0;
    }
}