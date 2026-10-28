package dp;

import java.util.Arrays;

public class CoinChange {

	public static void main(String[] args) {
		int arr[]= {1,2,5,6,9};
		int target=11;
		System.out.println(minCoin(arr, 0, target));
		
		int dp[][]=new int[arr.length][target+1];
		for(int i[] : dp) {
			Arrays.fill(i,-1);
		}
		System.out.println(minCoinMemo(arr,0,target,dp));
		System.out.println(MinCoinI(arr, target));
	}
	public static int minCoin(int arr[],int i,int target) {
		if(target==0) return 0;
		if(i==arr.length) return 100000000;
		
		if(arr[i]>target) {
			return minCoin(arr,i+1,target);
		}
		int include=1+minCoin(arr,i,target-arr[i]);
		int exclude=minCoin(arr,i+1,target);
		return Math.min(include, exclude);
		
	}
	
	public static int minCoinMemo(int arr[],int i,int target,int dp[][]) {
		if(target==0) return 0;
		if(i==arr.length) return 1000000000;
		
		if(dp[i][target]!=-1) return dp[i][target];
		
		if(arr[i]>target) {
			return minCoinMemo(arr,i+1,target,dp);
		}
		int include=1+minCoinMemo(arr,i,target-arr[i],dp);
		int exclude=minCoinMemo(arr,i+1,target,dp);
		dp[i][target]=Math.min(include, exclude);
		return dp[i][target];
	}
	
	public static int MinCoinI(int arr[],int target) {
		int n=arr.length;
		int dp[][]=new int[n][target+1];
		
		for(int i=0;i<n;i++) {
			dp[i][0]=0;
		}
		for(int j=1;j<=target;j++) {
			if(j%arr[0]==0) {
				dp[0][j]=j/arr[0];
			}else {
				dp[0][j]=Integer.MAX_VALUE;
			}
		}
		for(int i=1;i<n;i++) {
			for(int j=1;j<=target;j++) {
				if(arr[i]<=j) {
					int include=1+dp[i][j-arr[i]];
					int exclude=dp[i-1][j];
					dp[i][j]=Math.min(include, exclude);
				}else {
					dp[i][j]=dp[i-1][j];
				}
			}
		}
		return dp[n-1][target];
		
	}

}
