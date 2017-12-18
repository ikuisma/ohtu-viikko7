package ohtu.kivipaperisakset;

import java.util.Scanner;

public class KPSPelaajaVsPelaaja extends KPSPeli {

    @Override
    protected void suoritaVastustajanSiirto() {
        System.out.print("Toisen pelaajan siirto: ");
        tokanSiirto = lueRivi();
    }


}