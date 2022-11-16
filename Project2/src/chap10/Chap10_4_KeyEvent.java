package chap10;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
class KeyPanel extends JFrame {
	private JLabel l1 = new JLabel("Hello");
	private int lx = 40, ly = 40, size = 30;
	private int fx = 400, fy = 600;
	private int cx, cy;
	private final int move = 10;
	
//	class KListener implements KeyListener
	class KListener extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			int k = e.getKeyCode();
			switch(k) {
			case KeyEvent.VK_UP:
				if (ly - move >= 0)
					ly -= move;
				l1.setLocation(lx, ly);
				break;
			case KeyEvent.VK_DOWN:
				if (ly + size + move <= cy)
					ly += move;
				l1.setLocation(lx, ly);
				break;
			case KeyEvent.VK_LEFT:
				if (lx - move >= 0)
					lx -= move;
				l1.setLocation(lx, ly);
				break;
			case KeyEvent.VK_RIGHT:
				if (lx + size + move <= cx)
					lx += move;
				l1.setLocation(lx, ly);
				break;
			}
		}
	}
	
	public KeyPanel() {
		setSize(fx, fy);
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.addKeyListener(new KListener());
		
		l1.setLocation(lx, ly);
		l1.setSize(size, size);
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

public class Chap10_4_KeyEvent {

	public static void main(String[] args) {
		new KeyPanel();

	}

}
