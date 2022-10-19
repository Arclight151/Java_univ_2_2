package chap08;

import java.io.*;
import java.util.Scanner;
import java.util.Vector;

public class Chap08_3_FileIOWrite {

	public static void main(String[] args) {
		FileReader fileIn;
		FileWriter fileOut;
		Scanner sc;
		Vector<String> wordVector = new Vector<>();
		String filePath = "src\\chap08\\test1.txt";
		String outputPath = "src\\chap08\\output1.txt";
		
		try {
			fileIn = new FileReader(filePath);
			fileOut = new FileWriter(outputPath);
			sc = new Scanner(fileIn);
			while (sc.hasNext()) {
				String word = sc.nextLine();
				wordVector.add(word);
			}
			
			for (int i = 0; i < wordVector.size(); i++) {
				System.out.println(wordVector.get(i));
				fileOut.write(wordVector.get(i) + "\r\n");
			}
			
			fileIn.close();
			fileOut.close();
		}
		catch (FileNotFoundException e) {
			System.out.println("File not found");
		}
		catch (IOException e) {
			System.out.println("IOException");
		}

	}

}