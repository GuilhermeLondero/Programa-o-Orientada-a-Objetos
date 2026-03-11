package pkg;

import java.util.Scanner;

public class Alunos {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        Aluno a1 = new Aluno();

        System.out.println("Digite o nome do aluno: ");
        a1.nome = teclado.nextLine();
        System.out.println("Digite a matrícula do aluno: ");
        a1.matricula = teclado.nextLine();
        System.out.println("Digite a nota 1: ");
        a1.nota1 = teclado.nextFloat();
        System.out.println("Digite a nota 2: ");
        a1.nota2 = teclado.nextFloat();
        System.out.println("Digite a nota 3: ");
        a1.nota3 = teclado.nextFloat();

        float media = (a1.nota1 + a1.nota2 + a1.nota3) / 3;

        System.out.println("Aluno: "+a1.nome+", Matrícula: "+a1.matricula);
        System.out.println("Notas: "+a1.nota1+", "+a1.nota2+", "+a1.nota3);
        System.out.println("Média: "+media);

        if (media >= 6) {
            System.out.println("Situação: Aprovado");
        } else {
            System.out.println("Situação: Reprovado");
        }

        teclado.close();
    }
}