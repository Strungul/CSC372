package ct6;

import java.util.ArrayList;
import java.util.Comparator;

public class MergeSort {
	/**
	 * @param stuArr An array of students
	 * @param comp a comparator I don't really know why we use
	 */
	public static void sortStudents(ArrayList<Student> stuArr, Comparator<Student> comp) {
		
		if(stuArr == null || stuArr.size() <= 1) {
			return;
		}
		//split the array
		int m = stuArr.size()/2;
		ArrayList<Student> arrL = new ArrayList<>(stuArr.subList(0, m));
		ArrayList<Student> arrR = new ArrayList<>(stuArr.subList(m, stuArr.size()));
		
		sortStudents(arrL, comp);
		sortStudents(arrR, comp);
		
		
		//merge the arrays
		// Merged array Position
		int i = 0;
		//left compare position
		int j = 0;
		//right compare position
		int k = 0;
		
		while (j < arrL.size() && k < arrR.size()) {
			if (comp.compare(arrL.get(j), arrR.get(k)) <= 0) {
				stuArr.set(i++, arrL.get(j++));
			} else {
				stuArr.set(i++, arrR.get(k++));
			}
		}
		
		while (j < arrL.size()) {
			stuArr.set(i++, arrL.get(j++));
		}
		
		while (k < arrR.size()) {
			stuArr.set(i++, arrR.get(k++));
		}
	}
	
	

}
