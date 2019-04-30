
import java.util.logging.Level;
import java.util.logging.Logger;


public class Main {
    public static void main(String[] args) {
          ProducerConsumer pc = new ProducerConsumer();        producer cınsumer class ından bir degeobje olusuturduk
    
    Thread producer = new Thread(new Runnable() {
        @Override
        public void run() {
            pc.produce();
        }                                                      //  uretimin ve tuketimin aynı anda calısması icin threadler icerisinde her iki methodu da cagırdık
    });
    Thread consumer = new Thread(new Runnable() {
        @Override
        public void run() {
            pc.consume();
        }
    });
 
    producer.start();                                                   // threadleri baslattık
    consumer.start();
    
        try {
            producer.join();                                             // main methoda calısmadan once main methodu beklemesini soyledik
            consumer.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }
    
  
}
