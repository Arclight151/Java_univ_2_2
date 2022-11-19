package chap10;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
class CalculatorFrame extends JFrame {
	NPanel np;
	CPanel cp;
	public CalculatorFrame() {
		setTitle("Simple Calculator");
		setSize(300, 300);
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container cPane = getContentPane();
		cPane.setLayout(new BorderLayout(5, 5));
		
		np = new NPanel();
		cp = new CPanel();
		cPane.add(np, BorderLayout.NORTH);
		cPane.add(cp, BorderLayout.CENTER);
		
		class BListen implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				JButton b = (JButton) e.getSource();
				String str = b.getText();
				np.tf1.setText(np.tf1.getText() + str);
			}
		}
		
		for (int i = 0; i < 10; i++) {
			cp.bArray[i].addActionListener(new BListen());
		}
		for (int i = 12; i < 16; i++) {
			cp.bArray[i].addActionListener(new BListen());
		}
		cp.bArray[10].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				np.tf1.setText("");
			}
		});
		cp.bArray[11].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				np.calc();
			}
		});
		
		setVisible(true);
	}
}

@SuppressWarnings("serial")
class NPanel extends JPanel {
	JTextField tf1;
	public NPanel() {
		this.setBackground(Color.lightGray);
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		Font f = new Font("Default", 0, 18);
		
		JLabel label1 = new JLabel("Input & Result");
		label1.setFont(f);
		add(label1);
		
		tf1 = new JTextField("", 8);
		tf1.setFont(f);
		add(tf1);
	}
	
	public void calc() {
		String str = tf1.getText();
		String[] num = str.split("\\+|-|x|/");
		for (int i = 0; i < num.length; i++) {
			switch (str.charAt(num[0].length())) {
			case '+':
				tf1.setText(Integer.toString(Integer.parseInt(num[0]) + Integer.parseInt(num[1])));
				break;
			case '-':
				tf1.setText(Integer.toString(Integer.parseInt(num[0]) - Integer.parseInt(num[1])));
				break;
			case 'x':
				tf1.setText(Integer.toString(Integer.parseInt(num[0]) * Integer.parseInt(num[1])));
				break;
			case '/':
				tf1.setText(Float.toString(Float.parseFloat(num[0]) / Float.parseFloat(num[1])));
				break;
			}
		}
	}
}

@SuppressWarnings("serial")
class CPanel extends JPanel {
	String[] btxt = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "CE", "=", "+", "-", "x", "/"};
	JButton[] bArray = new JButton[16];
	Font f = new Font("Default", 0, 20);
	
	
	
	public CPanel() {
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

public class Chap10_hw1_ListenerCalc {

	public static void main(String[] args) {
		new CalculatorFrame();

	}

}
