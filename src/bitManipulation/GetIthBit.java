package bitManipulation;

public class GetIthBit {

	public static void main(String[] args) {
		int n=13;
		int i=2;
//		System.out.println(1<<(i-1));
		System.out.println(n&(1<<(i-1)));
	}

}
