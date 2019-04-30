package hashsetler;

import java.util.HashMap;
import java.util.Map;

public class Hashsetler {

    public static void main(String[] args) {
        
        HashMap<Integer,String> hashsetX= new HashMap<Integer,String>();   // hashmap tanimladik
        
        hashsetX.put(10, " java");   // hashsetlere deger ataması yapma
        hashsetX.put(16, "c++");
        hashsetX.put(28," php");
        hashsetX.put(24, "python");
        
        System.out.println(hashsetX.get(10)); // hashsetleri ekranan bastirma
        System.out.println(hashsetX.get(28));
        System.out.println(hashsetX.get(24));
        
       for( Map.Entry<Integer,String> entry: hashsetX.entrySet()) // hash maplerde foreach dongusu kullanma
       {
           System.out.println(" Anahtar : " + entry.getKey()+ "======> degerler: "+ entry.getValue());
                                                //hashsetleri foreach ile ekrana bastirma
       
       }
    }
}
