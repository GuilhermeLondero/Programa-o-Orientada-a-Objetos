package pkg7;

public class Smartphone extends Eletronico {
    String modelo;

    public Smartphone(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public void ligar() {
        System.out.println("Smartphone " + modelo + " ligado.");
    }

    public void conectar4G() {
        System.out.println("Conectado à rede 4G.");
    }
}