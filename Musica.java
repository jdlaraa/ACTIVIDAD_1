public class Musica {
    public static void main(String[] args) {
        Sonido sonidoThread = new Sonido();
        Conversacion conversacionThread = new Conversacion(sonidoThread);

        sonidoThread.start();
        conversacionThread.start();
    }
}
