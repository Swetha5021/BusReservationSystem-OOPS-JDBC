package busResv;
import java.util.*;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
public class Booking {
    int booking_id;
    String passengerName;
    int busNo;
    Date date;
    Booking() throws ParseException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter id:");
        booking_id = sc.nextInt();
        System.out.println("Enter your name:");
        passengerName = sc.next();
        System.out.println("Enter bus no: ");
        busNo = sc.nextInt();
        System.out.println("Enter date dd-mm-yyyy:");
        String dateInput = sc.next();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        date = dateFormat.parse(dateInput);
    }

    public boolean isAvailable()  throws SQLException{

        BusDAO busdao = new BusDAO();
        BookingDAO bookingdao = new BookingDAO();
        int capacity = busdao.getCapacity(busNo);
        int booked = bookingdao.getBookedCount(busNo,date);
        return booked<capacity;

    }
}
