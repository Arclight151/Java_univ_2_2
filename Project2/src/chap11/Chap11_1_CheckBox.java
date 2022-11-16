package chap11;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
class ComponentTest extends JFrame {
	public ComponentTest() {
		setSize(300, 200);
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		
		class CheckBoxItemListener implements ItemListener {
			public void itemStateChanged(ItemEvent e) {
				//TODO
			}
		}
		
		JLabel label1 = new JLabel("Test");
		JCheckBox chkb1 = new JCheckBox("Item1");
		JCheckBox chkb2 = new JCheckBox("Item2");
		add(label1);
		add(chkb1);
		add(chkb2);
		
		setVisible(true);
	}
}

public class Chap11_1_CheckBox {

	public static void main(String[] args) {
		new ComponentTest();

	}

}
