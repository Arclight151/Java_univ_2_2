package chap09;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
class MousePanel extends JFrame {
	private JLabel l1 = new JLabel("Hello");
	
//	class MListener implements MouseListener
	class MListener extends MouseAdapter {
		public void mouseClicked(MouseEvent e) {
			Point p = e.getPoint();
			l1.setLocation(p);
		}
	}
	
	public MousePanel() {
		setSize(400, 600);
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.addMouseListener(new MListener());
		this.setLayout(null);
		
		l1.setSize(40, 20);
		l1.setOpaque(true);
		l1.setBackground(Color.cyan);
		
		add(l1);
		
		setVisible(true);
	}
}

public class Chap09_6_MouseEvent {

	public static void main(String[] args) {
		new MousePanel();

	}

}
