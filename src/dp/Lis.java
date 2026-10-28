package dp;

import java.util.Arrays;

public class Lis {

	public static void main(String[] args) {
		int arr[]= {1,3,5,7,3,6,4};
		System.out.println(lis(arr));
		int n=arr.length;
		int dp[][]=new int[n][n];
		for(int i[] : dp) {
			Arrays.fill(i,-1);
		}
		System.out.println(maxSize(arr, 0, -1,dp));
	}
	
	
	
	public static int maxSize(int arr[],int i,int prev,int [][]dp) {
		if(i==arr.length) return 0;
		
		if(dp[i][prev+1]!=-1) return dp[i][prev+1];
		int exclude=maxSize(arr, i+1, prev,dp);
		int include=0;
		
		if(prev==-1||arr[i]>arr[prev]) {
			include=1+maxSize(arr, i+1, i,dp);
		}
		return dp[i][prev+1]= Math.max(exclude, include);
	}
	
	
	
	
	
	
	
	
	
	
	
	public static int lis(int arr[]) {
		if(arr.length==0||arr.length==1) {
			return 1;
		}
		
		int output[]=new int[arr.length];
		output[0]=1;
		int max=1;
		for(int i=1;i<arr.length;i++) {
			output[i]=1;
			for(int j=i-1;j>=0;j--) {
				if(arr[j]>arr[i]) {
					continue;
				}
				int ans=output[j]+1;
				if(output[i]<ans) {
					output[i]=ans;
					max=Math.max(max, ans);
				}
			}
		}
		
		return max;
	}
}
