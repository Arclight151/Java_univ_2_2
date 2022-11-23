package chap13;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;

@SuppressWarnings("serial")
class ThreadEx extends JFrame implements Runnable {
	TestPanel tPane;
	Thread th1;
	int px = 10, py = 10;
	int cx, cy;
	int size = 50;
	
	public ThreadEx() {
		setSize(300, 300);
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tPane = new TestPanel();
		setContentPane(tPane);
		th1 = new Thread(this);
		
		tPane.addKeyListener(new TestKeyListener());
		
		setVisible(true);
		cx = tPane.getWidth();
		cy = tPane.getHeight();
		
		tPane.setFocusable(true);
		tPane.requestFocus();
	}
	
	class TestPanel extends JPanel {
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.blue);
			g.drawRect(px, py, size, size);
//			g.fillRect(50, 50, size, size);
//			g.setColor(Color.magenta);
//			g.drawRect(90, 90, size, size);
		}
	}
	
	class TestKeyListener extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			int k = e.getKeyCode();
			switch(k) {
			case KeyEvent.VK_UP:
				py -= size;
				repaint();
				break;
			case KeyEvent.VK_DOWN:
				py += size;
				repaint();
				break;
			case KeyEvent.VK_LEFT:
				px -= size;
				repaint();
				break;
			case KeyEvent.VK_RIGHT:
				px += size;
				repaint();
				break;
			case KeyEvent.VK_ENTER:
				th1.start();
				break;
			default:
				th1.interrupt();
			}
		}
	}

	public void run() {
		while(px < cx - size * 2 || py < cy - size * 2) {
			try {
				Thread.sleep(500);
				px += size;
				py += size;
				repaint();
			}
			catch (InterruptedException e) {
				System.out.println("Quit");
				return;
			}
		}
	}
}

public class Chap13_1_ThreadedMove {

	public static void main(String[] args) {
		new ThreadEx();

	}

}
