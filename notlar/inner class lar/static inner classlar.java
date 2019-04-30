// static inner class
package staticınnerclass;
public class StaticClass {
    
    public static class DaireAlan
    {
        public void DaireAlan(int x)
        {
            int islem=(int) (4*Math.PI*x*x);
            
            System.out.println(" alan =" + islem );
        }
    }
}
// main class  static class ları cagırdıgımız
package staticınnerclass;

public class StaticInnerClass {

    public static void main(String[] args) {
        
        StaticClass.DaireAlan Dalan=new StaticClass.DaireAlan();   // static class ın objesinin tanumlanma sekli
        Dalan.DaireAlan(8);
    }
}