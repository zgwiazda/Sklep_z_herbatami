public class Main {

    public static void main(String[] args) {

        // cennik
        Cennik cennik = Cennik.pobierzCennik();

        // dodawanie nowych cen do cennika
        cennik.dodaj("zielona", 4, "imbir", 80, 70);	// zielona herbata o smaku imbirowym kosztuje 80 zł/kg jeśli klient kupi nie więcej niż 4 kg,
        // w innym przypadku kosztuje 70 zł/kg

        cennik.dodaj("czarna", "kiwi", 120);		// czarna herbata o smaku kiwi kosztuje 120 zł/kg niezależnie od ilości

        cennik.dodaj("czerwona", "truskawka", 80);	// czerwona herbata o smaku truskawkowym kosztuje 80 zł/kg niezależnie od ilości

        cennik.dodaj("zielona", "jaśmin", 150);		// zielona herbata o smaku jaśminowym kosztuje 150 zł/kg niezależnie od ilości

        // Klient Herbal deklaruje kwotę 2000 zł na zakupy
        Klient herbal = new Klient("herbal", 2000);

        // Klient Herbal dodaje do listy zakupów
        // różne rodzaje herbaty: 5 kg zielonej imbirowej, 5 kg czerwonej truskawkowej,
        // 3 kg niebieskiej waniliowej, 3 kg czarnej kiwi
        herbal.dodaj(new Zielona("imbir", 5));
        herbal.dodaj(new Czerwona("truskawka", 5));
        herbal.dodaj(new Niebieska("wanilia", 3));
        herbal.dodaj(new Czarna("kiwi", 3));

        // Lista zakupów Herbala
        ListaZakupow listaHerbala = herbal.pobierzListeZakupow();

        System.out.println("Lista zakupów klienta herbal:" + listaHerbala);

        // Przed płaceniem, klient przepakuje herbaty z listy zakupów do koszyka.
        // Możliwe, że na liście zakupów są herbaty niemające ceny w cenniku,
        // w takim przypadku zostałyby usunięte z koszyka (ale nie z listy zakupów)
        Koszyk koszykHerbala = new Koszyk(herbal);
        herbal.przepakuj(koszykHerbala);

        // Co jest na liście zakupów Herbala
        System.out.println("Po przepakowaniu, lista zakupów klienta herbal:" + herbal.pobierzListeZakupow());

        // Co jest w koszyku Herbala
        System.out.println("Po przepakowaniu, koszyk klienta herbal: " + koszykHerbala);

        // Jaka jest wartość herbaty o smaku truskawkowym w koszyku Herbala
       System.out.println("Herbata truskawkowa w koszyku Herbala kosztowała:  "
                + Kwota.wartosc(koszykHerbala, "truskawka")+'\n');

        // Klient zapłaci...
        herbal.zaplac(true);	// płaci przelewem (true), bez prowizji

        // Ile Herbalowi zostało pieniędzy?
        System.out.println("Po zapłaceniu, Herbalowi zostało : " + herbal.pobierzPortfel() + " zł\n");

        // Mogło klientowi zabraknąć srodków, wtedy herbaty są odkładane,
        // w innym przypadku koszyk jest pusty po zapłaceniu
        System.out.println("Po zapłaceniu, koszyk klienta herbal:" + herbal.pobierzKoszyk());
        System.out.println("Po zapłaceniu, koszyk klienta herbal:" + koszykHerbala);

        System.out.println(" ");
        // Teraz przychodzi Kawuś,
        // deklaruje 620 zł na zakupy
        Klient kawus = new Klient("kawus", 620);

        // Nabrał herbaty za dużo jak na tę kwotę
        kawus.dodaj(new Zielona("imbir", 3));
        kawus.dodaj(new Czarna("kiwi", 4));

        // Co Kawuś ma na swojej liście zakupów
        System.out.println("Lista zakupów klienta kawus:" + kawus.pobierzListeZakupow());

        // Przepakowanie z listy zakupów do koszyka,
        // może się okazać, że na liście zakupów są herbaty niemające ceny w cenniku,
        // w takim razie zostałyby usunięte z koszyka (ale nie z listy zakupów)
        Koszyk koszykKawusia = new Koszyk(kawus);
        kawus.przepakuj(koszykKawusia);

        // Co jest na liście zakupów Kawusia
        System.out.println("Po przepakowaniu, lista zakupów klienta kawus:" + kawus.pobierzListeZakupow());
        System.out.println(" ");

        // A co jest w koszyku Kawusia
        System.out.println("Po przepakowaniu, koszyk klienta kawus:" + kawus.pobierzKoszyk());

        // Kawuś płaci
        kawus.zaplac(false);	// płaci kartą płatniczą (false), prowizja = 2%

        // Ile Kawusiowi zostało pieniędzy?
        System.out.println("Po zapłaceniu, Kawusiowi zostało : " + kawus.pobierzPortfel() + " zł\n");

        // Co zostało w koszyku Kawusia (za mało pieniędzy miał)
        System.out.println("Po zapłaceniu, koszyk klienta kawus:" + koszykKawusia);

    }
}
