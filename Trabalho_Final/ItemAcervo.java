// classe abstrata base de todos os itens do acervo
public abstract class ItemAcervo implements Emprestavel {
    private int codigo;
    private String titulo;
    private boolean disponivel;

    public ItemAcervo(int codigo, String titulo) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.disponivel = true;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    @Override
    public boolean isDisponivel() {
        return disponivel;
    }

    @Override
    public void marcarComoEmprestado() {
        this.disponivel = false;
    }

    @Override
    public void marcarComoDisponivel() {
        this.disponivel = true;
    }

    // cada tipo de item informa o seu nome e a sua multa
    public abstract String getTipo();

    @Override
    public abstract double getMultaPorDia();

    public String descricao() {
        String status = disponivel ? "Disponivel" : "Emprestado";
        return "[" + codigo + "] " + titulo + " (" + getTipo() + ") - " + status;
    }
}