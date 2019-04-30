//Generic class lari   genelde  int string char da cok az kullanilir cünku bunların turleri zaten bellidir 3 tane 
 // ama objelerin turleri bizim verdigimiz isinlere gore degisiklik gosterdigi normalde her obje icin ayrı ayrı birer class veya obje
 // olusturmalıyız buda bize buyuk projelerde buyuk zaman kayıpları ve karısıklara yol acar ama generic class lar yardımıyla yaptıgımızda 
 // method veya class bize bizim donderdigimiz turde degeri otomatik donderek bir cok methodu ve class ı tek bir programla 
 //calistirmamizi saglar
package genericclass;

public class GenericClass {

    public static void main(String[] args)
    {                                                                                                 // belli turlerde diziler olusturduk
       String[] String_dizi={"numan"," sinan"," ns"};
       Character[] char_dizi={'j','a','v','a'};
       Integer [] integerdizi={6,8,7,5,1};
       
       Ogrenci[] ogrenci_dizi={ new Ogrenci("numan"),new Ogrenci("sinan"), new Ogrenci("ns")};  // bir tanede obje dizisi olusuturduk
       YazdirmaSinifi yzd= new YazdirmaSinifi();
    
       yzd.yazdir(String_dizi);
       yzd.yazdir(char_dizi);
       yzd.yazdir(integerdizi);
       yzd.yazdir(ogrenci_dizi);
    }
    // inner class la ogrenci class inin burada tanımladık
    public static class Ogrenci {
    public String name;

    public Ogrenci(String name) {
        this.name = name;
    }
    
        @Override                              
        public String toString() {
            return " isim =" + name ; // sout icerisinde  obje yi cagırdıgımızda to String te donderdigimizi ekrana yazdirir
        }
        
}
}

// java dosyasi 2 yazdirma sinifi

package genericclass;
                                           // burayi yazmak onemli
public class YazdirmaSinifi<E> {  // Generic class ımızı olusturduk
    public void yazdir( E[] yazdir)   // burada E gonderdigimiz tipi E ye ataniyor
    {
    for( E yaz: yazdir)    // gonderdigimiz tipi de for each ile ekrana yazdiriyoruz
        
            System.out.println( yaz);
    }
}