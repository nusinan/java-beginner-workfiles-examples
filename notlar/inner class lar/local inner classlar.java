// local inner classlar

package localınner;
public class LocalInner {
    public static void main(String[] args) {
	
	
       class Alan{          // main methodu icerisinde actıgımız class ımız  // public tanımlamamıza gerek yok 
	                               // bu local inner class ları sadece main methodu icerisinde tanımlayabiliriz
								   // bu local inner class lar acil bir class olusturmamız gerektiginde olusuturabiliriz 
								   // diger turlu baska bir java dosyası ac orda bir class tanımla.... derken cok vakit alacagı icin 
								   // local inner class lar bizim icin bazen pratic olabiliyor
            
            public void DaireAlan(int alan)
            {
            int islem=alan*alan;
                System.out.println(" alan hesapla = "+ islem);
            }
        }
        Alan alanhesapla= new Alan();
        
        alanhesapla.DaireAlan(6);
    }
}
