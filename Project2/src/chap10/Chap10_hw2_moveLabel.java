package chap10;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
class BasePanel extends JFrame {
	private JLabel l1 = new JLabel("Hello");
	private int lx = 170, ly = 500, lw = 50, lh = 20;
	private int fx = 400, fy = 600;
	private int cx, cy;
	private final int move = 10;
	
	class KListener extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			int k = e.getKeyCode();
			switch(k) {
			case KeyEvent.VK_UP:
				if (ly - move >= cy * 0.7) {
					ly -= move;
					System.out.println("Up");
				}
				l1.setLocation(lx, ly);
				break;
			case KeyEvent.VK_DOWN:
				if (ly + lh + move <= cy) {
					ly += move;
					System.out.println("Down");
				}
				l1.setLocation(lx, ly);
				break;
			case KeyEvent.VK_LEFT:
				if (lx - move >= 0) {
					lx -= move;
					System.out.println("Left");
				}
				l1.setLocation(lx, ly);
				break;
			case KeyEvent.VK_RIGHT:
				if (lx + lw + move <= cx) {
					lx += move;
					System.out.println("Right");
				}
				l1.setLocation(lx, ly);
				break;
			case KeyEvent.VK_ENTER:
				System.out.println("Game Start");
				break;
			case KeyEvent.VK_SPACE:
				System.out.println("Fire");
			}
		}
	}
	
	public BasePanel() {
		setSize(fx, fy);
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.addKeyListener(new KListener());
		
		l1.setLocation(lx, ly);
		l1.setSize(lw, lh);
		l1.setOpaque(true);
		l1.setBackground(Color.cyan);
		this.add(l1);
		
		this.setFocusable(true);
		this.requestFocus();
		
		setVisible(true);
		Container c = getContentPane();
		cx = c.getWidth();
		cy = c.getHeight();
	}
}

public class Chap10_hw2_moveLabel {

	public static void main(String[] args) {
		new BasePanel();

	}

}
