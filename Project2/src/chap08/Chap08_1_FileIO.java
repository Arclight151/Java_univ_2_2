package chap08;

import java.io.*;

public class Chap08_1_FileIO {

	public static void main(String[] args) {
		FileReader reader;
		String filePath = "src\\chap08\\test1.txt";
		
		try {
			reader = new FileReader(filePath);
			int c;
			while ((c = reader.read()) != -1) {
				System.out.print((char) c);
			}
			
			reader.close();
		}
		catch (FileNotFoundException e) {
			System.out.println("File not found");
		}
		catch (IOException e) {
			System.out.println("IOException");
		}

	}

}
