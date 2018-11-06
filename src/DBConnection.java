import java.sql.*;


public class DBConnection {

    Connection conn;

    public DBConnection() throws SQLException {
        conn = DriverManager.getConnection("jdbc:h2:~/test", "Natalia", "damnbd");
    }

    public Connection getConnection() {
        return conn;
    }
}


