package javaapplication70;

import com.sun.xml.internal.bind.v2.runtime.output.SAXOutput;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JavaApplication70 {

    public static void main(String[] args)
    {
         FileInputStream fis = null;
        try {
            fis= new FileInputStream("exampleX.txt"); // okuyacagimiz dosya
        
             try {
                     int deger;
                    String s="";
                    int say=0;
                    fis.skip(5);
                     while((deger=fis.read())!=-1)
                    {
                        s+=(char) deger;
                        say++;  // saysacla 5 ile 15 inci indexler arasindaki degerleri aldik
                        if(say==15)
                        {
                            break;
                        }

                    }
                    System.out.println(" dosyanin besinci yerinden itibaren 10 karakter..." +s);
                    
                    /*while((deger=fis.read())!=-1) //read methodu okuyacak deger bulamadigi zaman -1 degeri donderir 
                    {                               // biz de read methodu bize -1 degerini donderinceye kadar dongumuzu calismasini bildirdik 
                                                    //ve byte degerlerini deger adinda bir int e atadik
                        s+=(char) deger;

                    }
                    System.out.println(" dosya icerigi..."+s);*/
                    /*fis.skip(7); // imlecin dosyayi  okumaya baslayacagi konumu sectik
                    System.out.println(" 1. okunan deger "+  ((char)fis.read())); // fis.read sadece tek bir byte ı okuyor
                    System.out.println(" 2. okunan deger "+  ((char)fis.read()));// ve burada sonen byte ı char a cevirdik
                    System.out.println(" 3. okunan deger "+  ((char)fis.read()));*/
                 
             } catch (IOException ex) {
                 System.out.println(" dosya olunurken bir hata olustu...");
             }
        } catch (FileNotFoundException ex) {
            System.out.println(" dosya bulunamadi");
        }
        finally
        {
             try {
                 if(fis!=null)// bunu yazmassak dosya bize nullpointerexception hatasi verir 
                 { // eger bulunmayan bir dosyayi cagirdigimizda fis e  deger atanmayacak
                  //ve burada null degeri donderen fis i  kapatmaya calisirsak bize bir hata vermemesi icin yaptik
                    fis.close();
                 }
             } catch (IOException ex) {
                 System.out.println(" dosya klapatilirken bir hata olustu");
             }
        }
    }
}
