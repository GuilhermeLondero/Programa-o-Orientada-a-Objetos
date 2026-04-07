package pkg8;

public class Conta {
    double saldo;

    public Conta(double saldo) {
        this.saldo = saldo;
    }

    public void render() {
        System.out.println("Conta comum não rende.");
    }

    public void exibirSaldo() {
        System.out.printf("Saldo: R$ %.2f%n", saldo);
    }
}