package nezet;



import java.util.Scanner;

public class KartyaTrukk_CUI {
    private Scanner scanner = new Scanner(System.in);

    public int melyik() { // oszlop
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
}
