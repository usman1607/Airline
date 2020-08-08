import java.util.Date;

public class Flight {
    String flight_No;
    String aircraft_No;
    double price;
    String takeOff_Point;
    Date takeOff_Time;
    String destination;
    Date estimated_LandingTime;

    public Flight() {

    }

    public Flight(String flight_No, String aircraft_No, double price, String takeOff_Point, Date takeOff_Time, String destination){
        this.flight_No = flight_No;
        this.aircraft_No = aircraft_No;
        this.price = price;
        this.takeOff_Point = takeOff_Point;
        this.takeOff_Time = takeOff_Time;
        this.destination = destination;
    }
}
