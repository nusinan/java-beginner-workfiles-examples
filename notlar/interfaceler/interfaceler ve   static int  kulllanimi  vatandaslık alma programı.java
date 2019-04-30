

// dosya 1    //main menu

package vatandaslıkverme;

public class VatandaslıkVerme {
    
    public static void main(String[] args) {
        
        System.out.println(" vatandaslik basvursuna hosgeldiniz");
        VatandasX vatandas= new VatandasX(true, true, true, 23, 16000);
        
        while(true)
        {
            vatandas.DilBilgisi(vatandas.isIngilizce());
            vatandas.EgitimDuzeyi(vatandas.isDiploma());
            vatandas.HesaptakiPara(vatandas.getPara());
            vatandas.Sicil(vatandas.isSicil());
            vatandas.SosyalDestek(vatandas.getSosyaldestek());
            if(VatandasX.getPuan()>=80)
            {
                System.out.println(" tebrikler vatandasliga hak kazandiniz...");
                break;
            }
            else 
                    {
              System.out.println(" vatandaslık icin yeterli puanınız yok...");
                    
                    }
        }
        
    }
	


	//dosya 2  // interface
	
package vatandaslıkverme;

public interface VatandasOlma {
    
    public void HesaptakiPara(int para);
    public void EgitimDuzeyi(boolean diploma);
    public void yas(int yas);
    public void DilBilgisi( boolean ingilizce);
    public void SosyalDestek( String sosyaldestek);
    public void Sicil(boolean sicil);
    
}
 
// dosya 3   vatandas olusturmak icin olusuturdugunuz vatandas sınıfı

package vatandaslıkverme;
public class VatandasX  implements VatandasOlma{
     private boolean ingilizce;
     private boolean diploma;
     private boolean sicil;
     private int yas;
     private int para;
     private String sosyaldestek;
     private static int puan=0;

    public static int getPuan() {
        return puan;
    }

    public static void setPuan(int puan) {
        VatandasX.puan = puan;
    }

    public VatandasX(boolean ingilizce, boolean diploma, boolean sicil, int yas, int para) {
        this.ingilizce = ingilizce;
        this.diploma = diploma;
        this.sicil = sicil;
        this.yas = yas;
        this.para = para;
    }

    public boolean isIngilizce() {
        return ingilizce;
    }

    public void setIngilizce(boolean ingilizce) {
        this.ingilizce = ingilizce;
    }

    public boolean isDiploma() {
        return diploma;
    }

    public void setDiploma(boolean diploma) {
        this.diploma = diploma;
    }

    public boolean isSicil() {
        return sicil;
    }

    public void setSicil(boolean sicil) {
        this.sicil = sicil;
    }

    public int getYas() {
        return yas;
    }

    public void setYas(int yas) {
        this.yas = yas;
    }

    public int getPara() {
        return para;
    }

    public void setPara(int para) {
        this.para = para;
    }

    public String getSosyaldestek() {
        return sosyaldestek;
    }

    public void setSosyaldestek(String sosyaldestek) {
        this.sosyaldestek = sosyaldestek;
    }

    @Override
    public  void HesaptakiPara(int para) {
        
        if(para>=12000)
        {
            System.out.println(" yeterli paraniz var...");
        }
        else 
        {
            System.out.println(" yeterli paraniz malesef yok...");
            
        }
    }

    @Override
    public void EgitimDuzeyi(boolean diploma) {
        
        if( diploma)
        {
            System.out.println(" vatandaslik icin yeterli paraniz var");
            puan+=20;
        }
        else 
        {
            System.out.println(" vatandaslik icin yeterli paraniz bulunmamaktadir");
        }
    }

    @Override
    public void yas(int yas) {
       
        if( yas>=34 && yas>=18)
        {
            System.out.println(" yasiniz vatadaslik icin tutuyor...");
            puan+=15;
        }
        else 
        {
            System.out.println(" yasiniz malesef vatandsaslik icin tutmuyor...");
        }
    }

    @Override
    public void DilBilgisi(boolean ingilizce) {
        if(ingilizce)
        {
                System.out.println(" vatandaslik icin ingilizce duzeyiniz var ");
                puan+=20;
        }
        else
        {
            System.out.println(" vatandaslik icin ingilizce duzeyiniz yok...");
        }
    }

    @Override
    public void SosyalDestek(String sosyaldestek) {
        if( sosyaldestek!=null)
        {
            System.out.println(" vatandaslik icin sosyal destek yapmissiniz");
            puan+=15;
            
        }
        else {
            System.out.println(" vatandaslik icin sosyal desteginiz bulunmuyor...");
        }
    }

    @Override
    public void Sicil(boolean sicil) {
       
        if(sicil==false)
        {
            System.out.println(" vatandaslik icin adli siciliniz yok...");
            puan+=15;
        }
        else
        {
             System.out.println(" vatandaslik icin adli siciliniz var...");
        
        }
    }
}

