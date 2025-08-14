package shapes;

public class Triangle extends Shape {
	private double s1;
	private double s2;
	private double s3;

	
	public Triangle(double s1, double s2, double s3) {
		 if (s1 <= 0 || s2 <= 0 || s3 <= 0 ||
			        s1 + s2 <= s3 || s1 + s3 <= s2 || s2 + s3 <= s1) {
			        throw new IllegalArgumentException("Invalid side lengths for a triangle");
			    }
		this.s1 = s1;
		this.s2 = s2;
		this.s3 = s3;
		
		
	}
	
	
	public double getSide1() {
		return s1;
	}
	
	public double getSide2() {
		return s2;
	}
	
	public double getSide3() {
		return s3;
	}
	
	@Override
	public double area() {
		double sp = (s1 + s2 + s3)/2;
		return Math.sqrt(sp * (sp - s1) * (sp - s2) * (sp - s3));
	}
	
	@Override
	public double perimeter() {
		return s1 + s2 + s3;
	}
	
	@Override
	public String toString() {
		return "Triangle Area: " + String.valueOf(area()) + " " + "Triangle Perimeter: " + String.valueOf(perimeter());
		
	}
}
