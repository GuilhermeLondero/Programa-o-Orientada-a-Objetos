package pkg8;

public class Main {
    public static void main(String[] args) {
        Conta c = new Conta(1000.0);
        c.exibirSaldo();
        c.render();
        c.exibirSaldo();

        System.out.println("---");

        ContaPoupanca cp = new ContaPoupanca(1000.0);
        cp.exibirSaldo();
        cp.render();
        cp.exibirSaldo();
    }
}