
public class Aircraft {
    int capacity;
    String reg_No;
    String type;
    String name;

    public Aircraft(){
        
    }

    public Aircraft(String reg_No){
        this.reg_No = reg_No;
    }

    public Aircraft(String reg_No, int capacity){
        this.capacity = capacity;
        this.reg_No = reg_No;
    }

    public Aircraft(String reg_No, String type, String name, int capacity) {
        this.capacity = capacity;
        this.reg_No = reg_No;
        this.type = type;
        this.name = name;
    }

    @Override
    public String toString() {
        return capacity + "\t" + reg_No + "\t" + type + "\t" + name;
    }

    public static Aircraft parse(String line)
    {
        String[] props = line.split("\t");
        int capacity = Integer.parseInt(props[0]);
        return new Aircraft(props[1], props[2], props[3], capacity);
    }
}

