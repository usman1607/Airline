import java.util.*;

public class Booking {
    String booking_No;
    String passenger_Id;
    Flight flight;
    Date booking_Date_Time;
    int seat_No;

    public Booking(){
        
    }

    public Booking(String booking_No, String passenger_Id, Flight flight, Date booking_Date_Time, int seat_No){
        this.booking_No = booking_No;
        this.passenger_Id = passenger_Id;
        this.flight = flight;
        this.booking_Date_Time = booking_Date_Time;
        this.seat_No = seat_No;
    }
}

