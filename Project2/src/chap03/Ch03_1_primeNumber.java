package chap03;

import java.util.Scanner;

public class Ch03_1_primeNumber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		boolean isPrimeNumber = true;
		
		System.out.print("Enter number: ");
		int n = sc.nextInt();
		
		for (int i = 2; i <= n / 2 + 1; i++) {
			if (n % i == 0) {
				isPrimeNumber = false;
				break;
			}
		}
		
		if (isPrimeNumber)
			System.out.println(n + "is a Prime Number.");
		else
			System.out.println(n + "is not a Prime Number.");
		
		sc.close();

	}

}
