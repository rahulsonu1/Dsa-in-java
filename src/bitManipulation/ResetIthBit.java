package bitManipulation;

public class ResetIthBit {

	public static void main(String[] args) {

		int n=5;
		int i=2;
		int ans=(n&(~(1<<(i-1)))); // for toggle just use XOR (^) instead of ~
		System.out.println(ans);
	}

}
