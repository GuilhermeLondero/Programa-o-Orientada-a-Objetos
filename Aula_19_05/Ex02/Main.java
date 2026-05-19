public class Main {
    public static void main(String[] args) {
        ContaCorrente conta = new ContaCorrente("João");

        conta.depositar(1000.0);
        System.out.println("Saldo atual: R$ " + conta.getSaldo());

        try {
            conta.sacar(2000.0);
        } catch (SaldoInsuficienteException e) {
            System.out.println("Erro no saque: " + e.getMessage());
        }

        try {
            conta.depositar(-100.0);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro no depósito: " + e.getMessage());
        }

        try {
            conta.sacar(500.0);
            System.out.println("Saldo final: R$ " + conta.getSaldo());
        } catch (SaldoInsuficienteException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        conta.calcularImpostos();
        conta.fazerPix("joao@email.com", 200.0);
    }
}