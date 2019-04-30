
import java.util.logging.Level;
import java.util.logging.Logger;


public class ThreadSafe {
    private int count = 0;
    public synchronized void artir(){           // sycronized edttigimiz method
        
        count++;
    }
    public void threadleriCalistir(){                      // burada bir thread olusuturduk ve thread imizin degerini her defasında bir arttırdık
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0 ;  i < 5000 ; i++) {
                	// count++;                            // ilk basta degerini count  icerisinde arttırmayı denedik ama islem sırası ve onceligi alttaki thread ile karıstıgı icin
                	                                       //  degeri 10000 e tam ulasmadı cunku bildigimiz gibi threadler calsıma oncelligi cok fazla degisiklik gosterebildgi icin 
                	                                       //  bir sekronizasyon sorıunu olusumaktadır mesela thread1  calıstıgı zaman deger arttırımını atamayıp ikinci thread calısmaya 
                	                                        // basladı ikiside sıfıra bir degeri atayıp  1 e yukseltirler halbuki thread1  e atadıktan sonra degeri 1 artttırıp 2 yuıkseltmesi
                	                                        //  gerekmekteydi bir bu sekilde  bir senkron sorunu olustu  bu senkron  bozouklugunu gidermek icin  bir thread1 in yaptıgı 
                	                                        // islemi bitirdikten sonra thread 2 nin islemini yapmaya baslamasıdır  buunu yapmak icin arttır methoduna synchorized  diye 
                	                                       //  bir tanımlama getirdik synchorized burada bir  (lock) olusturdu yani thread 1 e bir anahtar ver di bu anahtarla methodu calısıtır
                	                                       // masını sagladı.islemini bitirdikten sonra anahtarı thread ikiye vermesini soyledi ve bu sekilde syncronized sorununu cozmus olmuk
                	                                         //  
                    artir();
                    
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {       // burada ikinci bir thread olusturduk 
            @Override
            public void run() {
                for(int i = 0 ;  i < 5000 ; i++) { 
                    artir();
                }
            }
        });
        
        thread1.start();
        thread2.start();
        
        try {
            thread1.join();               // burada thread1 ve thread2 nin haricinde main methodununn  threadi de onlarla beraber calısmaktadır ve threatlerde islem sıradı karısık 
                                          // oldugu icin threadlerin islemleri bitmeden main merthodu baslayabilmektedir main methodu bize baslamayan islemin degerini donderebilecegi icin
                                          // main methodunu thread lerin islemleri bittikten sonra baslamasını istedik ve thread bir ve thread2 ye join methodu gondererek main in kendilerini 
                                        //  beklemesimi sagladık yani thread1 ve thread2 islemini tamamladıktan sonra main methodunun calsımasını sagladık
            thread2.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(ThreadSafe.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        System.out.println("Count değişkenin değeri : " + count);
        
        
    }
    public static void main(String[] args) {
        ThreadSafe threadsafe = new ThreadSafe();  // burada da consructurdan tanımladıgımız objenin icerini   constructorda tanımlı oldugu icin direk cagırdık ve calıstırdık
        
        threadsafe.threadleriCalistir();
        
        
    }
    
    
}
