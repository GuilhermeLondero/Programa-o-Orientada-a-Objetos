package pkg4;

public class Vendedor extends Funcionario {
    double comissao;

    public Vendedor(String nome, double comissao) {
        super(nome);
        this.comissao = comissao;
    }

    @Override
    public double calcularSalario() {
        return 3000.0 + comissao;
    }
}