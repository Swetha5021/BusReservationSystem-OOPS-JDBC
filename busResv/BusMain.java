package busResv;
import java.util.*;
import java.sql.*;

public class BusMain {
    public static void main(String args[]){
        try
        {
            BusDAO busdao = new BusDAO();
            busdao.displayBusInfo();
            int choice = 1;
            Scanner sc = new Scanner(System.in);
            while(choice!=3)
            {
                System.out.println("Enter your choice:");
                System.out.println("1:Book Ticket\n2:Cancel Ticket\nExit");
                choice = sc.nextInt();
                if(choice==1)
                {
                    Booking booking = new Booking();
                    if(booking.isAvailable())
                    {
                        BookingDAO bookingdao = new BookingDAO();
                        bookingdao.addBooking(booking);
                        System.out.println("Your booking is confirmed..\nThanks for booking");
                    }
                    else {
                        System.out.println("Sorry. Bus is full. Try another bus or date.");
                    }
                }
                else if(choice==2)
                {
                    Cancel cancel = new Cancel();
                    System.out.print("Ticket cancelled Successfully.");
                }
                System.out.println("-----------------------------------------");
            }
            sc.close();
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
