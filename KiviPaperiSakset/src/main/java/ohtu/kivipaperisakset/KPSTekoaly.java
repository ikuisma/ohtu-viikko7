package ohtu.kivipaperisakset;

import java.util.Scanner;

public class KPSTekoaly extends KPSPeli {

    private static final Scanner scanner = new Scanner(System.in);
    private TekoalyPelaaja tekoaly;

    protected KPSTekoaly(TekoalyPelaaja tekoaly) {
        this.tekoaly = tekoaly;
    }

    @Override
    protected void suoritaVastustajanSiirto() {
        tokanSiirto = tekoaly.annaSiirto();
        System.out.println("Tietokone valitsi: " + tokanSiirto);
        tekoaly.asetaSiirto(ekanSiirto);
    }

}