public class Aluno extends Usuario {
    private String curso;

    public Aluno(int matricula, String nome, String curso) {
        super(matricula, nome);
        this.curso = curso;
    }

    public String getCurso() {
        return curso;
    }

    @Override
    public int getPrazoDias() {
        return 7;
    }

    @Override
    public int getLimiteEmprestimos() {
        return 3;
    }

    @Override
    public String getTipo() {
        return "Aluno";
    }
}