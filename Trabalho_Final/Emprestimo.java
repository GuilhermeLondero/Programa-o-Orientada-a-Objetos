import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Emprestimo {
    private ItemAcervo item;
    private Usuario usuario;
    private LocalDate dataEmprestimo;
    private LocalDate dataPrevista;
    private LocalDate dataDevolucao;
    private boolean ativo;

    public Emprestimo(ItemAcervo item, Usuario usuario) {
        this.item = item;
        this.usuario = usuario;
        this.dataEmprestimo = LocalDate.now();
        // o prazo vem do tipo do usuario (polimorfismo)
        this.dataPrevista = dataEmprestimo.plusDays(usuario.getPrazoDias());
        this.ativo = true;
    }

    public ItemAcervo getItem() {
        return item;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public LocalDate getDataPrevista() {
        return dataPrevista;
    }

    // registra a devolucao e retorna o valor da multa
    public double devolver(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
        this.ativo = false;

        long atraso = ChronoUnit.DAYS.between(dataPrevista, dataDevolucao);
        if (atraso <= 0) {
            return 0.0;
        }
        // a multa por dia vem do tipo do item (polimorfismo)
        return atraso * item.getMultaPorDia();
    }

    public String descricao() {
        String situacao = ativo ? "Ativo (previsto p/ " + dataPrevista + ")" : "Devolvido";
        return usuario.getNome() + " -> " + item.getTitulo() + " | " + situacao;
    }
}