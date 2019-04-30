
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProducerConsumer {
    Random random = new Random();
    Object lock =  new Object();
    Queue<Integer> queue = new LinkedList<Integer>();
    private int limit = 10;
    
    
    
    public void produce() {
        
        while (true) {
            
            try {
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ProducerConsumer.class.getName()).log(Level.SEVERE, null, ex);
            }
            synchronized(lock) {                       burada bir anahtar olusturduk
                
                if (queue.size() == limit) {          
                                           
                    try {
                        lock.wait();   // eger kuyrukta 10 tane eleman varsa  anahtarı bırakmasını bildiriyoruz ve consume anahtarı alıyor
                    } catch (InterruptedException ex) {
                        Logger.getLogger(ProducerConsumer.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                Integer value = random.nextInt(100);
                queue.offer(value);                    //  dongu yıkarıda ki methoda girmediyse  kuyruga eleman ekliyor
                System.out.println("Producer Üretiyor : " + value);
                lock.notify();                     // consumer  ekleyen bir anahtar varsa anahtarın devam etmesini bildiriyor uretilenleri tuketmesi icin
                
            }
      
        }
        
        
    }
    public void consume(){
        
        while (true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ProducerConsumer.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            synchronized(lock) {          
                
                if (queue.size() == 0) {     
                    
                    try {
                        lock.wait();   //  eger kuyrukta hic eleman yoksa tukedim olmadıgı icin anahtarı bırakmasını bildiriyoruz
                    } catch (InterruptedException ex) {
                        Logger.getLogger(ProducerConsumer.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                Integer value =  queue.poll();             // kuyrukta eleman alıp tuketim yaptırıyoruz
                System.out.println("Consumer Tüketiyor : " + value);
                System.out.println("Queue Size : " + queue.size());
                lock.notify();          // eger producer bekleyen bir anahtar varsa anahtarın devam etmesini bildiriyoruz
                
                
            }
            
        }
        
      
    }
   
    
    
}
