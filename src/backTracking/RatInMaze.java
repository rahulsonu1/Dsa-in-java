package backTracking;

public class RatInMaze {

	public static void main(String[] args) {
		int arr[][]= {{1,1,0},{1,1,1,},{0,1,1}};
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("_________________________");
		System.out.println(solve(arr));

		
	}
	public static boolean solve(int arr[][]) {
		int n=arr.length;
		int path[][]=new int[n][n];
		return solveM(arr,0,0,path);
	}
	public static void solveM(int arr[][],int i,int j,int path[][]) {
		int n=arr.length;
		if(i<0 || i>=n || j<0 || j>=n|| arr[i][j]==0 || path[i][j]==1) {
			return ;
		}
		path[i][j]=1;
		if(i==n-1 && j==n-1) {
			for(int a=0;a<n;a++) {
				for(int b=0;b<n;b++) {
					System.out.print(path[a][b]+" ");
				}
				System.out.println();
				
			}
		}
		solveM(arr,i-1,j,path);
		solveM(arr,i,j+1,path);
		solveM(arr,i+1,j,path);
		solveM(arr,i,j-1,path);
	}
}
