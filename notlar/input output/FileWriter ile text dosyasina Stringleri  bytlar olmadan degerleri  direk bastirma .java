
package filewriterx;

import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileWriterX {

    public static void main(String[] args) 
    {
        FileWriter fwriteX=null; // file write ı ilk basta null esitledik ki finally blog unda calistirabilelim diye
        try {
            fwriteX= new FileWriter("fileX.txt",true); // file writer ı namımladik 
            fwriteX.write("numan sinan\n"); //ve program her calistiginda islemleri bir daha yapmasi icin true degerini atadik
            fwriteX.write("mehmet sinan\n"); // file write ile Stringleri direk olarak text dosyasina yazdirdik
            fwriteX.write("mustafa sinan\n");
        } catch (IOException ex) 
        {
            System.out.println(" dosya yazilirken bir hata olustu...");
        }
        finally
        {
            try {
                if(fwriteX!=null)
                {
                 fwriteX.close();
                }
               
            } catch (IOException ex) {
                System.out.println(" dosya kapatilirken bir hata olustu...");
            }
        }
    }
}
