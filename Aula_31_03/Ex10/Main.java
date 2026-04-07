package pkg10;

public class Main {
    public static void main(String[] args) {
        Instrumento i = new Instrumento();
        Violao v = new Violao();
        Piano p = new Piano();

        i.tocar();
        v.tocar();
        p.tocar();
    }
}