package chap09;

import java.awt.*;
import javax.swing.*;

class CalcFrame extends JFrame {
	public CalcFrame() {
		setTitle("Simple Calculator");
		setSize(300, 300);
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container cPane = getContentPane();
		cPane.setLayout(new BorderLayout(5, 5));
		
		cPane.add(new NorthPanel(), BorderLayout.NORTH);
		cPane.add(new CenterPanel(), BorderLayout.CENTER);
		
		setVisible(true);
	}
}

class NorthPanel extends JPanel {
	public NorthPanel() {
		this.setBackground(Color.lightGray);
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		Font f = new Font("Default", 0, 18);
		
		JLabel label1 = new JLabel("Input & Result");
		label1.setFont(f);
		add(label1);
		
		JTextField tf1 = new JTextField("2+3", 8);
		tf1.setFont(f);
		add(tf1);
	}
}

class CenterPanel extends JPanel {
	String[] btxt = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "CE", "=", "+", "-", "x", "/"};
	JButton[] bArray = new JButton[16];
	Font f = new Font("Default", 0, 20);
	public CenterPanel() {
		GridLayout GL = new GridLayout(4, 4, 5, 5);
		this.setLayout(GL);
		
		for (int i = 0; i < btxt.length; i++) {
			bArray[i] = new JButton(btxt[i]);
			bArray[i].setFont(f);
			add(bArray[i]);
		}
		
		bArray[10].setBackground(Color.red);
		bArray[11].setBackground(Color.green);
		for (int i = 12; i < 16; i++) {
			bArray[i].setBackground(Color.cyan);
		}
	}
}

public class Chap09_hw1_CalcSample {

	public static void main(String[] args) {
		new CalcFrame();

	}

}
