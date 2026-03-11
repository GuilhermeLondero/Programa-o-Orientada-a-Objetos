package pkg;

import java.util.Scanner;

public class Computadores {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		Computador c1 = new Computador();
		Computador c2 = new Computador();
		
		System.out.println("Digite a marca do 1º computador: ");
		c1.marca = teclado.nextLine();
		System.out.println("Digite o modelo do 1º computador: ");
		c1.modelo = teclado.nextLine();
		System.out.println("Digite o tipo do 1º computador: ");
		c1.tipo = teclado.nextLine();
		System.out.println("Digite o preço do 1º computador: ");
		c1.preco = teclado.nextFloat();
		teclado.nextLine();
		
		System.out.println("O "+c1.tipo+" "+c1.modelo+" da marca "+c1.marca+" custa "+c1.preco);
		System.out.println("O "+c2.tipo+" "+c2.modelo+" da marca "+c2.marca+" custa "+c2.preco);
		
		teclado.close();
	}

}
