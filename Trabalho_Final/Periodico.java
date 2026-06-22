public class Periodico extends ItemAcervo {
    private int edicao;

    public Periodico(int codigo, String titulo, int edicao) {
        super(codigo, titulo);
        this.edicao = edicao;
    }

    public int getEdicao() {
        return edicao;
    }

    @Override
    public String getTipo() {
        return "Periodico";
    }

    @Override
    public double getMultaPorDia() {
        return 0.5;
    }
}