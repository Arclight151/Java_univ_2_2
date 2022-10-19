package chap08;

import java.io.*;
import java.util.Scanner;
import java.util.Vector;

public class Chap08_2_FileIOLine {

	public static void main(String[] args) {
		FileReader reader;
		Scanner sc;
		Vector<String> wordVector = new Vector<>();
		String filePath = "src\\chap08\\test1.txt";
		
		try {
			reader = new FileReader(filePath);
			sc = new Scanner(reader);
			while (sc.hasNext()) {
//				System.out.println(sc.nextLine());
				String word = sc.nextLine();
				wordVector.add(word);
			}
			
			reader.close();
		}
		catch (FileNotFoundException e) {
			System.out.println("File not found");
		}
		catch (IOException e) {
			System.out.println("IOException");
		}
		
		for (int i = 0; i < wordVector.size(); i++) {
			System.out.println(wordVector.get(i));
		}

	}

}
