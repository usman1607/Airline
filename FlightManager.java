import java.util.*;
import java.io.*;

public class FlightManager {
    
    List<Flight> ava_f;
    List<Flight> flights;
    AircraftManager aircraftManager; 
    File file;
    Writer writer;

    public FlightManager() {
        flights = new ArrayList<Flight>();
        file = new File("flight.txt");
        try{
            if (!file.createNewFile())
            {
                loadFlights();
            }
            writer = new FileWriter(file, true);
        }
        catch(IOException exception)
        {
            System.out.println("An error occurred while creating the flight.txt file");
            System.out.println(exception);
        }
    }

    private void loadFlights() throws FileNotFoundException {
        // file already exists
        Scanner scanner = new Scanner(file);
        while(scanner.hasNext())
        {
            String line = scanner.nextLine();
            Flight flight = Flight.parse(line);
            flights.add(flight);
        }
        scanner.close();
    }

    public FlightManager(AircraftManager aircraftManager) {
        this.aircraftManager = aircraftManager;
    }

    public void show(Flight f){
        System.out.printf("%s %s %f %s %s %s \n",f.number, f.aircraftNo, f.price, f.takeOff_Point, f.takeOff_Time, f.destination, f.availebleSeats);
        //System.out.println(f.number + " " + airc.reg_No + " " + f.price + " " + f.takeOff_Point + " " + f.takeOff_Time + " " + f.destination);
    }

    public void list() {
        for(Flight f: flights){
            show(f);
        }
    }

   // Aircraft airc = new Aircraft();
    public void create(String number, String aircraft_No, double price, String takeOff_Point, String takeOff_Time, String destination, int availebleSeats){
        aircraftManager = new AircraftManager();
        Aircraft aircraft = aircraftManager.find(aircraft_No);
        if(aircraft == null){
            System.out.printf("Aircfratf %s cannot be found \n",aircraft_No); 
            return;
        }
        Flight f = new Flight(number, aircraft_No, price, takeOff_Point, takeOff_Time, destination, availebleSeats);
        flights.add(f);
        try{
            if (writer == null)
            {
               throw new Exception("The writer could not be initialized");
            }

            writer.append(f.toString() + System.lineSeparator());
            writer.flush();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());      
		}
    }

    public void updatedOuput() {
        try{
            writer = new PrintWriter(file);
            
            for(Flight f: flights){
                writer.append(f.toString() + System.lineSeparator() );
            }
            writer.flush();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());      
		}
    }

    public Flight find(String flight_No) {
        for(Flight f: flights){
            if(f.number.equals(flight_No)){
                return f;
            }
        }
        return null;
    }

    public void findAvailableFlight(String takeOffPoint, String Destination) {
        int count = 0;
        ava_f = new ArrayList<Flight>();
        for(Flight f: flights){
            if((f.takeOff_Point.equals(takeOffPoint)) && (f.destination.equals(Destination)) && (f.availebleSeats > 0)){
                ava_f.add(f);
                count++;
            }
        }
        if(count == 0) {
            System.out.printf("There is no Flight going from %s to %s available now.\n", takeOffPoint, Destination);
            return;
        }else{
            int sNo = 1;
            System.out.printf("There are/is %d Flight going from %s to %s available, they are:\n", count, takeOffPoint, Destination);
            System.out.println("S/N" + "\t" + "Flight No." + "\t\t" + "Take Off Point" + "\t\t" + "Destination" + "\t" + "Price");
            System.out.println("============================================================================");
            for(Flight aF : ava_f) {
                System.out.println(sNo + "\t" + aF.number + "\t" + aF.takeOff_Point + "\t" + aF.destination + "\t" + aF.price);
                sNo++;
            }
        }
    }

    public int checkAvaFlight(String flightNo) {
        int num = 0;
        for(Flight f : ava_f) {
            if(f.number.equals(flightNo)) {
                num++;
            }
        }

        return num;
    }

    public void findFli(String flight_No){
        Flight fli = find(flight_No);
        if(fli == null){
            System.out.printf("There is no Flight %s  amaong the Flights...\n",flight_No); 
            return;
        }
        System.out.printf("%s %s %f %s %s %s \n",fli.number, fli.aircraftNo, fli.price, fli.takeOff_Point, fli.takeOff_Time, fli.destination);
    }

    public void update(String number, double price, String takeOff_Point, String takeOff_Time, String destination) {
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
        updatedOuput();
    }

    public void removeFli(String flight_No){
        Flight fli = find(flight_No);
        if(fli == null){
            System.out.printf("There is no Flight %s  amaong the Flights...\n",flight_No); 
            return;
        }
        flights.remove(fli);
        updatedOuput();
    }
    
}