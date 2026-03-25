public class Estudante {
    private double nota;

    // Getter
    public double getNota() {
        return nota;
    }

    // Setter com validação estrita (0 a 10 inclusive)
    public void setNota(double nota) {
        // Condição: nota válida está ENTRE 0 e 10
        if (nota >= 0 && nota <= 10) {
            this.nota = nota;
        }
        // Se inválida: não faz nada, nota anterior é preservada
    }
}