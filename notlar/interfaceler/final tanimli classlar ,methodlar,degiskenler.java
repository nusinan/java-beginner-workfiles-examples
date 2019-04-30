//
package finalexp;


public final class FinalExp {   // final olarak tanimladigimiz bir class tan hicbir sekilde alt sınıf turetemeyiz.... yani extend edemeyiz

 final int finalInt=2;       // final anahtar kelimesi sadece baska methodlarda veya kod bloglarında degismesini istemedigimz yerlerde kullanılır PI sayısı gibi
 final String finalString;   // final anahtarinin degerini  ya tanimladigimiz anda vermeliyiz yada constructurun icerisinde vermeliyiz 

    public FinalExp(String finalString) {
        this.finalString = finalString;
    }
	
    public final void finalexpmet()  //final olarak tanimladigimiz methodlari override edemeyiz  
    {                                //yani icerisinde final ile tanimlanmis method olan bir class ın final methodunu alamayiz
    }
}