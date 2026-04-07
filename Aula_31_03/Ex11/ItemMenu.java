package pkg11;

public class ItemMenu {
    String nome;
    double preco;

    public ItemMenu(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public void exibirInfo() {
        System.out.println("Item: " + nome + " | Preço: R$ " + preco);
    }
}