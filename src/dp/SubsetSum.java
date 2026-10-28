package dp;

import java.util.Arrays;

public class SubsetSum {

	public static void main(String[] args) {
		int arr[]= {1,2,5};
		int target=4;
		int n=arr.length;
		Boolean dp[][]=new Boolean[n][target+1];
		System.out.println(memorization(arr,0, target, dp));
		System.out.println(targetSumI(arr, target));
		
		
		
	}
	
	public static boolean targetSumI(int arr[],int target) {
		int m=arr.length;
		
		boolean dp[][]=new boolean[m][target+1];
		for(int i=0;i<m;i++) {
			dp[i][0]=true;
		}
		if(arr[0] <= target) {
	        dp[0][arr[0]] = true;
	    }
		
		for(int i=1;i<m;i++) {
			for(int j=1;j<=target;j++) {
				
					boolean take=false;
					if(arr[i]<=j) {
						take= dp[i-1][j-arr[i]];
					}
					boolean notTake=dp[i-1][j];
					dp[i][j]=take||notTake;
					
			}
		}
		return dp[m-1][target];
	}
	
	
	
	
	public static boolean memorization(int arr[],int i,int sum,Boolean dp[][]) {
		if(sum==0) return true;
		if(i==arr.length) return false;
		if(dp[i][sum]!=null) return dp[i][sum];
		boolean notTake=memorization(arr, i+1, sum, dp);
		boolean take=false;
		if(arr[i]<=sum) {
			take=memorization(arr, i+1, sum-arr[i], dp);
		}
		dp[i][sum]=notTake||take;
		return dp[i][sum];
		
	}
	
	
	public static boolean isPresent(int arr[],int i,int sum) {
		if(i==arr.length) {
			return false;
		}
		if(sum==0) {
			return true;
		}
		Boolean include=isPresent(arr, i+1, sum-arr[i]);
		Boolean exclude=isPresent(arr, i+1, sum);
		if(include || exclude) {
			return true;
		}
		return false;
		
	}

}
