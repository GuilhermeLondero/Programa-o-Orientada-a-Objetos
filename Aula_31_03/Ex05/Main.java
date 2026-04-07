package pkg5;

public class Main {
    public static void main(String[] args) {
        Produto p = new Produto("Caneta", 5.99);
        ProdutoEletronico pe = new ProdutoEletronico("Notebook", 4500.00, 12);

        p.exibirInfo();
        System.out.println("---");
        pe.exibirInfo();
    }
}