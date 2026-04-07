package pkg3;

public class Main {
    public static void main(String[] args) {
        Carro carro = new Carro(0);
        System.out.println("Velocidade inicial: " + carro.velocidade + " km/h");
        carro.acelerar(50);
        carro.acelerar(30);
    }
}