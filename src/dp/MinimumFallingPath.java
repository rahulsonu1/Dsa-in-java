package dp;

public class MinimumFallingPath {

	public static void main(String[] args) {
		int arr[][]= {{2,1,3},{6,5,4},{7,8,9}};
		int min=Integer.MAX_VALUE;
		for(int i=0;i<arr.length;i++) {
			min=Math.min(min,minFallPath(arr, 0, i));
		}
		System.out.println(min);
		System.out.println(minFallPathI(arr));

	}
	public static int minFallPathI(int arr[][]) {
		int m=arr.length;
		int n=arr[0].length;
		int dp[][]=new int[m][n];
		for(int j=0;j<m;j++) {
			dp[0][j]=arr[0][j];
		}
		for(int i=1;i<m;i++) {
			for(int j=0;j<n;j++) {
				int left=Integer.MAX_VALUE,right=Integer.MAX_VALUE;
				int top=dp[i-1][j];
				if(j>0) left=dp[i-1][j-1];
				if(j<n-1) right=dp[i-1][j+1];
				dp[i][j]=arr[i][j]+Math.min(right, Math.min(left, top));
			}
		}
		int ans=Integer.MAX_VALUE;
		for(int i=0;i<n;i++) {
			ans=Math.min(ans,dp[n-1][i]);
		}
		return ans;
	}
	
	
	
	public static int minFallPath(int arr[][],int i,int j) {
		if(i>=arr.length||j>=arr[i].length||j<0) return Integer.MAX_VALUE;
		if(i==arr.length-1) return arr[i][j];
		
		int left=minFallPath(arr,i+1,j-1);
		int bottom=minFallPath(arr,i+1,j);
		int right=minFallPath(arr,i+1,j+1);
		
		return arr[i][j]+Math.min(right,Math.min(left, bottom));
	}

}
