//  inner class example
// my firs java folder
package ınner.pkgclass.lar;
public class innerclass {           // normal bir class tanımladik


    public class alan            // tanınladıgımız class ın icerisinde bir tanedaha class tanımladık
    {
        public void alanhesapla(int x,int y)
        {
            
          int alan=x*y;
      
        System.out.println(" alan = "+ alan);
         }
    }
    
    public class fakt          // tanınladıgımız class ın icerisinde bir tanedaha class tanımladık
    {
    public void fakthesapla(int x)
    {
        int f=1;
    for( int i=1;i<=x;i++)
    {
        f=f*i;
    }
        System.out.println(" faktoriyel sonus "+ f);
    
    }
    
    
    }
    public class asal{           // tanınladıgımız class ın icerisinde bir tanedaha class tanımladık
    
    public boolean asal (int x)
    {
        int i=2;
        while(i<x)
        {
       
            if(x%i==0)
            {
                System.out.println(" x asaldir...");
                return false;
            }
           
            i++;
        }
        return true;
    }
    }
    }
	
	
   // second java page   inner classları calıstıracagım java dosyası
   
   package ınner.pkgclass.lar;

public class InnerClassLar {
    

    public static void main(String[] args)
    {
        innerclass.alan alanhesap =new innerclass().new alan();   // birinci inner class ımınobjesini tanimladim
        innerclass.asal asalbul= new innerclass().new asal();        // ikinci  inner class ım objesini tanimladim
		
        innerclass.fakt fakthesap= new innerclass().new fakt();   // ucuncu inner class ımınobjesini tanimladim
        
        alanhesap.alanhesapla(4, 20);           
        fakthesap.fakthesapla(6);
        if(  asalbul.asal(13)==true)
        {     
            System.out.println(" girilen sayi asal bir sayidir");
        }
    }
}
   
   



