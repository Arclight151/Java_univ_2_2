package chap12;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;

@SuppressWarnings("serial")
class GraphicsEx extends JFrame {
	TestPanel tPane;
	int px = 10, py = 10;
	int size = 50;
	public GraphicsEx() {
		setSize(300, 300);
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tPane = new TestPanel();
		setContentPane(tPane);
		tPane.addKeyListener(new TestKeyListener());
		
		setVisible(true);
		
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
			}
		}
	}
}

public class Chap12_1_Graphics {

	public static void main(String[] args) {
		new GraphicsEx();

	}

}
