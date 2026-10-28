package dp;

import java.util.Arrays;

public class NinjaTraining {

	public static void main(String[] args) {
		int mat[][]= {{1 ,2, 5},
				{3 ,1 ,1},
				{3 ,3, 3}};
		int n=mat.length;
		int dp[][]=new int[n][4];
		for(int i=0;i<n;i++) {
			Arrays.fill(dp[i],-1);
		}
		
		System.out.println(maxMerit(mat, 0, -1));
		System.out.println(maxMeritMemo(mat, 0, 3, dp));
	}
	public static int maxMerit(int arr[][], int start,int exclude) {
		if(start==arr.length) return 0;
		int ans=Integer.MIN_VALUE;
		for(int i=0;i<3;i++) {
			if(exclude==i) continue;
			int first=arr[start][i]+maxMerit(arr,start+1,i);
			ans=Math.max(ans, first);
		}
		return ans;
	}
	
	public static int maxMeritMemo(int arr[][],int start,int exclude,int dp[][]) {
		if(start==arr.length) return 0;
		if (dp[start][exclude] != -1) return dp[start][exclude];
		int ans=Integer.MIN_VALUE;
		for(int i=0;i<3;i++) {
			if(exclude==i) continue;
			int first=arr[start][i]+maxMeritMemo(arr,start+1,i,dp);
			ans=Math.max(ans, first);
			
		}
		return dp[start][exclude]=ans;
		
		
	}
	
	

}
