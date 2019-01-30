package Examples;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * @author imssbora
 */
public class PipedReaderWriter {
   public static void main(String[] args) throws Exception {
      final PipedReader pipedReader = new PipedReader();
      final PipedWriter pipedWriter = new PipedWriter();

      // Connect pipe
      pipedReader.connect(pipedWriter);

      // Writing data to pipe
      Thread writerThread = new Thread(new Runnable() {
         @Override
         public void run() {
            try {
               for (int i = 65; i <= 70; i++) {
                  pipedWriter.write((char) i);
                  Thread.sleep(100);
               }
               pipedWriter.close();
            } catch (IOException | InterruptedException e) {
               e.printStackTrace();
            }
         }
      });

      // Reading data from pipe
      Thread readerThread = new Thread(new Runnable() {
         @Override
         public void run() {
            try {
               int i;
               while ((i = pipedReader.read()) != -1) {
                  System.out.println((char) i);
                  Thread.sleep(100);
               }
               pipedReader.close();
            } catch (IOException | InterruptedException e) {
               e.printStackTrace();
            }
         }
      });

      // Start thread
      writerThread.start();
      readerThread.start();
   }
}