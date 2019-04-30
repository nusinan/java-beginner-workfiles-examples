// java page 1 worker class ı thread olarak kullanmak icin runnable interface ini implemente ettik

package threadpool;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Worker  implements Runnable{  // thread class imizi burada olusturduk
    private String isim;
    private int TaskId;

    public Worker(String isim, int TaskId) {
        this.isim = isim;
        this.TaskId = TaskId;
    }
    @Override
    public void run() {
        System.out.println(" worker : " + isim + " " + TaskId + "ise  basladi");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(" worker : " + isim + " " + TaskId + "1.ci isi  bitirdi...");
    }
}

//  java page main methodu 


package threadpool;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;                                                               																										//Thread t1 = new  Thread(new Worker(("1",1));
																																																							//t1.start(); 
																																																							//t1.join();

public class Main       // main methodu icersinde executor methodunu calistirdik                                                                         not // threadleri kullanarak obje olusturabilridik ve threadleri tek tek start la calistirip joinleri bekletebilirdik 
																																																					// ama  bu sekilde yapsaydik  buyuk projelrde bircok thread i  kullanmak zorunda kalabiliriz bu da bize cok fazla 
																																																					// islem gücü kullanmamiza ve programa buyuk bir yuk olusturabilir
{
    public static void main (String [] args)                                                                                                            
    { 
        
        //executor services bize bircok thread  i ayni anda degilde belli bir siraya gore yazdirmamizi saglar
        ExecutorService executor= Executors.newFixedThreadPool(2) ; // threadleri ikiser ikiser calistirdik
        
        for( int i=0;i<=5;i++)
        {
            executor.submit(new Worker("numan", 452));
            executor.submit(new Worker("sinan", 352));
            executor.submit(new Worker("mehmet", 442));
            executor.submit(new Worker("elif", 552));
            executor.submit(new Worker("mustafa", 462));
            executor.submit(new Worker("fatih", 456));
            executor.submit(new Worker("leyla", 752));
            executor.submit(new Worker("beyza", 482));
            
           
        }
        executor.shutdown();// threadlerin calismasi bittiyse executor u kapatmak zorundayiz 
         try {
              executor.awaitTermination(1, TimeUnit.DAYS);
            } 
        catch (InterruptedException ex)
        {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
