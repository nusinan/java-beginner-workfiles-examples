// interface java dosyasi
package ınterfaceler2;
public interface Interface2X {
    public String isim=" numan";    //interface lerde normol olarak degisken tanimlayamayiz ama public olarak tanimlayabiliriz java bu inteface icerisinde 
    public int  sayi= 12;          // tanimladigimiz degiskenleri otomayik olarak Static bir degere ceviriyor ... bu  yolla degiskeni Class ismi ile cagirabiliriz 
                                   // normalde cagirabilmememiz icin obje olusuturmamız lazımdı interfacelerde obje olusuturulamadigi icin bu yolla class yardimi ile kullanabilmekteyiz
                                  // buradali degiskene static de yazabiliriz ama java static i otomatik olarak yaptigi icin bir daha yazmaya gerek yok
    public static void  hesapla()   // interfacelerde iolusturdugumuz methodların normalde kod blogu olmaz cunku interfaceleri obje ile cagiramayiz ama intefaceleri static ile
                                   // olusturursak degiskenlerde oldugu gibi bunlarıda class ile cagirabiliriz
    {
        System.out.println(" hesaplama yapiliyor... ");
    
    }
}

 
 // main class ı
package ınterfaceler2;
public class Maininterface {
    
    public static void main(String[] args)
{
    System.out.println(Interface2X.isim);   // java tarafından otomatik olarak static e  donusturulmus degiskeni class ismi yardimiyla direk olarak cagirdik
     
    Interface2X.hesapla();   // static olarak tanimladigimiz bir degiskeni class yardimi ile direk olarak cagirdik
 
}
}
