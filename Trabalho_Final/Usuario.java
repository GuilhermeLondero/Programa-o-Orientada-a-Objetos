// classe base de todos os usuarios
public abstract class Usuario {
    private int matricula;
    private String nome;

    public Usuario(int matricula, String nome) {
        this.matricula = matricula;
        this.nome = nome;
    }

    public int getMatricula() {
        return matricula;
    }

    public String getNome() {
        return nome;
    }

    public abstract int getPrazoDias();
    public abstract int getLimiteEmprestimos();
    public abstract String getTipo();

    public String descricao() {
        return "[" + matricula + "] " + nome + " (" + getTipo() + ")";
    }
}