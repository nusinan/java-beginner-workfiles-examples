package mapınterface;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapInterface {

    public static void main(String[] args) {
        
 //Map Interface i ile HashMap LinkedHashMap TreeMap i burada tanimladik   
 
         Map<Integer,String> MapX= new HashMap<Integer, String>(); // degerleri Hash ile atadigi icin rasgele siralarla  donderir
         Map<Integer,String> MapY= new LinkedHashMap<Integer,String>(); // degerleri ekeldigimiz siraya gore donderir
         Map<Integer,String> MapZ= new TreeMap<Integer,String>();  // degerleri alfabetik olarak donderir
         
         MapX.put(10, "php");
         MapX.put(12,"java");
         MapX.put(24," c++");
         MapX.put(16, "c");
         
         MapY.put(14," javaScript");
         MapY.put(21,"c++");
         MapY.put(19,"c");                  // degerleri Maplerimize ekledik
         MapY.put(29,"java");
                  
         
         MapZ.put(9, "c++");
         MapZ.put(2, " java");
         MapZ.put(1, "php");
         MapZ.put(17, "python");
         
        System.out.println(MapX.get(10));
        System.out.println(MapY.get(29)); // ekrana tek tek bastirmak istersek
        System.out.println(MapZ.get(9)); 
        
       for( Map.Entry<Integer,String> girilen : MapZ.entrySet()){    // Entry set i kullanarak degerleri ekrana bastirabiliriz  yani map imizi set e donusturerek set te ekrana yazdima ozelligi ile ekrana yazdirdik
    
           System.out.println(" Key : " + girilen.getKey() + " Value " + girilen.getValue() );
       }
        System.out.println(" ***************************************************************  ");
       
       for( Integer key : MapY.keySet())    // key uzerinde gezerek ekrana yazdirm ayapabiliriz
       {
           System.out.println(" value : " + MapY.get(key));
       
       }
       
        System.out.println(" *****************************************************************  ");
        Collection <String> Values = MapZ.values(); // collection interaface ini kullannarak ekrana yazdirabiliriz
        for(String gez : Values)
        {
            System.out.println(" degerler : " + gez);
        }
    }   
}
