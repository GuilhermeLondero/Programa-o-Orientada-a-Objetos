package pkg;

import java.util.Scanner;

public class Carros {

	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);
		
		Carro c1 = new Carro();
		
		System.out.println("Digite a marca do 1º carro: ");
		c1.marca = teclado.nextLine();
		System.out.println("Digite o modelo do 1º carro: ");
		c1.modelo = teclado.nextLine();
		System.out.println("Digite o ano de fabricação do 1º carro: ");
		c1.anoFabricacao = teclado.nextInt();
		teclado.nextLine();
		
		Carro c2 = new Carro();
		
		System.out.println("Digite a marca do 2º carro: ");
		c2.marca = teclado.nextLine();
		teclado.nextLine();
		System.out.println("Digite o modelo do 2º carro: ");
		c2.modelo = teclado.nextLine();
		System.out.println("Digite o ano de fabricação do 2º carro: ");
		c2.anoFabricacao = teclado.nextInt();
		
		System.out.println("O modelo "+c1.modelo+" da marca "+c1.marca+" foi fabricado em "+c1.anoFabricacao);
		System.out.println("O modelo "+c2.modelo+" da marca "+c2.marca+" foi fabricado em "+c2.anoFabricacao);
		
		teclado.close();
		
	}

}
