
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ListWorker {
    
    Random random = new Random();
    ArrayList<Integer> list1 = new ArrayList<Integer>();
    ArrayList<Integer> list2 = new ArrayList<Integer>();
    
    private Object lock1 = new Object(); // burada obhe turunden bir veri tipi tanımladık olarak tanımlamak icin bu veri tipi sadece obje olmak zrounda degil istersek kendi olusturdugumuz
    private Object lock2 = new Object(); // ogrenci veri tipide olabilir
    
    
    public  void list1DegerEkle(){
        
        synchronized(lock1) {    // olusturdugumuz bu veri tipini synkronizet ettik yani sadece methodun kendine ozgu olugunu tanımladık methodu islemini bitirgi zaman lock unu bırakacak  
        	                     // dongu tekrar kendisine geldigi zaman kendi lock unu kullanarak tekrar calısacak yani diger yani threadin islemi bitmeden diger islemide yapmaya kalkısmayacak
         
        try {
            Thread.sleep(1);   
            
            
        } catch (InterruptedException ex) {
            Logger.getLogger(ListWorker.class.getName()).log(Level.SEVERE, null, ex);
        }
        list1.add(random.nextInt(100));      // list1 imize 0 ie 100 arasında rastgele bir deeeger ataması yapıyor
        }
       
        
    }
    public  void list2DegerEkle(){
        
        synchronized(lock2){           // olusturdugumuz bu veri tipini synkronizet ettik yani sadece methodun kendine ozgu olugunu tanımladık methodu islemini bitirgi zaman lock unu bırakacak  
                                       // dongu tekrar kendisine geldigi zaman kendi lock unu kullanarak tekrar calısacak yani diger yani threadin islemi bitmeden diger islemide yapmaya kalkısmayacak 
        	
       try {
            Thread.sleep(1);
            
            
        } catch (InterruptedException ex) {
            Logger.getLogger(ListWorker.class.getName()).log(Level.SEVERE, null, ex);
        }
        list2.add(random.nextInt(100));        // list1 imize 0 ie 100 arasında rastgele bir deeeger ataması yapıyor
        }
        
    }
    public void degerAta(){    
       
        for (int i = 0 ; i < 1000 ; i++) {
            list1DegerEkle();                  // methodlarımızı 1000 er defa cagırdık 
            list2DegerEkle();
            
        }
     
    }
    public void calistir(){
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {                          // threadlerimiz icerisinde degerata methodumuzu cagırdık
                degerAta();
                
            }                                                                      //  deger ata fonkdsiyonumuzu iki defa cagirdıgımız icin  listlerimize 2 ser bin tane deger eklendi
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {                         // threadlerimiz icerisinde degerata methodumuzu cagırdık
                degerAta();
                
            }
        });
        long baslangic = System.currentTimeMillis();
        
        thread1.start();
        thread2.start();
        
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(ListWorker.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("List1 Size :" + list1.size() + " List2 Size: " + list2.size());
        
        long bitis =  System.currentTimeMillis();
        
        System.out.println("Geçen Süre : " + (bitis - baslangic));
        
        
        
        
        
        
    }
    
    
}
