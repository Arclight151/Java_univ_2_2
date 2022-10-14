package chap07.hw;

import java.util.ArrayList;

abstract class Rectangle {
	protected int x, y, w, h;
	
	public Rectangle(int x, int y, int w, int h) {
		this.x = x; this.y = y; this.w = w; this.h = h;
	}
	
	public int getX() { return x; }
	public int getY() { return y; }
	public void printPos() {
		System.out.println("(" + x + ", " + y + "): w=" + w + ", h=" + h);
	}
	
	public abstract void move();
}

class Target extends Rectangle {

	public Target(int x, int y, int size) {
		super(x, y, size, size);
	}
	
	public void move() {}
	
}

class Missile extends Rectangle {

	public Missile(int x, int y, int w, int h) {
		super(x, y, w, h);
	}
	
	public void move() {}
	
}

public class Ch07_hw1_MissileSim {

	public static void main(String[] args) {
		

	}

}
