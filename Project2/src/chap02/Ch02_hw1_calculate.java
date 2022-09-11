package chap02;

import java.util.Scanner;

public class Ch02_hw1_calculate {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		double result = 0;
		
		System.out.print("수식 입력: ");
		int num1 = sc.nextInt();
		String opr = sc.next();
		int num2 = sc.nextInt();
		
		switch(opr) {
		case("+"):
			result = num1 + num2;
			System.out.println("결과: " + num1 + opr + num2 + '=' + result);
			break;
		case("-"):
			result = num1 - num2;
			System.out.println("결과: " + num1 + opr + num2 + '=' + result);
			break;
		case("*"):
			result = num1 * num2;
			System.out.println("결과: " + num1 + opr + num2 + '=' + result);
			break;
		case("/"):
			result = (double)num1 / num2;
			System.out.println("결과: " + num1 + opr + num2 + '=' + result);
			break;
		default:
			System.out.println("연산자 오류");
		}
		
		sc.close();

	}

}
