package pkg;

public class Carro {
	
    String marca;
    String modelo;
    int anoFabricacao;

    public void exibir() {
        System.out.println(
            "Marca: " + marca +
            ", Modelo: " + modelo +
            ", Ano de fabricação: " + anoFabricacao
        );
    }
}