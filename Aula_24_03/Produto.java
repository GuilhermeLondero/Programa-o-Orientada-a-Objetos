public class Produto {
    private String nome;              // opcional, mas boa prática ter nome
    private int quantidadeEmEstoque;

    public Produto(String nome, int quantidadeInicial) {
        this.nome = nome;
        this.quantidadeEmEstoque = quantidadeInicial;
    }

    public String getNome() { return nome; }

    public int getQuantidadeEmEstoque() {
        return quantidadeEmEstoque;
    }

    // Adicionar: soma diretamente (assume qtd positivo)
    public void adicionarEstoque(int qtd) {
        if (qtd > 0) {
            quantidadeEmEstoque += qtd;  // equivale a: quantidadeEmEstoque = quantidadeEmEstoque + qtd
        }
    }

    // Remover: subtrai SOMENTE se não zerar negativamente
    public void removerEstoque(int qtd) {
        if (qtd > 0 && qtd <= quantidadeEmEstoque) {
            quantidadeEmEstoque -= qtd;
        }
        // Se qtd > estoque: não faz nada, estoque não fica negativo
    }
}