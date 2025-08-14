package shapes;

public class shapeArray {
	
	public static Rectangle rec;
	public static Circle circ;
	public static Triangle tri;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		rec = new Rectangle(5,6);
		circ = new Circle(45);
		
		try {
			tri = new Triangle(5,6,7);
		} catch (IllegalArgumentException e) {
			System.out.println("Triangle values illegal.  Unable to create this triangle.  Please re-run this program with appropriate values.");
			System.exit(0);;
		}
		
		Shape[] shapeArray = new Shape[3];
		shapeArray[0] = rec;
		shapeArray[1] = circ;
		shapeArray[2] = tri;
		
		for (Shape s : shapeArray) {
			System.out.println(s);
			
		}
		
	}

}
