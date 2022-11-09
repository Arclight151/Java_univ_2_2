package chap09.listeners.inner_anonymous;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
class InnerListener extends JFrame {
	public InnerListener() {
		setSize(500, 200);
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		
		JButton b0 = new JButton("0");
		JButton b1 = new JButton("1");
		JButton bp = new JButton("+");
		JButton bcl = new JButton("CE");
		JButton beq = new JButton("=");
		JTextField tf = new JTextField(15);
		
		class ButtonAL implements ActionListener {	// InnerListener
			public void actionPerformed(ActionEvent e) {
				JButton b = (JButton) e.getSource();
//				if (b.getText().equals("Action"))
//					b.setText("Clicked");
//				else
//					b.setText("Action");
				String str = b.getText();
				tf.setText(tf.getText() + str);
			}
			
		}
		
		b0.addActionListener(new ButtonAL());
		b1.addActionListener(new ButtonAL());
		bp.addActionListener(new ButtonAL());
		bcl.addActionListener(new ActionListener() {	// AnonymousListener
			public void actionPerformed(ActionEvent e) {
				tf.setText("");
			}
		});
		beq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int calcResult = 0;
				String str = tf.getText();
				String[] sp = str.split("\\+|\\-");	// \\p{Punct} (refer java Regex)
				for (int i = 0; i < sp.length; i++) {
					calcResult += Integer.parseInt(sp[i]);
				}
				tf.setText(Integer.toString(calcResult));
			}
		});
		
		this.add(tf);
		this.add(b0);
		this.add(b1);
		this.add(bp);
		this.add(beq);
		this.add(bcl);
		
		setVisible(true);
	}
}

public class Chap09_5_2_InnerClassListener {

	public static void main(String[] args) {
		new InnerListener();

	}

}
