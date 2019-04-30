
package setınterface;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetInterface {

    public static void main(String[] args) {
	// bir elemani sadece bir defa depolamalarinin nedeni :Hash cod u arka planda eklenen her elamanın  listede olup olmadigini equels methodu ile arplanda kendisi yaparak ekleme yapıyor
                                                                                              // Set interface inden HashSet ,LinkedHashSet,Treeset leri  programda tanimladik
        Set<String> Set1= new HashSet<String>();   
		//degerleri bellekte hash table  mekanizmasina gore bellı bir yerlere yerlestiriyor ve biz bu degere bir deha ulasmaya calistigimizda hash fonksiyonunu calisiyor ve bellekteki yerini direk olarak o1 zamanda bulabiliyor
		// bir elementi sadece ve sadece bir defa depolarlar // bellekte eklenme sirasina gore depolanmiyorlar  hash table  mekanizmasina gore depolamnirlar
       // bu hash code u ile yazdigimiz kodun bellekteki yerini direk olarak bulabiliriz 
                                                   
        Set<String> Set2= new LinkedHashSet<String>();
		//degerleri hash table mekanizmasi  mantigina gore depoluyorlar yani hash fonksiyonu ile degerleri cagirdigimizda direk olarak  O1 zamanda erisebiliriz
		// bir elementi sadece ve sadece bir defa depolar  // HasSetten farklı olarak elemanlari ekleme sirasina gore depoluyor cunku referans ile birbirine baglanarak depolandigi icin		
        
        Set<String> Set3= new TreeSet<String>(); 
		// TreeSet te gonderdigimiz degerler alfabetik sira ile depolanir
		// bir elementi sadece bir defa depolarlar
           
        Set1.add("java");
        Set1.add("C++");
        Set1.add("php");
        Set1.add("javascript");
        
        Set2.add("C++");
        Set2.add("php");
        Set2.add("javaScript");
        Set2.add("java");
        
        Set3.add("php");
        Set3.add("java");
        Set3.add("python");
        Set3.add("c++");
        
        for(String s : Set1)
        {
            System.out.println("HashSet : "+s);
            
        }
        
        for( String s : Set2)
        {
            System.out.println("LinkedHashSet : "+s);
        }
        
        for( String s : Set3)
        {
            System.out.println("TreeSet : " + s);
        }
    }
}
