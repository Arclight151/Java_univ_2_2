package chap04;

import java.util.Scanner;

class Rectangle {
	private int w, h;
	
	public Rectangle(int w, int h) {
		this.w = w;
		this.h = h;
	}
	public void setValue(int w, int h) {
		this.w = w;
		this.h = h;
	}
	public int getArea() { return w * h; }
	
}

public class Ch04_1_rectangleClass {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//Rectangle r = new Rectangle();
		
		System.out.print("Enter width, height: ");
		int w = sc.nextInt();
		int h = sc.nextInt();
		//r.setValue(w, h);
		Rectangle r1 = new Rectangle(w, h);
		
		System.out.println("Area: " + r1.getArea());
		
		Rectangle [] r2 = new Rectangle[3];
		for (int i = 0; i < r2.length; i++) {
			r2[i] = new Rectangle(i, i);
		}
		for (int i = 0; i < r2.length; i++) {
			System.out.println("Area" + (i+1) + ": " + r2[i].getArea());
		}
		
		sc.close();

	}

}
