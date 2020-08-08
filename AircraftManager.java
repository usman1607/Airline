import java.util.*;

public class AircraftManager {

    List<Aircraft> aircrafts = new ArrayList<Aircraft>();
    public void show(Aircraft a){
        System.out.printf("%d %s %s %s \n",a.capacity, a.reg_No, a.type, a.name);
        //System.out.println(a.capacity + " " + a.reg_No);
    }

    public void list() {
        for(Aircraft a: aircrafts){
            show(a);
        }
    }

    public void create(int capacity, String reg_No, String type, String name){
        Aircraft a = new Aircraft(capacity, reg_No, type, name);
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

    public void removeAir(String reg_No){
        Aircraft aircr = find(reg_No);
        if(aircr == null){
            System.out.printf("There is no Aircfratf %s  amaong the Aircrafts...\n",reg_No); 
            return;
        }
        aircrafts.remove(aircr);
    }
    
}