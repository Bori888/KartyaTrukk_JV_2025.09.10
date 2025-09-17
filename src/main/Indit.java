package main;

public class Indit {

    public static void main(String[] args) {
        Indit indit = new Indit();
        indit.indito();
    }

    private void indito() {
        Pakli pakli = new Pakli();
        KartyaTrukk kartyaTrukk = new KartyaTrukk();

        for (int i = 0; i < 3; i++) {
            pakli.kirak();
            int oszlop = kartyaTrukk.melyik();
            pakli.kever(oszlop);
        }
        pakli.ezVolt();
    }
}
