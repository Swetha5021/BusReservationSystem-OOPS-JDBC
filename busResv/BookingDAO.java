package busResv;
import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.sql.*;
public class BookingDAO
{
    public static int getBookedCount(int bus_no,Date date) throws SQLException
    {
        String qry="select count(name) from booking where bus_no=? and travel_date=?";
        Connection con = DbConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(qry);
        java.sql.Date sqldate = new java.sql.Date(date.getTime());
        ps.setInt(3,bus_no);
        ps.setDate(4,sqldate);
        ResultSet rs = ps.executeQuery();
        rs.next();
        return rs.getInt(1);
    }
    public void addBooking(Booking booking) throws SQLException
    {
        String qry = "insert into booking values(?,?,?,?)";
        Connection con = DbConnection.getConnection();
        PreparedStatement pst = con.prepareStatement(qry);
        java.sql.Date sqldate = new java.sql.Date(booking.date.getTime());
        pst.setInt(1, booking.booking_id);
        pst.setString(2, booking.passengerName);
        pst.setInt(3, booking.busNo);
        pst.setDate(4, sqldate);

        pst.executeUpdate();
    }
}
