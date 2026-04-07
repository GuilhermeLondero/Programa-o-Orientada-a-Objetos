package pkg5;

public class ProdutoEletronico extends Produto {
    int garantiaMeses;

    public ProdutoEletronico(String nome, double preco, int garantiaMeses) {
        super(nome, preco);
        this.garantiaMeses = garantiaMeses;
    }

    @Override
    public void exibirInfo() {
        super.exibirInfo();
        System.out.println("Garantia: " + garantiaMeses + " meses");
    }
}