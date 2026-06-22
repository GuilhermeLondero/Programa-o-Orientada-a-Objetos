import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<ItemAcervo> itens;
    private List<Usuario> usuarios;
    private List<Emprestimo> emprestimos;

    public Biblioteca() {
        this.itens = new ArrayList<>();
        this.usuarios = new ArrayList<>();
        this.emprestimos = new ArrayList<>();
    }

    public void adicionarItem(ItemAcervo item) {
        itens.add(item);
    }

    public void adicionarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public List<ItemAcervo> getItens() {
        return itens;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public ItemAcervo buscarItem(int codigo) throws EntidadeNaoEncontradaException {
        for (ItemAcervo item : itens) {
            if (item.getCodigo() == codigo) {
                return item;
            }
        }
        throw new EntidadeNaoEncontradaException("Nenhum item com o codigo " + codigo + ".");
    }

    public Usuario buscarUsuario(int matricula) throws EntidadeNaoEncontradaException {
        for (Usuario u : usuarios) {
            if (u.getMatricula() == matricula) {
                return u;
            }
        }
        throw new EntidadeNaoEncontradaException("Nenhum usuario com a matricula " + matricula + ".");
    }

    private int contarEmprestimosAtivos(Usuario usuario) {
        int total = 0;
        for (Emprestimo e : emprestimos) {
            if (e.isAtivo() && e.getUsuario().getMatricula() == usuario.getMatricula()) {
                total++;
            }
        }
        return total;
    }

    public Emprestimo emprestar(int codigoItem, int matricula)
            throws EntidadeNaoEncontradaException, ItemIndisponivelException, LimiteEmprestimoException {

        ItemAcervo item = buscarItem(codigoItem);
        Usuario usuario = buscarUsuario(matricula);

        if (!item.isDisponivel()) {
            throw new ItemIndisponivelException("O item '" + item.getTitulo() + "' ja esta emprestado.");
        }

        int ativos = contarEmprestimosAtivos(usuario);
        if (ativos >= usuario.getLimiteEmprestimos()) {
            throw new LimiteEmprestimoException(
                    usuario.getNome() + " ja atingiu o limite de emprestimos.",
                    usuario.getLimiteEmprestimos());
        }

        item.marcarComoEmprestado();
        Emprestimo emprestimo = new Emprestimo(item, usuario);
        emprestimos.add(emprestimo);
        return emprestimo;
    }

    public double devolver(int codigoItem, LocalDate dataDevolucao) throws EntidadeNaoEncontradaException {
        for (Emprestimo e : emprestimos) {
            if (e.isAtivo() && e.getItem().getCodigo() == codigoItem) {
                double multa = e.devolver(dataDevolucao);
                e.getItem().marcarComoDisponivel();
                return multa;
            }
        }
        throw new EntidadeNaoEncontradaException("Nao existe emprestimo ativo para o item " + codigoItem + ".");
    }
}