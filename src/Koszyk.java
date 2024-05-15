import java.util.ArrayList;

public class Koszyk {
    ArrayList<Produkt> koszyk;
    Klient klient;

    public Koszyk(Klient klient) {
        this.klient = klient;
    }

    public String toString(){
       if(!koszyk.isEmpty()){
           String tekst="\n";
        for(Produkt p: koszyk){
            double cena= -1.0;
            String sprawdz = p.getClass().getSimpleName();
            sprawdz= sprawdz.toLowerCase();
            Cennik cennik= Cennik.getInstance();
            if(cennik.cennik.containsKey(sprawdz)) {
                ArrayList<Produkt> lista = cennik.cennik.get(sprawdz);
                for(Produkt c: lista){
                    if (c.smak.equals(p.smak)) {
                        if (p.ilosc > c.maxIlosc) {
                            cena = c.cena;
                        }
                        else
                            cena = c.cenaDo;
                    }
                }
            }

            tekst+= sprawdz+ ", smak: "+p.smak+", ilosc: "+p.ilosc+" kg, cena "+ cena+'\n';
        }
        return tekst;
       }
       else
           return "-----pusto";
    }

}


