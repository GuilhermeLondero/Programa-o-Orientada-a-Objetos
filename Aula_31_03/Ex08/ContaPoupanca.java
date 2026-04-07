package pkg8;

public class ContaPoupanca extends Conta {
    public ContaPoupanca(double saldo) {
        super(saldo);
    }

    @Override
    public void render() {
        double rendimento = saldo * 0.01;
        saldo += rendimento;
        System.out.printf("Rendimento de 1%%: + R$ %.2f%n", rendimento);
    }
}