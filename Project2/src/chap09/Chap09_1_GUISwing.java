package chap09;

import java.awt.*;
import javax.swing.*;

class GuiFrame extends JFrame {
	public GuiFrame() {
		setTitle("Sample Swing Frame 400*300");
		setSize(400, 300);
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		Container cPane = getContentPane();
		cPane.setBackground(Color.cyan);
		cPane.setLayout(new FlowLayout());
		
		cPane.add(new JButton("OK"));
		cPane.add(new JButton("Cancel"));
		cPane.add(new JButton("Ignore"));
		cPane.add(new JButton("--------------------"));
		
		cPane.add(new JLabel("Test"));
	}
}

public class Chap09_1_GUISwing {

	public static void main(String[] args) {
		new GuiFrame();

	}

}
