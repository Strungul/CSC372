package shapes;

public class Circle extends Shape {
	private double radius;
	
	public Circle(double radius) {
		this.radius = radius;
	}
	
	public double getRadius() {
		return radius;
	};
	
	@Override
	public double area() {
		return this.radius * this.radius * Math.PI;
	}
	
	@Override
	public double perimeter() {
		return 2 * Math.PI * radius;
	}
	
	@Override
	public String toString() {
		return "Circle Area: " + String.valueOf(area()) + " " + "Circle Perimeter: " + String.valueOf(perimeter());
		
	}
}
