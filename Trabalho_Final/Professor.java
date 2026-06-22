public class Professor extends Usuario {
    private String departamento;

    public Professor(int matricula, String nome, String departamento) {
        super(matricula, nome);
        this.departamento = departamento;
    }

    public String getDepartamento() {
        return departamento;
    }

    @Override
    public int getPrazoDias() {
        return 30;
    }

    @Override
    public int getLimiteEmprestimos() {
        return 10;
    }

    @Override
    public String getTipo() {
        return "Professor";
    }
}