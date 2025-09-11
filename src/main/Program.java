package main;

import java.util.Scanner;

public class Program {

    static String[] pakli = new String[22];

    public static void main(String[] args) {
        indito();
    }

    private static void indito() {
        for (int i = 0; i < 3; i++) {
            osszealit();
            kirak();
            beker();
            int oszlop = beker();
            kever(oszlop);
        }
        melyikVolt();
    }

    private static void osszealit() {
        String[] szinek = {"P", "T", "Z", "M"}; // Pikk, Tök, Zöld, Makk
        String[] ertekek = {"Ász", "Kir", "Fel", "X", "IX", "VII"};

        int index = 0;
        int makkDb = 0;

        for (int i = 0; i < szinek.length; i++) {
            for (int j = 0; j < ertekek.length; j++) {
                if (szinek[i].equals("M") && makkDb >= 3) {
                } else if (index < pakli.length) {
                    pakli[index] = szinek[i] + "-" + ertekek[j];
                    index++;
                    if (szinek[i].equals("M")) {
                        makkDb++;
                    }
                }
            }
        }
    }

    private static void kirak() {
        System.out.printf("%-10s%-10s%-10s%n", "1. oszlop", "2. oszlop", "3. oszlop");

        for (int sor = 0; sor < 7; sor++) {
            for (int oszlop = 0; oszlop < 3; oszlop++) {
                int idx = oszlop * 7 + sor;
                if (idx < pakli.length) {
                    System.out.printf("%-12s", pakli[idx]);
                }
            }
            System.out.println();
        }

        System.out.println("-----------------------------");
    }

    private static int beker() {
        Scanner scanner = new Scanner(System.in);
        int oszlop = 0;
        while (!(oszlop >= 1 && oszlop <= 3)) {
            System.out.print("Melyik oszlopban van a kiválasztott lap? (1-3): ");
            String input = scanner.nextLine().trim();
            try {
                oszlop = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Hibás érték! Kérlek, számot adj meg.");
                oszlop = 0;
            }
        }
        return oszlop;
    }

    private static void kever(int oszlop) {
        
        int index = 0;

        switch (oszlop) {
            case 1:
                for (int i = 1; i <= 7; i++) {
                    pakli[index++] = pakli[20 - (i - 1) * 3];
                    pakli[index++] = pakli[19 - (i - 1) * 3]; 
                    pakli[index++] = pakli[21 - 1 - (i - 1) * 3]; 
                }
                
            case 2:
                for (int i = 1; i <= 7; i++) {
                    pakli[index++] = pakli[19 - (i - 1) * 3]; 
                    pakli[index++] = pakli[20 - (i - 1) * 3]; 
                    pakli[index++] = pakli[21 - 1 - (i - 1) * 3]; 
                }
                
            case 3:
                for (int i = 1; i <= 7; i++) {
                    pakli[index++] = pakli[19 - (i - 1) * 3]; 
                    pakli[index++] = pakli[21 - 1 - (i - 1) * 3]; 
                    pakli[index++] = pakli[20 - (i - 1) * 3]; 
                }
                
        }

        
    }

    private static void melyikVolt() {
        //
    }

}
