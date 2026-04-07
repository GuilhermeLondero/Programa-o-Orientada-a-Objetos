package pkg11;

public class Main {
    public static void main(String[] args) {
        ItemMenu item = new ItemMenu("Hambúrguer", 35.90);
        item.exibirInfo();

        System.out.println("---");

        Sobremesa s1 = new Sobremesa("Bolo de Chocolate", 18.00, true);
        Sobremesa s2 = new Sobremesa("Mousse de Limão Zero", 16.00, false);

        s1.exibirInfo();
        System.out.println("---");
        s2.exibirInfo();
    }
}