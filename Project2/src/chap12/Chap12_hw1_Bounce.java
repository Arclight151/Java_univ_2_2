package chap12;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
class BouncingBall extends JFrame implements Runnable {
	Thread BounceThread;
	Ball ball;
	int px = 10, py = 10, size = 50;
	int cx, cy;
	int mx = 50, my = 50;
	
	public BouncingBall() {
		setSize(400, 500);
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container contPane = getContentPane();
		
		ball = new Ball();
		add(ball);
		BounceThread = new Thread(this);
		addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				int k = e.getKeyCode();
				switch(k) {
				case KeyEvent.VK_ENTER:
					BounceThread.start();
					break;
				case KeyEvent.VK_ESCAPE:
					BounceThread.interrupt();
				}
			}
		});
		
		setVisible(true);
		setFocusable(true);
		requestFocus();
		cx = contPane.getWidth();
		cy = contPane.getHeight();
	}
	
	class Ball extends JPanel {
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.blue);
			g.fillOval(px, py, size, size);
		}
	}

	public void run() {
		while(true) {
			try {
				px += mx;
				py += my;
				if (px + size + mx > cx || px + mx < 0)
					mx *= -1;
				if (py + size + my > cy || py + my < 0)
					my *= -1;
				repaint();
				Thread.sleep(5);
			}
			catch (InterruptedException e) {
				return;
			}
		}
	}
	
}

public class Chap12_hw1_Bounce {

	public static void main(String[] args) {
		new BouncingBall();

	}

}
