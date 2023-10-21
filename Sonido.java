import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import java.io.File;

public class Sonido extends Thread {
    private volatile boolean reproduciendo = true;

    public void detenerReproduccion() {
        reproduciendo = false;
    }

    
    public void run() {
        try {
            File archivo = new File("pastor.wav");
            Clip clip = AudioSystem.getClip();

            clip.open(AudioSystem.getAudioInputStream(archivo));
            clip.addLineListener(new LineListener() {
                public void update(LineEvent event) {
                    if (event.getType() == LineEvent.Type.STOP) {
                        reproduciendo = false;
                    }
                }
            });

            clip.start();

            while (reproduciendo) {
                Thread.sleep(1000);
            }

            clip.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
