

//***************
         // java page 1   objeyi olusturma islemi....
//**************************************

package javaapplication73;

import java.io.Serializable;

public class Ogrenci implements Serializable{  // bir objeyi serilestirmek icin objenin class i seriziable interface ini implements etmelidir
     
    // Seriazition  : java Seriazition Api sayesinde Seriaziable interface ini implements eden 
    //class larin objelerini bir byte dizinine  donusturup bir dosyaya kaydetmemizi saglar
    // java da bu islemlere objelerin serilesytirilmesi denilmesktedir..
    
    // daha sonra bu objelerin dosyadan okumaya ise deseriazition denir
    
    // serizetion avantajlari 
    // 1  objelerin statelerini( anlik durumlarini) kaydediip daha sonra devam etmek istiyorsak seriazition mantıgı kullailir
    // 2   iki platfor arasindaki veri alisverisini objeler uzerinden yapmak istiyorsak objerleri serilestirip dosya transferi yaptirabliriz
    // ornek olarak bir mesajlasma uygulamasinda mesajlari oje olarak dusunursek bunlari serilestirerek transfer edebliriz
    
    // 3 bir objenin olusmasi cok uzun sürüyorsa ve daha sonra bu objeyi sık sık kullanmak istiyorsak bu objeyi birdaha kullnanmak yeri 
    //bu objeyi serilestirip kullanabiliriz....
    
    private String isim;
    private int id;
    private String bolum;
		// eger ben ben objelerimi serilestirir ken serilestirmek istemeyecegim bazi ozellikler olabilir bunları serilestirmemek icin transist anahtar kelimesini kullniriz
	 //private transist String isim      //  isin degiskenimi bu sekilde yazsarsam degisken serilesmeyecektir


    public Ogrenci(String isim, int id, String bolum) {
        this.isim = isim;
        this.id = id;
        this.bolum = bolum;
    }

    @Override
    public String toString() {
        String bilgiler= "JavaApplication73{" + "isim=" + isim + ", id=" + id + ", bolum=" + bolum + '}';
        return bilgiler;
    }
}
                                                                                                                                                                                                            //not   methodlarida serilestirebiliriz ama methodlar static ise serilestiremeyiz cunku staticler class a ozgu 
																																																			// ozelliklerdir staticler programda otomatik olarak bellekte olusurlar
//****************
            //  java page 2  objeyi serilestirme islemi  ...
//******************************************


package javaapplication73;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ObjeyiYaz {
    
    public static void main(String[] args) 
    {  // Object output stream deki out referansi ile herhangi bir objeyi ogrenci.bin icerisine ikili code olarak depolayacagız
        try(ObjectOutputStream out = new ObjectOutputStream( new FileOutputStream("ogrenci.bin")))
        {
            Ogrenci ogrenci1 =  new Ogrenci("numan", 357, "softengineering");
            Ogrenci ogrenci2 = new  Ogrenci("mehmet",289, " ElectEngineering"); // bojeleri olusturduk
            Ogrenci ogrenci3 = new Ogrenci("mustafa", 182, "foodEngineering");
            
            out.writeObject(ogrenci1);
            out.writeObject(ogrenci2); // objerleri out.writeObject ile ogrenci.bin e iki code olarak yazdirdik
            out.writeObject(ogrenci3);
        
        } catch (FileNotFoundException ex) {
            System.out.println(" dosya bulunamadi...");
        } catch (IOException ex) {
            System.out.println(" IO exception hatasi olustu...");
        }
    }
}
//**************
            //    java page 3   serilesmis objeyi ekrana yazma islemi...
 //****************************************************
 
 package javaapplication73;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ObjeyiOku {
    
  public static void main(String[] args) 
    {   
         // ogrenci.bin e onceden atadigimiz ikili codelari objectOutputStreamin in referansi ile ogrenci.bin den kendi olusturdugumuz objerele cektik
        try(ObjectInputStream in = new ObjectInputStream( new FileInputStream("ogrenci.bin")))
        {                //ogrenci.bin icerisindeki ikiili kodlari ogrenci class ı turunden kendi atadigimiz objelere aatadik
        Ogrenci ogrenciX=(Ogrenci) in.readObject(); 
        // okutturdugumuz ikili koddaki objelere erisebilmek icn bunlari yine kendi olusturdugumuz objelere atiyoruz
        Ogrenci ogrenciY= (Ogrenci) in.readObject();
        Ogrenci ogrenciZ= (Ogrenci) in.readObject();
            System.out.println(" **************************************  ");
            System.out.println(" ilk objenin degeri : " + ogrenciX);
             System.out.println(" **************************************  ");
            System.out.println(" ikinci objenin degeri : "+ogrenciY); // toString sayesinde objeleri ekrana bastirdik
             System.out.println(" **************************************  ");
            System.out.println(" ucuncu objenin degeri "+ ogrenciZ) ;
        
        } catch (FileNotFoundException ex) {
            System.out.println(" dosya bulunamadi...");
        } catch (IOException ex) {
            System.out.println(" dosya IO exception hatasi olusturdu...");
      } catch (ClassNotFoundException ex) {
            System.out.println(" sinif bulunamadi...");
      }
    }
}
