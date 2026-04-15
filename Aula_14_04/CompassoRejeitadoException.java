import java.util.List;

public class CompassoRejeitadoException extends Exception {
    private List<String> acordesFalhos;

    public CompassoRejeitadoException(List<String> acordesFalhos){
        super("Compasso rejeitado devido a acordes inválidos.");
        this.acordesFalhos = acordesFalhos;
    }

    public List<String> getAcordesFalhos(){
        return acordesFalhos;
    }
}