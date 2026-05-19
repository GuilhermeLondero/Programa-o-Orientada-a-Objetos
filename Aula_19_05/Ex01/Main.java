public class Main {
    public static void main(String[] args) {
        Smartwatch meuRelogio = new Smartwatch("Apple");

        meuRelogio.exibirMarca();
        meuRelogio.ligar();
        meuRelogio.conectarBluetooth();
        meuRelogio.medirBatimentos();
    }
}