package chap02;

import java.util.Scanner;

public class Ch02_hw3_keyType {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		int key = 0;
		
		while(key != 'q') {
			System.out.print("키 입력(q = 종료): ");
			//String input = sc.next();
			//key = input.charAt(0);
			key = System.in.read();
			sc.nextLine();
			
			if (key >= 48 && key <= 57) {
				System.out.println("키 종류: 숫자 / 키 코드: " + (int)key);
			}
			else if (key >= 65 && key <= 90) {
				System.out.println("키 종류: 대문자 / 키 코드: " + (int)key);
			}
			else if (key >= 97 && key <= 122) {
				System.out.println("키 종류: 소문자 / 키 코드: " + (int)key);
			}
			else if (key == 32) {
				System.out.println("키 종류: Space / 키 코드: " + (int)key);
			}
			else if (key == 10 || key == 13) {
				System.out.println("키 종류: Enter / 키 코드: " + (int)key);
			}
			else {
				System.out.println("키 종류: 기타 / 키 코드: " + (int)key);
			}
		}
		System.out.println("종료");
		
		sc.close();

	}

}
