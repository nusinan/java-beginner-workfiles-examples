
import java.util.logging.Level;
import java.util.logging.Logger;


public class Main {
    public static void main(String[] args) {
        ReentrantLockOrnegi re = new ReentrantLockOrnegi();
        
        Thread thread1  = new Thread(new Runnable() {
            @Override
            public void run() {
                re.thread1Fonksiyonu();
                
            }
        });                                                // aynı anda calsımasını istedigimiz  methodlarımızı threadleri atadık
        Thread thread2  = new Thread(new Runnable() {
            @Override
            public void run() {
                re.thread2Fonksiyonu();
                
            }
        });
        thread1.start();     // her iki threadimizide baslattık
        thread2.start();
        
        try {
            thread1.join();                  //  threadlerimizin islemleri bitene kadar main methodunun beklemesini bildirdik
            thread2.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        re.threadOver();
        
        
    }
    
}
