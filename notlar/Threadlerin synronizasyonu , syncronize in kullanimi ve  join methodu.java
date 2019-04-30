package jax;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ThreadSafe
{
 
    private int count=0;
    public synchronized void arttir()   // methodu synronized yaparak bir anahtar kilit iliskisine soktuktuk yani method count degerine 
            // mudehale ederken baska bir methodun mudahale     etmesini engelledik  eger sycronize yapmasaydik thread1 ve thread2 methodu ayni anda calistirdigi zaman
            // ikiside ayni degeri arttirabiliridi bundan dolayi synronize anahtar kelimesini kullandik yani assagidaki 
            //islemin sonucu 10 000 degil 10 in altinda herhangi bir deger olabilrdi
    {
        count++;
    }
    public void ThreadleriCalistir()
    {
        Thread thread1= new Thread( new Runnable() {
            @Override                   // thread1 adinda bir thread  tanimladik ve class tanimladigimiz bir degeri burada arttirdik
            public void run() {
               for(int i=0;i<5000;i++)
               {
                   arttir();
               }
            }
        });
        Thread thread2= new Thread( new Runnable() {  //thread2 adinda bir thread tanimladik ve thread1 de arttirdigimiz count  degerini  burada arttirmaya devam ettik 
            @Override
            public void run() {
               for(int i=0;i<5000;i++)                
               {
                   arttir(); 
               }
            }
        });
        
        thread1.start();
        thread2.start();
        try {
            thread1.join(); // join methodu main methodunun thread1 in ve thread2 nin islemlerini bitirmesini bekleyip daha sonra calismasi
                             // thread1 ve thread2 nin calismasi bitmeden join methodu calismayacak
            thread2.join();
            
        } catch (InterruptedException ex) {
            Logger.getLogger(ThreadSafe.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(" count degiskeninin degeri : "+ count);
    }
    public static void main(String [] args)
    {
        ThreadSafe ts= new ThreadSafe();
        ts.ThreadleriCalistir();
    
    }
}
