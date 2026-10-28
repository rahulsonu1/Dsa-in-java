package graph;

public class DistanceNearestCell1 {

	public static void main(String[] args) {
		int arr[][]= {{1, 0, 1}, 
		             {1, 1, 0}, 
		             {1, 0, 0}};
		int n=arr.length;
		int m=arr[0].length;
		int ans[][]=new int[n][m];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(arr[i][j]==0) arr[i][j]=Integer.MAX_VALUE;
			}
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				dfs(arr,ans,i,j,0,n,m);
			}
		}
		
	}
	public static void dfs(int arr[][],int ans[][],int i,int j,int distance,int n,int m) {
		if(i<0||i>=n||j<0||j>=n||arr[i][j]==0||distance>=ans[i][j]) return ;
		ans[i][j]=7;
		
		
		dfs(arr,ans,i-1,j,distance+1,n,m);
		dfs(arr,ans,i,j+1,distance+1,n,m);
		dfs(arr,ans,i+1,j,distance+1,n,m);
		dfs(arr,ans,i,j-1,distance+1,n,m);
		
		
	}
}

