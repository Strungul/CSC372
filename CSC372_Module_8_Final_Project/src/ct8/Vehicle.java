package ct8;

public class Vehicle {

	private String make;
	private String model;
	private double milesPerGallon;
	
	public Vehicle() {
		this.make = "No make Entered";
		this.model = "No model Entered";
		this.milesPerGallon = -1;
	}
	
	public Vehicle(String make, String model, double milesPerGallon) {
		if (milesPerGallon <= 0) {
			throw new IllegalArgumentException("Miles per Gallon Cannot be 0 or less than 0");
		}
		
		this.make = make;
		this.model = model;
		this.milesPerGallon = milesPerGallon;
	}
	
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public double getMilesPerGallon() {
		return milesPerGallon;
	}
	public void setMilesPerGallon(double milesPerGallon) {
		if (milesPerGallon <= 0) {
			throw new IllegalArgumentException("Miles per Gallon Cannot be 0 or less than 0");
		}
		
		this.milesPerGallon = milesPerGallon;
	}
	
	@Override
	public String toString() {
		return "Make: " + make + "\n" + "Model: " + model + " \n" + "MPG: " + milesPerGallon;
	}
}
