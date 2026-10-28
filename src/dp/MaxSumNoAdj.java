package dp;

import java.util.Arrays;

public class MaxSumNoAdj {

	public static void main(String[] args) {
		int arr[]={3, 2, 5, 10, 7};
		System.out.println(maxR(arr, 0));
		int dp[]=new int[arr.length];
		Arrays.fill(dp, -1);
		System.out.println(maxMEMO(arr, 0, dp));
		System.out.println(maxI(arr));

	}
	public static int maxR(int arr[],int start) {
		if(start>=arr.length) return 0;
		int include=arr[start]+maxR(arr, start+2);
		int exclude=maxR(arr,start+1);
		return Math.max(include, exclude);
	}
	public static int maxMEMO(int arr[],int start,int dp[]) {
		if(start>=arr.length) return 0;
		if(dp[start]!=-1) return dp[start];
		int include=arr[start]+maxMEMO(arr,start+2,dp);
		int exclude=maxMEMO(arr,start+1,dp);
		dp[start]=Math.max(include, exclude);
		return dp[start];
	}
	public static int maxI(int arr[]) {
		int n=arr.length;
//		int dp[]=new int[n];
		int prev=0;
		int prev2=0;
		for(int i=0;i<n;i++) {

			int include=arr[i];
			int exclude=0;
			// include
			if(i>1) {
				include=include+prev2;
			}
			if(i>0) {
				exclude=prev;
			}
			int curr=Math.max(include, exclude);
			prev2=prev;
			prev=curr;
			
			
		}
		return prev;
	}

}
