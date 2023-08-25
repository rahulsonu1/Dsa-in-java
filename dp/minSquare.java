package dp;

public class minSquare {

	public static void main(String[] args) {
		int n=14;
		int arr[]=new int[n+1];
		System.out.println(minSqI(n));
		
	}
	public static int minSqI(int n) {
		if(n<=0) {
			return 0;
		}
		int arr[]=new int[n+1];
		arr[0]=0;
		for(int i=1;i<=n;i++) {
			int minAns=Integer.MAX_VALUE;
			for(int j=1;j*j<=i;j++) {
				int curr=arr[i-(j*j)];
				minAns=Math.min(minAns, curr);
			}
			arr[i]=1+minAns;
		}
		return arr[n];
	}
	public static int minSq(int n,int arr[]) {
		if(n==0) {
			return 0;
		}
		int min=Integer.MAX_VALUE;
		
		for(int i=1;i*i<=n;i++) {
			int ans;
			if(arr[n-i*i]==0) {
				ans=minSq(n-(i*i),arr);
				arr[n-i*i]=ans;
			}else {
				ans=arr[n-i*i];
			}
			
			if(ans<min) {
				min=ans;
			}
		}
		return 1+min;
	}

}
