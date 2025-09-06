package ct8;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.io.IOException;
import java.util.Comparator;
import java.io.BufferedWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;


public class Driver {
	
	private static LinkedList<Vehicle> VList= new LinkedList<>();
	private static Boolean vehToAdd = true;
	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Welcome to your vehicle inventory system!");

		while (vehToAdd) {
			String make;
			String model;
			double mpg = -1;
			char cont;
			
			while (true) {
				System.out.println("Please enter your vehicle's make.");
				make = input.nextLine();
				
				System.out.println("Please enter your vehicle's model.");
				model = input.nextLine();
				
				
				while(true) {
					System.out.println("Please enter the approximate miles per gallon of fuel consumption for this vehicle.");
					try {
						mpg = input.nextDouble();
						
					} catch(InputMismatchException e) {
						System.out.println("Value must be a number, try again.");
						
					}
					input.nextLine();
					break;
				}
				
				//validate and add the vehicle to the List
			while(true) {
				System.out.println("You would like to add a " + make + " " + model + " with " + mpg + " miles to the gallon.  Is this correct? (Y/N)");
				cont = input.nextLine().toUpperCase().charAt(0);
				if (cont != 'Y' && cont != 'N') {
					System.out.println("Please enter either Y for yes, or N for no to continue");
					continue;
				} else if (cont == 'Y') {
					try{
						VList.add(new Vehicle(make, model, mpg));
						System.out.println("Vehicle successfully added to List.");
						break;
					} catch (IllegalArgumentException e) {
						System.out.println(e);
						System.out.println("Your vehicle was not able to be added, please try again;");
						break;
					}
				} else {
					System.out.println("Ok, let's try again.");
					break;
				}	
			}
			break;
			}
			
			while (true) {
				System.out.println("Would you like to add another vehicle? (Y/N)");
				cont = input.nextLine().toUpperCase().charAt(0);
				if (cont != 'Y' && cont != 'N') {
					System.out.println("Please enter either Y for yes, or N for no to continue");
					continue;
				} else if (cont == 'Y') {
					break;
				} else {
					vehToAdd = false;
					break;
				}	 
			}
			
		}// end adding vehicles
		
		VList.sort(Comparator.comparing(Vehicle::getMilesPerGallon));
		
		for (Vehicle v: VList) {
		System.out.print(v.toString());
		System.out.println("");
		}
		
		try {
			saveToFile(VList,Paths.get(System.getProperty("user.dir"), "vehicles.txt"));
		} catch(IOException e) {
			System.out.println("An error has occured.");
			System.out.println(e);
		}
	}
	
	
	public static void saveToFile(LinkedList<Vehicle> Vlist, Path file) throws IOException {
	    try (BufferedWriter writer = Files.newBufferedWriter(
	            file, StandardCharsets.UTF_8,
	            StandardOpenOption.CREATE,
	            StandardOpenOption.TRUNCATE_EXISTING)) {

	        for (Vehicle v : Vlist) {
	            writer.write(v.getMake()  + "\n"
	                + v.getModel() + "\n"
	                + v.getMilesPerGallon()
	            	+ "\n\n");
	            writer.newLine();
	        }
	    }
	}
	

}
