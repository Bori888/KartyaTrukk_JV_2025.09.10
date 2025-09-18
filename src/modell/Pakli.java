package modell;

import modell.Lap;

public class Pakli {
    private Lap[] lapok = new Lap[21];

    public Pakli() {
        feltolt();
    }

    private void feltolt() {
        String[] szinek = {"P", "T", "Z", "M"};
        String[] ertekek = {"Ász", "Kir", "Fel", "X", "IX", "VII"};

        int index = 0;
        int makkDb = 0;

        for (String szin : szinek) {
            for (String ertek : ertekek) {
                if (szin.equals("M") && makkDb >= 3) {
                    continue;
                }
                if (index < 21) {
                    lapok[index++] = new Lap(szin + "-" + ertek);
                    if (szin.equals("M")) makkDb++;
                }
            }
        }
    }

    public void kirak() {
        System.out.printf("%-12s%-12s%-12s%n", "1. oszlop", "2. oszlop", "3. oszlop");

        for (int sor = 0; sor < 7; sor++) {
            for (int oszlop = 0; oszlop < 3; oszlop++) {
                int idx = sor * 3 + oszlop;
                System.out.printf("%-12s", lapok[idx]);
            }
            System.out.println();
        }
        System.out.println("-----------------------------");
    }

    public void kever(int oszlop) {
        Lap[] oszlop1 = new Lap[7];
        Lap[] oszlop2 = new Lap[7];
        Lap[] oszlop3 = new Lap[7];

        for (int i = 0; i < 7; i++) {
            oszlop1[i] = lapok[i * 3];
            oszlop2[i] = lapok[i * 3 + 1];
            oszlop3[i] = lapok[i * 3 + 2];
        }

        Lap[] ujPakli = new Lap[21];
        Lap[] bal = null, kozep = null, jobb = null;

        switch (oszlop) {
            case 1:
                bal = oszlop2;
                kozep = oszlop1;
                jobb = oszlop3;
                break;
            case 2:
                bal = oszlop1;
                kozep = oszlop2;
                jobb = oszlop3;
                break;
            case 3:
                bal = oszlop1;
                kozep = oszlop3;
                jobb = oszlop2;
                break;
            default:
                throw new IllegalArgumentException("Az oszlopnak 1-3 között kell lennie.");
        }

        for (int i = 0; i < 7; i++) {
            ujPakli[i] = bal[i];
            ujPakli[i + 7] = kozep[i];
            ujPakli[i + 14] = jobb[i];
        }

        lapok = ujPakli;
    }

    public void ezVolt() {
        System.out.println("A gondolt lapod: " + lapok[10]);
    }

    public Lap[] getLapok() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
