import java.util.*;
import java.io.*;

public class PassengerManager {
    
    List<Passenger> passengers;
    File file;
    Writer writer;
    BookingManager bookingManager;

    public PassengerManager() {
        passengers = new ArrayList<Passenger>();
        file = new File("passenger.txt");
        try{
            if (!file.createNewFile())
            {
                loadPassengers();
            }
            writer = new FileWriter(file, true);
        }
        catch(IOException exception)
        {
            System.out.println("An error occurred while creating the passenger.txt file");
            System.out.println(exception);
        }
    }


    private void loadPassengers() throws FileNotFoundException {
        // file already exists
        Scanner scanner = new Scanner(file);
        while(scanner.hasNext())
        {
            String line = scanner.nextLine();
            Passenger passenger = Passenger.parse(line);
            passengers.add(passenger);
        }
        scanner.close();
    }

    public PassengerManager(BookingManager bookingManager) {
        this.bookingManager = bookingManager;
    }

    public void show(Passenger p){
        System.out.println(p.id + " " + p.name + " " + p.address + " " + p.email + " " + p.phone_No);
    }
    
    public void list() {
        for(Passenger p: passengers){
            show(p);
        }
    }

    public void create(String id, String name, String address, String email, String phone_No) {
        bookingManager = new BookingManager();
        Booking booking = bookingManager.find(id);
        if(booking == null){
            System.out.printf("Passenger Id %s cannot be found in Bookings \n",id); 
            return;
        }
        Passenger p = new Passenger(id, name, address, email, phone_No);
        passengers.add(p);
        try{
            if (writer == null)
            {
               throw new Exception("The writer could not be initialized");
            }

            writer.append(p.toString() + System.lineSeparator());
            writer.flush();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());      
		}
    }

    public void updatedOuput() {
        try{
            writer = new PrintWriter(file);
            
            for(Passenger p: passengers){
                writer.append(p.toString() + System.lineSeparator());
            }
            writer.flush();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());      
		}
    }

    public Passenger find(String id){
        for(Passenger p: passengers){
            if(p.id.equals(id)) {
                return p;
            }
        }
        return null;
    }

    public void findPers(String id){
        Passenger pers = find(id);
        if(pers == null){
            System.out.printf("There is no Passenger with %s Id in the Passengers...\n",id); 
            return;
        }
        System.out.println(pers.id + " " + pers.name + " " + pers.address + " " + pers.email + " " + pers.phone_No);
    }

    public void update(String id, String name, String address, String email, String phone_No) {
        Passenger pers = find(id);
        if(pers == null) {
            System.out.printf("There is no Passenger with %s  Id in the Passengers...\n", id); 
            return;
        }
        pers.id = id;
        pers.name = name;
        pers.address = address;
        pers.email = email;
        pers.phone_No = phone_No;
        updatedOuput();
    }

    public void removePers(String id){
        Passenger pers = find(id);
        if(pers == null){
            System.out.printf("There is no Person with Id: %s  amaong the passengers...\n", id); 
            return;
        }
        passengers.remove(pers);
        updatedOuput();
    }
    
}