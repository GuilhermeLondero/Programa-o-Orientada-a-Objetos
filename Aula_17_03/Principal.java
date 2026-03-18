package pkg;
import java.util.Scanner;

public class Principal {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Quantos carros deseja cadastrar? ");
		int quantidade = teclado.nextInt();
		
		Carro[] carros = new Carro[quantidade];
		
		for(int i = 0 ; i < quantidade ; i++) {
			carros[i] = new Carro();
			
			System.out.print("Marca do carro: ");
			carros[i].marca = teclado.next();

			System.out.print("Modelo do carro: ");
			carros[i].modelo = teclado.next();

			System.out.print("Ano de fabricação do carro: ");
			carros[i].anoFabricacao = teclado.nextInt();
		}
		for (int i = 0 ; i < quantidade; i++) {
			carros[i].exibir();
		}
		teclado.close();
	}
}