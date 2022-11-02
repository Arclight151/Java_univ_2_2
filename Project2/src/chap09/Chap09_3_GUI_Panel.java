package chap09;

import java.awt.*;
import javax.swing.*;

class GuiFrame4 extends JFrame {
	public GuiFrame4() {
		setTitle("CalcEx");
		setSize(300, 200);
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container cPane = getContentPane();
		cPane.setBackground(Color.cyan);
		cPane.setLayout(new BorderLayout(5, 5));
		
		Panel1 pn1 = new Panel1();
		Panel2 pn2 = new Panel2();
		
		cPane.add(pn1, BorderLayout.NORTH);
		cPane.add(pn2, BorderLayout.CENTER);
		
		setVisible(true);
	}
}

class Panel1 extends JPanel {
	Panel1() {
		this.setBackground(Color.yellow);
		this.setLayout(new FlowLayout());
		
		Font f = new Font("Default", 0, 18);
		
		JLabel label1 = new JLabel("Calculator");
		label1.setFont(f);
		add(label1);
		
		JTextField tf1 = new JTextField("", 10);
		tf1.setFont(f);
		add(tf1);
	}
}
	

class Panel2 extends JPanel {
	String[] btxt = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "C", "="};
	Panel2() {
		this.setBackground(Color.green);
		GridLayout GL = new GridLayout(3, 4, 5, 5);
		this.setLayout(GL);
		
		for (int i = 0; i < btxt.length; i++) {
			JButton btn = new JButton(btxt[i]);
			Font f = new Font("Default", 0, 20);
			btn.setFont(f);
			add(btn);
		}
	}
}

public class Chap09_3_GUI_Panel {

	public static void main(String[] args) {
		new GuiFrame4();

	}

}
