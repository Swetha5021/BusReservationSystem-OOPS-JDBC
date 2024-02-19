package busResv;
import java.util.*;
import java.sql.*;
public class BusDAO {
    public void displayBusInfo() throws SQLException
    {
        String qry = "select * from bus";
        Connection con = DbConnection.getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(qry);
        while(rs.next())
        {
            System.out.println("Bus No: " + rs.getInt(1));
            if(rs.getInt(2)==0)
                System.out.println("AC: Not available");
            else
                System.out.println("AC: Available");
            System.out.println("Capacity: " + rs.getInt(3));
        }
        System.out.println("------------------------------------------");
    }
    public static int getCapacity(int id) throws SQLException
    {
        String qry="select capacity from bus where id="+id;
        Connection con = DbConnection.getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(qry);
        rs.next();
        return rs.getInt(1);
    }
}
