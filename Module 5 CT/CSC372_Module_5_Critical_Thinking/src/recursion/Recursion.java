package recursion;
import java.util.Arrays;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Recursion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//intake a list of 5 numbers
		double [] numArray = new double[5];
	
		System.out.println("Hello and welcome to the adding app.  I can add any numbers you want to throw at me, assuming there are 5 of them and they are presented"
				+ " as numbers and not as words.");
		
		try (Scanner intake = new Scanner(System.in)){ 
			for (int i = 0; i < numArray.length;) {
				int q = i + 1;
				System.out.println("Please enter a number (" + q + ").");
				try {
					numArray[i] = intake.nextDouble();
					i++;
				} catch (InputMismatchException e) {
					System.out.println("I said numbers only!");
					intake.nextLine();
				}
			}	
		}
		
		//return that sum to the user
		System.out.println("The sum of these values is " + provideSum(numArray)[0]);
	}
	

	//create a sum of those numbers
	//this would have been so easy as a loop
	public static double[] provideSum(double[] numbers) {
		if (numbers.length == 0) {
			return new double[] {0};
		}
		
		double[] sum = new double[1];
		sum [0]= numbers[0]  + provideSum(Arrays.copyOfRange(numbers, 1, numbers.length))[0];
		
		return sum;
	}
}


	