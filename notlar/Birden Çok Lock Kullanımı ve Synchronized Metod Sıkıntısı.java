package listworker;

import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ListWorker {
    
    Random random= new Random();
    ArrayList<Integer> list1= new ArrayList<Integer>();
    ArrayList<Integer > list2 = new ArrayList<Integer>();
    private Object lock1= new Object();   //burada 2 tane anahtar olusturduk thread 1 ve thread 2 icin
    private Object lock2= new Object();
    
    public  void List1DegerEkle()
    {
        synchronized(lock1) //syncronize a anahatar 1 i ekledik isi bitince anahtari cikartsin diger thread2 calissindiye  // eger anahtar kullanmasaydik thread1 ve thread2 farlli isleri ayni anda 
		                                    // yapmayacakti birisi calisirken digeri onun bitirmesini bekleyecekti  bundan dolayi surede iki katina cikacakti
        {
        try {
            Thread.sleep(1);
        } catch (InterruptedException ex) {
            Logger.getLogger(ListWorker.class.getName()).log(Level.SEVERE, null, ex);
        }
             list1.add(random.nextInt(100));
        }
    }
     public  void List2DegerEkle()
    {
        synchronized(lock2) //syncronize a anahatar2 yi ekledik isi bitince anahtari cikartsin diger thread calissindiye  // eger anahtar kullanmasaydik thread1 ve thread2 farlli isleri ayni anda 
		                                    // yapmayacakti birisi calisirken digeri onun bitirmesini bekleyecekti  bundan dolayi surede iki katina cikacakti
        {
        try {
            Thread.sleep(1);
        } catch (InterruptedException ex) {
            Logger.getLogger(ListWorker.class.getName()).log(Level.SEVERE, null, ex);
        }
             list2.add(random.nextInt(100));
        }
    }
     public void DegerAta()
     {
         for(int i=0 ;i<1000;i++)
         {
         List1DegerEkle();  // her iki list e de bin er tane deger eklettik
         List2DegerEkle();
         }
         
      }
     
     public void calistir()
     {
          //deger ekleme islemini thread 1 ve thread 2 de birer defa yaptirdik
         Thread thread1 = new Thread(new Runnable() { //thread 1 calisirken thread 2 thread 1 in isleminin bitmesini bekliyor yani 
                                                      // thread 1 in syncronizindaki lock list 1 i tutup thread 1 in list1 deki  
                                                       //islemlerini yaparken thread 2 list 1 e islem yapmak icin giremiyor thread 1 in lock u list1 i birakinccaya kadar 
                                                       // ama thread 2 diger listte islemlerini yapmaya devam ediyor ayni islem lock 2 nin thread2 de yapacagi icinde gecerli 
                                                       // thread1 thread2 calistiracagi list in lock aktif edip calistiyor  boyle olunca ikiside ayni anda bir isleme odaklanmiyor 
                                                      // thread 1 in isleminin bitmesini bekliyor
             @Override
             public void run() {   
                 DegerAta();                           
             }
         });
         
        Thread thread2 = new Thread(new Runnable() {
        @Override
        public void run() {
        DegerAta();
        }
        });
        long baslangic= System.currentTimeMillis();
        thread1.start();
        thread2.start();
        
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(ListWorker.class.getName()).log(Level.SEVERE, null, ex);
        }
         System.out.println(" lis1 size : "+ list1.size()+ " list2 size : "+ list2.size());
         long bitis=System.currentTimeMillis();
         System.out.println(" gecen sure :  " + (bitis- baslangic));
     }
}
