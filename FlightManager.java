import java.util.*;

public class FlightManager {
    
    List<Flight> flights = new ArrayList<Flight>();
    AircraftManager aircraftManager = new AircraftManager(); 

    public FlightManager() {

    }

    public FlightManager(AircraftManager aircraftManager) {
        this.aircraftManager = aircraftManager;
    }

    public void show(Flight f){
        System.out.printf("%s %s %f %s %s %s \n",f.number, f.aircraft, f.price, f.takeOff_Point, f.takeOff_Time, f.destination);
        //System.out.println(f.number + " " + airc.reg_No + " " + f.price + " " + f.takeOff_Point + " " + f.takeOff_Time + " " + f.destination);
    }

    public void list() {
        for(Flight f: flights){
            show(f);
        }
    }

   // Aircraft airc = new Aircraft();
    public void create(String number, String aircraft_No, double price, String takeOff_Point, Date takeOff_Time, String destination){
        Aircraft aircraft = aircraftManager.find(aircraft_No);
        if(aircraft == null){
            System.out.printf("Aircfratf %s cannot be found \n",aircraft_No); 
            return;
        }
        Flight f = new Flight(number, aircraft, price, takeOff_Point, takeOff_Time, destination);
        flights.add(f);
    }

    public Flight find(String flight_No) {
        for(Flight f: flights){
            if(f.number.equals(flight_No)){
                return f;
            }
        }
        return null;
    }

    public void findFli(String flight_No){
        Flight fli = find(flight_No);
        if(fli == null){
            System.out.printf("There is no Flight %s  amaong the Flights...\n",flight_No); 
            return;
        }
        System.out.printf("%s %s %f %s %s %s \n",fli.number, fli.aircraft, fli.price, fli.takeOff_Point, fli.takeOff_Time, fli.destination);
    }

    public void update(String number, double price, String takeOff_Point, Date takeOff_Time, String destination) {
        Flight fli = find(number);
        if(fli == null) {
            System.out.printf("There is no Flight %s  amaong the Flights...\n", number); 
            return;
        }
        fli.number = number;
        //fli.aircraft = aircraft;
        fli.price = price;
        fli.takeOff_Point = takeOff_Point;
        fli.takeOff_Time = takeOff_Time;
        fli.destination = destination;
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