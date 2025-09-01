package ct6;

import java.util.Comparator;

public class CompareByRollNo implements Comparator<Student> {
	
	
	@Override
	public  int compare(Student a, Student b) {
		return Integer.compare(a.getRollno(),b.getRollno());
		
	}

}
