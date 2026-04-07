package pkg1;

public class Main {
    public static void main(String[] args) {
        Animal animal = new Animal();
        Animal cachorro = new Cachorro();
        Animal gato = new Gato();

        animal.emitirSom();    // Som Genérico
        cachorro.emitirSom();  // Au Au
        gato.emitirSom();      // Miau
    }
}