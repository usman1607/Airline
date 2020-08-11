import java.util.*;

public class Booking {
    String id;
    String flightNo;
    Date booking_Date_Time;
    int seat_No;

    public Booking(){

    }

    public Booking(String id, String flightNo, Date booking_Date_Time, int seat_No){
        this.id = id;
        this.flightNo = flightNo;
        this.booking_Date_Time = booking_Date_Time;
        this.seat_No = seat_No;
    }
}

