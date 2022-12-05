package chap13;

import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
class Game extends JFrame {
	int fx = 300, fy = 500, cx, cy;
	int mx, my, tx, ty;
	int tSize = 10;
	ArrayList<Target> tgList = new ArrayList<>();
	
	public Game() {
		
	}
	
	public void createTargetList(int n) {
		int rx, ry;
		for (int i = 0; i < n; i++) {
			rx = (int) (Math.random() * (fx - tSize));
			ry = (int) (Math.random() * (fy * 0.2));
			tgList.add(new Target(rx, ry, tSize, tSize));
		}
	}
	
	public void printList() {
		for (int i = 0; i < tgList.size(); i++) {
			tgList.get(i).printPos();
		}
	}
	
	private boolean isPassed(Target t) {
		if (t.getY() > fy * 0.2)
			return true;
		return false;
	}
	
	public void removeFromList() {
		for (int i = 0; i < tgList.size(); i++) {
			if (isPassed(tgList.get(i))) {
				tgList.remove(i);
				i--;
			}
		}
	}
}

abstract class Rectangle {
	protected int x, y, w, h;
	
	public Rectangle(int x, int y, int w, int h) {
		this.x = x; this.y = y; this.w = w; this.h = h;
	}
	
	public int getX() { return x; }
	public int getY() { return y; }
	public int getW() { return w; }
	public int getH() { return h; }
	public void printPos() {
		System.out.println("(" + x + ", " + y + ")");
	}
	
	public abstract void move(int dist);

}

class Target extends Rectangle {
	public Target(int x, int y, int w, int h) {
		super(x, y, w, h);
	}

	public void move(int dist) {
		y += dist;
	}
}

class Missile extends Rectangle {
	public Missile(int x, int y, int w, int h) {
		super(x, y, w, h);
	}

	public void move(int dist) {
		y -= dist;
	}
}

public class Chap13_2_ShootingGameV1 {

	public static void main(String[] args) {
		Game g = new Game();
		g.createTargetList(5);
		g.printList();
		System.out.println();
		g.removeFromList();
		g.printList();

	}

}
