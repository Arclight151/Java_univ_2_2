package chap13;

import java.util.ArrayList;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;

@SuppressWarnings("serial")
class Game extends JFrame implements Runnable {
	private GamePanel gp = new GamePanel();
	int fx = 300, fy = 500, cx = 286, cy = 463;
	int mx, my, tx, ty;
	int mSize, tSize = 10;
	int pSize = 20, pMove = 10, px = cx / 2 - 5, py = cy - pSize - 10;
	ArrayList<Target> tgList = null;
	ArrayList<Missile> mslList = null;
	Thread th;
	
	public Game() {
		setSize(fx, fy);
		setTitle("ShotingGameV1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(gp);
		
		th = new Thread(this);
		tgList = new ArrayList<>();
		
		createTargets(10);
		
		gp.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e){
				int keyCode = e.getKeyCode();
				switch (keyCode) {
				case KeyEvent.VK_LEFT:
					if (px > 0)
						px -= pMove;
					break;
				case KeyEvent.VK_RIGHT:
					if (px + pSize < cx)
						px += pMove;
					break;
				case KeyEvent.VK_UP:
					if (py - pMove > 0)
						py -= pMove;
					break;
				case KeyEvent.VK_DOWN:
					if (py + pSize < cy)
						py += pMove;
					break;
				case KeyEvent.VK_ENTER:
					th.start();
					System.out.println("Game Start");
					break;
				}
				gp.repaint();
			}
		});
		
		setVisible(true);
		gp.setFocusable(true);
		gp.requestFocus();
		cx = gp.getWidth();
		cy = gp.getHeight();
	}
	
	public void createTargets(int n) {
		int rx, ry;
		for (int i = 0; i < n; i++) {
			rx = (int)(Math.random() * (cx - tSize));
			ry = (int)(Math.random() * (cy * 0.2));
			tgList.add(new Target(rx, ry, tSize, tSize));
		}
	}
	
	public void printList() {
		for (int i = 0; i < tgList.size(); i++) {
			tgList.get(i).printPos();
		}
	}
	
	private boolean isPassed(Target t) {
		if (t.getY() >= cy * 0.8)
			return true;
		return false;
	}
	
	public void removePassedFromList() {
		for (int i = 0; i < tgList.size(); i++) {
			if (isPassed(tgList.get(i))) {
				System.out.println("Passed: " + i);
				tgList.remove(i);
				i--;
			}
		}
	}
	
	private boolean isHit(Target t) {
		if (((px + pSize) >= t.getX() && px <= (t.getX() + t.getW())) && ((py + pSize) >= t.getY() && py <= (t.getY() + t.getH())))
			return true;
		return false;
	}
	
	public void removeHitFromList() {
		for (int i = 0; i < tgList.size(); i++) {
			if (isHit(tgList.get(i))) {
				System.out.println("Hit: " + i);
				tgList.remove(i);
				i--;
			}
		}
	}
	
	class GamePanel extends JPanel {
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			drawPlayer(g);
			drawTarget(g);
			g.setColor(Color.gray);
			g.fillRect(0, (int)(cy * 0.8), cx, 2);
		}
		
		void drawPlayer(Graphics g) {
			g.setColor(Color.blue);
			g.fillRect(px, py, pSize, pSize);
		}
		
		void drawTarget(Graphics g) {
			g.setColor(Color.orange);
			Target tg;
			for (int i = 0; i < tgList.size(); i++) {
				tg = tgList.get(i);
				g.fillRect(tg.getX(), tg.getY(), tg.getW(), tg.getH());
			}
		}
		
		void drawMsl(Graphics g) {
			//
		}
	}

	public void run() {
		while (tgList.size() > 0) {
			for (int i = 0; i < tgList.size(); i++) {
				Target tg = tgList.get(i);
				tg.move((int)(Math.random() * 5 + 3));
				gp.repaint();
			}
			removePassedFromList();
			removeHitFromList();
			try {
				Thread.sleep(250);
			} catch (InterruptedException e) {
				return;
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
		new Game();

	}

}
