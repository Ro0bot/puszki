import java.util.Scanner;
import java.sql.*;
public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/puszki";
        String user = "root";
        String password = "";
        Scanner sc = new Scanner(System.in);
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

        System.out.println("Jaką puszkę chcesz dodać?");
        System.out.println("1 - Zwykłą");
        System.out.println("2 - Limitowaną");
        int wybor = sc.nextInt();
        switch (wybor) {
            case 1:
                System.out.println("Podaj firmę producenta");
                firma = sc.next();
                System.out.println("Podaj smak napoju");
                smak = sc.next();
                System.out.println("Podaj ilość mililitrów");
                mililitry = sc.nextInt();
                System.out.println("Podaj cenę");
                cena = sc.nextDouble();
                System.out.println("Czy zawiera cukier?");
                System.out.println("Wpisz true jeśli tak, lub false jeśli nie");
                cukier = sc.nextBoolean();
                puszka = new Puszka(firma, smak, mililitry, cena, cukier);
                puszka.nowaPuszka();
                try (Connection conn = DriverManager.getConnection(url, user, password)) {
                    String insert = "INSERT INTO zwykle_puszki (firma,smak,mililitry,cena,cukier) VALUES (?,?,?,?,?)";
                    PreparedStatement PS = conn.prepareStatement(insert);
                    PS.setString(1, firma);
                    PS.setString(2, smak);
                    PS.setInt(3, mililitry);
                    PS.setDouble(4, cena);
                    PS.setBoolean(5,cukier);
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
                mililitry = sc.nextInt();
                System.out.println("Podaj cenę");
                cena = sc.nextDouble();
                System.out.println("Czy zawiera cukier?");
                System.out.println("Wpisz true jeśli tak, lub false jeśli nie");
                cukier = sc.nextBoolean();
                System.out.println("Podaj kto / co pojawia się na puszce");
                powiazanie = sc.next();
                System.out.println("Podaj kolor puszki");
                kolor = sc.next();
                lPuszka = new LimitowanaPuszka(firma, smak, mililitry, cena, cukier, powiazanie, aromat, kolor);
                lPuszka.nowaPuszka();
                try (Connection conn = DriverManager.getConnection(url, user, password)) {
                    String insert = "INSERT INTO limitowe_puszki (firma,smak,mililitry,cena,cukier,powiazanie,kolor) VALUES (?,?,?,?,?,?,?)";
                    PreparedStatement PS = conn.prepareStatement(insert);
                    PS.setString(1, firma);
                    PS.setString(2, smak);
                    PS.setInt(3, mililitry);
                    PS.setDouble(4, cena);
                    PS.setBoolean(5,cukier);
                    PS.setString(6,powiazanie);
                    PS.setString(7,kolor);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
        }
    }
}
