package chap12;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
class TetrisGame extends JFrame  implements Runnable {
	int px = 120, py = 80, size = 20, rot = 0;
	int gbx = 5, gby = 0;
	int fx = 310, fy = 550;
	int cx, cy;
	int curX[] = new int [4];
	int curY[] = new int [4];
	boolean gameOver = false;
	
	int[][][] block = { 
	{
		{1, 0, 0, 0}, 
		{1, 1, 1, 0}, 
		{0, 0, 0, 0}, 
		{0, 0, 0, 0} 
	}, 
	{
		{1, 1, 0, 0}, 
		{1, 0, 0, 0}, 
		{1, 0, 0, 0}, 
		{0, 0, 0, 0} 
	}, 
	{
		{1, 1, 1, 0}, 
		{0, 0, 1, 0}, 
		{0, 0, 0, 0}, 
		{0, 0, 0, 0} 
	}, 
	{
		{0, 1, 0, 0}, 
		{0, 1, 0, 0}, 
		{1, 1, 0, 0}, 
		{0, 0, 0, 0} 
	} };
	
	int[][] gameBoard = {
			{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
	        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
	        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
	        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
	        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
	        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
	        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
	        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
	        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
	        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
	        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
	        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
	        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
	        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
	        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
	        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
	        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
	        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
	        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};
	
	class TetrisBlock extends JPanel {
		int size = 20;
		Container contPane = getContentPane();
		
		public TetrisBlock() {
			setBackground(Color.lightGray);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setVisible(true);
		}
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			drawBorder(g);
			drawBlock(g);
		}
		
		void drawBlock (Graphics g) {
			g.setColor(Color.BLUE);
			int i=0;
			for (int r=0; r<4; r++) {
				for (int c=0; c<4; c++)		
					if (block[rot][r][c] == 1) {
						g.fillRect(px + c * size, py + r * size, size, size);
						curX[i] = gbx + c; curY[i] = gby + r;
						i++;
					}
			}	
		}
		
		public void drawBorder(Graphics g) {
			g.setColor(Color.black);
			g.fillRect(30, 70, 230, 10);
			g.fillRect(30, 460, 230, 10);
			g.fillRect(30, 70, 10, 400);
			g.fillRect(260, 70, 10, 400);
		}

		public boolean isLeft() {
			for (int i=0; i<curX.length; i++)
				if (gameBoard[curY[i]][curX[i] - 1] == 1)
					return true;
			return false;
		}
		public boolean isRight() {
			for (int i=0; i<curX.length; i++)
				if (gameBoard[curY[i]][curX[i] + 1] == 1)
					return true;
			return false;
		}
		public boolean isBottom() {
			for (int i=0; i<curX.length; i++)
				if (gameBoard[curY[i] + 1][curX[i]] == 1)
					return true;
			return false;
		}
	}
	
	TetrisBlock tb;
	
	class MoveRotateListener extends KeyAdapter {
		public void keyPressed(KeyEvent e){
			if (!gameOver) {
				int keyCode = e.getKeyCode();
				switch (keyCode) {
				case KeyEvent.VK_LEFT:
          			if (!tb.isLeft()) {
          				px -= size;
          				gbx--;
          			}
          			break;
          		case KeyEvent.VK_RIGHT:
          			if (!tb.isRight()) {
          				px += size;
          				gbx++;
          			}
          			break;
             	case KeyEvent.VK_DOWN:
             		if (!tb.isBottom()) {
          				py += size;
          				gby++;
             		}
             		break;
             	case KeyEvent.VK_UP:
             		rot = ++rot % 4;
    				break;
             	default:
				}
             tb.repaint();
             }
        }
	}
	
	public TetrisGame() {
		setSize(fx, fy);
		setLayout(null);
		tb = new TetrisBlock();
		setContentPane(tb);
		tb.addKeyListener(new MoveRotateListener());
		setVisible(true);
		Container contPane = getContentPane();
		cx = contPane.getWidth();
		cy = contPane.getHeight();
		contPane.setFocusable(true);
		contPane.requestFocus();
	}

	public void run() {
		
	}
}

public class Chap12_hw2_TetrisGame {

	public static void main(String[] args) {
		new TetrisGame();

	}

}
