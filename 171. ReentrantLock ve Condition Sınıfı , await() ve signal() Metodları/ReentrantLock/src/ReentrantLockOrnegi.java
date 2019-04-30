
import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;




public class ReentrantLockOrnegi {
    
  
    private int say = 0;
    private Lock lock = new ReentrantLock();    //  lock sınıfından bir reantered lock objesi olusturduk
    private Condition condition = lock.newCondition();   //condition sınıfından bir lock objesi olusturduk
    
    public void artir(){
        for (int i = 0 ;  i < 10000 ; i++) {
            
            say++;
        }
        
        
    }
    public void thread1Fonksiyonu(){
        
        lock.lock();                    // bir lock olusturarak thread 1 in  calsımasını sagladık 
        System.out.println("Thread 1 Çalışıyor...");
        System.out.println("Thread 1 Uyandırılmayı Bekliyor....");       
        
        try {
            condition.await();               //  thread bir calsırken anahtarı teslim ederek thread 2 tarafından uyandırılana kadar  uyumasını  await methodu ile bildirdik
        } catch (InterruptedException ex) {
            Logger.getLogger(ReentrantLockOrnegi.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Thread 1 Uyandırıldı ve İşlemine Devam Ediyor...."); //  thread bir uyandırıldı ve islemlerini  yapmaya unlock olana kadar devam etti
        artir();
       
        
        lock.unlock();
        
        
        
    }
    public void thread2Fonksiyonu(){
        try {
            Thread.sleep(1000);       // thread1 in ilk once baslamsı icin thread iki yi baslamadan 1 saniye uyuttuk
        } catch (InterruptedException ex) {
            Logger.getLogger(ReentrantLockOrnegi.class.getName()).log(Level.SEVERE, null, ex);
        }
        Scanner scanner = new Scanner(System.in);   
        
        
        lock.lock();                                //  ilk baslayan thread1 suan uyuyup anahtarı bıraktıgı icin bostaki anahtarı(lock u) suan thread 2 aldlı
        System.out.println("Thread 2 Çalışıyor....");
        
        artir();                                   // arttırma islemlerini yaptı
        System.out.println("Devam etmek için bir tuşa basın...");
        scanner.nextLine();                       // bir sayı girerek thread2 nin devam etmesin sagladık
        condition.signal();                      // condition signal diyerek thread1 uyardık
        System.out.println("Thread 1'i Uyandırdım.Ben gidiyorum..."); 
       
        lock.unlock();                            // isi biten thread2 anahtarı bırakarak thread1 bostaki anahtarı alarak islemlerini devam ettirdi
        
        
        
        
        
    }
    public void threadOver(){
        System.out.println("Say değişkenin değeri : " + say);
        
        
    }
}
