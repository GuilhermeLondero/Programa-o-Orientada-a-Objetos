package pkg4;

public class Main {
    public static void main(String[] args) {
        Funcionario f = new Funcionario("Funcionário Padrão");
        Gerente g = new Gerente("Ana");
        Vendedor v = new Vendedor("Bruno", 1500.0);

        System.out.println(f.nome + " - Salário: R$ " + f.calcularSalario());
        System.out.println(g.nome + " - Salário: R$ " + g.calcularSalario());
        System.out.println(v.nome + " - Salário: R$ " + v.calcularSalario());
    }
}