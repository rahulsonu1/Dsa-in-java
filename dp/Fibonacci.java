package dp;

public class Fibonacci {

	public static void main(String[] args) {
		int n=10;
		int arr[]=new int[n+1];
		System.out.println(fib(n,arr));
	}
	public static int fib(int n,int arr[]) {
		if(n==0 || n==1) {
			return n;
		}
		int ans1,ans2;
		if(arr[n-1]<1) {
			ans1=fib(n-1,arr);
			arr[n-1]=ans1;
		}
		else {
			ans1=arr[n-1];
		}
		if(arr[n-2]<1) {
			ans2=fib(n-2,arr);
		}
		else {
			ans2=arr[n-2];
		}
		return ans1+ans2;
		
	}
}
