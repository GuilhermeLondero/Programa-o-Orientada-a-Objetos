package pkg12;

public class Ebook extends Livro {
    double tamanhoArquivoMB;

    public Ebook(String titulo, String autor, double tamanhoArquivoMB) {
        super(titulo, autor);
        this.tamanhoArquivoMB = tamanhoArquivoMB;
    }

    @Override
    public void exibirInfo() {
        super.exibirInfo();
        System.out.println("Tamanho do arquivo: " + tamanhoArquivoMB + " MB");
    }
}