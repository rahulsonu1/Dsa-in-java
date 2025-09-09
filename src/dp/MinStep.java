package dp;

public class MinStep {

	public static void main(String[] args) {
		int n=2000004;
		int arr[]=new int[n+1];
		System.out.println(minStepto1(n));
	}
	public static int minStepto1(int n) {
		if(n==1) {
			return 0;
		}
		int arr[]=new int[n+1];
		arr[1]=0;
		for(int i=2;i<=n;i++) {
			int one=arr[i-1];
			int two=Integer.MAX_VALUE;
			int three=Integer.MAX_VALUE;
			if(i%2==0) {
				two=arr[i/2];
			}
			if(i%3==0) {
				three=arr[i/3];
			}
			arr[i]=1+Math.min(one,Math.min(two, three));
		}
		return arr[n];
	}
	
	
	
	
	
	public static int minStepto1(int n,int arr[]) {
		if(n==1) {
			return 0;
		}
		int one=Integer.MAX_VALUE;
		int two=Integer.MAX_VALUE;
		int three=Integer.MAX_VALUE;
		if(arr[n-1]==0) {
			one=minStepto1(n-1, arr);
			arr[n-1]=one;
		}else {
			one=arr[n-1];
		}
		if(n%2==0) {
			if(arr[n/2]==0) {
				two=minStepto1(n/2, arr);
				arr[n/2]=two;
			}else {
				two=arr[n/2];
			}
		}
		if(n%3==0) {
			if(arr[n/3]==0) {
				three=minStepto1(n/3, arr);
				arr[n/3]=three;
			}else {
				three=arr[n/3];
			}
		}
		return 1+Math.min(one,Math.min(two, three));
	}

}
