
package javaapplication69;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JavaApplication69 {

    public static void main(String[] args) {
        
        FileOutputStream fos= null; // file output stream i disarida tanimladik 
        try { // fos.write ile ekrana yazdirma yaparken exceptin olusturmasini onlemek icin try icine aldik
            // File file = new File("example.txt");
            fos= new FileOutputStream("example.txt",true); // bu method sayesinde adcı karakterlerle ekrana yazi yazdirabiliyoruz...
            // yeni bir obje olusuturduk ve bu  method ile yazdiklarimizi aktaaracagimiz example.txt adinda bir dosya olusturduk
            fos.write(65);  // ascı karakterle degeri ekrana yazdirdik
            fos.write(74);
           
            byte[] array = {68,78,77,69,73};// ascı karakterleri byte dizisine atayarakta ekrana bastirabiliriz
            fos.write(array);
            String s="numan sinan";   // bir String i ascı degerlere donusturup anu  bir byte array ine atadik
            byte [] arrX=s.getBytes(); // String in byte sizisine donusturumu
            fos.write(arrX);
            
        } catch (FileNotFoundException ex) {
            System.out.println(" file not found exception olustu...");
        } catch (IOException ex) {
            System.out.println(" dosya olusturulurken bir hata olustu...");
        }
        finally{
            try {
                fos.close();  // programın arka planda calismaya devam etdip performamns kaybetmesini onlemek icin finally blogunda kapattik
            } catch (IOException ex) {
                System.out.println(" dosya kapatilirken hata olustu...");
            }
        }
    }
}
