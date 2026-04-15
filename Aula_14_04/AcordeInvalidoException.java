public class AcordeInvalidoException extends Exception{
    public enum MotivoErro {
        NOTA_INEXISTENTE,
        SINTAXE_ERRADA
    }

    private MotivoErro motivo;
    
    public AcordeInvalidoException(String mensagem, MotivoErro motivo){
        super(mensagem);
        this.motivo = motivo;
    }
    
    public MotivoErro getMotivo(){
        return motivo;
    }   
}
