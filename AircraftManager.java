import java.util.*;
import java.io.*;

public class AircraftManager {
    List<Aircraft> aircrafts;
    File file;
    Writer writer;
    
    public AircraftManager() {
        aircrafts = new ArrayList<Aircraft>();
        file = new File("aircraft.txt");
        try{
            if (!file.createNewFile())
            {
                loadAircrafts();
            }
            writer = new FileWriter(file, true);
        }
        catch(IOException exception)
        {
            System.out.println("An error occurred while creating the aircraft.txt file");
            System.out.println(exception);
        }
    }


    private void loadAircrafts() throws FileNotFoundException {
        // file already exists
        Scanner scanner = new Scanner(file);
        while(scanner.hasNext())
        {
            String line = scanner.nextLine();
            if (line.trim().isEmpty())
            {
                continue;
            }
            Aircraft aircraft = Aircraft.parse(line);
            aircrafts.add(aircraft);
        }
        scanner.close();
    }


    public void show(Aircraft a){
        System.out.printf("%s %s %s %d \n", a.reg_No, a.type, a.name, a.capacity);
        //System.out.println(a.capacity + " " + a.reg_No);
    }

    public void list() {
        for(Aircraft a: aircrafts){
            show(a);
        }
    }

    public void create(String reg_No, String type, String name, int capacity) throws Exception {
        Aircraft a = new Aircraft(reg_No, type, name, capacity);
        aircrafts.add(a);
        if (writer == null)
        {
            throw new Exception("The writer could not be initialized");
        }

        writer.append("\n" + a.toString() + "\n");
        writer.flush();
        //writer.write("\n");
        //writer.flush();
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

    public void updatedOuput() {
        try{
            writer = new PrintWriter(file);
            
            for(Aircraft a: aircrafts){
                writer.append(a.toString() + "\n");
            }
            writer.flush();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());      
		}
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
        updatedOuput();
    }

    public void removeAir(String reg_No){
        Aircraft aircr = find(reg_No);
        if(aircr == null){
            System.out.printf("There is no Aircfratf %s  amaong the Aircrafts...\n",reg_No); 
            return;
        }
        aircrafts.remove(aircr);
        updatedOuput();
    }

}