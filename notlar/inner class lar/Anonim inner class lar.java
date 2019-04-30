//Anonim Inner class lar 
// bu inner class lar sadece interface ler ve abstract class lar la birlikte kullanılılır 
package anonimınnerclasslar;

public class AnonimInnerClasslar {

    public static void main(String[] args) {
        
		
		//interface
        Ogrenci ogr= new Ogrenci() {                       // main methoud icerisine interface i cagırdik 
		                                                                          // interface digerlerinden farklı olarak methodlaromıı obje parantezi icerisde
            @Override                                                  //tanımladık
            public void DersCalis() {
                System.out.println(" ben su anda ders calisiyorum");
            }

            @Override
            public void DerseGir() {
                System.out.println(" su anda derse giriyorum..");
            }
        };
        ogr.DersCalis();
        ogr.DerseGir();
		
		//abstract class                                                // main methodu icerisinde abstract class ı cagırdık ama static yaparak
                                                                                   // abstract ı da digerlerinden fafrklı tanımladık    
        OgrenciAbs ogrAbs= new OgrenciAbs() {
            @Override
            void kayıtyaptır() {
                 System.out.println(" suan kayıt yaptırıyorum...");
            }
           
            
        };
        ogrAbs.SınavaGir();
        ogrAbs.kayıtyaptır();

    }
    
	 // abstrack methodu tanımladık
    public static abstract class OgrenciAbs{   // main methodu icerisinde kulllanabilmemiz icin static yapmalıyız
    
        abstract void kayıtyaptır();
        
        public void SınavaGir()
        {
            System.out.println(" sınava giriyorum");
        
        }
    }
    // interface i tanımladık
    public interface Ogrenci{   // bu interfac i baska bir dosyada da acabiliriz
    
    void DersCalis();
    void DerseGir();
    
    }
    
}


