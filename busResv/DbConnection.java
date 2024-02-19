package busResv;
import java.sql.*;
public class DbConnection {
    private static final String url="jdbc:mysql://localhost:8279/busresv";
    private static final String userName = "root";
    private static final String password = "gtw4t";
    public static Connection getConnection() throws SQLException{
        return  DriverManager.getConnection(url,userName,password);
    }
}
