// generi methodlar......

//Generic class lari   genelde  int string char da cok az kullanilir cünku bunların turleri zaten bellidir 3 tane 
 // ama objelerin turleri bizim verdigimiz isinlere gore degisiklik gosterdigi normalde her obje icin ayrı ayrı birer class veya obje method
 // olusturmalıyız buda bize buyuk projelerde buyuk zaman kayıpları ve karısıklara yol acar ama generic class lar yardımıyla yaptıgımızda 
 // method veya class bize bizim donderdigimiz turde degeri otomatik donderek bir cok methodu ve class ı tek bir programla 
 //calistirmamizi saglar
 
// java class page 1;

package genericclass;

public class GenericClass {

    public static void main(String[] args)
    {
    
       Sayisal sayisal= new  Sayisal(40, 30, 60, 78);
       Sayisal sayisal1= new Sayisal(30, 60, 70, 10);
                                                               // objeleri tanimladik
       EsitAgirlik Ea1= new  EsitAgirlik(40, 30, 60, 78);
       EsitAgirlik Ea2= new EsitAgirlik(30, 60, 70, 10);
       
       Sayisal bir=birinci(sayisal1, sayisal1);
       EsitAgirlik birinciE=birinci(Ea1, Ea2);
       
        System.out.println(" sayisal birincinin puani =" +bir.puanhesapla());     // burada normal methodla birinciyi hesaoladık
       System.out.println("esitagirlik birincinin puani =" +birinciE.puanhesapla());  //burada gereric methodla birinciyi hesapladik
    }


     public static  Sayisal birinci(Sayisal sayisal1,Sayisal sayisal2)   //  referans objesi donderen bir method yazdik.. ve birinciyi hesapladık
     {                                                                    // burada birinciyi tek tip deger donderen bir methodla cagiridik
         if(sayisal1.puanhesapla()>sayisal2.puanhesapla())
         {
           return sayisal1;
         }
         else
         {
           return  sayisal2;
         }
     }
     
        public static  <E extends NewClass> E birinci(E e1,E e2 )  //  gonderdigimiz tipte deger donderen generic method tanimladik 
     {                                                               // puan hesaplamasi yaptirdik
         if(e1.puanhesapla()>e2.puanhesapla())                     // burada birinciyi gonderdigimiz deger ile cagiran method ile yaptirdik
         {
           return e1;
         }
         else
         {
           return  e2;
         }
     }
}

// java class page 2 sayisal page 

package genericclass;


public class Sayisal extends NewClass{

    public Sayisal(int turkce, int mat, int edebiyat, int fizik) {
        super(turkce, mat, edebiyat, fizik);
    }

    @Override
    int  puanhesapla() {
        
        
        return  getTurkce()*3+ getEdebiyat()*3 +getFizik()*5+getMat()*4;

    }

}
// java class page 3  esitagirliki page
package genericclass;

public class EsitAgirlik extends NewClass {

    public EsitAgirlik(int turkce, int mat, int edebiyat, int fizik) {
        super(turkce, mat, edebiyat, fizik);
    }

    @Override
    int puanhesapla() {
        
        return getEdebiyat()*5+getTurkce()*5+getFizik()*3+getMat()*4;
    }
    
}

// java class page 4 abstrack page esit agirlik ve sayisali extend ettigimiz sayffa


package genericclass;


public abstract class NewClass {
    private int turkce;
    private int mat;
    private int edebiyat;
    private int fizik;

    public NewClass(int turkce, int mat, int edebiyat, int fizik) {
        this.turkce = turkce;
        this.mat = mat;
        this.edebiyat = edebiyat;
        this.fizik = fizik;
    }
    

    public int getTurkce() {
        return turkce;
    }

    public void setTurkce(int turkce) {
        this.turkce = turkce;
    }

    public int getMat() {
        return mat;
    }

    public void setMat(int mat) {
        this.mat = mat;
    }

    public int getEdebiyat() {
        return edebiyat;
    }

    public void setEdebiyat(int edebiyat) {
        this.edebiyat = edebiyat;
    }

    public int getFizik() {
        return fizik;
    }

    public void setFizik(int fizik) {
        this.fizik = fizik;
    }
    abstract int puanhesapla();
}




