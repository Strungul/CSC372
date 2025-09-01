package ct6;
import java.util.Random;

public class Student {

	private int rollno;
	private String name;
	private String address;
	
	public Student () {
		this.rollno = -1;
		this.name = "No Name Provided";
		this.address = "No Address Provided";
	}
	
	/**
	 * @param name Student's name
	 * @param address  Student's Address
	 */
	public Student (String name, String address) {
		if (name == null) {
			throw new IllegalArgumentException("Name cannot be null");
		}
		
		if (address == null) {
			throw new IllegalArgumentException("Address cannot be null");
		}
		
		//I initially made this as an incrementing number, as I probably would in a real program, but this is more fun for a sorting program.
		this.rollno = new Random().nextInt(900_000) + 100_000;
		this.name = name;
		this.address = address;
	}

	public int getRollno() {
		return rollno;
	}

	public void setRollno(int rollno) {
		this.rollno = rollno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "Student{ rollno: " + rollno + ", name: " + name + ",address: " + address + " }";
	}
}
