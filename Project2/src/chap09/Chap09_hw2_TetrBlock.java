package chap09;

import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
class BlockFrame extends JFrame {
	
	int[][][] block = { 
	{
		{0, 0, 0, 0}, 
		{1, 0, 0, 0}, 
		{1, 1, 1, 0}, 
		{0, 0, 0, 0} 
	}, 
	{
		{0, 1, 1, 0}, 
		{0, 1, 0, 0}, 
		{0, 1, 0, 0}, 
		{0, 0, 0, 0} 
	}, 
	{
		{0, 0, 0, 0}, 
		{0, 1, 1, 1}, 
		{0, 0, 0, 1}, 
		{0, 0, 0, 0} 
	}, 
	{
		{0, 0, 0, 0}, 
		{0, 0, 1, 0}, 
		{0, 0, 1, 0}, 
		{0, 1, 1, 0} 
	} };
	
	class TetrisPanel extends JPanel {
		int size = 20;
		JPanel cPane = new JPanel();
		
		public TetrisPanel() {
			setTitle("TetrisPanel");
			setBackground(Color.lightGray);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			setContentPane(cPane);
			drawBlock(0, 100, 10);
			drawBlock(1, 100, 90);
			drawBlock(2, 100, 170);
			drawBlock(3, 100, 250);
			
			setVisible(true);
		}
		
		public void drawBlock(int dir, int px, int py) {
			for (int i = 0; i < block.length; i++) {
				for (int j = 0; j < block[i].length; j++) {
					if (block[dir][j][i] == 1) {
						JPanel pn = new JPanel();
						pn.setLocation(i * size + px, j * size + py);
						pn.setSize(size, size);
						pn.setBackground(Color.blue);
						cPane.add(pn);
					}
				}
			}
		}
	}
	
	TetrisPanel tp = new TetrisPanel();
	
	public BlockFrame() {
		setSize(300, 500);
		setLayout(null);
		setVisible(true);
	}
	
}

public class Chap09_hw2_TetrBlock {

	public static void main(String[] args) {
		new BlockFrame();
	}

}
