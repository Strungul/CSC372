package ct6;
import java.util.ArrayList;


public class Driver {
	
	static ArrayList<Student> studentsArr = new ArrayList<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CompareByRollNo comp = new CompareByRollNo();
		
		studentsArr.add( newStudent("John Doe", "101 Maple Street"));
		studentsArr.add( newStudent("Jane Dee", "202 Oak Avenue"));
		studentsArr.add( newStudent("Jorf Doen", "303 Pine Road"));
		//creating a bunch of different fake addresses gets tedious
		studentsArr.add( newStudent("Billibob Frenzic", "123 Fake Avenue"));
		studentsArr.add( newStudent("Illigitimate Child", "123 Fake Avenue"));
		studentsArr.add( newStudent("Sweet Baby Jane", "123 Fake Avenue"));
		studentsArr.add( newStudent("Bilbo Baggins", "123 Fake Avenue"));
		studentsArr.add( newStudent("Sweeny Todd", "123 Fake Avenue"));
		studentsArr.add( newStudent("Tyler Durdin", "123 Fake Avenue"));
		studentsArr.add( newStudent("Shell Silverstein", "123 Fake Avenue"));
		
		System.out.println("Here are the students in order of creation.\n");
		for (Student s: studentsArr) {
			System.out.println(s.toString());
		}
		
		System.out.println("\n\n");
		
		
		
		MergeSort.sortStudents(studentsArr, comp);
		
		System.out.println("Here are the students in order of Roll Number.\n");
		for (Student s: studentsArr) {
			System.out.println(s.toString());
		}
		
		

	}
	
	public static Student newStudent(String name, String address) {
		Student newStu = new Student(name, address);
		for (Student s:studentsArr) {
			if (s.getRollno() == newStu.getRollno()) {
				return newStudent(name, address);
			} 
		}
		
		
		return newStu;
	}
	
	

}
