public class LimiteEmprestimoException extends Exception {
    private int limite;

    public LimiteEmprestimoException(String mensagem, int limite) {
        super(mensagem);
        this.limite = limite;
    }

    public int getLimite() {
        return limite;
    }
}