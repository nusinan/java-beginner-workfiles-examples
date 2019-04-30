
package hashmethod;

import java.awt.BorderLayout;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

 /// hash set in icerisinde dondermek icin bir tane method tanimladik
        class Player{
           
        private String playerName;
        private int playerId;

        public Player(String playerName, int playerId) {
            this.playerName = playerName;
            this.playerId = playerId;
        }

        public String getPlayerName() {
            return playerName;
        }

        public void setPlayerName(String playerName) {
            this.playerName = playerName;
        }

        public int getPlayerId() {
            return playerId;
        }

        public void setPlayerId(int playerId) {
            this.playerId = playerId;
        }
 // hash code un icerisine yazdigimiz degerleri normalde otomatik kontrol ettigi gibi burada  kontrol etmiyor kontroıl etmesi icin insert code dan equels and hash code u cagiriyoruz ve otomatik olarak kontrol etmesini sagliyoruz
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.playerName);
        hash = 11 * hash + this.playerId;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {             
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Player other = (Player) obj;
        if (this.playerId != other.playerId) {
            return false;
        }
        if (!Objects.equals(this.playerName, other.playerName)) {
            return false;
        }
        return true;
    }
       /// deger olarak obje donderecegimiz icin  obje donderdigimizde donmesini istedigimiz ifadenin ne olacagini buraya yazdik
    @Override
    public String toString() {
        return " id = "+ playerId +" playername = "+ playerName+" *******";  
    }
      
    }

public class HashMethod {

    public static void main(String[] args) {
        Player player1= new Player("numan", 2); // player referans larina   degerleri atadik 
        Player player2= new Player("numan",2);
        Player player3= new Player(" mustafa",8);
        Player player4 = new Player( "mehmet",9);
        
        
        Set<Player> Hashset= new HashSet<Player>(); // Set interface inin  turunu Player  objelerimiz atayabilmek icin  belirterek(Player) yaptik 
        Hashset.add(player1);  // olusturdugumuz referanslari referanslari  Hashset e atadik
        Hashset.add(player2);
        Hashset.add(player3);
        Hashset.add(player4);
        
        for( Player playX : Hashset)
        {                                              // degerleri for each ile donderdik ve bize objelerin toString teki degerlerini gonderdi
            System.out.println( " donen degerler" +playX);
        }
    }
    
}
