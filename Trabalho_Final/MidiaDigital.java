public class MidiaDigital extends ItemAcervo {
    private String formato;

    public MidiaDigital(int codigo, String titulo, String formato) {
        super(codigo, titulo);
        this.formato = formato;
    }

    public String getFormato() {
        return formato;
    }

    @Override
    public String getTipo() {
        return "Midia Digital";
    }

    @Override
    public double getMultaPorDia() {
        return 2.0;
    }
}