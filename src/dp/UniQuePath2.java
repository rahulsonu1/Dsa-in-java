package dp;

public class UniQuePath2 {

	public static void main(String[] args) {
		int path[][]= {{0,0,0},{0,1,0},{0,0,0}};
		int arr[][]=new int[path.length+1][path[0].length+1];
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[0].length;j++) {
				arr[i][j]=-1;
			}
		}
			
		System.out.println(uPath(path, 0, 0,arr));
		
		System.out.println(uniquePathTab(path));

	}
	
	public static int uniquePathTab(int arr[][]) {
		int m=arr.length;
		int n=arr[0].length;
		int dp[][]=new int[m][n];
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(arr[i][j]==1) dp[i][j]=0;
				else if(i==0 && j==0) dp[i][j]=1;
				else {
					int right=0,down=0;
					if(i>0)
						down=dp[i-1][j];
					if(j>0)
						right=dp[i][j-1];
					dp[i][j]=down+right;
				}
				
			}
		}
		return dp[m-1][n-1];
	}
	
	
	
	
	
	
	
	
	
	
	
	
	public static int uPath(int arr[][],int i,int j,int path[][]) {
		int m=arr.length;
		int n=arr[0].length;
		if(i==m || j==n|| arr[i][j]==1) {
			return 0;
		}
		if(i==m-1 && j==n-1) {
			return 1;
		}
		if(path[i][j]!=-1) {
			return path[i][j];
		}
		int right,down;
		if(path[i][j+1]==-1) {
		    right=uPath(arr, i, j+1,path);
		    path[i][j+1]=right;
		}else {
			right=path[i][j+1];
		}
		if(path[i+1][j]==-1) {
			down=uPath(arr, i+1, j,path);
			path[i+1][j]=down;
		}else {
			down=path[i+1][j];
		}
		return arr[i][j]=down+right;
		
	}

}
