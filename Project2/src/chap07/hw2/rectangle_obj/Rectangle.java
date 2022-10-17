package chap07.hw2.rectangle_obj;

public abstract class Rectangle {
	protected int x, y, w, h;
	
	public Rectangle(int x, int y, int w, int h) {
		this.x = x; this.y = y; this.w = w; this.h = h;
	}
	
	public int getX() { return x; }
	public int getY() { return y; }
	public int getW() { return w; }
	public int getH() { return h; }
	public void printPos() {
//		System.out.println("(" + x + ", " + y + "): w=" + w + ", h=" + h);
		System.out.println("(" + x + ", " + y + ")");
	}
	
	public abstract void move();

}
