
package queuiface;

import java.util.LinkedList;
import java.util.Queue;

public class Queuiface {
    
    public static void main(String[] args) {
        // Queue lar linkend listlerin interface i dir elamanlari sirali bir sekilde kuyruga sokar ve first in first out mantigii vardir pide kuyrugu  gibi ilk giren son cikar
        Queue<String> qlX =  new LinkedList<String>();
        
        qlX.offer("java"); // Que interface i ile olusturdugumuzn interface in ozelligi 
                           //olan offer ile eleman ekleyebiliriz burada deger ekledik 
        qlX.offer("c++");
        qlX.offer("c");
        qlX.offer("python");
        qlX.add("php");   //normal linked list in eleman ekleme methodunuda burada kullanabiliriz
        
        System.out.println(" kuyrugun en basindaki eleman .. :" + qlX.peek());
        // dizideki ilk degeri bize donderir
        
        System.out.println(" kuyrygun en basindaki eleman cikartiliyor ...  : " + qlX.poll());
        for( String s : qlX)                                            // dizideki dederi cikarttir
        {
            System.out.println(s);
        }
        
        while(!qlX.isEmpty()) // dizinin dolu olup olmadigini kontrol ettik ve bunu ozelligi kullanarak assagida islem yaptik
        {
            System.out.println(" eleman cikariliyor...."+ qlX.poll());
            
        }
    }
}
