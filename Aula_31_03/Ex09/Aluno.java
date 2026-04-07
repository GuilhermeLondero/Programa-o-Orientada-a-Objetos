package pkg9;

public class Aluno extends Pessoa {
    String matricula;

    public Aluno(String nome, int idade, String matricula) {
        super(nome, idade);
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return super.toString() + " | Matrícula: " + matricula;
    }
}