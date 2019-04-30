package javaapplication73;

import java.io.Serializable;

public class Ogrenci implements Serializable{    // objeleirmizi serilestirirken  Serializable interface ini  kullaniriz
     
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
// bojeyi dosyaya yazdirma.....  java  page2

package javaapplication73;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;


                                                                                                                                                                                              //not   methodlarida serilestirebiliriz ama methodlar static ise serilestiremeyiz cunku staticler class a ozgu 
																																															// ozelliklerdir staticler programda otomatik olarak bellekte olusurlar
 
public class ObjeyiYaz {
    
     public static void main(String[] args) 
    {     
        Ogrenci ogrenci1 =  new Ogrenci("numan", 357, "softengineering");
        Ogrenci ogrenci2 = new  Ogrenci("mehmet",289, " ElectEngineering"); // bojeleri olusturduk
        Ogrenci ogrenci3 = new Ogrenci("mustafa", 182, "foodEngineering");
        
        Ogrenci [] ogrenci  = {ogrenci1,ogrenci2,ogrenci3};  
                                                       //ArrayList ogrenci array ini atadik
        ArrayList<Ogrenci> ogr= new ArrayList<Ogrenci>(Arrays.asList(ogrenci)); //bir arrayi ArrayList e boyle atariz
      // Object output stream deki out referansi ile herhangi bir objeyi ogrenci.bin icerisine ikili code olarak depolayacagız
        try(ObjectOutputStream out = new ObjectOutputStream( new FileOutputStream("ogrenciler.bin")))
        {
            out.writeObject(ogrenci);
            out.writeObject(ogr);
        } catch (FileNotFoundException ex) {
            System.out.println(" dosya bulunamadi...");
        } catch (IOException ex) {
            System.out.println(" IO exception hatasi olustu...");
        }
        
    }   
}
//dosyayi ekrana (sisteme yaazdirma) .........   java page 3

package javaapplication73;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class ObjeyiOku {
    
  public static void main(String[] args) 
    {   
            // ogrenci.bin e onceden atadigimiz ikili codelari objectOutputStreamin in referansi ile ogrenci.bin den kendi olusturdugumuz objerele cektik
        try(ObjectInputStream in = new ObjectInputStream( new FileInputStream("ogrenciler.bin")))
        {                //ogrenci.bin icerisindeki ikiili kodlari ogrenci class ı turunden kendi atadigimiz objelere aatadik
            
          Ogrenci[] ogrenciX= (Ogrenci[])in.readObject();
          ArrayList<Ogrenci> ogrX=(ArrayList<Ogrenci>) in.readObject();
          
          for( Ogrenci ogr : ogrenciX)
          {
              System.out.println(" ogrenci dizisinin degerleri"+ ogr);
          }
           
            System.out.println("***************************************************");
          for(Ogrenci ogrXX : ogrX)
          {
              System.out.println(" ogrenci dizisinin diger elemankari 2" +ogrXX );
          }
            System.out.println(" ucuncu bir okutma cesidi....");
          for(int i=0;i<ogrX.size();i++)
          {
              System.out.println(" array in degerleri : "+ogrX.get(i));
          }
          
        } catch (FileNotFoundException ex) {
            System.out.println(" dosya bulunamadi...");
        } catch (IOException ex) {
            System.out.println(" dosya IO exception hatasi olusturdu...");
      } catch (ClassNotFoundException ex) {
            System.out.println(" sinif bulunamadi...");
      } 
    }
}




