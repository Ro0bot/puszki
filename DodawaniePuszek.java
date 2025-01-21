import java.util.Scanner;
import java.sql.*;

/**
 * Klasa zapisująca puszki w bazie danych
 */

public class DodawaniePuszek {
    String firma;
    String smak;
    int mililitry;
    double cena;
    boolean cukier;
    Puszka puszka;
    String powiazanie;
    String aromat;
    String kolor;
    LimitowanaPuszka lPuszka;

    Scanner sc = new Scanner(System.in);
    Polaczenie con = new Polaczenie();

    /**
     * Nie wiem, nie działa bez tego
     *
     * @throws SQLException Rzuca błąd SQL, jeżeli takowy zajdzie
     */

    public DodawaniePuszek() throws SQLException {

    }

    /**
     * Metoda wysyła puszki do bazy
     */

    public void dodawanie() {
        System.out.println("Jaką puszkę chcesz dodać?");
        System.out.println("1 - Zwykłą");
        System.out.println("2 - Limitowaną");
        int rodzaj = sc.nextInt();
        switch (rodzaj) {
            case 1:
                System.out.println("Podaj firmę producenta");
                firma = sc.next();
                System.out.println("Podaj smak napoju");
                smak = sc.next();
                System.out.println("Podaj ilość mililitrów");
                boolean check = true;
                while (check == true) {
                    try {
                        mililitry = sc.nextInt();
                    } catch (Exception e) {
                        System.out.println("Podano coś innego niż liczbę, spróbuj ponownie");
                    } finally {
                        check = false;
                    }
                }
                System.out.println("Podaj cenę");
                check = true;
                while (check == true) {
                    try {
                        cena = sc.nextDouble();
                    } catch (Exception e) {
                        System.out.println("Podano coś innego niż liczbę lub podano '.' zamiast ',', spróbuj ponownie");
                    } finally {
                        check = false;
                    }
                }
                System.out.println("Czy zawiera cukier?");
                System.out.println("Wpisz true jeśli tak, lub false jeśli nie");
                check = true;
                while (check == true) {
                    try {
                        cukier = sc.nextBoolean();
                    } catch (Exception e) {
                        System.out.println("Podano coś innego niż true lub false, spróbuj ponownie");
                    } finally {
                        check = false;
                    }
                }
                puszka = new Puszka(firma, smak, mililitry, cena, cukier);
                puszka.nowaPuszka();
                try (con.conn) {
                    String insert = "INSERT INTO zwykle_puszki (firma, smak, mililitry, cena, cukier) VALUES (?, ?, ?, ?, ?)";
                    PreparedStatement PS = con.conn.prepareStatement(insert);
                    PS.setString(1, firma);
                    PS.setString(2, smak);
                    PS.setInt(3, mililitry);
                    PS.setDouble(4, cena);
                    PS.setBoolean(5,cukier);
                    PS.executeUpdate();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case 2:
                System.out.println("Podaj firmę producenta");
                firma = sc.next();
                System.out.println("Podaj smak napoju (podstawowy jeśli występuje dodatkowy aromat)");
                smak = sc.next();
                System.out.println("Podaj aromat (dodatkowy smak) jaki ma napój (jeśli jakiś aromat występuje)");
                aromat = sc.next();
                System.out.println("Podaj ilość mililitrów");
                check = true;
                while (check == true) {
                    try {
                        mililitry = sc.nextInt();
                    } catch (Exception e) {
                        System.out.println("Podano coś innego niż liczbę, spróbuj ponownie");
                    } finally {
                        check = false;
                    }
                }
                System.out.println("Podaj cenę");
                check = true;
                while (check == true) {
                    try {
                        cena = sc.nextDouble();
                    } catch (Exception e) {
                        System.out.println("Podano coś innego niż liczbę lub podano '.' zamiast ',', spróbuj ponownie");
                    } finally {
                        check = false;
                    }
                }
                System.out.println("Czy zawiera cukier?");
                System.out.println("Wpisz true jeśli tak, lub false jeśli nie");
                check = true;
                while (check == true) {
                    try {
                        cukier = sc.nextBoolean();
                    } catch (Exception e) {
                        System.out.println("Podano coś innego niż true lub false, spróbuj ponownie");
                    } finally {
                        check = false;
                    }
                }
                System.out.println("Podaj kto / co pojawia się na puszce");
                powiazanie = sc.next();
                System.out.println("Podaj kolor puszki");
                kolor = sc.next();
                lPuszka = new LimitowanaPuszka(firma, smak, mililitry, cena, cukier, powiazanie, aromat, kolor);
                lPuszka.nowaPuszka();
                try (con.conn) {
                    String insert = "INSERT INTO limitowane_puszki (firma, smak, mililitry, cena, cukier, powiazanie, aromat, kolor) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
                    PreparedStatement PS = con.conn.prepareStatement(insert);
                    PS.setString(1, firma);
                    PS.setString(2, smak);
                    PS.setInt(3, mililitry);
                    PS.setDouble(4, cena);
                    PS.setBoolean(5,cukier);
                    PS.setString(6,powiazanie);
                    PS.setString(7, aromat);
                    PS.setString(8,kolor);
                    PS.executeUpdate();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            default:
                System.out.println("Podano złą cyfre");
                break;
        }
    }
}
