
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class ArrayandLinkedListMain {
    
    public static void main(String[] args) {
	
         // linked list ve ArrayList in Fark ı 
		 
        LinkedList<Integer> linkedlist  = new LinkedList<Integer>();  // LinkedList bellekte veriler  referanslari ile birbirine baglanmaktadir bir her bir veri kendinden sonrakinin referansini tutarak baglanamktadir
        ArrayList<Integer> arraylist =  new ArrayList<Integer>();       // ArrrayListler bellekte indexler ile yazilan sira ile bellekte veriler tutulmaktadir
        
        //zamanhesapla("LinkedList",linkedlist);
        zamanhesapla("ArrayList",arraylist);
        
        
    }
    public static void zamanhesapla(String veri_tipi,List<Integer> list)
     {
        
        // Listin sonuna değer ekleme
        long baslangic;   // long zaman tutma degiskeni,dir
        long bitis;
        
        baslangic = System.currentTimeMillis(); // System.currentTimeMİllis() bulundugu andaki zamani milisaniyecinsinden veriri
        
        for (int i = 0 ; i< 1000000 ; i++) {
            
            list.add(0,i);
            
        }
        bitis = System.currentTimeMillis();// System.currentTimeMİllis() bulundugu andaki zamani milisaniyecinsinden veriri
        
        System.out.println(veri_tipi + " ekleme süresi " + (bitis - baslangic) + " ms");   // gecen sure hesaplama 
		// ArrayListler bellekte yeri hazir olan yerlere  list.add ile deger gondererek Linkedlistlere gore daha hizlidir linkedlistler baglanarak arraylistler bellekteki hazir indexlere eklendikleri için linked e gore daha hizlidir
		
		// belleye yeni bir veri ekledigimiz zaman   arraylistler Linkedlistlere gore daha yavastirlar cunku linked listlerde  yeni eklenen veri referanslara baglanarak eklenir  ama 
		// Arraylist ler de bir veri yi ekledigimiz zaman  devamli ayni yere ekliyorsak  verilerin sonuna kadar  kaydirilarak eklenmesi gerekmektedir
        
        
        
        
    }
    
}