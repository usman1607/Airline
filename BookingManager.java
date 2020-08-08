import java.util.*;

public class BookingManager {
    
    List<Booking> bookings = new ArrayList<Booking>();
    FlightManager flightManager = new FlightManager(); 
    public void show(Booking b){
        System.out.println(b.booking_No + " " + b.passenger_Id + " " + b.flight + " " + b.booking_Date_Time + " " + b.seat_No);
    }
    
    public void list() {
        for(Booking b: bookings){
            show(b);
        }
    }

    public void create(String booking_No, String passenger_Id, String flight_No, Date booking_Date_Time, int seat_No) {
        Flight flight = flightManager.find(flight_No);
        if(flight ==null){
            System.out.printf("Aircfratf %s cannot be found \n",flight_No); 
            return;
        }
        Booking b = new Booking(booking_No, passenger_Id, flight, booking_Date_Time, seat_No);
        bookings.add(b);
    }

    public Booking find(String passenger_Id) {
        for(Booking b: bookings){
            if(b.passenger_Id.equals(passenger_Id)){
                return b;
            }
        }
        return null;
    }

    public void removeBook(String booking_No){
        Booking book = find(booking_No);
        if(book == null){
            System.out.printf("There is no Booking with Id: %s  in the Bookings...\n", booking_No); 
            return;
        }
        bookings.remove(book);
    }
    
}