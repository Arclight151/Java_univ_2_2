package chap09;

import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
class NullLayout extends JFrame {
	JPanel pnl = new JPanel();
	int px = 20, py = 40;
	int size = 70;
	int[][] block = {{1, 0, 0, 1}, 
					 {1, 0, 0, 0}, 
					 {1, 1, 1, 0}, 
					 {1, 0, 0, 1}};
	
	public NullLayout() {
		setSize(400, 800);
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setContentPane(pnl);
		
		pnl.setBackground(Color.darkGray);
		pnl.setLayout(null);
		
		JLabel l1 = new JLabel("Press Button");
		l1.setForeground(Color.white);
		l1.setLocation(300, 50);
		l1.setSize(100, 10);
		pnl.add(l1);
		
		drawBlock(px, py);
		drawBlock(px, py + 300);
		
		setVisible(true);
	}
	
	public void drawBlock(int x, int y) {
		for (int i = 0; i < block.length; i++) {
			for (int j = 0; j < block[i].length; j++) {
				if (block[j][i] == 1) {
					JButton btn = new JButton(Integer.toString(i) + "," + Integer.toString(j));
					btn.setLocation(i * size + x, j * size + y);
					btn.setSize(size - 5, size - 5);
					pnl.add(btn);
				}
			}
		}
	}
}

public class Chap09_4_NullLayout {

	public static void main(String[] args) {
		new NullLayout();

	}

}
