
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        
        try(FileWriter writer1 = new FileWriter("diller.txt")){  // javaya gelen bu ozellik saysesinde 
        	                                                    // finally de close ile yaptıgımız kapatma islemini simdi otomatik 
        	                                                   // olarak  java yapmaktadır try icerisine istedigimiz kadar referans
        	                                                  // objesi olusturabiliriz ama  noktalı virgulle ayırarak yazarız
           Scanner scanner = new Scanner(System.in);
           String dil;
           
           while (true) {
               
               System.out.println("Bir dil giriniz:");
               dil = scanner.nextLine();
               
              
               
               if (dil.equals("-1")) {
                   System.out.println("Programdan Çıkılıyor...");
                   System.out.println("Dosyayı Kontrol Edin...");
                   break;
               }
               writer1.write(dil + "\n");   //kullanıcıdan aldımız degerleri teker teker diller.txt dosyasına  yazdırdık
               
               
           }
            
           
        } catch (IOException ex) {
            System.out.println("Dosya oluşturulurken hata oluştu....");

        }
    }
}
