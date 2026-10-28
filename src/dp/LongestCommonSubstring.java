package dp;

public class LongestCommonSubstring {

	public static void main(String[] args) {
		String a="ABCDGH";
		String b="ACDGHR";
		
		
		System.out.println(maxString(a, b));
	}
	public static int maxString(String a,String b) {
		int m=a.length();
		int n=b.length();
		
		int dp[][]=new int[m][n];
		int ans=0;
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(a.charAt(i)==b.charAt(j)) {
					if(i==0||j==0) {
						dp[i][j]=1;
					}else {
						int prev=dp[i-1][j-1];
						dp[i][j]=prev+1;
					}
					ans=Math.max(ans, dp[i][j]);
				}else {
					dp[i][j]=0;
				}
			}
		}
		return ans;
		
	}

}
