public class Passenger {
    String id;
    String name;
    String address;
    String email;
    String phone_No;

    Booking b = new Booking();

    public Passenger() {
        
    }

    public Passenger(String name) {
        this.name = name;
    }

    public Passenger(String id, String name, String address, String email, String phone_No) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.email = email;
        this.phone_No = phone_No;
    }

    @Override
    public String toString() {
        return id + "\t" + name + "\t" + address + "\t" + email + "\t" + phone_No;
    }

    public static Passenger parse(String line)
    {
        String[] props = line.split("\t");
        //int capacity = Integer.parseInt(props[0]);
        return new Passenger(props[0], props[1], props[2], props[3], props[4]);
    }
}
