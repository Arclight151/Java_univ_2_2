package chap03;

import java.util.Random;

public class Ch03_2_random {

	public static void main(String[] args) {
		Random rand = new Random();
		
		int r1;
		
		System.out.println("Random: 1~6");
		for (int i = 0; i < 10 ; i++) {
			r1 = rand.nextInt(6) + 1;
			System.out.println(r1);
		}
		
		System.out.println("Random: 10~99");
		for (int i = 0; i < 10 ; i++) {
			r1 = rand.nextInt(90) + 10;
			System.out.println(r1);
		}

	}

}
