import java.util.*;

public class FlightManager {
    
    List<Flight> flights = new ArrayList<Flight>();
    AircraftManager aircraftManager = new AircraftManager(); 
    public void show(Flight f){
        //System.out.printf("%s %s %f %s %f %s \n",f.flight_No, f.aircraft, f.price, f.takeOff_Point, f.takeOff_Time, f.destination);
        System.out.println(f.flight_No + " " + f.aircraft_No + " " + f.price + " " + f.takeOff_Point + " " + f.takeOff_Time + " " + f.destination);
    }

    public void list() {
        for(Flight f: flights){
            show(f);
        }
    }

    public void create(String flight_No, String aircraft_No, double price, String takeOff_Point, Date takeOff_Time, String destination){
        Aircraft aircraft = aircraftManager.find(aircraft_No);
        if(aircraft == null){
            System.out.printf("Aircfratf %s cannot be found \n",aircraft_No); 
            return;
        }
        Flight f = new Flight(flight_No, aircraft_No, price, takeOff_Point, takeOff_Time, destination);
        flights.add(f);
    }

    public Flight find(String flight_No) {
        for(Flight f: flights){
            if(f.flight_No.equals(flight_No)){
                return f;
            }
        }
        return null;
    }

    public void removeFli(String flight_No){
        Flight fli = find(flight_No);
        if(fli == null){
            System.out.printf("There is no Flight %s  amaong the Flights...\n",flight_No); 
            return;
        }
        flights.remove(fli);
    }
    
}