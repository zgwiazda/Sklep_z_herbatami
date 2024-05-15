import java.util.ArrayList;

public class Klient {
    String nazwa;
    double iloscPieniedzy;
    Koszyk koszyk;

   ArrayList<Produkt> listaZakupow= new ArrayList<>();

    public Klient(String nazwa, double iloscPieniedzy) {
        this.nazwa = nazwa;
        this.iloscPieniedzy = iloscPieniedzy;
    }

    public void dodaj(Produkt p){
    listaZakupow.add(p);
    }
    public ListaZakupow pobierzListeZakupow(){
     ListaZakupow lista = new ListaZakupow(listaZakupow);
     return lista;
    }

    public void przepakuj(Koszyk koszyk){
        ArrayList<Produkt> listaKoszyk = new ArrayList<Produkt>();
        Cennik cennik= Cennik.getInstance();
        ArrayList<Produkt> nowaListaZakupow = new ArrayList<>();
        for(Produkt p: this.listaZakupow){
            String sprawdz = p.getClass().getSimpleName().toLowerCase();
            if(cennik.cennik.containsKey(sprawdz)){
                ArrayList<Produkt> lista = cennik.cennik.get(sprawdz);
               boolean czyJest=false;
                for(Produkt c: lista){
                    if(c.smak.equals(p.smak)){
                        listaKoszyk.add(p);
                        czyJest=true;
                        break;
                    }
                }
                if(!czyJest)
                    nowaListaZakupow.add(p);
            }
            else
                nowaListaZakupow.add(p);
        }
        this.listaZakupow=nowaListaZakupow;
        koszyk.koszyk = listaKoszyk;
        this.koszyk=koszyk;

    }

    public void zaplac(boolean czyPrzelew){
        double cenaWszystko=0;
        double cenaProdukt=0;
        double przechowajIloscPieniedzy = this.iloscPieniedzy;
        ArrayList<Produkt> nowyKoszyk= new ArrayList<>();
      for(Produkt p: this.koszyk.koszyk){
          String smak = p.smak;
        //bez prowizji
          if (czyPrzelew) {
              cenaProdukt=Kwota.wartosc(this.koszyk,smak);
              if(cenaProdukt<=this.iloscPieniedzy){
              this.iloscPieniedzy-=cenaProdukt;
              }
              else {
                  double pozostalyFundusz= this.iloscPieniedzy;
                  double cenaPolKg= Kwota.cenaCzesciKoszyka(p);
                  int ileKg = (int) (pozostalyFundusz/cenaPolKg);
                  pozostalyFundusz-=ileKg*cenaPolKg;
                  p.ilosc-=ileKg;
                  nowyKoszyk.add(p);
                  this.iloscPieniedzy=pozostalyFundusz;
              }
          }
        //z prowizja
          else {
                cenaProdukt=Kwota.wartosc(this.koszyk,smak);
                double przewidywanaKwota= (cenaWszystko+cenaProdukt)*1.02;
              if(przewidywanaKwota<=przechowajIloscPieniedzy){
                  cenaWszystko+= Kwota.wartosc(this.koszyk,smak);
                  przechowajIloscPieniedzy-=cenaProdukt;
              }
              else {
                  double pozostalyFundusz= przechowajIloscPieniedzy;
                  double cenaPolKg= Kwota.cenaCzesciKoszyka(p);
                  int ilePolKg = (int) (pozostalyFundusz/cenaPolKg);
                  pozostalyFundusz-=ilePolKg*cenaPolKg;
                  p.ilosc-=(ilePolKg/2);
                  nowyKoszyk.add(p);
                  przechowajIloscPieniedzy=pozostalyFundusz;
              }
          }

      }
      if(!czyPrzelew){
          double zaplata = this.iloscPieniedzy-przechowajIloscPieniedzy;
          zaplata=zaplata*1.02;
          this.iloscPieniedzy-=zaplata;
      }
        this.koszyk.koszyk=nowyKoszyk;
    }

    public double pobierzPortfel(){
        return this.iloscPieniedzy;
    }

public String pobierzKoszyk(){
        if(this.koszyk.koszyk.isEmpty())
            return "----pusto";
        else
            return koszyk.toString();

}

}
