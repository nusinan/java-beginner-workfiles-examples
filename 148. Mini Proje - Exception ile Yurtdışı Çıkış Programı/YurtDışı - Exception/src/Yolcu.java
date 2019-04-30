
import java.util.Scanner;
class SiyasiException extends Exception {    // clasımızın exceptionn oldugunu belirtiyoruz ama Exceptiion 
                                               //  ı extend ettigimiz icin checked bir excetion oluyor

    @Override
    public void printStackTrace() {        // exception ın vermesini istedigimiz hatayı belilrttik
        System.out.println("Siyasi Yasağınız Bulunuyor...");

    }
   
}
class VizeException extends Exception {    // clasımızın exceptionn oldugunu belirtiyoruz ama Exceptiion
	                                       //  ı extend ettigimiz icin checked bir excetion oluyor
    @Override
    public void printStackTrace() {          // exception ın vermesini istedigimiz hatayı belilrttik
        System.out.println("Gideceğiniz Vizeniz Bulunmamaktadır...");
    }
  
    
}
class HarcException extends Exception {  // clasımızın exceptionn oldugunu belirtiyoruz ama Exceptiion
	                                     //  ı extend ettigimiz icin checked bir excetion oluyor
    @Override
    public void printStackTrace() {    // exception ın vermesini istedigimiz hatayı belilrttik

        System.out.println("Lütfen yurtdışı harcını tam yatırın...");
    }
    
    
    
}

public class Yolcu{
    
    private int harc;
    private boolean siyasiYasak;
    private boolean vizeDurumu;
    
    public Yolcu() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Yatırdığınız Harç Bedeli : ");
        this.harc = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("Herhangi bir siyasi yasağınız bulunuyor mu(evet ya da hayır) ? ");
        
        String cevap = scanner.nextLine();
        
        if (cevap.equals("evet")) {
            
            this.siyasiYasak = true;
        } 
        else {
            this.siyasiYasak = false;
        }
        System.out.print("Vizeniz bulunuyor mu ? (evet ya da hayır)");
        
        String cevap2 = scanner.nextLine();
        
        if (cevap2.equals("evet") ){
            this.vizeDurumu = true;
            
        }
        else {
            this.vizeDurumu = false;
        }
        
        
        
        
        
    }

    
    public void yurtdisiHarciKontrol() throws HarcException { // exception dan extend edildigi
        if (this.harc < 15) {                                 // icin checked bir exception
            
           throw new HarcException();  // kendi exception umuzu gonderdik
           
        }
        else {
            System.out.println("Yurtdışı harcı işlemi tamam!");
          
        }
    }

    
    public void siyasiYasakKontrol() throws SiyasiException {  // exception dan extend edildigi 
    	                                                       // icin checked bir exception
        if (this.siyasiYasak == true) {
            throw new SiyasiException();  // kendi exception umuzu gonderdik
            
           
        }
        else {
            System.out.println("Siyasi yasağınız bulunmuyor...");
           
        }
    }

    
    public void vizeDurumuKontrol() throws VizeException {// exception dan extend edildigi  
        if (this.vizeDurumu == true) {                    // icin checked bir exception
            System.out.println("Vize işlemleri tamam!");
            
        } 
        else {                       // kendi exception umuzu gonderdik
            throw new VizeException();
            
            
        }

    }
    
    
}
