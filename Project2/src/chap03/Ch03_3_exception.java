package chap03;

public class Ch03_3_exception {

	public static void main(String[] args) {
		int n1 = 100, n2 = 0;
		
		try {
			System.out.println(n1 / n2);
		}
		catch(ArithmeticException e) {
			System.out.println("Divided by zero");
		}
		finally {
			System.out.println("Finally");
		}

	}

}
