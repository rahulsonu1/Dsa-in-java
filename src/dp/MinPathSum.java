package dp;

import java.util.Arrays;

public class MinPathSum {

	public static void main(String[] args) {
		 int arr[][] = {{1,3,1},{1,5,1},{4,2,1}};
		 System.out.println(minPath(arr));
		 
	}
	public static int minPath(int arr[][]) {
		int m=arr.length;
		int n=arr[0].length;
		int dp[][]=new int[m][n];
		for(int i[]:dp) {
			Arrays.fill(i, Integer.MAX_VALUE);
		}
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(i==0 && j==0) dp[i][j]=arr[i][j];
				else {
					int top=Integer.MAX_VALUE,left=Integer.MAX_VALUE;
					if(i>0) {
						top=dp[i-1][j];
					}
					if(j>0) {
						left=dp[i][j-1];
					}
					dp[i][j]=arr[i][j]+Math.min(top, left);
				}
			}
		}
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				System.out.print(dp[i][j]+" ");
			}
			System.out.println();
		}
		return dp[m-1][n-1];
	}

}
