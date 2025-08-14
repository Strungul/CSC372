package shapes;

public class Rectangle extends Shape {
	private double width;
	private double length;
	
	public Rectangle(double width, double length) {
		this.width = width;
		this.length = length;
	}
	
	public double getWidth() {
		return width;
	};
	public double getLength() {
		return length;
	};
	
	@Override
	public double area() {
		return this.width * this.length;
	}
	
	@Override
	public double perimeter() {
		return 2*(this.width + this.length);
	}
	
	@Override
	public String toString() {
		return "Rectangle Area: " + String.valueOf(area()) + " " + "Rectangle Perimeter: " + String.valueOf(perimeter());
		
	}
	
}
