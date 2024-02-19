package busResv;
import java.util.*;
import java.sql.*;
public class CancelDAO {
    public static void cancel_ticket(int booking_id) throws SQLException
    {
        String qry = "delete from booking where booking_id="+booking_id;
        Connection con = DbConnection.getConnection();
        PreparedStatement st = con.prepareStatement(qry);
        st.executeUpdate();
    }
}
