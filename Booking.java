//import java.util.*;

public class Booking {
    String id;
    String flightNo;
    String date_Time;
    int seat_No;

    public Booking(){

    }

    public Booking(String id, String flightNo, String date_Time, int seat_No){
        this.id = id;
        this.flightNo = flightNo;
        this.date_Time = date_Time;
        this.seat_No = seat_No;
    }

    @Override
    public String toString() {
        return id + "\t" + flightNo + "\t" + date_Time + "\t" + seat_No;
    }

    public static Booking parse(String line)
    {
        String[] props = line.split("\t");
        int seat_No = Integer.parseInt(props[3]);
        return new Booking(props[0], props[1], props[2], seat_No);
    }
}

