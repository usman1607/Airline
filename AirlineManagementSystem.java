import java.util.*;
import java.text.*;

public class AirlineManagementSystem{

	static Scanner reader = new Scanner(System.in);

	Aircraft aircraft = new Aircraft();
	static AircraftManager aircraftManager = new AircraftManager();

	static FlightManager flightManagers = new FlightManager();
	static FlightManager flightManager = new FlightManager(aircraftManager);

	static BookingManager bookingManagers = new BookingManager();
	static BookingManager bookingManager = new BookingManager(flightManagers, aircraftManager);

	static PassengerManager passengerManager = new PassengerManager();

	public static void main(String [] args) {
       
		boolean flag = true;
		while(flag) {
			showMainMenu();
			String option = reader.nextLine();
			if(option.equals("0")) {
				flag=false;
			}else {
               showSubMenu(option);
			}
		}

	}

	public static void showMainMenu(){

		System.out.println("Enter 0 to exit");
		System.out.println("Enter 1 to Manage Aircrafts");
		System.out.println("Enter 2 to Manage Flights");
		System.out.println("Enter 3 to Manage Bookings");
		System.out.println("Enter 4 to Manage Passengers");
	}

	public static void showSubMenu(String option){

		if(option.equals("1")){
             showManageAirCraftsMenu();
			 String subOption = reader.nextLine();
			 handleManageAirCraftsAction(subOption);
		}
		else if(option.equals("2")) {
			showManageFlightsMenu();
            String subOption = reader.nextLine();
            handleManageFlightsAction(subOption);
		}
		else if(option.equals("3")) {
			showManageBookingsMenu();
            String subOption = reader.nextLine();
            handleManageBookingsAction(subOption);
		}
		else if(option.equals("4")) {
			showManagePassengersMenu();
            String subOption = reader.nextLine();
            handleManagePassengersAction(subOption);
		}
		//showSubMenu(option);
	}

	public static void showManageAirCraftsMenu(){

		System.out.println("Enter 0 to return to Main Menu");
		System.out.println("Enter 1 to Create Aircraft");
		System.out.println("Enter 2 to List Aircrafts");
		System.out.println("Enter 3 to Remove Aircraft");
		System.out.println("Enter 4 to Find an Aircraft");
		System.out.println("Enter 5 to Update an Aircraft");
	}

	public static void handleManageAirCraftsAction(String action){

		if(action.equals("0")){
			return;
			//showMainMenu();
		}else if(action.equals("2")){
			aircraftManager.list();
		}
		else if(action.equals("3")){
			System.out.println("Enter the Reg_No of Aircraft to remove: ");
			String reg_No = reader.nextLine();
			aircraftManager.removeAir(reg_No);
		}
		else if(action.equals("4")){
			System.out.println("Enter the Reg_No of Aircraft to find: ");
			String reg_No = reader.nextLine();
			aircraftManager.findAir(reg_No);
		}
		else if(action.equals("5")){
			System.out.println("Enter the Reg_No of Aircraft to update: ");
			String reg_No = reader.nextLine();

			System.out.println("Enter the Aircraft Name: ");
			String name = reader.nextLine();
			System.out.println("Enter the Aircraft Type: ");
			String type = reader.nextLine();
			System.out.println("Enter the Aircraft Capacity: ");
			int capacity = reader.nextInt();
			reader.nextLine();
			aircraftManager.update(reg_No, type, name, capacity);
		}
		else if (action.equals("1")){

            System.out.println("Enter the Aircraft No: ");
			String aircraftNo = reader.nextLine();
			System.out.println("Enter the Aircraft Name: ");
			String aircraftName = reader.nextLine();
			System.out.println("Enter the Aircraft Type: ");
			String aircraftType = reader.nextLine();
			System.out.println("Enter the Aircraft Capacity: ");
			int aircraftCapacity = reader.nextInt();
			reader.nextLine();
			aircraftManager.create(aircraftNo, aircraftType, aircraftName, aircraftCapacity);
		}
	}

	public static void showManageFlightsMenu(){

		System.out.println("Enter 0 to return to Main Menu");
		System.out.println("Enter 1 to Create Flight");
		System.out.println("Enter 2 to List Flights");
		System.out.println("Enter 3 to Remove Flight");
		System.out.println("Enter 4 to Find a Flight");
		System.out.println("Enter 5 to Update a Flight");
	}

	public static void handleManageFlightsAction(String action){
		try{
			if(action.equals("0")){
				showMainMenu();
			}else if(action.equals("2")){
				flightManager.list();
			}
			else if(action.equals("3")){
				System.out.println("Enter the Flight_No of Flight to remove?");
				String flight_No = reader.nextLine();
				flightManager.removeFli(flight_No);
			}
			else if(action.equals("4")){
				System.out.println("Enter the Number of Flight to find?");
				String number = reader.nextLine();
				flightManager.findFli(number);
			}
			else if(action.equals("5")){
				System.out.println("Enter the number of Flight to update: ");
				String number = reader.nextLine();

				//System.out.println("Enter the aircraft No:");
				//String aircraftno = reader.nextLine();
				System.out.println("Enter the Flight price: ");
				double price = reader.nextDouble();
				reader.nextLine();
				System.out.println("Enter the Take_Off Point: ");
				String takeOff_Point = reader.nextLine();
				System.out.println("Enter Date and Time (dd/MM/yyyy hh:mm:ss): ");
				String pDate = reader.nextLine();
				SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
				Date date1 = formatter.parse(pDate);
				System.out.println("Enter the Destination: ");
				String destination = reader.nextLine();
				flightManager.update(number, price, takeOff_Point, date1, destination);
			}
			else if (action.equals("1")){

				System.out.println("Enter the flight No:");
				String flight_No = reader.nextLine();
				System.out.println("Enter the aircraft No:");
				String aircraftno = reader.nextLine();
				System.out.println("Enter the Flight price: ");
				double price = reader.nextDouble();
				reader.nextLine();
				System.out.println("Enter the Take_Off Point: ");
				String takeOff_Point = reader.nextLine();
				System.out.println("Enter Date and Time (dd/MM/yyyy hh:mm:ss): ");
				String pDate = reader.nextLine();
				SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
				Date date1 = formatter.parse(pDate);
				System.out.println("Enter the Destination: ");
				String destination = reader.nextLine();
				
				flightManager.create(flight_No, aircraftno, price, takeOff_Point, date1, destination);
			}
		}
        catch(Exception ex){
            System.out.println(ex.getMessage());      
		}
	}
	
	public static void showManageBookingsMenu(){
		System.out.println("Enter 0 to return to Main Menu");
		System.out.println("Enter 1 to Create Booking");
		System.out.println("Enter 2 to List Bookings");
		System.out.println("Enter 3 to Remove Booking");
	}

	public static void handleManageBookingsAction(String action){
		try{
			if(action.equals("0")){
				showMainMenu();
			}else if(action.equals("2")){
				bookingManager.list();
			}
			else if(action.equals("3")){
				System.out.println("Enter the Booking_No of Booking to remove?");
				String Booking_No = reader.nextLine();
				bookingManager.removeBook(Booking_No);
			}
			else if (action.equals("1")){
				System.out.println("Enter the Booking No:");
				String booking_No = reader.nextLine();
				System.out.println("Enter the Passenger Id:");
				String passenger_Id = reader.nextLine();
				System.out.println("Enter the Flight No: ");
				String flight_No = reader.nextLine();
				System.out.println("Enter Booking Date and Time (dd/MM/yyyy hh:mm:ss): ");
				String bookingDate = reader.nextLine();
				SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
				Date date1 = formatter.parse(bookingDate);
				System.out.println("Enter the Seat No: ");
				int seat_No = reader.nextInt();
				reader.nextLine();
	
				bookingManager.create(booking_No, passenger_Id, flight_No, date1, seat_No);
			}
		}
        catch(Exception ex){
            System.out.println(ex.getMessage());      
		}
	}

	public static void showManagePassengersMenu(){
		System.out.println("Enter 0 to return to Main Menu");
		System.out.println("Enter 1 to Create Passenger");
		System.out.println("Enter 2 to List Passengers");
		System.out.println("Enter 3 to Remove Passenger");
	}

	public static void handleManagePassengersAction(String action){
		if(action.equals("0")){
			showMainMenu();
		}else if(action.equals("2")){
			passengerManager.list();
		}
		else if(action.equals("3")){
			System.out.println("Enter Id of Passenger to remove?");
			String id = reader.nextLine();
			passengerManager.removePers(id);
		}
		else if (action.equals("1")){
			System.out.println("Enter the Passenger Id:");
			String id = reader.nextLine();
			System.out.println("Enter the Passenger Name:");
			String name = reader.nextLine();
			System.out.println("Enter the Passenger Address: ");
			String address = reader.nextLine();
			System.out.println("Enter the Passenger Email: ");
			String email = reader.nextLine();
			System.out.println("Enter the Passenger Phone No: ");
			String phone_No = reader.nextLine();

			passengerManager.create(id, name, address, email, phone_No);
		}
	}

	public static int getAvailbleSeats(){
		int availableSeat = 0;


		return availableSeat;
	}

}