package pkg6;

public class Circulo extends Forma {
    double raio;

    public Circulo(String cor, double raio) {
        super(cor);
        this.raio = raio;
    }

    public double calcularArea() {
        return Math.PI * raio * raio;
    }

    public void exibirInfo() {
        System.out.println("Cor: " + cor);
        System.out.println("Raio: " + raio);
        System.out.printf("Área: %.2f%n", calcularArea());
    }
}