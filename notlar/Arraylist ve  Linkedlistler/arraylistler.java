package arry;

import java.util.ArrayList;

public class Arry {
    public static void main(String[] args)
{
         // arrayleri okutma yontemleri 1     // arraylistler indislerle  sıralı bir sekilde siralanir
        ArrayList<String> arrys= new ArrayList<String>();
        
        arrys.add(" numan");
        arrys.add(" java");
        arrys.add(" sinan");
        arrys.add(" ns");
        
        for( String  e :  arrys){
                                                    // for each dongusu ile yandaki gibi ekrana yazdirabiliriz
        System.out.println( "degerler" +e);
    }
           // arrayleri okutma yontem 2         
          for( int i=0;i<arrys.size();i++)
        {
                                                  // degerleri ekrana for yapısı ile dondururuz..
            System.out.println(" degerlerimiz..."+ arrys.get(i));   // degerleri kullanicidan alırken kullanicidan yandaki gibi alinir
        }
    }
}
    

