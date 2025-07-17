package module1_CT;

public class Employee {
	
	//employee attributes
	protected String firstName;
	protected String lastName;
	protected int employeeID;
	protected double salary;
	
	//default constructor
	public Employee() {
		this.salary = 0;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}
	
	public int getEmployeeID() {
		return employeeID;
	}
	
	public double getSalary() {
		return salary;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public void employeeSummary() {
		System.out.println("First Name: " + firstName);
		System.out.println("Last Name: " + lastName);
		System.out.println("Employee ID: " + employeeID);
		System.out.println("Salary: " + salary);
	}
}
