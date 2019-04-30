// thread ler bellekte 3 farkli sekilde olusur
// 1. yontem thread interfaceini thread cagiracagimiz  class a implments ederek

package com.numansinan.thread1;          // thread1 paketi  icerisinde olusfturduk

import java.util.logging.Level;
import java.util.logging.Logger;

public class Printer extends Thread {  // thread olusturmak icin Thread class ini thread olusuturacagimiz class a ecxtend etmeliyiz
    
    private String isim;

    public Printer(String isim) {
        this.isim = isim;
    }
    @Override
    public void run() {  // thread class indan run methodunu overrride ettik
        
        for(int i=0 ;i<=10;i++)
        {
         System.out.println( isim +  "calisiyor...  : " +i);
            try {
                Thread.sleep(1000);  // thread imimizin 1 er saniye araliklarla calismasinı istedik
            } catch (InterruptedException ex) {
                System.out.println(" thread kesintiye ugradi...");
            }
        }
    }
}

// thread1 i main  class i icerisinde calistiriyoruz
package com.numansinan.thread1;
public class Main 
{
    public static void main(String args[])
    {
        Printer printer1 = new  Printer("printer1");// thread class ini extend ettigimiz class tan  obje olusturduk
        Printer printer2 = new Printer("printer2");
        
        printer1.start(); // bunlar thread olduklari icin  start() ile calistirdik ve  iki objede ayni anda calismaya basladi  
        printer2.start(); //bunlarin baslama sirasini program  belirledigi icin degisiklik gosterebilir
        System.out.println(" main methodu calisiyor...");
    }
}


/// ikinci yontem runnable interface ini implemente ederek


package com.numansinan.thread2;
public class Printer implements Runnable{ // ikinci yontem olarak runnable interface ini implemente etmektir
                                         // runnable interfacede thread in ozellikleri bulundugu icin
    private String isim;

    public Printer(String isim) {
        this.isim = isim;
    }
    @Override
    public void run() {   // ayni sekilede sun methodunu override ettik
        
        for(int i=0 ;i<=10;i++)
        {
         System.out.println( isim +  "calisiyor...  : " +i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                System.out.println(" thread kesintiye ugradi...");
            }
        }
    }
}
// runnable interface ini main methodu icerisinde cagirdik

package com.numansinan.thread2;
public class Main 
{
    public static void main(String args[])
    {
       Thread printer1 = new Thread(new Printer("printer1")); // bu thread ı runnable dan olusturdugumuz programin icerisinde var olan Thread i cagirip 
                                                              // bu thread runnable donderdigi icin runnable olarak tanimladigimiz Printer i cagirdik
       Thread printer2 = new Thread(new Printer("printer2"));
       
        printer1.start();   // thread ozelligi olan methodumuzu baslattik ve thread mantiginda yani printer1 ve printer2 ayni anda calismaya basladi
        printer2.start();
        System.out.println(" main metdodu calisiyor..."); // main methodu thread methoduna sahip oldugu icin ve bellekte ilk olustugu icin ilk once main methodu kodlari calisir
    }
}

//ucuncu yontem main methodu icerisinde cagirip main methodu icerisinde calistirdik

package com.numansinan.thread2;
public class Main 
{
    public static void main(String args[])
    {
       Thread printer1 = new Thread(new Printer("printer1")); // bu thread ı runnable dan olusturdugumuz programin icerisinde var olan Thread i cagirip 
                                                              // bu thread runnable donderdigi icin runnable olarak tanimladigimiz Printer i cagirdik
       Thread printer2 = new Thread(new Printer("printer2"));
       
        printer1.start();   // thread ozelligi olan methodumuzu baslattik ve thread mantiginda yani printer1 ve printer2 ayni anda calismaya basladi
        printer2.start();
        System.out.println(" main metdodu calisiyor..."); // main methodu thread methoduna sahip oldugu icin ve bellekte ilk olustugu icin ilk once main methodu kodlari calisir
    }
}










