import java.sql.*;

/**
 * Klasa obsługująca połączenie z bazą danych
 */

public class Polaczenie {
    String url = "jdbc:mysql://localhost:3306/puszki";
    String user = "root";
    String password = "";

    final Connection conn = DriverManager.getConnection(url, user, password);

    /**
     * Nie wiem, nie działa bez tego
     *
     * @throws SQLException Rzuca błąd SQL, jeżeli takowy zajdzie
     */

    public Polaczenie() throws SQLException {

    }
}
