package dp;

import java.util.Arrays;

public class CoinChange2 {

	public static void main(String[] args) {
		int arr[]= {1,2,5};
		int target=5;
		System.out.println(count(arr,0,target));
		
		int dp[][]=new int[arr.length][target+1];
		for(int i[] : dp) {
			Arrays.fill(i, -1);
		}
		System.out.println(countMemo(arr, 0, target, dp));
		System.out.println(countI(arr, target));
	}
	
	
	public static int countI(int arr[],int target) {
		int n=arr.length;
		int dp[][]=new int[n][target+1];
		for(int i=0;i<n;i++) {
			dp[i][0]=1;
		}
		for(int j = 0; j <= target; j++) {
		    if(j % arr[0] == 0) {
		        dp[0][j] = 1;
		    }
		}
		for(int i=1;i<n;i++) {
			for(int j=1;j<=target;j++) {
				if(arr[i]>j) {
					dp[i][j]=dp[i-1][j];
				}else {
					int exclude=dp[i-1][j];
					int include=dp[i][j-arr[i]];
					dp[i][j]=exclude+include;
				}
			}
		}
		
		return dp[n-1][target];
		
	}
	
	public static int countMemo(int arr[],int i,int target,int dp[][]) {
		if(i==arr.length) {
			return target==0?1:0;
		}
		if(dp[i][target]!=-1) return dp[i][target];
		
		if(arr[i]>target) {
			return countMemo(arr,i+1,target,dp);
		}
		int exclude=countMemo(arr,i+1,target,dp);
		int include=countMemo(arr,i,target-arr[i],dp);
		return dp[i][target]=exclude+include;
		
	}
	public static int count(int arr[],int i,int target) {
		if(i==arr.length) {
			return target==0?1:0;
		}
		if(arr[i]>target) {
			return count(arr,i+1,target);
		}
		int exclude=count(arr,i+1,target);
		int include=count(arr,i,target-arr[i]);
		return exclude+include;
	}

}
