package bitManipulation;

public class EvenOdd {

	public static void main(String[] args) {
		int n=40;
		System.out.println(isEven(n));

	}
	public static boolean isEven(int n) {
		return (n&0)==0;
	}

}
