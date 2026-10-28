package dp;

public class TriangleMinPath {

	public static void main(String[] args) {
		int arr[][]= {{2},{3,4},{6,5,7},{4,1,8,3}};
		System.out.println(minPath(arr, 0, 0));
		System.out.println(minPathI(arr));

	}
	
	public static int minPathI(int arr[][]) {
		int m=arr.length;
		int n=arr[m-1].length;
		int dp[][]=new int[m][n];
		for(int i=0;i<n;i++) {
			dp[n-1][i]=arr[n-1][i];
		}
		for(int i=n-2;i>=0;i--) {
			for(int j=arr[i].length-1;j>=0;j--) {
				int bottom=dp[i+1][j];
				int diagonal=dp[i+1][j+1];
				dp[i][j]=arr[i][j]+Math.min(diagonal, bottom);
			}
		}
		return dp[0][0];
	}
	
	
	
	public static int minPath(int arr[][],int i,int j) {
		if(i>=arr.length|| j>=arr[i].length) return 0;
		if(i==arr.length && j<arr[i].length) return arr[i][j];
		
		int down=minPath(arr,i+1,j);
		int diagonal=minPath(arr,i+1,j+1);
		return arr[i][j]+Math.min(down, diagonal);
		
	}

}
