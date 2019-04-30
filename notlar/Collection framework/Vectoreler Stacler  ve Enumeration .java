package vectosandstacs;

import java.util.Enumeration;
import java.util.List;
import java.util.ListIterator;
import java.util.Stack;
import java.util.Vector;

public class VectosAndStacs {

    public static void main(String[] args) 
    {
        
        Vector<String> vector= new Vector<String>();  
		// vectorlerde List İnterface inden implemente olurlar
		// vectorler le araylerlistler hemen hemen ayni yani tek farki vec torlerde
        //sysncronize var bu bakimdan arraylistlere gore daha guvenli ama arraylistlere gore daha yavastir vectorler threadlerdeki 
        //hata donderme kfarisikligini gideririr eger threadler le islem yapmayacaksak vectorleri kullanmamiz daha mantikli olacaktir
        
       vector.add("numan");
       vector.add("php");
       vector.add("python");
       vector.add("javascript");
       // vectorleri bastirma yontemleri...............
       // foreach yontemi ile bastirma.....
           for( String s: vector)
        {
            System.out.println(s);
        
        }
           
       // iterator yontemi ile bastirma...
       ListIterator<String> iterator=vector.listIterator(); 
        while(iterator.hasNext())
        {
            System.out.println(iterator.next());
        }
        
      // enumeretain ile ekrana bastirma...
        Enumeration<String> enumeration=vector.elements();
        
        while(enumeration.hasMoreElements())
        {
            System.out.println(enumeration.nextElement());
        }
        
        System.out.println(" ilk element : "+ vector.firstElement());
        System.out.println(" son element : "+ vector.lastElement());
        
        
    //******************************************************************************
        System.out.println("");
        System.out.println("*********************************Stacler.................................................");
        System.out.println("");
    //Stacler......
    // Staclerin  matigin da last in firs out matigi vardir 
    // vectorler den turedikleri icin vectorlere benzerler ve onlar gibi threadlerdeki hatalari gidermek icin syncronize a sahiptirler
    Stack<String> stackX= new Stack<String>();
    
    stackX.push("java");
    stackX.push("php");
    stackX.push("c");
    stackX.push("c++");
    
    for(String s :stackX)
    {
        System.out.println("Stacler foreach ile :  "+s);
    }
    
    Enumeration<String> enumStack =stackX.elements();
    
    while(enumStack.hasMoreElements())
    {
        System.out.println("Stacler Enumeration ile ..  : "+enumStack.nextElement()); 
    }
    ListIterator<String> iteratorStack=stackX.listIterator();
    
    while( iteratorStack.hasNext())
    {
        System.out.println( "stacler iteratorla : " + iteratorStack.next());
    }
     // Stack in son giren elemanini alma methodu 
     
        System.out.println(" son giren elemani ekranda gosterdik :  ");stackX.peek();
        
    // songiren elemani cikarma methodu
    
        System.out.println(" son giren eleman : " + stackX.peek()+ " cikartiliyor  : " +stackX.pop());
        
        for( String s : stackX)
        {
            System.out.println(" listenin son hali " +s);
        }
        System.out.println(stackX.empty());  // Stac in dolu  olup olmadigini kontrol ediyor...
        
        while(!stackX.empty()) // eleman doluluk kontrolüne gore donguyu devam ettirdik...
        {
            System.out.println(" eleman cikartiliyor..."+stackX.pop()); //eger dongu dolu ise donguden deger cikardik 
        }
    }
    
}
