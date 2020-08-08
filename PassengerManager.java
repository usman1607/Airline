import java.util.*;

public class PassengerManager {
    
    List<Passenger> passengers = new ArrayList<Passenger>();
    BookingManager bookingManager = new BookingManager();
    public void show(Passenger p){
        System.out.println(p.id + " " + p.name + " " + p.address + " " + p.email + " " + p.phone_No);
    }
    
    public void list() {
        for(Passenger p: passengers){
            show(p);
        }
    }

    public void create(String id, String name, String address, String email, String phone_No){
        Booking booking = bookingManager.find(id);
        if(booking == null){
            System.out.printf("Passenger Id %s cannot be found in Bookings \n",id); 
            return;
        }
        Passenger p = new Passenger(id, name, address, email, phone_No);
        passengers.add(p);
    }

    public Passenger find(String id){
        for(Passenger p: passengers){
            if(p.id.equals(id)) {
                return p;
            }
        }
        return null;
    }

    public void removePers(String id){
        Passenger pers = find(id);
        if(pers == null){
            System.out.printf("There is no Person with Id: %s  amaong the passengers...\n", id); 
            return;
        }
        passengers.remove(pers);
    }
    
}