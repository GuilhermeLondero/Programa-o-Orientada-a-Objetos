package pkg3;

public class Carro extends Veiculo {
    public Carro(int velocidade) {
        super(velocidade);
    }

    public void acelerar(int incremento) {
        velocidade += incremento;
        System.out.println("Acelerando! Velocidade atual: " + velocidade + " km/h");
    }
}