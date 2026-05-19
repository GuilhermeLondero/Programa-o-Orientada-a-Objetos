public abstract class ContaBancaria {
    private String titular;
    private double saldo;

    public ContaBancaria(String titular) {
        this.titular = titular;
        this.saldo = 0.0;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor de depósito inválido");
        }
        saldo += valor;
        System.out.println("Depósito de R$ " + valor + " realizado.");
    }

    public abstract void sacar(double valor) throws SaldoInsuficienteException;

    protected void debitar(double valor) {
        saldo -= valor;
    }
}