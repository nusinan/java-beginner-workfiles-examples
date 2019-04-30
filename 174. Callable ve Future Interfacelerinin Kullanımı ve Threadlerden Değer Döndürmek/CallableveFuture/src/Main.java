
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Main {
    public static void main(String[] args) {
        
        ExecutorService executor = Executors.newFixedThreadPool(1);  // thread tanımlamak icin exception tanımladık
        
        /*executor.submit(new Runnable() {             genellikle  threadlerimizi runnuble interface i ile  cagırmaktayız
            @Override
            public void run() {
                Random random = new Random();
                
                System.out.println("Thread çalışıyor....");
                
                int sure =  random.nextInt(1000) + 2000;
                
                try {
                    Thread.sleep(sure);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println("Thread çıkıyor....");
                
            }
        });*/
                                                                        // executor ile thread dimizi tanımladık
        Future<?> future  = executor.submit(new Callable<Integer>(){   // threadleimizin deger dondermesi icin callable ile turunu 
            @Override                                                 // belirleyip olusturabiliriz donnmesini istedigimiz degeri ise
            public Integer call() throws Exception {                 // future referansını atayarak cagırabiliriz ? ile olan yer ise 
                                                                     // callable ile belirledigimiz  deger dir isetersek oraya degerin
                Random random = new Random();                       // adınıda yazabiliriz
                
                System.out.println("Thread çalışıyor....");
                
                int sure =  random.nextInt(1000) + 2000;
                
                /*if (sure > 2500){
                    throw new IOException("Thraead çok uzun süre uyudu....");
                     
                }*/   //deneme amaclı bir exception gonderdik
                
                
                try {
                    Thread.sleep(sure);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println("Thread çıkıyor....");

                return sure;  // degeri dondererek future atadık
                

            }
           
        });
        
        
        executor.shutdown();       // executordan olusuturdugumuz thread in executor unu kapattık
        
        try {
            System.out.println("Dönen Değer : " + future.get());  // donderdigimiz degeri ekrana bastırdık
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExecutionException ex) {
            System.out.println(ex);
        }
        
    }
    
}
