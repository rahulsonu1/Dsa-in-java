package graph;

public class Floodfill {

	public static void main(String[] args) {
		int arr[][]= {{1, 1, 1, 0}, {0, 1, 1, 1}, {1, 0, 1, 1}};
		int i=1,j=2;
		int newColor=2;
		int color=arr[i][j];
		int n=arr.length;
		int m=arr[0].length;
		
		dfs(arr,i,j,newColor,color,n,m);
		
		for(int t=0;t<n;t++) {
			for(int u=0;u<m;u++ ) {
				System.out.print(arr[t][u]+" ");
			}
			System.out.println();
		}
	}
	public static void dfs(int arr[][],int i,int j, int newColor,int color,int n,int m) {
		if(i<0||i>=n||j<0||j>=m|| arr[i][j]==newColor||arr[i][j]==0) return ;
		arr[i][j]=newColor;
		
		//top 
		dfs(arr,i-1,j,newColor,color,n,m);
		
		dfs(arr,i,j+1,newColor,color,n,m);
		
		dfs(arr,i+1,j,newColor,color,n,m);
		
		dfs(arr,i,j-1,newColor,color,n,m);
		
	}

}
