package recursion;

public class ReverseNum {
	
	public static void main(String[] args) {
		int n=1234;
		System.out.println(rev(n,0));

	}
	public static int rev(int n,int ans) {
		if(n==0) return ans;
		int d=n%10;
		ans=ans*10+d;
		return rev(n/10,ans);
	
		
	}

}
