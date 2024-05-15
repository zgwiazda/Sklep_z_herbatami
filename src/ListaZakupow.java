import java.util.ArrayList;

public class ListaZakupow {
    ArrayList<Produkt> lista = new ArrayList<>();

    public ListaZakupow(ArrayList<Produkt> lista) {
        this.lista = lista;
    }
    public String toString(){
       String tekst= "\n";
      if(!this.lista.isEmpty()) {
          for(Produkt p: lista){
            double cena= -1.0;
            String sprawdz = p.getClass().getSimpleName();
            sprawdz= sprawdz.toLowerCase();
            Cennik cennik= Cennik.getInstance();
            if(cennik.cennik.containsKey(sprawdz)) {
                ArrayList<Produkt> lista = cennik.cennik.get(sprawdz);
                for(Produkt c: lista){
                    if (c.smak.equals(p.smak)) {
                        if (p.ilosc >= c.maxIlosc) {
                            cena = c.cena;
                        }
                        else
                            cena = c.cenaDo;
                    }
                }
            }

            tekst+= sprawdz+ ", smak: "+p.smak+", ilosc: "+p.ilosc+" kg, cena "+ cena+'\n';
        }
    return tekst;}
      else
          return "---pusto";
    }

}
