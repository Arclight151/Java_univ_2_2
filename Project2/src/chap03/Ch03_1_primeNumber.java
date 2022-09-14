package chap03;

import java.util.Scanner;

public class Ch03_1_primeNumber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		boolean isPrimeNumber = true;
		
		System.out.print("정수 입력: ");
		int n = sc.nextInt();
		
		for (int i = 2; i <= n / 2 + 1; i++) {
			if (n % i == 0) {
				isPrimeNumber = false;
				break;
			}
		}
		
		if (isPrimeNumber)
			System.out.println(n + "은(는) 소수입니다.");
		else
			System.out.println(n + "은(는) 소수가 아닙니다.");
		
		sc.close();

	}

}
