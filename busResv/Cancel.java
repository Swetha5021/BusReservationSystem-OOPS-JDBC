package busResv;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.sql.SQLException;
public class Cancel {
    int booking_id;
    Cancel() throws ParseException,SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter booking_id to cancel: ");
        booking_id = sc.nextInt();
        CancelDAO cancel = new CancelDAO();
        cancel.cancel_ticket(booking_id);
    }
}
