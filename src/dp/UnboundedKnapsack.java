package dp;

import java.util.Arrays;

public class UnboundedKnapsack {

	public static void main(String[] args) {
		int val[]= {10, 40, 50, 70};
		int wt[]= {1,3,4,5};
		int capacity=8;
		int dp[][]=new int[val.length][capacity+1];
		for(int i[] : dp) {
			Arrays.fill(i, -1);
		}
		System.out.println(maxProfit(val, wt, 0, capacity, dp));
	}
	
	public static int maxProfit(int val[],int wt[],int i,int capacity,int dp[][]) {
		if(i==val.length) return 0;
		if(capacity==0) return 0;
		if(dp[i][capacity]!=-1) return dp[i][capacity];
		if(wt[i]>capacity) {
			return maxProfit(val,wt,i+1,capacity,dp);
		}
		int exclude=maxProfit(val, wt, i+1, capacity, dp);
		int include=val[i]+maxProfit(val, wt, i, capacity-wt[i], dp);
		
		dp[i][capacity]=Math.max(exclude, include);
		return dp[i][capacity];
		
	}

}
