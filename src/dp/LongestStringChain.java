package dp;

public class LongestStringChain {

	public static void main(String[] args) {
		String words[]={"a","b","ba","bca","bda","bdca"};
		
		System.out.println(longestchain(words));
	}
	public static int longestchain(String [] words) {
		int n=words.length;
		
		int dp[]=new int[n];
		int max=1;
		for(int i=0;i<n;i++) {
			dp[i]=1;
			for(int j=0;j<i;j++) {
				if(compare(words[i],words[j]) && dp[i]<dp[j]+1) {
					dp[i]=dp[j]+1;
				}
			}
			max=Math.max(max, dp[i]);
		}
		return max;
	}
	
	public static boolean compare(String a,String b) {
		if(a.length()-b.length()!=1) return false;
		int i=0;
		int j=0;
		while(i<a.length() && j<b.length()) {
			if(a.charAt(i)==b.charAt(j)) {
				i++;
				j++;
			}else {
				i++;
			}
		}
		return j==b.length();
	}

}
