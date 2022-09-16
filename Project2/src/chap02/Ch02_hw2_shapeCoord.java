package chap02;

import java.util.Scanner;

public class Ch02_hw2_shapeCoord {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean inSquare = false, inCircle = false;
		int squareX1 = 0, squareX2 = 100, squareY1 = 0, squareY2 = 100;
		int cirX = 100, cirY = 50, cirRad = 50;
		
		for(int i = 0; i < 4; i++) {
			System.out.print("��ǥ �Է�: ");
			int inputX = sc.nextInt();
			int inputY = sc.nextInt();	
			
			if (inputX >= squareX1 && inputX <= squareX2 && inputY >= squareY1 && inputY <= squareY2)
				inSquare = true;
			else
				inSquare = false;
			
			if ((inputX - cirX) * (inputX - cirX) + (inputY - cirY) * (inputY - cirY) <= (cirRad * cirRad))
				inCircle = true;
			else
				inCircle = false;
			
			if (inSquare) {
				if (inCircle)
					System.out.println("�� ���� ����");
				else
					System.out.println("�簢�� ����");
			}
			else {
				if (inCircle)
					System.out.println("�� ����");
				else
					System.out.println("�� ���� �ܺ�");
			}
		}
		
		sc.close();
	}

}
