public class ContaCorrente extends ContaBancaria implements Tributavel, TransacaoOnline {
    private static final double TAXA_SAQUE = 5.00;

    public ContaCorrente(String titular) {
        super(titular);
    }

    @Override
    public void sacar(double valor) throws SaldoInsuficienteException {
        double total = valor + TAXA_SAQUE;
        if (total > getSaldo()) {
            throw new SaldoInsuficienteException(
                "Saldo insuficiente para sacar R$ " + valor + " (taxa: R$ " + TAXA_SAQUE + ")"
            );
        }
        debitar(total);
        System.out.println("Saque de R$ " + valor + " realizado (taxa: R$ " + TAXA_SAQUE + ").");
    }

    @Override
    public void calcularImpostos() {
        System.out.println("Calculando impostos da conta corrente...");
    }

    @Override
    public void fazerPix(String chavePix, double valor) {
        System.out.println("Pix de R$ " + valor + " enviado para a chave: " + chavePix);
    }
}