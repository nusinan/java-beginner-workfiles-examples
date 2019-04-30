
package javaapplication72;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JavaApplication72 {
public static void main(String[] args) {
        
 // normal try catch bloglarinda cok fazla cathc blogu yazmak zorunda kalıyorduk ve  finally blogu ile programi sonlandirmak zorunda kalıyorduk 
 //aman try with resource da finally blogunu yazmaya ve  fazladan cath blogu tanimlamaya gerek yok cünku try with resource program bunlari kendisi yapiyor 
        try(FileWriter writer = new FileWriter("diller.txt");
            FileWriter Writer2 = new FileWriter("dosX2.txt")) // burada try icerisinden birden fazlada dosya olusturabiliriz her biriniz noktali virgul ile ayirarak
        {
            Scanner input = new Scanner(System.in);
            String dil;
            while(true)
            {
                System.out.println(" bir dil giriniz...");
                dil=input.nextLine();
                if(dil.equals("-1"))
                {
                    System.out.println(" programdan cikiliyor...");
                    System.out.println(" dosyalari kontrol ediniz...");
                break;
                }
                 writer.write(dil+"\n");
            }
        } catch (IOException ex) {
            Logger.getLogger(JavaApplication72.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
