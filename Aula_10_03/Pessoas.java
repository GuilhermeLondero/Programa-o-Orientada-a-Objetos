package pkg;

import java.util.Scanner;

public class Pessoas {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        Pessoa p1 = new Pessoa();

        System.out.println("Digite o nome da pessoa: ");
        p1.nome = teclado.nextLine();
        System.out.println("Digite a idade da pessoa: ");
        p1.idade = teclado.nextInt();
        teclado.nextLine();
        System.out.println("Digite o gênero da pessoa: ");
        p1.genero = teclado.nextLine();

        System.out.println("Nome: "+p1.nome+", Idade: "+p1.idade+", Gênero: "+p1.genero);

        teclado.close();
    }
}