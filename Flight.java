//import java.util.*;

public class Flight {
    String number;
    String aircraftNo;
    double price;
    String takeOff_Point;
    String takeOff_Time;
    String destination;
    String estimated_LandingTime;

    Aircraft aircraft = new Aircraft();

    public Flight() {

    }

    public Flight(double price) {
        this.price = price;
    }

    public Flight(String number, String aircraftNo, double price, String takeOff_Point, String takeOff_Time, String destination){
        this.number = number;
        this.aircraftNo = aircraftNo;
        this.price = price;
        this.takeOff_Point = takeOff_Point;
        this.takeOff_Time = takeOff_Time;
        this.destination = destination;
    }

    @Override
    public String toString() {
        return number + "\t" + aircraftNo + "\t" + price + "\t" + takeOff_Point + "\t" + takeOff_Time + "\t" + destination;
    }

    public static Flight parse(String line) 
    {
        String[] props = line.split("\t");
        Double price = Double.parseDouble(props[2]);
        return new Flight(props[0], props[1], price, props[3], props[4], props[5]);
    }
}
