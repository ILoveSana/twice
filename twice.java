import javax.sound.sampled.*;
import java.io.*;
import java.net.URL;
public class twice{
    public static synchronized void playSound(final String url) {
        new Thread(new Runnable() {
        // The wrapper thread is unnecessary, unless it blocks on the
        // Clip finishing; see comments.
          public void run() {
            try {
              Clip clip = AudioSystem.getClip();
              InputStream input = new URL(url).openStream();
              AudioInputStream inputStream = AudioSystem.getAudioInputStream(input);
              
              clip.open(inputStream);
              clip.start(); 
            } catch (Exception e) {
              System.err.println(e.getMessage());
            }
          }
        }).start();
      }
}