package ohtu.kivipaperisakset;

import java.util.Scanner;

public abstract class KPSPeli {

    private static final Scanner scanner = new Scanner(System.in);
    protected String ekanSiirto;
    protected String tokanSiirto;

    public void pelaa() {
        Tuomari tuomari = new Tuomari();

        suoritaPelaajanSiirto();
        suoritaVastustajanSiirto();

        while (onkoOkSiirto(ekanSiirto) && onkoOkSiirto(tokanSiirto)) {
            tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
            System.out.println(tuomari);
            System.out.println();

            suoritaPelaajanSiirto();
            suoritaVastustajanSiirto();
        }

        System.out.println();
        System.out.println("Kiitos!");
        System.out.println(tuomari);
    }

    private void suoritaPelaajanSiirto() {
        System.out.print("Ensimmäisen pelaajan siirto: ");
        ekanSiirto = lueRivi();
    }

    protected String lueRivi() {
        return scanner.nextLine();
    }

    protected abstract void suoritaVastustajanSiirto();

    private static boolean onkoOkSiirto(String siirto) {
        return "k".equals(siirto) || "p".equals(siirto) || "s".equals(siirto);
    }

    public static KPSPeli luoPeliTekoalyaVastaan() {
        return new KPSTekoaly(new Tekoaly());
    }

    public static KPSPeli luoPeliParanneltuaTekoAlyaVastaan() {
        return new KPSTekoaly(new TekoalyParannettu(20));
    }

    public static KPSPeli luoPeliIhmistaVastaan() {
        return new KPSPelaajaVsPelaaja();
    }

}
