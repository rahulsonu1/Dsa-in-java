package graph;

public class NumberOfIslands {

	public static void main(String[] args) {
		char arr[][]= {
				{'1','1','0','0','0'},
				{'1','1','0','0','0'},
				{'0','0','1','0','0'},
				{'0','0','0','1','1'}};
		
	int n=arr.length;
	int count=0;
	boolean visited[][]=new boolean[n][n];
	
	for(int i=0;i<n;i++) {
		for(int j=0;j<n;j++) {
			if(arr[i][j]=='1' && !visited[i][j]) {
				dfs(arr,visited,i,j,n);
				count++;
			}
		}
	}
	System.out.println(count);
	
	}
	public static void dfs(char[][] arr,boolean visited[][],int i,int j,int n) {
		
		if(i<0||i>=n||j<0||j>=n||visited[i][j] || arr[i][j]=='0') return;
		
		visited[i][j]=true;
//		top
		dfs(arr,visited,i-1,j,n);
//		right
		dfs(arr,visited,i,j+1,n);
//		bottom
		dfs(arr,visited,i+1,j,n);
//		left
		dfs(arr,visited,i,j-1,n);
	}
}
