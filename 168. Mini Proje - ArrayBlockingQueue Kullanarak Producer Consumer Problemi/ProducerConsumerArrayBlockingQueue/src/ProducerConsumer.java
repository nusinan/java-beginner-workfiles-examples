
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProducerConsumer {
    Random random = new Random();
    
    BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10);  // icinde en fazla 10 tane eleman tutabilen bir kuyruyk olusturduk 
  
    public void produce() {
        
        while (true) {
            try {
                Thread.sleep(5000);  // 5 saniye beklemesini soyledik
            } catch (InterruptedException ex) {
                Logger.getLogger(ProducerConsumer.class.getName()).log(Level.SEVERE, null, ex);
            }
       
            try {
                Integer value =  random.nextInt(100);
                                                          // rast gele deger urettirip queue  ya atamasını soyledik  producer-consider= 10 oldugu surece devam etmesini bildirdik
                                                          // yani 10  tane uretim oldu producer duruyor taki consider deger tuketip uretilen queue yu tuketene kadar 
                queue.put(value);
                
                System.out.println("Producer Üretiyor : " + value);
            } catch (InterruptedException ex) {
                Logger.getLogger(ProducerConsumer.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }
        
    }
    public void consume(){
        
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ProducerConsumer.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try {
                Integer value =  queue.take();
                System.out.println("Consumer tüketiyor : " + value);      /// queue daki uretilen degerleri  tek tek tuketmeye basladı  
                
                System.out.println("Queue Size: " + queue.size());
                
            } catch (InterruptedException ex) {
                Logger.getLogger(ProducerConsumer.class.getName()).log(Level.SEVERE, null, ex);
            }
             
        }
    } 
}
