package listsira;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

 class player implements Comparable<player>{  // comparable interface ini implement ettik
     private int id;
     private String name;

    public player(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return " id : "+ id + " name "+ name;
    }

    @Override
    public int compareTo(player player) {   // objeleri icerisindeki degerlere gore siralama yaptirdik
        
        if( this.id<player.id )    //gelen deger var olan degerden buyukse -1 donecek
        {
        return -1;                 // bulundurdugu listeleri sirali olarak gonderen treeset te bizim burada kullandigimiz CompereTo methodunu kullanarak siraliyor
        }                         
        else if (this.id>player.id)//gelen deger var olan degerden kucukse 1 donecek
        {
        return 1;
        }
        else 
        {
        return 0;  //gelen deger ile var olan deger birbirlerine esitlerse 0 donderecekler
        }
    }
 }
public class ListSira {
    
    public static void main(String[] args) {
        
        List<String> list_String= new ArrayList<String>(); // list String teki objeleri siralama
        
        list_String.add("java");         // degerleri list te ekledik
        list_String.add(" c++"); 
        list_String.add("php");
        list_String.add("python");
        
        Collections.sort(list_String);// Collection interface inden static olan  sort methodunu kullanarak listeyi siralatiyoruz
        
        for( String s : list_String) // siralanmis olan listeyi ekrana bastiriyoruz
        {
            System.out.println( s);
        }
 //*******************************************************************************************************************************
 //listlerin icerisinereferans gondrirsek ne bok yicez referansta direk olarak Collection Short u kabul etmiyor
        List<player> list_player= new ArrayList<player>();
       
        list_player.add(new player(10,"numan"));
        list_player.add( new player(13, "sinan"));// yeni objeler olusturduk
        list_player.add(new player(19,"num"));
        list_player.add(new player( 33,"mehmet"));
        
        Collections.sort(list_player);  // comprerable methodunu implement edip override ettigimiz compereTo ile objelerin kendi icerisindeki siralamasini  kendimiz yeptik
         for(player playX : list_player) // düzenlenmis olan list_player listesini foreach ile ekrana bastirdik
                                            // bulundurdugu listeleri sirali olarak gonderen treeset te bizim burada kullandigimiz CompereTo methodunu kullanarak siraliyor
         {
             System.out.println(playX);
         }
    }
}
