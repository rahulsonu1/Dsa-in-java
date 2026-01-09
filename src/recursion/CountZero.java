package recursion;

public class CountZero {
	public static void main(String args[]) {
		int n=1040300;
		System.out.println(count(n));
	}
	public static int count(int n){
		if(n==0) return 0;
		int ans=0;
		int d=n%10;
		if(d==0) {
			ans=1;
		}
		return ans+count(n/10);
		
	}

}
