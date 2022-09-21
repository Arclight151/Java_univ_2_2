package chap04;

class Calc {
	public static int max(int n1, int n2) { return (n1 > n2) ? n1 : n2; }
	public static int min(int n1, int n2) { return (n1 < n2) ? n1 : n2; }
	public static int sum(int n1, int n2) { return n1 + n2; }
	public static int sub(int n1, int n2) { return n1 - n2; }
	public static int mul(int n1, int n2) { return n1 * n2; }
	public static double div(int n1, int n2) { return ((double)n1 / n2 ); }
}

public class Ch04_2_static {

	public static void main(String[] args) {
		//Calc c = new Calc();
		System.out.println(Calc.max(5, 10));
		System.out.println(Calc.min(-7, -2));
	}

}
