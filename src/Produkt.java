public class Produkt {
    private static Produkt instance = null;

     String nazwa;
   String smak;
     double cena;
     int maxIlosc;
     double cenaDo;
     double ilosc;

    Produkt(String nazwa, String smak, double cena) {
        this.nazwa=nazwa;
        this.smak=smak;
        this.cena=cena;
    }
    Produkt(String nazwa, int maxIlosc, String smak, double cenaDo, double cena){
        this.nazwa=nazwa;
        this.maxIlosc=maxIlosc;
        this.smak=smak;
        this.cenaDo=cenaDo;
        this.cena=cena;
    }

    Produkt(String smak,double ilosc){
        this.smak=smak;
        this.ilosc=ilosc;
    }
}
