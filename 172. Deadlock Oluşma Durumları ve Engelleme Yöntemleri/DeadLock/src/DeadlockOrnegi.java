
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class DeadlockOrnegi {
    private Hesap hesap1 = new Hesap();
    private Hesap hesap2 = new Hesap();    //hesap class ımızdan objelerimizi cagırdık
    private Random random = new Random();
    
    private Lock lock1 = new ReentrantLock();      //    threadleri synronize etmek icin reenteredlock tan iki  obje olusuturduk
    
    private Lock lock2 = new ReentrantLock();
    
    
    public void LocklariKontrolEt(Lock a,Lock b) {   // programın deadlock olusuturmaması icin bir method tanımladık yani program calsıtıgında  iki tane calsıması icin 2 tane lock u da alması 
    	                                            // gereken ama bazen isletim sisteminden dolayı  threadlerin iksinin de bir lock alarak calsöaları icin gerekli olan diger lock u alamak 
    	                                            // icin birbirlerini beklemek durumunda kalmaktadırlar yani birisinin calsıması icin en az biriniz lock unu bırakması gerekmektedir lock ları
    	                                            // ellerindeki lock u bırakmsı icinde  islemin tamamlanmasını beklemeye baslar ikisde baslamayan islemlerini bitiremedigi icin ve ellerindeki 
    	                                             // lock u bırakamadıgı icin deadlock olusur
    	                                            // deadlock olusmasını onlemek icin thread in her iki lcok u da aldıgından emin olacagı bir method yazaar deadlock olusmasını onledik
        
        boolean a_elde_edildi = false;
        boolean b_elde_edildi = false;                     // her iki lock unda elinde olmadıgını varsaydık
        
        while(true) {
            
            a_elde_edildi = a.tryLock();                   // a ve b lock unu her ikisininde almayı denemesini sagladık
            b_elde_edildi = b.tryLock();
            
            if (a_elde_edildi == true && b_elde_edildi == true) { eger her iki lock u da program aldıysa   programı devam  return ederek programı devam etmesi bildirdik
                
                return;
            }
            if (a_elde_edildi == true) {
                
                a.unlock();                    //  yada locklardan sadece birini aldıgı zaman  dgier thread in lcok u alarak baslamsını saglamak icin  aldıgı lcok u bırakmasını soyledik
            }
            if (b_elde_edildi == true) {
                b.unlock();
            }
            
        }
        
        
    }
    
    public void thread1Fonksiyonu(){
        
        LocklariKontrolEt(lock1, lock2);                 // aynı anda her iki lock u alana kadar methodun calsımasını soyledik
        
        
        
        for (int i = 0; i < 5000 ; i++) {
            
            Hesap.paraTransferi(hesap1, hesap2, random.nextInt(100));
            
        }                                           // methdou calıstırdık ve bittigi zaman lockşarı birakmasını birdirdik
        lock1.unlock();
        lock2.unlock();
      
        
    }
    public void thread2Fonksiyonu(){
        
        LocklariKontrolEt(lock2, lock1);          // aynı anda her iki lock u alana kadar methodun calsımasını soyledik

        for (int i = 0; i < 5000 ; i++) {
            
            Hesap.paraTransferi(hesap2, hesap1, random.nextInt(100));
            
        }
        lock2.unlock();                     // methdou calıstırdık ve bittigi zaman lockşarı birakmasını birdirdik
        lock1.unlock();
       
       
    }
    public void threadOver(){
        System.out.println("Hesap1 Bakiye : " + hesap1.getBakiye() + " Hesap2 Bakiye : " + hesap2.getBakiye());        //  en son olusan islemimizin sonucunu donderdik
        
        System.out.println("Toplam Bakiye : " + (hesap1.getBakiye() + hesap2.getBakiye()));
        
    }
}
