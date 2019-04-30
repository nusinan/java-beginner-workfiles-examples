
package priarityqueue;

import java.util.PriorityQueue;
import java.util.Queue;
 // priertyqueue lar liste icerisindeki elemanlari oncelik sirasina gore siralarlar oncelik sirasi buyukluk kucukluk ve alfabetik olarak 
        // objeler icerisindeki oncelik sirasini bulmak icin comparable methodunu kullanmaliyiz
class player implements Comparable<player>
{
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
    public int compareTo(player player) {  // compare to ile degerleri karsilastirdik
         if( this.id< player.id)
         {
             return -1;
             
         }
         else if( this.id>player.id)
         {
             return 1;
             
         }
         else 
         {
             return 0;
         }
    }

    @Override
    public String toString() {
        return " name : "+name + " id : "+ id;  // to string 
    }
}
public class Priarityqueue {

    public static void main(String[] args) {
        
        // priertyqueue lar liste icerisindeki elemanlari oncelik sirasina gore siralarlar oncelik sirasi buyukluk kucukluk ve alfabetik olarak 
        // objeler icerisindeki oncelik sirasini bulmak icin comparable methodunu kullanmaliyiz
        Queue<Integer> priqueX = new PriorityQueue<Integer>();
        
        priqueX.offer(5);
        priqueX.offer(9);
        priqueX.offer(7);
        priqueX.offer(2);
        priqueX.offer(15);
     // priqueX.clear();  tüm listeyi sifilama methodu
        System.out.println(priqueX.contains(7)); // degerin liste icerisinde icerip icermemesine gore true ve false gondererek kontrol eder
        System.out.println("siralli haldeki  ilk degerimiz : "+ priqueX.peek());
        for( Integer I : priqueX)
        {
            System.out.println(" degerlerimiz : "+I);
        }
       
        while(!priqueX.isEmpty())
        {
            System.out.println(" degerleri siliyoruz : "+ priqueX.poll());
        }           // degerleri silmek icin poll methodunu kullandik....
        
        
        Queue<player> playerX = new PriorityQueue<player>();
        
        playerX.offer(new player(21, "numan"));
        playerX.offer(new player(18, "hasan"));
        playerX.offer(new player(27,"mustafa"));
        playerX.offer(new player(23, "mehemt"));
        
        while(!playerX.isEmpty())
        {
            System.out.println( " referans objemizin ilki cikartiliyor...." + playerX.poll()); 
        }        // donderdigimiz objeleri listeden cikarttik to Stringle de ekranda cikarttigimiz gosterdik
    }
}
