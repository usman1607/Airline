//import java.util.*;

public class Flight {
    String number;
    String aircraftNo;
    double price;
    String takeOff_Point;
    String takeOff_Time;
    String destination;
    String estimated_LandingTime;
    int availebleSeats;

    Aircraft aircraft = new Aircraft();

    public Flight() {

    }

    public Flight(double price) {
        this.price = price;
    }

    public Flight(String number, String aircraftNo, double price, String takeOff_Point, String takeOff_Time, String destination, int availebleSeats){
        this.number = number;
        this.aircraftNo = aircraftNo;
        this.price = price;
        this.takeOff_Point = takeOff_Point;
        this.takeOff_Time = takeOff_Time;
        this.destination = destination;
        this.availebleSeats = availebleSeats;
    }

    @Override
    public String toString() {
        return number + "\t" + aircraftNo + "\t" + price + "\t" + takeOff_Point + "\t" + takeOff_Time + "\t" + destination + "\t" + availebleSeats;
    }

    public static Flight parse(String line) 
    {
        String[] props = line.split("\t");
        Double price = Double.parseDouble(props[2]);
        int availebleSeats = Integer.parseInt(props[6]);
        return new Flight(props[0], props[1], price, props[3], props[4], props[5], availebleSeats);
    }
}
