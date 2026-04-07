package pkg;

import java.util.ArrayList;

public class ExcecoesComuns {

    public static void main(String[] args) {

        System.out.println("======= EXEMPLO 1: NullPointerException =======");
        // Ocorre ao tentar usar um objeto que é null
        try {
            String texto = null;
            System.out.println(texto.length());
        } catch (NullPointerException e) {
            System.out.println("Erro: tentou usar um objeto null.");
        }

        System.out.println("\n======= EXEMPLO 2: ArrayIndexOutOfBoundsException =======");
        // Ocorre ao acessar um índice inexistente de um array
        try {
            int[] numeros = {10, 20, 30};
            System.out.println(numeros[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Erro: índice fora dos limites do array.");
            System.out.println("Detalhe: " + e.getMessage());
        }

        System.out.println("\n======= EXEMPLO 3: NumberFormatException =======");
        // Ocorre ao converter uma String inválida para número
        try {
            String valor = "abc";
            int numero = Integer.parseInt(valor);
        } catch (NumberFormatException e) {
            System.out.println("Erro: string não pode ser convertida para número.");
            System.out.println("Detalhe: " + e.getMessage());
        }

        System.out.println("\n======= EXEMPLO 4: ArithmeticException =======");
        // Ocorre em operações matemáticas inválidas (ex: divisão por zero)
        try {
            int resultado = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Erro aritmético: " + e.getMessage());
        }

        System.out.println("\n======= EXEMPLO 5: ClassCastException =======");
        // Ocorre ao tentar converter um objeto para um tipo incompatível
        try {
            Object obj = "Sou uma String";
            Integer numero = (Integer) obj;
        } catch (ClassCastException e) {
            System.out.println("Erro: conversão de tipo incompatível.");
            System.out.println("Detalhe: " + e.getMessage());
        }

        System.out.println("\n======= EXEMPLO 6: IndexOutOfBoundsException (ArrayList) =======");
        // Semelhante à de array, mas para listas (ArrayList, etc)
        try {
            ArrayList<String> lista = new ArrayList<>();
            lista.add("item1");
            System.out.println(lista.get(5));
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Erro: índice fora dos limites da lista.");
            System.out.println("Detalhe: " + e.getMessage());
        }

        System.out.println("\n======= EXEMPLO 7: IllegalArgumentException =======");
        // Ocorre quando um argumento inválido é passado para um método
        try {
            definirIdade(-5);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro de argumento: " + e.getMessage());
        }

        System.out.println("\n======= EXEMPLO 8: StackOverflowError =======");
        // Ocorre quando há recursão infinita, estourando a pilha de chamadas
        try {
            contagemInfinita(1);
        } catch (StackOverflowError e) {
            System.out.println("Erro: pilha de chamadas estourou (recursão infinita).");
        }

        System.out.println("\n======= FIM DOS EXEMPLOS =======");
    }

    static void definirIdade(int idade) {
        if (idade < 0) {
            throw new IllegalArgumentException("Idade não pode ser negativa: " + idade);
        }
        System.out.println("Idade definida: " + idade);
    }

    static void contagemInfinita(int n) {
        contagemInfinita(n + 1);
    }
}