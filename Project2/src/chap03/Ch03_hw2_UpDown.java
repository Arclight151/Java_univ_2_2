package chap03;

import java.util.Scanner;
import java.util.Random;

public class Ch03_hw2_UpDown {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random rand = new Random();
		
		int input = 100, r;
		
		while (true) {
			r = rand.nextInt(100);
			int attempt = 1;
			
			System.out.println("Guess the number(0~99), -1 = Quit");
			while (input != r) {
				System.out.print("Attempt " + attempt + ": ");
				input = sc.nextInt();
				if (input < 0) {
					System.out.println("Quit");
					break;
				}
				else if (input < r) {
					System.out.println("Up");
				}
				else if (input > r) {
					System.out.println("Down");
				}
				else
					break;
				attempt++;
			}
			if (input < 0)
				break;
			System.out.println("Correct");
		}
		
		sc.close();
	}

}
