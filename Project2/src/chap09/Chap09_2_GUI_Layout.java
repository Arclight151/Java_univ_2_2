package chap09;

import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
class GuiFrame2 extends JFrame {
	public GuiFrame2() {
		setTitle("BorderLayout");
		setSize(400, 300);
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container cPane = getContentPane();
		cPane.setBackground(Color.cyan);
		cPane.setLayout(new BorderLayout(30, 20));
		
		cPane.add(new JButton("East"), BorderLayout.EAST);
		cPane.add(new JButton("West"), BorderLayout.WEST);
		cPane.add(new JButton("North"), BorderLayout.NORTH);
		cPane.add(new JButton("South"), BorderLayout.SOUTH);
		cPane.add(new JButton("Center"), BorderLayout.CENTER);
		
		setVisible(true);
	}
}

@SuppressWarnings("serial")
class GuiFrame3 extends JFrame {
	public GuiFrame3() {
		setTitle("GridLayout");
		setSize(400, 300);
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container cPane = getContentPane();
		cPane.setBackground(Color.cyan);
		
		GridLayout GL = new GridLayout(4, 2, 3, 20);
//		GL.setVgap(5);
		cPane.setLayout(GL);
		
		cPane.add(new JLabel("Name"));
		cPane.add(new JTextField());
		cPane.add(new JLabel("Name"));
		cPane.add(new JTextField());
		cPane.add(new JLabel("Name"));
		cPane.add(new JTextField());
		cPane.add(new JLabel("Name"));
		cPane.add(new JTextField());
		
		setVisible(true);
	}
}

public class Chap09_2_GUI_Layout {

	public static void main(String[] args) {
//		new GuiFrame2();
		new GuiFrame3();

	}

}
