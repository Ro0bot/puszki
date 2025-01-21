import java.util.Scanner;
import java.sql.*;

/**
 * Klasa główna
 */

public class Main {

    /**
     * Metoda główna spinająca cały interfejs
     *
     * @param args Przekazuje parametry do konsoli wiersza poleceń
     * @throws SQLException Wykrywa i wyrzuca błąd SQL jeśli wystąpi
     */

    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        DodawaniePuszek DP = new DodawaniePuszek();
        PobieraniePuszek PP = new PobieraniePuszek();

        while (true) {
            System.out.println();
            System.out.println("Witaj!");
            System.out.println("Aby dodać puszke, wciśnij 1");
            System.out.println("Aby pokazać zebrane puszki, wciśnij 2");
            System.out.println("Aby zamknąć program, wciśnij 3");
            try {
                int wybor = sc.nextInt();
                switch (wybor) {
                    case 1:
                        DP.dodawanie();
                        break;
                    case 2:
                        PP.pobieranie();
                        break;
                    case 3:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Podano złą liczbę");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Podano nieprawidłowy znak");
            }
        }
    }
}
