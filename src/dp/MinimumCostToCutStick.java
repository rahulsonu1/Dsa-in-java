package dp;
import java.util.*;
public class MinimumCostToCutStick {

	public static void main(String[] args) {
		int cuts[]= {1,3,4,5};
		int n=7;
		ArrayList<Integer>list=new ArrayList<>();
		list.add(0);
		for(int i:cuts) {
			list.add(i);
		}
		list.add(n);
		
		int dp[][]=new int[n][n];
		for(int i[] : dp) {
			Arrays.fill(i, Integer.MAX_VALUE);
		}
		
		System.out.println(minCost(list, 1, 4,dp));
		

	}
	public static int minCostI(int cuts[],int n) {
		Arrays.sort(cuts);
		ArrayList<Integer>list=new ArrayList<>();
		list.add(0);
		for(int i:cuts) {
			list.add(i);
		}
		list.add(n);
		int m=cuts.length;
		int dp[][]=new int[m+2][m+2];
		
		for(int len=1;len<=m;len++) {
			for(int start=1;start+len-1<=m;start++) {
				int end=start+len-1;
				int ans=Integer.MAX_VALUE;
				
				for(int i=start;i<=end;i++) {
	                int cost = list.get(end + 1) - list.get(start - 1);
	                int left = dp[start][i - 1];
	                int right = dp[i + 1][end];
	                int total = cost + left + right;
	                ans = Math.min(ans, total);
				}
				dp[start][end]=ans;
			}
		}
		return dp[1][m];
	}
	
	public static int minCost(ArrayList<Integer> list,int start,int end,int dp[][]) {
		if(start>end) return 0;
		if(dp[start][end]!=Integer.MAX_VALUE) return dp[start][end];
		int ans=Integer.MAX_VALUE;
		for(int i=start;i<=end;i++) {
			int cost=list.get(end+1)-list.get(start-1);
			int left=minCost(list,start,i-1,dp);
			int right=minCost(list,i+1,end,dp);
			int total=cost+left+right;
			ans=Math.min(ans, total);
			list.remove(i);
		}
		return dp[start][end]=ans;
	}

}
