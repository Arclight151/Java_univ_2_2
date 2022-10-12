package chap07;

import java.util.ArrayList;
import java.util.Scanner;

public class Ch07_1_Collection_ArrayList {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<String> arl = new ArrayList<>();
		
		int listSize = 4;
		
		for (int i = 0; i < listSize; i++) {
			System.out.print("Enter name: ");
			String s = sc.next();
			arl.add(s);
		}
		
		for (int i = 0; i < arl.size(); i++) {
			System.out.println(arl.get(i));
		}
		
		int longestIndex = 0;
		for (int i = 0; i < arl.size(); i++) {
			if (arl.get(i).length() > arl.get(longestIndex).length())
				longestIndex = i;
		}
		System.out.println("Longest name: " + arl.get(longestIndex));
		
		
		sc.close();
	}

}
