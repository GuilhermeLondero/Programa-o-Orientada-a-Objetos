package pkg;

import java.util.Scanner;

public class Calculadora {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Digite o primeiro número: ");
            double num1 = Double.parseDouble(scanner.nextLine());

            System.out.print("Digite o operador (+, -, *, /): ");
            String operador = scanner.nextLine().trim();

            System.out.print("Digite o segundo número: ");
            double num2 = Double.parseDouble(scanner.nextLine());

            double resultado = calcular(num1, operador, num2);
            System.out.printf("Resultado: %.2f %s %.2f = %.2f%n", num1, operador, num2, resultado);

        } catch (NumberFormatException e) {
            System.out.println("Erro: digite apenas números válidos (ex: 3.14 ou 10).");
        } catch (ArithmeticException e) {
            System.out.println("Erro de cálculo: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    static double calcular(double num1, String operador, double num2) {
        switch (operador) {
            case "+": return num1 + num2;
            case "-": return num1 - num2;
            case "*": return num1 * num2;
            case "/":
                if (num2 == 0) {
                    throw new ArithmeticException("Divisão por zero não é permitida.");
                }
                return num1 / num2;
            default:
                throw new IllegalArgumentException("Operador inválido: '" + operador + "'. Use +, -, * ou /.");
        }
    }
}