package dp;

import java.util.Arrays;

public class Knapsack {

	public static void main(String[] args) {
		int weight[]={10,20,30};
		int profit[]= { 60, 100, 120 };
		int W=50;
//		System.out.println(knapsack(W, weight, profit, 0));
//		System.out.println(knapSackI(W, weight, profit));
		int dp[][]=new int[weight.length+1][W+1];
		for(int row[]:dp) {
			Arrays.fill(row,-1);
		}
		System.out.println(memorization(W, weight, profit, 0, dp));

	}
	public static int knapSackI(int w,int weight[],int profit[]) {
		int n=weight.length;
		int arr[][]=new int[n+1][w+1];
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=w;j++) {
				if(j==0||i==0) {
					arr[i][j]=0;
					continue;
				}
				int ans;
				if(weight[i]<=j) {
					int include=profit[i]+arr[i-1][j-weight[i]];
					int exlude=arr[i-1][j];
					ans=Math.max(include, exlude);
				}
				else {
					ans=arr[i-1][j];
				}
				arr[i][j]=ans;
		}
		
	}
		return arr[n][w];
	}
	
	public static int memorization(int w,int weight[],int profit[],int i,int[][]dp) {
		if(i==weight.length) {
			return 0;
		}
		if(dp[i][w]!=-1) return dp[i][w];
		if(weight[i]<=w) {
			int include=profit[i]+memorization(w-weight[i], weight, profit, i+1, dp);
			int exlude=memorization(w, weight, profit,i+1, dp);
			dp[i][w]=Math.max(include, exlude);
		}else {
			dp[i][w]=memorization(w, weight, profit, i+1, dp);
		}
		return dp[i][w];
	}
	
	public static int knapsack(int w,int weight[],int profit[],int i) {
		if(i>=weight.length) {
			return 0;
		}
		if(w<weight[i]) {
			return knapsack(w, weight, profit, i+1);
		}
		int include=profit[i]+knapsack(w-weight[i], weight, profit, i+1);
		int exclude=knapsack(w, weight, profit, i+1);
		return Math.max(include, exclude);
	}

}
