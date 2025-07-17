package module1_CT;

public class Module1Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Employee Jim = new Employee();
		Jim.setFirstName("Jim");
		Jim.setLastName("Bob");
		Jim.setEmployeeID(8675309);
		
		System.out.println("The first employee's first name is " + Jim.getFirstName());
		System.out.println("The first employee's last name is " + Jim.getLastName());
		System.out.println("The first employee's employee ID number is " + Jim.getEmployeeID());
		System.out.println("The first employee's salary is " + Jim.getSalary());
		System.out.println("Hopefully someone gives " + Jim.getFirstName() + " a raise.");
		
		Jim.employeeSummary();
		
		
		Manager Mike = new Manager();
		Mike.setFirstName("Michael");
		Mike.setLastName("Hildebrand");
		Mike.setEmployeeID(20245);
		Mike.setSalary(500001.21);
		Mike.setDepartment("IOT");
		
		Mike.employeeSummary();
		System.out.println(Mike.getFirstName() + " needs to share some of his income with his employees.");
	}

}
