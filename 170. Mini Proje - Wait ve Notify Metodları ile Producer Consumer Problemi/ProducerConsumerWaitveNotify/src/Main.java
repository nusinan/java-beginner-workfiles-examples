
import java.util.logging.Level;
import java.util.logging.Logger;


public class Main {
    public static void main(String[] args) {
          ProducerConsumer pc = new ProducerConsumer();
    
    Thread producer = new Thread(new Runnable() {
        @Override
        public void run() {
            pc.produce();
        }
    });
    Thread consumer = new Thread(new Runnable() {           //  aynı anda uretim ve tuketimi olması icin threadlerin icerisinde tanımladık
        @Override
        public void run() {
            pc.consume();
        }
    });

    producer.start();                                // threadleri baslattık
    consumer.start();
    
        try {
            producer.join();                 // main methodunun thread i calsımadan once consumer ve producer  methodunun bitmesini beklemesiini bildirdik
            consumer.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }
    
  
}
