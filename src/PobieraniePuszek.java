import java.util.Scanner;
import java.sql.*;

/**
 * Klasa pobierająca puszki z bazy danych
 */
public class PobieraniePuszek {
    Scanner sc = new Scanner(System.in);
    Polaczenie con = new Polaczenie();

    /**
     * Nie wiem, nie działa bez tego
     *
     * @throws SQLException Rzuca błąd SQL, jeżeli takowy zajdzie
     */

    public PobieraniePuszek() throws SQLException {

    }

    /**
     * Metoda pobiera puszki z bazy
     */

    public void pobieranie() {
        System.out.println("1 - Przejrzyj wszystkie puszki");
        System.out.println("2 - Podaj specyficzne polecenie");
        int tryb = sc.nextInt();
        switch (tryb) {
            case 1:
                System.out.println("Które puszki chcesz przejrzeć?");
                System.out.println("1 - Zwykłe");
                System.out.println("2 - Limitowane");
                int tabela = sc.nextInt();
                switch (tabela) {
                    case 1:
                        String normal = "SELECT * FROM zwykle_puszki";
                        try {
                            Statement statement = con.conn.createStatement();
                            ResultSet resultSet = statement.executeQuery(normal);
                            while (resultSet.next()) {
                                int baza_id_p = resultSet.getInt("id_p");
                                String baza_firma = resultSet.getString("firma");
                                String baza_smak = resultSet.getString("smak");
                                int baza_mililitry = resultSet.getInt("mililitry");
                                int baza_cena = resultSet.getInt("cena");
                                boolean baza_cukier = resultSet.getBoolean("cukier");
                                System.out.println("ID: " + baza_id_p + ", Firma: " + baza_firma + ", Smak: " + baza_smak + ", Mililitry: " + baza_mililitry + ", Cena: " + baza_cena + ", Cukier: " + baza_cukier);
                            }
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                        break;
                    case 2:
                        String limited = "SELECT * FROM limitowane_puszki";
                        try {
                            Statement statement = con.conn.createStatement();
                            ResultSet resultSet = statement.executeQuery(limited);
                            while (resultSet.next()) {
                                int baza_id_p = resultSet.getInt("id_p");
                                String baza_firma = resultSet.getString("firma");
                                String baza_smak = resultSet.getString("smak");
                                int baza_mililitry = resultSet.getInt("mililitry");
                                int baza_cena = resultSet.getInt("cena");
                                boolean baza_cukier = resultSet.getBoolean("cukier");
                                String baza_powiazanie = resultSet.getString("powiazanie");
                                String baza_aromat = resultSet.getString("aromat");
                                String baza_kolor = resultSet.getString("kolor");
                                System.out.println("ID: " + baza_id_p + ", Firma: " + baza_firma + ", Smak: " + baza_smak + ", Mililitry: " + baza_mililitry + ", Cena: " + baza_cena + ", Cukier: " + baza_cukier + ", Powiazanie " + baza_powiazanie + ", Aromat " + baza_aromat + ", Kolor " + baza_kolor);
                            }

                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                        break;
                    default:
                        System.out.println("Podano złą cyfre");
                        break;
                }
                break;
            case 2:
                System.out.println("Podaj polecenie");
                sc.nextLine();
                String sql = sc.nextLine().trim();
                try {
                    Statement statement = con.conn.createStatement();
                    ResultSet resultSet = statement.executeQuery(sql);
                    ResultSetMetaData metadata = resultSet.getMetaData();
                    int kolumny = metadata.getColumnCount();

                    System.out.print("Kolumny: ");
                    int i = 1;
                    System.out.print(metadata.getColumnName(i).substring(0, 1).toUpperCase() + metadata.getColumnName(i).substring(1));

                    if (kolumny > 1) {
                        for (i = 2; i <= kolumny; i++) {
                            System.out.print(" | " + metadata.getColumnName(i).substring(0, 1).toUpperCase() + metadata.getColumnName(i).substring(1));
                        }
                    }

                    System.out.println("\n-----------------------------------------------");

                    while (resultSet.next()) {
                        for (i = 1; i <= kolumny; i++) {
                            String columnValue = resultSet.getString(i);
                            System.out.print("[ " + metadata.getColumnName(i).substring(0, 1).toUpperCase() + metadata.getColumnName(i).substring(1) + ": " + columnValue.substring(0, 1).toUpperCase() + columnValue.substring(1) + " ] ");
                        }
                        System.out.println();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
        }
    }
}
