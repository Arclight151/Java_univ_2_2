package chap04;

import java.util.Scanner;

class Calculator {
	public static int sum(int n1, int n2) { return n1 + n2; }
	public static int sub(int n1, int n2) { return n1 - n2; }
	public static int mul(int n1, int n2) { return n1 * n2; }
	public static double div(int n1, int n2) { return (n1 / (double)n2 ); }
}

public class Ch04_hw2_staticCalculator {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a, b, result;
		double result_d;
		char op;
		
		while(true) {
			System.out.print("Enter calculation: ");
			a = sc.nextInt();
			String opstr = sc.next();
			op = opstr.charAt(0);
			b = sc.nextInt();
			
			switch(op) {
			case '+':
				result = Calculator.sum(a, b);
				System.out.println(a + " " + op + " " + b + " = " + result);
				continue;
			case '-':
				result = Calculator.sub(a, b);
				System.out.println(a + " " + op + " " + b + " = " + result);
				continue;
			case '*':
				result = Calculator.mul(a, b);
				System.out.println(a + " " + op + " " + b + " = " + result);
				continue;
			case '/':
				if (b == 0) {
					System.out.println("Cannot divide by zero");
					continue;
				}
				result_d = Calculator.div(a, b);
				System.out.println(a + " " + op + " " + b + " = " + result_d);
				continue;
			default:
				System.out.println(op + " is not a valid operator");
				break;
			}
			break;
		}
		sc.close();

	}

}
