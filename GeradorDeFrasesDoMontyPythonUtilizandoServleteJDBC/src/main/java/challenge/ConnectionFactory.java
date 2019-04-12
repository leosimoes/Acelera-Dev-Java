package challenge;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public static Connection createConnection() throws SQLException {
        String url = "jdbc:sqlite::resource:database.sqlite";
        return DriverManager.getConnection(url);
    }
}
