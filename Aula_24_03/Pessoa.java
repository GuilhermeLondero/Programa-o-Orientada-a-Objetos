public class Pessoa {
    // 1. Atributos privados (encapsulados)
    private String nome;
    private int idade;

    // 2. Construtor (inicializa o estado)
    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    // 3. Getter — leitura pública do atributo privado
    public String getNome() {
        return nome;
    }

    // 4. Setter — escrita controlada
    public void setNome(String nome) {
        this.nome = nome;
    }

    // 5. Getter para idade
    public int getIdade() {
        return idade;
    }

    // 6. Setter para idade
    public void setIdade(int idade) {
        this.idade = idade;
    }
}