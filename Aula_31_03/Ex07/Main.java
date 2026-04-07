package pkg7;

public class Main {
    public static void main(String[] args) {
        Eletronico e = new Eletronico();
        e.ligar();

        System.out.println("---");

        Smartphone s = new Smartphone("Galaxy S23");
        s.ligar();
        s.conectar4G();
    }
}