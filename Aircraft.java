
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

    public Aircraft(int capacity, String reg_No){
        this.capacity = capacity;
        this.reg_No = reg_No;
    }

    public Aircraft(int capacity, String reg_No, String type, String name) {
        this.capacity = capacity;
        this.reg_No = reg_No;
        this.type = type;
        this.name = name;
    }
}

