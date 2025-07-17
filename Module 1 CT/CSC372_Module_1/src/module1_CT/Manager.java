package module1_CT;

public class Manager extends Employee{

	//instructions say string department a, but I think that's a mistake
	private String department;
	
	//getters and setters not requested, but if we're going to have a test class, we have to have some way of setting this value

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	
	@Override
	public void employeeSummary() {
		super.employeeSummary();
		System.out.println("Department: " + getDepartment());
	}
	
}
