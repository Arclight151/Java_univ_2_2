package chap12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

@SuppressWarnings("serial")
public class Chap12_ref extends JFrame  implements Runnable {
	
	private MyPanel panel = new MyPanel();
	
	Thread th;
	
	int pX=120, pY=80, gbX = 5, gbY = 0;
	int rsize = 20;
	
	int curX[] = new int [4];
	int curY[] = new int [4];
	
	int rotation = 0;
	int currentBlk = 0, nextBlk = (int)(Math.random()*7);

	int block[][][]  = 
	    	         {	// b[0]
	    	            {  {0,0,0,0},
	    	               {1,0,0,0},
	    	               {1,1,1,0},
	    	               {0,0,0,0} },
	    	            {  
	    	               {0,1,1,0},
	    	               {0,1,0,0},
	    	               {0,1,0,0},
	    	               {0,0,0,0} },
	    	            {
	    	               {1,1,1,0},
	    	               {0,0,1,0},
	    	               {0,0,0,0},
	    	               {0,0,0,0} },
	    	            {
	    	               {0,0,1,0},
	    	               {0,0,1,0},
	    	               {0,1,1,0},
	    	               {0,0,0,0} }
	    	         };
	
	int[][] gameboard = {	// 20 * 13 (r19*c11)
			{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},	// 0
			{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
	        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},	// 2
	        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
	        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},	// 4
	        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
	        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},	// 6
	        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
	        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},	// 8
	        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
	        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},	// 10
	        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
	        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},	// 12
	        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
	        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},	// 14
	        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
	        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},	// 16
	        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
	        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},	// 18
	        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}}; // 19
	
	public Chap12_ref() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);		
		setContentPane(panel);
		th = new Thread(this);
		
	    panel.addKeyListener(new KeyAdapter() {
	        public void keyPressed(KeyEvent e){
	        	if (true) {//!gameOver) {	        		  
	              int keyCode = e.getKeyCode();
	              switch (keyCode) {
	          		case KeyEvent.VK_LEFT:
	          			if (! panel.isLeft()) {
	          				pX -= rsize;
	          				gbX--;
	          			}
	          			break;
	          		case KeyEvent.VK_RIGHT:
	          			if (! panel.isRight()) {
	          				pX += rsize;
	          				gbX++;
	          			}
	          			break;
	             	case KeyEvent.VK_UP:

	             		break;
	             	case KeyEvent.VK_DOWN:
           		
	             		break;

	             	default:
	             }
	                        
	             panel.repaint();

	           }
	        }
	    });		

		setSize(300, 550);
		setVisible(true);
	    panel.requestFocus(true);
	    panel.requestFocus();	    
	}
	
    public void run(){

    }
    
	public static void main(String [] args) {
		new Chap12_ref();
	}

	class MyPanel extends JPanel {
		public void paintComponent(Graphics g) {
			super.paintComponent(g);

			drawBorder (g);
			drawBlock (g);
						
			// ���Ȯ��
//        	 if (isTop()) {
//      	 		System.out.println ("���� ����");
//      	 		gameOver = true;
//        	 }
//        	 else
//        		 drawBlock (g);
//        	 
//             drawFixedBlocks (g);	// �ٴ� ���� ��� �׸���
//           		
//             if (isBottom()) {	// �ٴ� ���� Ȯ��
//           	 	updateBottom();		// �ٴ� ��� ������ǥ ����, ����ʱ�ȭ
//               	drawFixedBlocks(g);
//     			removeBlock(g);		// ä���� �� ����
//     			drawBlock(g);
//             }
		}
		
	   public void drawBorder(Graphics g) {
		   g.setColor(Color.black);
		   g.fillRect(30, 70, 230, 10);
		   g.fillRect(30, 460, 230, 10);
		   g.fillRect(30, 70, 10, 400);
		   g.fillRect(260, 70, 10, 400);
	   }
		
	   void drawBlock (Graphics g) {
			g.setColor(Color.BLUE);
			int i=0;
			for (int r=0; r<4; r++) {
				for (int c=0; c<4; c++)		
					if (block[rotation][r][c] == 1) {
						g.fillRect(pX + c*rsize, pY + r*rsize, rsize, rsize);
						curX[i] = gbX + c; curY[i] = gbY + r;
						i++;
					}
			}	
		}
		
	   	// �ٴں�� ó��: ����� ���� ��ǥ 1, ���� ��� �ʱ�ȭ
		public void updateBottom () {
			// ����� ������ǥ�� 1��
			
            // �� ��� �ʱ�ȭ

		}
		
	    public void drawFixedBlocks (Graphics g) {	// �ٴ�(����) ��� �׸���

	    }      
		
	    // ä���� �� ����, �� ���� �Ʒ��� ����
	    public void removeBlock (Graphics g){

	    }
		
		public boolean isLeft ( ) {	// ���� ���
			for (int i=0; i<curX.length; i++)
				if (gameboard[curY[i]][curX[i] - 1] == 1)
					return true;
			return false;
		}
		
		public boolean isRight ( ) {	// ������ ���
			for (int i=0; i<curX.length; i++)
				if (gameboard[curY[i]][curX[i] + 1] == 1)
					return true;
			return false;
		}	
		
	    public boolean isTop() {	// ������ 2�� Ȯ��
	    	
			return false;
	    }	    
   
	    // �������� ����� �ٴڿ� ����: true;
	    public boolean isBottom() {

		    return false;
	    }	
	}	// MyPanel

} 
