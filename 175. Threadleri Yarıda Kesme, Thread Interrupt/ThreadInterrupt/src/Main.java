
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Main {
    public static void main(String[] args) {
        
        List<Integer> list =  new LinkedList<Integer>();
        
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread çalışıyor....");
                
                for (int i = 0 ; i < 1000000 ;i++){
                    
                    if (Thread.currentThread().isInterrupted()){    // thread in interrupt exception eden olup olmadıgını belirliyor
                        System.out.println("Kesintiye Uğradı....");
                        return;
                        
                    }
                    
                    list.add(i);  // eger interrupt exception hatası olmadıysa  linked list imize deger eklemesi yapıyor
                   
                }
                
                System.out.println("Thread kesintiye uğramadan işini bitirdi...");
                
                
                /*for(int i= 1; i <= 10;i++) {
                    System.out.println("Thread Yazıyor : " + i);
                    
                    try {
                        Thread.sleep(1000);
                        System.out.println("Uykumun " + i + ". saniyesindeyim...");
                    } catch (InterruptedException ex) {
                        System.out.println("Uykum bölündü....");
                    }
                    
                }*/
                
                
                
            }
        });
        
        t.start(); // thread in calsımasını bildiriyoruz 
        
        try {
            Thread.sleep(5000);  // 5 saniye bekletiyoruz
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        t.interrupt();
        
        
        
        
        
        
        
        
    }
}
