package chap04;

import java.util.Scanner;

class Player {
	private String name;
	private String word;
	
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public void setWord(String word) { this.word = word; }
	public char firstChar() { return word.charAt(0); }
	public char lastChar() { return word.charAt(word.length() - 1); }
}

public class Ch04_hw1_wordGame {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Player count: ");
		int pCount = sc.nextInt();
		Player [] pArray = new Player[pCount];
		for (int i = 0; i < pCount; i++) {
			pArray[i] = new Player();
		}
		
		for (int i = 0; i < pCount; i++) {
			System.out.print("Player name " + (i + 1) + ": ");
			String name = sc.next();
			pArray[i].setName(name);
		}
		
		System.out.println("Starting game...");
		
		int turn = 0;
		while(true) {
			System.out.print(pArray[turn].getName() + ": ");
			pArray[turn].setWord(sc.next());
			
			
			turn++;
			if (turn > pCount)
				turn = 0;
		}
		
		//sc.close();

	}

}
