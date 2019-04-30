
package javaapplication67;

import java.util.Scanner;

public class JavaApplication67 {
    
    static void yascontrol(int yas)
    {
        if(yas<18)
        { // throw kendi exception umuzu olusuturup gerekli yerde dondermemizi saglayan bir degerdir
            throw new ArithmeticException();  // yasin 18 den kucuk olmasi durumunda aritmatic excepiton hatasi gonderdik
        }
        else
        {
            System.out.println(" mekanimiza hos geldiniz .....");
        }

        }
    public static void main(String[] args) {
        
        Scanner input= new Scanner(System.in);
        System.out.println(" yasinizi giriniz");
        int yas=input.nextInt();
        
        try{
             yascontrol(yas);  // yasi 18 den kücük girdigimiz anda exception hatasi olusaileceginden dolayi exception olusma ihtimaline karsililk try icerisine aldik
        }

        catch(ArithmeticException e) //olusabilecek  exception hatasini burada  bildirdik
        {
            System.out.println(" yasiniz 18 den kucuk olmasi dolayisilya mekanimiza giris yapamassiniz..");
        }
    }
}
