package chap10;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;

@SuppressWarnings("serial")
class TetrisFrame extends JFrame {
	int px = 120, py = 80, rot = 0;
	int fx = 310, fy = 550;
	int cx, cy;
	JLabel squares[] = new JLabel[4];
	
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
		{1, 1, 1, 0}, 
		{0, 0, 1, 0}, 
		{0, 0, 0, 0} 
	}, 
	{
		{0, 0, 1, 0}, 
		{0, 0, 1, 0}, 
		{0, 1, 1, 0}, 
		{0, 0, 0, 0} 
	} };
	
	class TetrisPanel extends JPanel {
		int size = 20;
		Container contPane = getContentPane();
		
		public TetrisPanel() {
			setBackground(Color.lightGray);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			drawBlock(rot);
			
			setVisible(true);
		}
		
		public void drawBlock(int dir) {
			int n = 0;
			for (int i = 0; i < block.length; i++) {
				for (int j = 0; j < block[i].length; j++) {
					if (block[dir][j][i] == 1) {
						squares[n] = new JLabel();
						squares[n].setSize(size, size);
						squares[n].setLocation(i * size + px, j * size + py);
						squares[n].setBackground(Color.blue);
						squares[n].setOpaque(true);
						contPane.add(squares[n]);
						n++;
					}
				}
			}
		}
		
		public void moveBlock(int dir) {
			int n = 0;
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					if (block[dir][j][i] == 1) {
						squares[n].setLocation(i * size + px, j * size + py);
						n++;
					}
				}
			}
		}
		
	}
	
	TetrisPanel tp;
	
	class MoveRotateListener extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			int k = e.getKeyCode();
			switch(k) {
			case KeyEvent.VK_UP:
				rot = ++rot % 4;
				tp.moveBlock(rot);
				break;
			case KeyEvent.VK_DOWN:
				if (py + tp.size * 4 < cy)
					py += tp.size;
				tp.moveBlock(rot);
				break;
			case KeyEvent.VK_LEFT:
				if (px > 0)
					px -= tp.size;
				tp.moveBlock(rot);
				break;
			case KeyEvent.VK_RIGHT:
				if (px + tp.size * 4 < cx)
					px += tp.size;
				tp.moveBlock(rot);
				break;
			}
		}
	}
	
	public TetrisFrame() {
		setSize(fx, fy);
		setLayout(null);
		tp = new TetrisPanel();
		this.addKeyListener(new MoveRotateListener());
		setVisible(true);
		Container contPane = getContentPane();
		cx = contPane.getWidth();
		cy = contPane.getHeight();
	}
	
}

public class Chap10_hw3_moveTetrBlock {

	public static void main(String[] args) {
		new TetrisFrame();

	}

}
