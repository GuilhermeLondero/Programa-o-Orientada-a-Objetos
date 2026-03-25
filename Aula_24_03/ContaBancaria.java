public class ContaBancaria {
    private double saldo;
    private double limite;

    public ContaBancaria(double saldo, double limite) {
        this.saldo = saldo;
        setLimite(limite);
    }

    public double getSaldo() { return saldo; }
    public double getLimite() { return limite; }

    public void setLimite(double limite) {
        if (limite >= 0) {
            this.limite = limite;
        }
    }

    public boolean sacar(double valor) {
        if (valor <= saldo + limite) {
            saldo -= valor;
            return true;
        }
        return false;
    }
}