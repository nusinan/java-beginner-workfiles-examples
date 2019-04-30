
package javaapplication66;

public class JavaApplication66 {

    public static void main(String[] args) {
	// exception bize iki tur hata verir kontrollü ve kontrolsuz hata  checked ve unchecked
	//  checked excepitonlar hatayi bize otomatik olarak kendileri donduruyorlar 
	// uncheckend exception da ise hatayi  bizim kendimiz bulmak zorundayiz ve assgidaki gibi belirtmeliyiz...
        
        try
        {
        int [] x = {4,5,5,9,1,30};                  // exception hasasi verbilecek kodu buraya yaziyoruz
        System.out.println(" int deger " +x[9]);
        int y=20/0;                // kod buradan ilk gordugu hatada try blogundan cikar ve  catch blogalrin dan kendine ait olan hataya sahip cash blogunu donderir
                                   // program hatayi buldıktan sonra catch te bulamassa program oradaki hata giderilinceye kadar calismaya devam etmez
        }
        catch(ArithmeticException e) // kodun bize dondercegi harayi buraya yaziyoruz... // buraya Exception da diyebiliriz
                                     // kodun bize verdigi hatayi genelden ozele dogru yazmaliyiz yani bireysel 
                                    //hatalar ilk hepsini kapsayan  exception en sona yazilmali 
        {
            System.out.println("aritmatic exception olustu...");
        }
        catch(IndexOutOfBoundsException e)
        {
            System.out.println("index out of bounds exception olustu...");
        }
        catch(Exception e)
        {s
            e.printStackTrace();  // burada kodunmuz try icerisinde olusan exception hatasıini bu coded blog u ile ekrana yazdirmamizi saglar

        }
        finally{
            System.out.println(" program calismaya devam ediyor..."); // burada program her ne sebeple olursa olsun  hata cikmasa bile 
            //calisan bir code blogu dur  ama exception hatalarini da gondermeye devam eder
        
        }
    }
}
