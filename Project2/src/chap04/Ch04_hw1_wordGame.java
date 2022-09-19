package chap04;

class Player {
	private String name;
	private String word;
	
	public String getName() { return name; }
	public void setWord(String word) { this.word = word; }
	public char firstChar() { return word.charAt(0); }
	public char lastChar() { return word.charAt(word.length() - 1); }
}

class wordGame {
	private int turn;
}

public class Ch04_hw1_wordGame {

	public static void main(String[] args) {
		

	}

}
