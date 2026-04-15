import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Partitura partitura = new Partitura();

        System.out.println("=== TESTE 1: Acorde simples válido ===");

        try {
            partitura.registrarAcorde("Am");
        } catch (AcordeInvalidoException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    
        System.out.println("\n=== TESTE 2: Cifra complexa válida ===");
        
        try {
            partitura.registrarAcorde("Bm/A");
        } catch (AcordeInvalidoException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    
        System.out.println("\n=== TESTE 3: Nota inválida ===");

        try {
            partitura.registrarAcorde("Xm7");
        } catch (AcordeInvalidoException e) {
            if (e.getMotivo() == AcordeInvalidoException.MotivoErro.NOTA_INEXISTENTE) {
                System.out.println("Nota Inexistente: " + e.getMessage());
            } else if (e.getMotivo() == AcordeInvalidoException.MotivoErro.SINTAXE_ERRADA) {
                System.out.println("Sintaxe Inválida: " + e.getMessage());
            }
        }
        
        System.out.println("\n=== TESTE 4: Acorde vazio ===");

        try {
            partitura.registrarAcorde("");
        } catch (AcordeInvalidoException e) {
            if (e.getMotivo() == AcordeInvalidoException.MotivoErro.SINTAXE_ERRADA) {
                System.out.println("Sintaxe Inválida: " + e.getMessage());
            }
        }

        System.out.println("\n=== TESTE 5: Processando compasso ===");
        List<String> compasso = Arrays.asList("Am", "Bm/A", "X7", "C", "", "Gm", "Zm");

        try {
            partitura.processarCompasso(compasso);
            System.out.println("Compasso OK!");
        } catch (CompassoRejeitadoException e) {
            System.out.println("\nCompasso rejeitado!");
            System.out.println("Acordes que falharam: " + e.getAcordesFalhos());
        }
        
    }
}