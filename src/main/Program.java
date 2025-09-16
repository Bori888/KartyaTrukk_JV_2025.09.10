package main;

import java.util.Scanner;

public class Program {

    static String[] pakli = new String[21];

    public static void main(String[] args) {
        indito();
    }

    private static void indito() {
        osszeallit();
        for (int i = 0; i < 3; i++) {
            kirak();
            int oszlop = beker();
            kever(oszlop);
        }
        melyikVolt();
    }

    private static void osszeallit() {
        // 21 lap feltöltése (4 színnel, az M színből max 3 lap)
        String[] szinek = {"P", "T", "Z", "M"};
        String[] ertekek = {"Ász", "Kir", "Fel", "X", "IX", "VII"};

        int index = 0;
        int makkDb = 0;

        for (int i = 0; i < szinek.length; i++) {
            for (int j = 0; j < ertekek.length; j++) {
                if (szinek[i].equals("M") && makkDb >= 3) continue;
                if (index < 21) {
                    pakli[index++] = szinek[i] + "-" + ertekek[j];
                    if (szinek[i].equals("M")) makkDb++;
                }
            }
        }
    }

    private static void kirak() {
        System.out.printf("%-12s%-12s%-12s%n", "1. oszlop", "2. oszlop", "3. oszlop");

        for (int sor = 0; sor < 7; sor++) {
            for (int oszlop = 0; oszlop < 3; oszlop++) {
                int idx = sor * 3 + oszlop;
                System.out.printf("%-12s", pakli[idx]);
            }
            System.out.println();
        }

        System.out.println("-----------------------------");
    }

    private static int beker() {
        Scanner scanner = new Scanner(System.in);
        int oszlop = 0;
        while (oszlop < 1 || oszlop > 3) {
            System.out.print("Melyik oszlopban van a kiválasztott lap? (1-3): ");
            try {
                oszlop = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Hibás bevitel. Próbáld újra.");
            }
        }
        return oszlop;
    }

    private static void kever(int oszlop) {
        String[] oszlop1 = new String[7];
        String[] oszlop2 = new String[7];
        String[] oszlop3 = new String[7];

        // Oszlopok kiszedése a pakliból a kirakás logikájával egyezően (soronként 3 oszlop)
        for (int i = 0; i < 7; i++) {
            oszlop1[i] = pakli[i * 3 + 0];
            oszlop2[i] = pakli[i * 3 + 1];
            oszlop3[i] = pakli[i * 3 + 2];
        }

        // Új pakli összeállítása: választott oszlop mindig középre kerül
        String[] ujPakli = new String[21];

        String[] bal = null, kozep = null, jobb = null;

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
        }

        for (int i = 0; i < 7; i++) {
            ujPakli[i * 3 + 0] = bal[i];
            ujPakli[i * 3 + 1] = kozep[i];
            ujPakli[i * 3 + 2] = jobb[i];
        }

        pakli = ujPakli;
    }

    private static void melyikVolt() {
        System.out.println("A gondolt lapod: " + pakli[10]);
    }
}
