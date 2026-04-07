package pkg;

import java.util.Scanner;

public class ConversaoTipos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // --- Conversão String → double ---
        System.out.println("=== Conversão para Double ===");
        try {
            System.out.print("Digite um número decimal (ex: 3.14): ");
            String entradaDouble = scanner.nextLine();
            double valorDouble = Double.parseDouble(entradaDouble);
            System.out.println("Valor convertido para double: " + valorDouble);
        } catch (NumberFormatException e) {
            System.out.println("Erro: não foi possível converter para double. " + e.getMessage());
        }

        // --- Conversão String → int ---
        System.out.println("\n=== Conversão para Inteiro ===");
        try {
            System.out.print("Digite um número inteiro: ");
            String entradaInt = scanner.nextLine();
            int valorInt = Integer.parseInt(entradaInt);
            System.out.println("Valor convertido para int: " + valorInt);
        } catch (NumberFormatException e) {
            System.out.println("Erro: não foi possível converter para int. " + e.getMessage());
        }

        // --- Conversão String → boolean ---
        System.out.println("\n=== Conversão para Boolean ===");
        try {
            System.out.print("Digite true ou false: ");
            String entradaBool = scanner.nextLine().trim().toLowerCase();
            if (!entradaBool.equals("true") && !entradaBool.equals("false")) {
                throw new IllegalArgumentException("Valor inválido para boolean: '" + entradaBool + "'");
            }
            boolean valorBool = Boolean.parseBoolean(entradaBool);
            System.out.println("Valor convertido para boolean: " + valorBool);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            scanner.close();
            System.out.println("\nFim das conversões.");
        }
    }
}