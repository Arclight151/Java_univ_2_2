package chap06;

import java.util.StringTokenizer;

public class Ch06_2_StringTokenizer {

	public static void main(String[] args) {
		String str = "25+30-20";
		StringTokenizer st = new StringTokenizer(str, "+-*/");
		int tok1, tok2;
		
		tok1 = Integer.parseInt(st.nextToken());
		System.out.println(tok1);
		tok2 = Integer.parseInt(st.nextToken());
		System.out.println(tok2);

	}

}
