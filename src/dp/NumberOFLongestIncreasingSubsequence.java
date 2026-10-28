package dp;

import java.util.HashMap;

public class NumberOFLongestIncreasingSubsequence {

	public static void main(String[] args) {
		int arr[]= {2,2,2,2,2};
		
		System.out.println(lis(arr));
	}
	public static int lis(int arr[]) {
		int n=arr.length;
		int dp[]=new int[n];
		int count[]=new int[n];

		for(int i=0;i<n;i++) {
			dp[i]=1;
			for(int j=0;j<i;j++) {
				if(arr[j]<arr[i]) {
					if(dp[i]<dp[j]+1) {
					  dp[i]=dp[j]+1;
					  if(map.containsKey())
					}
					else if(dp[i]==dp[j]+1) {
						
					}
				}
			}
		}
	}
	

}
