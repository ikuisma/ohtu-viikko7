package ohtu.kivipaperisakset;

import java.util.HashMap;
import java.util.Scanner;

public class Paaohjelma {

    private static final Scanner scanner = new Scanner(System.in);
    private static final PeliTehdas peliTehdas = new PeliTehdas();

    public static void main(String[] args) {

        while (true) {
            System.out.println("\nValitse pelataanko"
                    + "\n (a) ihmistä vastaan "
                    + "\n (b) tekoälyä vastaan"
                    + "\n (c) parannettua tekoälyä vastaan"
                    + "\nmuilla valinnoilla lopetataan");

            String vastaus = scanner.nextLine();
            String avain = parseStringToKey(vastaus);

            try {
                KPSPeli peli = peliTehdas.hae(avain);
                System.out.println("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
                peli.pelaa();
            } catch (Exception e) {
                break;
            }
        }
    }

    private static String parseStringToKey(String s) {
        return "" + s.charAt(s.length() - 1);
    }

}

class PeliTehdas {

    private HashMap<String, KPSPeli> pelit;

    public PeliTehdas() {
        pelit = new HashMap<>();
        pelit.put("a", KPSPeli.luoPeliIhmistaVastaan());
        pelit.put("b", KPSPeli.luoPeliTekoalyaVastaan());
        pelit.put("c", KPSPeli.luoPeliParanneltuaTekoAlyaVastaan());
    }

    public KPSPeli hae(String valinta) {
        return pelit.get(valinta);
    }

}
