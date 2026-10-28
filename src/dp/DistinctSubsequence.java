package dp;

import java.util.Arrays;

public class DistinctSubsequence {

	public static void main(String[] args) {
		String a="babgbag";
		String b="bag";
		
		int m=a.length();
		int n=b.length();
		int dp[][]=new int[m][n];
		for(int i[] : dp) {
			Arrays.fill(i, -1);
		}
		
		System.out.println(countMatch(a, b, 0, 0,dp));

	}
	public static int countMatch(String a,String b,int i,int j,int dp[][]) {
		if(j==b.length()) return 1;
		if(a.length()==i) {
			return b.length()==j?1:0;
		}
		if(dp[i][j]!=-1) return dp[i][j];
		
		int exclude=countMatch(a, b, i+1, j,dp);
		int include=0;
		if(a.charAt(i)==b.charAt(j)) {
			include=countMatch(a, b, i+1, j+1,dp);
		}
		return dp[i][j]= exclude+include;
		
		
	}

}
