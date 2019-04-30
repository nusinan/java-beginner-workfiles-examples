package iterators;

import java.util.LinkedList;
import java.util.ListIterator;

public class Iterators {

    public static void main(String[] args) {
        
        LinkedList<String> linkedX= new LinkedList<String>();
        linkedX.add(" numan");
        linkedX.add("5");
        linkedX.add(" sinan");
        
           
        // linken listleri yazdirma  yontem 1 
        for( String scan: linkedX)
        {
            System.out.println(" okunan degerler..."+ scan);   // linled listler for each dongusu ile yazdirilabilir
        }
        
        // linken listleri yazdirma yontem 2  iterator ile yazdirma   
        ListIterator<String> iterator= linkedX.listIterator();   //linkedlistimizin degerini yandaki gibi atariz..
          
               while(iterator.hasNext())   // ekrana bastırıken linked list baglantısının devamında oge eklimi degilmi oldugunu kontrol ederiz
        {
            
             System.out.println(iterator.next()); // eger devamında varsa iterator.next ile ekrana bastiririz
                                                   // iterator.next i her yazdirdigimizda  en son yazdırılan degerden sonra gelen baglantıyı yazar...
        }
               
               while(iterator.hasPrevious())   // geri ye dogru giderken listenin devamında sayi olup olmadıgını kontrol ettik 
               {
                   System.out.println(" geri gidiliyor..."+ iterator.previous());  // eger listenin geriye dogru devamında deger varsa ekrana yazdirdik
               }
    
    }

}
