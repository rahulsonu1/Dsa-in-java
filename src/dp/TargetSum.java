package dp;

import java.util.Arrays;

public class TargetSum {
	static int count=0;

	public static void main(String[] args) {
		int arr[]= {0 ,10, 0};
		int target=0;
		countTargetSum(arr, 0, target,0);
		System.out.println(count);
//		int sum=0;
//		for(int i:arr) {
//			sum=sum+i;
//		}
//		int range=2*sum+1;
//		Integer dp[][]=new Integer[arr.length+1][range];
//		System.out.println(memo(arr, 0, target, 0, sum, dp));
		
//		int dp[][]=new int[arr.length][target+1];
//		for(int i[] : dp) {
//			Arrays.fill(i, -1);
//		}
//		System.out.println(countMemo(arr, 0, target, dp));
		
		System.out.println(countI(arr, target));
		
	}
	
	public static int countI(int arr[],int target) {
		int n=arr.length;
		int dp[][]=new int[n][target+1];
		for(int i=0;i<n;i++) {
			dp[i][0]=1;
		}
		if(arr[0] <= target) {
	        dp[0][arr[0]] = 1;
	    }
		
		for(int i=1;i<n;i++) {
			for(int j=0;j<=target;j++) {
				int exclude=dp[i-1][j];
				int include=0;
				if(arr[i]<=j) {
					include=dp[i-1][j-arr[i]];
				}
				dp[i][j]=include+exclude;
			}
		}
		return dp[n-1][target];
	}
	
	public static int countMemo(int arr[],int i,int target, int dp[][]) {
		 if(i == arr.length) {
		        return target == 0 ? 1 : 0;
		    }

		if(dp[i][target]!=-1) return dp[i][target];
		
		int include=countMemo(arr,i+1,target,dp);
		int exclude=0;
		if(arr[i]<=target) {
			exclude=countMemo(arr,i+1,target-arr[i],dp);
		}
		dp[i][target]=include+exclude;
		return dp[i][target];
	}
	
	
	
	
	
	public static int memo(int arr[],int idx,int target,int sum,int offset, Integer dp[][]) {
		if(idx==arr.length) {
			return target==sum?1:0;
		}
		if(dp[idx][sum+offset]!=null) {
			return dp[idx][sum+offset];
		}
		int add=memo(arr, idx+1, target, sum+arr[idx], offset,dp);
		int minus=memo(arr,idx+1,target,sum-arr[idx],offset,dp);
		dp[idx][sum+offset]=add+minus;
		return dp[idx][sum+offset];
		
	}
	
	
	
	
	
	
	
	public static void countTargetSum(int arr[],int idx,int target,int sum) {
		if(idx==arr.length ) {
			if(target==sum) {
				count++;
			}
			return;
		}
		countTargetSum(arr, idx+1, target,sum+(~arr[idx]+1));
		countTargetSum(arr, idx+1, target,sum+arr[idx]);
	}

}
