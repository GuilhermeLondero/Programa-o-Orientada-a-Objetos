package pkg;

import java.util.Scanner;

public class RaizQuadrada {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Digite um número inteiro: ");
            String entrada = scanner.nextLine();
            int numero = Integer.parseInt(entrada);

            if (numero < 0) {
                throw new ArithmeticException("Não é possível calcular a raiz quadrada de um número negativo.");
            }

            double resultado = Math.sqrt(numero);
            System.out.printf("Raiz quadrada de %d = %.2f%n", numero, resultado);

        } catch (NumberFormatException e) {
            System.out.println("Erro: valor inválido. Digite apenas números inteiros.");
        } catch (ArithmeticException e) {
            System.out.println("Erro aritmético: " + e.getMessage());
        } finally {
            scanner.close();
            System.out.println("Programa encerrado.");
        }
    }
}