package chap06;

public class Ch06_1_Split {

	public static void main(String[] args) {
		String str = "25+30-20";
		String[] sp = str.split("\\+");
		for (int i = 0; i < sp.length; i++) {
			System.out.println(sp[i]);
		}

	}

}
