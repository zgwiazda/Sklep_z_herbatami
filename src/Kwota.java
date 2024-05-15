import java.util.ArrayList;

abstract public class Kwota {
    public static double wartosc(Koszyk koszyk, String smak){
    double cena=0;
    double ilosc=0;
    double kwotaFinal=0;
    for(Produkt p: koszyk.koszyk){
        if(p.smak.equals(smak)){
            ilosc= p.ilosc;
            Cennik cennik= Cennik.getInstance();
            String sprawdz= p.getClass().getSimpleName().toLowerCase();
            ArrayList<Produkt> lista = cennik.cennik.get(sprawdz);
            for(Produkt c: lista){
                if(c.smak.equals(smak)){
                    if(ilosc>c.maxIlosc){
                        cena=c.cena;
                        break;
                    }
                    else{
                        cena=c.cenaDo;
                    break;
                    }
                }
            }
        }
    }
    kwotaFinal=cena*ilosc;
    return kwotaFinal;
    }
    public static double cenaCzesciKoszyka(Produkt produkt){
        double cenaProduktu=0;
        String sprawdz= produkt.getClass().getSimpleName().toLowerCase();
        Cennik cennik = Cennik.getInstance();
        ArrayList<Produkt> lista = cennik.cennik.get(sprawdz);
        for(Produkt c: lista){
            if(c.smak.equals(produkt.smak)){
                if(produkt.ilosc>c.maxIlosc){
                    cenaProduktu=c.cena;
                }
                else
                    cenaProduktu=c.cenaDo;
            }
        }
        double cenaPolKg = cenaProduktu*0.5;
        return cenaPolKg;
    }
}
