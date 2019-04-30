// kendi exception class ımızı yazma
package javaapplication68;
import java.util.Scanner;
public class JavaApplication68 {    
    public static void mekancontrol(int yas)
    {
        if(yas<18)
        {
           throw new TestExapleException("TestException"); // throe la kendi exception umuzu  donderdik
        }
    
        else 
        {
            System.out.println(" mekanimiza giris yapabilirsiniz... ");
        }
    }
    
    public static void main(String [] args )
    {
        Scanner input = new  Scanner(System.in);

        System.out.println(" lütfen yasiniz giriniz...");

        try{
         int yas =input.nextInt();
        mekancontrol(yas);

        }
        catch(TestExapleException e)
        {
            System.out.println(" iceriye girmek icin yasiniz uygun degil...");
        }
    }
}
// page 2 kendi exception class imizi burada olusturduk
package javaapplication68;

public class TestExapleException extends ArithmeticException // aritmarik exception  ı extend ettik
                                        // eger burayi IO exception yapsaydik checked exceptioin olacaktı ve hatayi otomatik tanimlamamiz icin gosterecekti
										// normal olarak en ust class olan Exception ı cagirsaydik yine checken  bir exception olacakti
{
    public TestExapleException(String message)// exception a isim verdik 
    {
      super(message);
    }
    @Override
    public void printStackTrace() { //vermesini istedigimiz hatayi buraya yazdik
        System.out.println(" bu bir TestExampleException hatasidir...");
    }
}
