public class Smartwatch extends Dispositivo implements Conectividade, Monitoramento {
    public Smartwatch(String marca) {
        super(marca);
    }
    @Override
    public void ligar() {
        System.out.println("Smartwatch ligando. Exibindo tela inicial.");
    }
    @Override
    public void conectarBluetooth() {
        System.out.println("Conectando ao Bluetooth do celular");
    }

    @Override
    public void medirBatimentos() {
        System.out.println("Medindo batimentos cardiacos no pulso. 78 bpm.");
    }
}