package dp;

import java.util.Arrays;

public class RodCutting {

	public static void main(String[] args) {
		int arr[]= {3, 5, 8, 9, 10, 17, 17, 20};
		int n=arr.length;
		int dp[][]=new int[n][n+1];
		for(int i[] : dp) {
			Arrays.fill(i,-1);
		}
		
		System.out.println(maxProfit(arr,0,n,dp));
		System.out.println(maxProfitI(arr));

	}
	
	public static int maxProfitI(int arr[]) {
		int n=arr.length;
		int dp[][]=new int[n][n+1];
		for(int i=0;i<=n;i++) {
			if(arr[0]>i) {
				dp[0][i]=0;
			}else {
				dp[0][i]=i*arr[0];
			}
		}
		
		for(int i=1;i<n;i++) {
			for(int j=1;j<=n;j++) {
				int exclude=dp[i-1][j];
				int include=-10000000;
				if(i+1<=j) {
					include=arr[i]+dp[i][j-(i+1)];
				}
				dp[i][j]=Math.max(exclude, include);
			}
		}
		return dp[n-1][n];
		
	}
	
	
	public static int maxProfit(int arr[],int i,int n , int dp[][]) {
		if(n==0) return 0;
		if(i>=arr.length) return 0;
		if(dp[i][n]!=-1) return dp[i][n];
		int exclude=maxProfit(arr, i+1, n, dp);
		int include=-1000000;
		if(i+1<=n) {
			include=arr[i]+maxProfit(arr, i, n-(i+1), dp);
		}
		dp[i][n]=Math.max(exclude, include);
		return dp[i][n];
	}

}
