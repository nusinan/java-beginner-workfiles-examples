
import java.util.logging.Level;
import java.util.logging.Logger;


public class Main {
    public static void main(String[] args) {
          DeadlockOrnegi deadlock  = new DeadlockOrnegi();
    
    Thread thread1 = new Thread(new Runnable() {
        @Override
        public void run() {                 
            deadlock.thread1Fonksiyonu();
        }
    });                                                 // her iki methodunda aynı anda calsımasını saglamak icin threadlerin icerisinde baslattık
     Thread thread2 = new Thread(new Runnable() {
        @Override
        public void run() {
            deadlock.thread2Fonksiyonu();
        }
    });
    thread1.start();                          
                                                    // threadlerimizi baslattıp methodlarımızın aynı anda calısmasını sagladık 
    thread2.start();
    
        try {
            thread1.join();
            thread2.join();                      // main methoduna threadleirn islemleri bitene kadar beklemesini bildidrdik
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
   
    deadlock.threadOver();
    }
    
  

}
