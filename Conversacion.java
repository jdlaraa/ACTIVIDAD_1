import java.util.Scanner;

public class Conversacion extends Thread {
    private Sonido sonidoThread;

    public Conversacion(Sonido sonidoThread) {
        this.sonidoThread = sonidoThread;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Reproduciendo la canción. Para detener la música y salir, presiona Enter.");

        System.out.println("Buen día, ¿cómo estás?");
        String respuesta = scanner.nextLine();

        if (respuesta.equalsIgnoreCase("bien")) {
            System.out.println("Me alegro mucho.");
        } else if (respuesta.equalsIgnoreCase("mal")) {
            System.out.println("Lo siento mucho.");
        } else {
            System.out.println("Respuesta no válida.");
        }

        scanner.close();
        sonidoThread.detenerReproduccion();
    }
}
