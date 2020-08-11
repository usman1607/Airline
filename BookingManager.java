import java.util.*;

public class BookingManager {
    
    List<Booking> bookings = new ArrayList<Booking>();
    FlightManager flightManager = new FlightManager(); 
    AircraftManager aircraftManager = new AircraftManager();

    public BookingManager() {

    }

    public BookingManager(FlightManager flightManager) {
        this.flightManager = flightManager;
    }
    
    public void show(Booking b){
        System.out.println(b.id + " " + b.flightNo + " " + b.booking_Date_Time + " " + b.seat_No);
    }
    
    public void list() {
        for(Booking b: bookings){
            show(b);
        }
    }

    public void create(String id, String flight_No, Date booking_Date_Time, int seat_No) {
        Flight flight = flightManager.find(flight_No);
        if(flight ==null){
            System.out.printf("Flight %s cannot be found \n",flight_No); 
            return;
        }
        Booking b = new Booking(id, flight_No, booking_Date_Time, seat_No);
        bookings.add(b);
    }

    public Booking find(String id) {
        for(Booking b: bookings){
            if(b.id.equals(id)) {
                return b;
            }
        }
        return null;
    }

    public void findBook(String id){
        Booking book = find(id);
        if(book == null){
            System.out.printf("There is no Booking with %s Id in the Bookings...\n",id); 
            return;
        }
        System.out.println(book.id + " " + book.flightNo + " " + book.booking_Date_Time + " " + book.seat_No);
    }

    public void update(String id, String flight_No, Date booking_Date_Time, int seat_No) {
        Booking book = find(id);
        if(book == null) {
            System.out.printf("There is no Booking with %s  Id in the Bookingss...\n", id); 
            return;
        }
        book.id = id;
        book.flightNo = flight_No;
        book.booking_Date_Time = booking_Date_Time;
        book.seat_No = seat_No;
    }

    public void removeBook(String id){
        Booking book = find(id);
        if(book == null){
            System.out.printf("There is no Booking with Id: %s  in the Bookings...\n", id); 
            return;
        }
        bookings.remove(book);
    }
    
}