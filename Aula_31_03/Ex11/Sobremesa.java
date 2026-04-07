package pkg11;

public class Sobremesa extends ItemMenu {
    boolean contemAcucar;

    public Sobremesa(String nome, double preco, boolean contemAcucar) {
        super(nome, preco);
        this.contemAcucar = contemAcucar;
    }

    @Override
    public void exibirInfo() {
        super.exibirInfo();
        System.out.println("Contém açúcar: " + (contemAcucar ? "Sim" : "Não"));
    }
}