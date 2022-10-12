package chap07;

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

public class Ch07_2_RectOverlapSim {
	int frameW = 100, frameH = 100;
	int mx = 30, my = 30, mw = 40, mh = 30;
	int tSize = 20;
	
	Target tg = new Target(71, 10, tSize);
	Missile ms = new Missile(mx, my, mw, mh);
	
	public boolean HitScan(Missile m, Target t) {
		if ((m.x >= (t.x - m.w) && m.x <= (t.x + t.w)) && (m.y >= (t.y - m.h) && m.y <= (t.y + t.h)))
			return true;
		else
			return false;
	}
	
	public void play() {
		boolean result = HitScan(ms, tg);
		System.out.println(result);
	}

	public static void main(String[] args) {
		Ch07_2_RectOverlapSim test = new Ch07_2_RectOverlapSim();
		test.play();

	}

}
