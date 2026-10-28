package dp;
import java.util.*;
public class MatrixChainMultiplication {

	public static void main(String[] args) {
		int arr[]= {1, 2, 3, 4, 3};
		int n=arr.length;
        int dp[][]=new int[n][n];
        for(int i[] : dp){
            Arrays.fill(i,Integer.MAX_VALUE);
        }
         System.out.println(minOp(arr,1,arr.length-1,dp));
         System.out.println(minOpI(arr));
	}
	
	public static int minOpI(int arr[]) {
		int n=arr.length;
		int dp[][]=new int[n][n];
		for(int i=0;i<n;i++) {
			dp[i][i]=0;
		}
		for(int len=2;len<=n-1;len++) {
			for(int i=1;i<=n-len;i++) {
				int j=i+len-1;
				int ans=Integer.MAX_VALUE;
				for(int k=i;k<j;k++) {
					int left=dp[i][k];
					int right=dp[k+1][j];
					int cost=arr[i-1]*arr[k]*arr[j];
					int total=left+right+cost;
					ans=Math.min(ans, total);
				}
				dp[i][j]=ans;
			}
		}
		return dp[1][n-1];
	}
	
	
	
	public static int minOp(int arr[],int i,int j,int [][]dp){
        if(i==j) return 0;
        
        if(dp[i][j]!=Integer.MAX_VALUE) return dp[i][j];
        int ans=Integer.MAX_VALUE;
        
        for(int k=i;k<j;k++){
            int left=minOp(arr,i,k,dp);
            int right=minOp(arr,k+1,j,dp);
            int cost=arr[i-1]*arr[k]*arr[j];
            int total=cost+left+right;
            ans=Math.min(ans,total);
        }
        return dp[i][j]=ans;
    }

}
