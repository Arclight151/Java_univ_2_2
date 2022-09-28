package chap05;

abstract class Shape {
	private String name;
	public Shape(String str) { name = str; }
	public abstract void draw();
	public String getName() { return name; }
}

class Rectangle extends Shape {

	public Rectangle(String str) { super(str); }
	public void draw() {
		System.out.println("Draw Rectangle");
	}
}

public class Ch05_1_abstractShape {

	public static void main(String[] args) {
		Rectangle r1 = new Rectangle("r1");
		r1.draw();
	}

}
