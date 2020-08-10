import java.util.Date;

public class Flight {
    String number;
    Aircraft aircraft;
    double price;
    String takeOff_Point;
    Date takeOff_Time;
    String destination;
    Date estimated_LandingTime;

    //Aircraft aircraft = new Aircraft();

    public Flight() {

    }

    public Flight(String number, Aircraft aircraft, double price, String takeOff_Point, Date takeOff_Time, String destination){
        this.number = number;
        this.aircraft = aircraft;
        this.price = price;
        this.takeOff_Point = takeOff_Point;
        this.takeOff_Time = takeOff_Time;
        this.destination = destination;
    }

}
