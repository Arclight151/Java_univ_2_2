package chap02;

import java.util.Scanner;

public class Ch02_hw3_keyType {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		int key = 0;
		
		while(key != 'q') {
			System.out.print("Ű �Է�(q = ����): ");
			//String input = sc.next();
			//key = input.charAt(0);
			key = System.in.read();
			sc.nextLine();
			
			if (key >= 48 && key <= 57) {
				System.out.println("Ű ����: ���� / Ű �ڵ�: " + (int)key);
			}
			else if (key >= 65 && key <= 90) {
				System.out.println("Ű ����: �빮�� / Ű �ڵ�: " + (int)key);
			}
			else if (key >= 97 && key <= 122) {
				System.out.println("Ű ����: �ҹ��� / Ű �ڵ�: " + (int)key);
			}
			else if (key == 32) {
				System.out.println("Ű ����: Space / Ű �ڵ�: " + (int)key);
			}
			else if (key == 10 || key == 13) {
				System.out.println("Ű ����: Enter / Ű �ڵ�: " + (int)key);
			}
			else {
				System.out.println("Ű ����: ��Ÿ / Ű �ڵ�: " + (int)key);
			}
		}
		System.out.println("����");
		
		sc.close();

	}

}
