package chap11;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
class TextAreaTest extends JFrame {
	public TextAreaTest() {
		setSize(300, 200);
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		
		JTextArea txtA = new JTextArea(7, 20);
		JScrollPane scPane = new JScrollPane(txtA);
		
		add(scPane);
		
		setVisible(true);
	}
}

public class Chap11_3_TextArea_ScrollPane {

	public static void main(String[] args) {
		new ComboBoxTest();

	}

}
