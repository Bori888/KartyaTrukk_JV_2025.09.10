package main;

import modell.Pakli;
//mport nezet.KartyaTrukk_CUI;
import nezet.KartyaTrukk_JOP;

public class Indit {

    public static void main(String[] args) {
        Indit indit = new Indit();
        indit.indito();
    }

    private void indito() {
        Pakli pakli = new Pakli();
        //KartyaTrukk_CUI kartyaTrukk = new KartyaTrukk_CUI();
        KartyaTrukk_JOP kartyaTrukk = new KartyaTrukk_JOP();

        for (int i = 0; i < 3; i++) {
            pakli.kirak();
            int oszlop = kartyaTrukk.melyik();
            pakli.kever(oszlop);
        }
        pakli.ezVolt();
    }
}