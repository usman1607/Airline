import java.util.*;

public class AircraftManager {

    List<Aircraft> aircrafts = new ArrayList<Aircraft>();
    public void show(Aircraft a){
        System.out.printf("%s %s %s %d \n", a.reg_No, a.type, a.name, a.capacity);
        //System.out.println(a.capacity + " " + a.reg_No);
    }

    public void list() {
        for(Aircraft a: aircrafts){
            show(a);
        }
    }

    public void create(String reg_No, String type, String name, int capacity){
        Aircraft a = new Aircraft(reg_No, type, name, capacity);
        aircrafts.add(a);
    }

    public Aircraft find(String reg_No) {
        for(Aircraft a: aircrafts){
            if(a.reg_No.equals(reg_No)){
                return a;
            }
        }
        return null;
    }

    public void findAir(String reg_No){
        Aircraft aircr = find(reg_No);
        if(aircr == null){
            System.out.printf("There is no Aircfratf %s  amaong the Aircrafts...\n",reg_No); 
            return;
        }
        System.out.printf("%s %s %s %d \n", aircr.reg_No, aircr.type, aircr.name, aircr.capacity);
    }

    public void update(String reg_No, String type, String name, int capacity) {
        Aircraft aircr = find(reg_No);
        if(aircr == null){
            System.out.printf("There is no Aircfratf %s  amaong the Aircrafts...\n",reg_No); 
            return;
        }
        aircr.capacity = capacity;
        aircr.reg_No = reg_No;
        aircr.type = type;
        aircr.name = name;
    }

    public void removeAir(String reg_No){
        Aircraft aircr = find(reg_No);
        if(aircr == null){
            System.out.printf("There is no Aircfratf %s  amaong the Aircrafts...\n",reg_No); 
            return;
        }
        aircrafts.remove(aircr);
    }

}