package chap10;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
class IndpListener extends JFrame {
	public IndpListener() {
		setSize(400, 400);
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		
		JButton btn = new JButton("Action");
		btn.addActionListener(new ButtonAL());
		
		this.add(btn);
		
		setVisible(true);
	}
}

class ButtonAL implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton) e.getSource();
		if (b.getText().equals("Action"))
			b.setText("Clicked");
		else
			b.setText("Action");
	}
	
}

public class Chap10_1_IndependentListener {

	public static void main(String[] args) {
		new IndpListener();

	}

}