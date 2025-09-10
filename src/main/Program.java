package main;

public class Program {

    public static void main(String[] args) {
        String[] pakli = new String[22];
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

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 3; j++) {
                int idx = i * 3 + j;
                if (idx < pakli.length) {
                    System.out.printf("%-8s", pakli[idx]);
                }
            }
            System.out.println();
        }

        
    }

}
