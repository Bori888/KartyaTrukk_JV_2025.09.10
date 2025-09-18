package nezet;

import javax.swing.JOptionPane;
import modell.Lap;

public class KartyaTrukk_JOP {
    
    public void kirak(Lap[] lapok) {
        String szoveg = "1. oszlop\t2. oszlop\t3. oszlop\n\n";

        for (int sor = 0; sor < 7; sor++) {
            int idx1 = sor * 3;
            int idx2 = sor * 3 + 1;
            int idx3 = sor * 3 + 2;

            szoveg += lapok[idx1].toString() + "\t"
                    + lapok[idx2].toString() + "\t"
                    + lapok[idx3].toString() + "\n";
        }

        JOptionPane.showMessageDialog(null, szoveg, "Pakli kirakása", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public int melyik() {
        Object[] options = {"1", "2", "3"};
        int valasztas = JOptionPane.showOptionDialog(null, "Melyik oszlopban van a kiválasztott lap? (1-3)", "Kártyatrükk - Oszlop választás", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        if (valasztas == -1) {
            System.exit(0);
        }

        return valasztas + 1;
    }

    public void mutatVegsoLap(Lap lap) {
        JOptionPane.showMessageDialog(null, "A gondolt lapod: " + lap.toString(), "Eredmény", JOptionPane.INFORMATION_MESSAGE);
    }
}
