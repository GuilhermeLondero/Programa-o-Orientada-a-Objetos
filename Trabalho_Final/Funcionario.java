public class Funcionario extends Usuario {
    private String setor;

    public Funcionario(int matricula, String nome, String setor) {
        super(matricula, nome);
        this.setor = setor;
    }

    public String getSetor() {
        return setor;
    }

    @Override
    public int getPrazoDias() {
        return 15;
    }

    @Override
    public int getLimiteEmprestimos() {
        return 5;
    }

    @Override
    public String getTipo() {
        return "Funcionario";
    }
}