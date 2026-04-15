import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Partitura {
    private static final List<String> NOTAS_VALIDAS = 
        Arrays.asList("C", "D", "E", "F", "G", "A", "B");

    private String extrairTonica(String acorde) throws AcordeInvalidoException {
        char primeiroChar = acorde.charAt(0);
        if(!Character.isLetter(primeiroChar)){
            throw new AcordeInvalidoException(
                "Sintaxe inválida: '" + acorde + "' não começa com uma letra.",
                AcordeInvalidoException.MotivoErro.SINTAXE_ERRADA
            );
        }
        return String.valueOf(primeiroChar).toUpperCase();
    }
    public void registrarAcorde(String acorde) throws AcordeInvalidoException {
        if (acorde == null || acorde.trim().isEmpty()) {
            throw new AcordeInvalidoException(
                "Acorde não pode ser vazio ou nulo.",
                AcordeInvalidoException.MotivoErro.SINTAXE_ERRADA
            );
        }
        String tonica = extrairTonica(acorde);

        if (!NOTAS_VALIDAS.contains(tonica)) {
            throw new AcordeInvalidoException(
                "Nota inválida: '" + tonica + "' não existe na escala musical.",
                AcordeInvalidoException.MotivoErro.NOTA_INEXISTENTE
            );
        }
        System.out.println("Acorde '" + acorde + "' registrado. Tônica: " + tonica);
    }
    public void processarCompasso(List<String> acordes) throws CompassoRejeitadoException {

        List<String> acordesFalhos = new ArrayList<>();

        for (String acorde : acordes) {
            try {
                registrarAcorde(acorde);
            } catch (AcordeInvalidoException e) {
                System.out.println("Falhou: '" + acorde + "' — " + e.getMessage());
                acordesFalhos.add(acorde);
            }
        }

        if (!acordesFalhos.isEmpty()) {
            throw new CompassoRejeitadoException(acordesFalhos);
        }
    }
}