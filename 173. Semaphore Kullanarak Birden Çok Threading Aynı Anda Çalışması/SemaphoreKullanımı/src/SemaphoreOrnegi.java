
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SemaphoreOrnegi {
    
    private Semaphore sem = new Semaphore(4); // semaphore class ını tanımladık ve aynı anda 5 tane methodun calısacagını bildirdik
    
    public void threadFonksiyonu(int id) {
        
        try {                       
            sem.acquire();          // olusturdugumuz methodun icerisinde sem.equire sırasına girerek calsımasını bildirdik
        } catch (InterruptedException ex) {
            Logger.getLogger(SemaphoreOrnegi.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("Thread Başlıyor... ID : " + id );
        
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(SemaphoreOrnegi.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Thread Çıkıyor.... ID : " + id);
        
        sem.release();              // en son semaphore olan thread in  methodunun isi bittgi zaman methodu i serbest bırakarak semaphore u  olan diger  thread i almasını bildidrdik
                                   // bu yolla tum threadler belli bir sıra ile aynı anda calsıtırdık
        
    }
    
}
