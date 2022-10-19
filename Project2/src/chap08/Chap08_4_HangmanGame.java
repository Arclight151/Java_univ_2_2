package chap08;

import java.io.*;
import java.util.Scanner;
import java.util.Vector;

public class Chap08_4_HangmanGame {

	public static void main(String[] args) {
		FileReader reader;
		Scanner sc;
		Vector<String> wordV = new Vector<>();
		String filePath = "src\\chap08\\test1.txt";
		
		try {
			reader = new FileReader(filePath);
			sc = new Scanner(reader);
			while (sc.hasNext()) {
				String word = sc.nextLine();
				wordV.add(word);
			}
			
			reader.close();
		}
		catch (FileNotFoundException e) {
			System.out.println("File not found");
		}
		catch (IOException e) {
			System.out.println("IOException");
		}
		
		int idx = (int)(Math.random() * wordV.size());
		String currentWord = wordV.get(idx);
		
		int hideChar = (int)(Math.random() * currentWord.length());
		
		for (int i = 0; i < wordV.size(); i++) {
			
		}

	}

} // TODO: Incomplete