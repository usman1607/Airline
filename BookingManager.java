import java.util.*;
import java.io.*;

public class BookingManager {
    
    List<Booking> bookings;
    File file;
    Writer writer;
    FlightManager flightManager;
    PassengerManager passengerManager;
    Scanner reader = new Scanner(System.in);
    AircraftManager aircraftManager = new AircraftManager();

    //public BookingManager() {

   // }

    public BookingManager() {
        bookings = new ArrayList<Booking>();
        file = new File("booking.txt");
        try{
            if (!file.createNewFile())
            {
                loadBookings();
            }
            writer = new FileWriter(file, true);
        }
        catch(IOException exception)
        {
            System.out.println("An error occurred while creating the booking.txt file");
            System.out.println(exception);
        }
    }

    private void loadBookings() throws FileNotFoundException {
        // file already exists
        Scanner scanner = new Scanner(file);
        while(scanner.hasNext())
        {
            String line = scanner.nextLine();
            Booking booking = Booking.parse(line);
            bookings.add(booking);
        }
        scanner.close();
    }

    public BookingManager(FlightManager flightManager) {
        this.flightManager = flightManager;
    }
    
    public void show(Booking b){
        System.out.println(b.id + " " + b.flightNo + " " + b.date_Time + " " + b.seat_No);
    }
    
    public void list() {
        for(Booking b: bookings){
            show(b);
        }
    }

    public void create(String id, String flight_No, String date_Time, int seat_No) {
        flightManager = new FlightManager();
        Flight flight = flightManager.find(flight_No);
        if(flight ==null){
            System.out.printf("Flight %s cannot be found \n",flight_No); 
            return;
        }
        Booking b = new Booking(id, flight_No, date_Time, seat_No);
        bookings.add(b);
        try{
            if (writer == null)
            {
                throw new Exception("The writer could not be initialized");
            }

            writer.append(b.toString() + System.lineSeparator());
            writer.flush();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());      
        }
    }

    public void bookFlight(String takeOffPoint, String destination) {
        
        flightManager = new FlightManager();
        passengerManager = new PassengerManager();
        flightManager.findAvailableFlight(takeOffPoint, destination);
        int check;
        String flightNo;
        do {
            System.out.print("Enter the Fligth number of your choosed Flight: ");
            flightNo = reader.nextLine();
            check = flightManager.checkAvaFlight(flightNo);
        }while(check == 0);
        Flight f = flightManager.find(flightNo);
        System.out.printf("Cost of the flight is %f.\n", f.price);
        System.out.println("Do you want to proceed to book the flight? ");
        System.out.println("Please enter (1) to proceed or (0) to cancel: ");
        int yes_No = reader.nextInt(); reader.nextLine();
        if(yes_No == 0) {
            return;
        }

        System.out.println("Enter your Name:");
        String name = reader.nextLine();
        System.out.println("Enter your Address: ");
        String address = reader.nextLine();
        System.out.println("Enter your Email: ");
        String email = reader.nextLine();
        System.out.println("Enter your Phone No: ");
        String phone_No = reader.nextLine();
        
        // Make payment here............
        f.availebleSeats -= 1;
        flightManager.updatedOuput();
        int seatNo = f.availebleSeats + 1;
        String id = ( Integer.toString(seatNo) ) + 100;

        System.out.println("Thank you for choosing to fly with us...");

        Booking b = new Booking(id, flightNo, f.takeOff_Time, seatNo);
        passengerManager.create(id, name, address, email, phone_No);
        bookings.add(b);
        try{
            if (writer == null)
            {
                throw new Exception("The writer could not be initialized");
            }

            writer.append(b.toString() + System.lineSeparator());
            writer.flush();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());      
        }
    }

    public void updatedOuput() {
        try{
            writer = new PrintWriter(file);
            
            for(Booking b: bookings){
                writer.append(b.toString() + System.lineSeparator());
            }
            writer.flush();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());      
		}
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
        System.out.println(book.id + " " + book.flightNo + " " + book.date_Time + " " + book.seat_No);
    }

    public void update(String id, String flight_No, String date_Time, int seat_No) {
        Booking book = find(id);
        if(book == null) {
            System.out.printf("There is no Booking with %s  Id in the Bookingss...\n", id); 
            return;
        }
        book.id = id;
        book.flightNo = flight_No;
        book.date_Time = date_Time;
        book.seat_No = seat_No;
        updatedOuput();
    }

    public void removeBook(String id){
        Booking book = find(id);
        if(book == null){
            System.out.printf("There is no Booking with Id: %s  in the Bookings...\n", id); 
            return;
        }
        bookings.remove(book);
        updatedOuput();
    }
    
}