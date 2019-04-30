import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
class Player implements Comparable<Player>{   // compare methodu player objesi icerisinde sıramaları  yapmak uzere implemete edildi
    private String isim;
    
    private int id;

    public Player(String isim, int id) {
        this.isim = isim;
        this.id = id;
    }

    @Override
    public String toString() {
       return "|||| ID: " + id + " İsim :" + isim + " |||";
       
    }

    @Override
    public int compareTo(Player player) {    //

        if (this.id < player.id) {          // Compareto methodu burada obje icin sıralama kosulları ayarlanarak  degistirildi
            
            return -1;
            
        }
        else if (this.id > player.id) {
            return 1;
            
        }
        return 0;
        


    }
    

    
}
public class Main {
    public static void main(String[] args) {
        
       /* List<String> list_string = new ArrayList<String>();
        
        
        list_string.add("Java");
        list_string.add("C++");
        list_string.add("Python");
        list_string.add("Php");
        list_string.add("Go");
        
        Collections.sort(list_string);
        
        for (String s : list_string) {   //burada pc sistemde tanımlı olan compareTo methodu ile  Stringleri otomatik ollarak karsılastırmaktadır
                                         // ama sadece Stringleri karsilastirir cunku Stringler icin tanımlı oldugu icin  objeleri karsilastirma yapayamız yapmak icin 
                                         // implemente edip  objeye goere duzenleyip karsilastirma yapmaliyiz
            System.out.println(s);
        }*/
       
        List<Player> list_player = new ArrayList<Player>();
        
        list_player.add(new Player("Murat", 5));
        list_player.add(new Player("Emre", 1));
        list_player.add(new Player("Oğuz", 10));
        list_player.add(new Player("Yusuf", 4));
        
        Player p1 = new Player("Murat", 5);
        Player p2 = new Player("Yusuf", 4);
        
       // System.out.println(p1.compareTo(p1));
        
        /*Collections.sort(list_player);        // objenin sıoralanmasını etkileyen obje icin degisiklileri compareTo da yaptıktan sonra  objelerin sıralanması collection sort ile 
         *                                     // artık objeleri  yaptıgımız degisikliklere gore sıralama yaptırabiliriz
        
        for (Player p : list_player) {
            
            System.out.println(p);
            
        }*/
        
        Set<Player> treeset = new  TreeSet<Player>();   // TreeSet compare to ya gore sırama yapam bir class tır normalde sıralı bir sekilde sıralama yapması icin compareTo da 
                                                        // tanımlanmıstır ama biz  compare to nun yapısını  objeye gore degistirdigimiz icin sıralamasını objede yaptırdıgıız 
                                                         // degisikliklere gore yaptıracaktır 
        
        treeset.add(new Player("Murat", 5));
        treeset.add(new Player("Emre", 1));
        treeset.add(new Player("Oğuz", 10));
        treeset.add(new Player("Yusuf", 4));
        
        for (Player p : treeset) {
            System.out.println(p);
            
        }
        
        
    }

}



