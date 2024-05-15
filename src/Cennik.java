import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cennik {

    Map<String, ArrayList<Produkt>> cennik;
    private static Cennik instance = null;

    private Cennik() {
        cennik = new HashMap<>();
    }

    public static Cennik getInstance() {
        if (instance == null) {
            instance = new Cennik();
        }
        return instance;
    }

    public void dodaj(String nazwa, String smak, double cena){
       if(!cennik.containsKey(nazwa)){
           ArrayList<Produkt> lista = new ArrayList<>();
           lista.add(new Produkt(nazwa,smak,cena));
           cennik.put(nazwa, lista);
       }
        else{
            ArrayList<Produkt> lista = cennik.get(nazwa);
            lista.add(new Produkt(nazwa,smak,cena));
            cennik.put(nazwa,lista);
       }

    }

    public void dodaj(String nazwa, int maxIlosc, String smak, double cenaDo, double cena){
        //ArrayList<Produkt> lista = new ArrayList<>();
        //lista.add(new Produkt(nazwa,maxIlosc, smak,cenaDo, cena));
       // cennik.put(nazwa, lista);
        if(!cennik.containsKey(nazwa)){
            ArrayList<Produkt> lista = new ArrayList<>();
            lista.add(new Produkt(nazwa,maxIlosc, smak,cenaDo, cena));
            cennik.put(nazwa, lista);
        }
        else{
            ArrayList<Produkt> lista = cennik.get(nazwa);
            lista.add(new Produkt(nazwa, maxIlosc,smak,cenaDo, cena));
            cennik.put(nazwa,lista);
        }

    }

    public static Cennik pobierzCennik(){
        Cennik cennik = new Cennik();
        instance=cennik;
        return cennik;
    }

    // static ArrayList<Produkt> cennik;

   /* public void dodaj(String nazwa, String smak, double cena){
        Produkt p = new Produkt(nazwa,smak,cena);
        //     cennik.add(p);
    }
    public void dodaj(String nazwa,int maxIlosc, String smak, double cenaDo, double cena){
        Produkt p = new Produkt(nazwa, maxIlosc, smak, cenaDo, cena);cennik.add(p);
    }*/


}

