package backTracking;

public class RatInMaze {

	public static void main(String[] args) {
		int arr[][]= {{1,1,1},{1,1,1,},{1,1,1}};
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("_________________________");
		maze(arr);

		
	}
	public static void maze(int arr[][]) {
		int n=arr.length;
		int path[][]=new int[n][n];
//		boolean res=solveMaze(arr,0,0,path);
		solveAllPath(arr, 0, 0, path);
//		return res;
	}
	public static void solveAllPath(int arr[][],int i,int j,int path[][]) {
		int n=arr.length;
		if(i<0 || i>=n ||j<0||j>=n|| arr[i][j]==0|| path[i][j]==1) {
			return ;
		}
		path[i][j]=1;
		if(i==n-1 && j==n-1) {
			for(int r=0;r<n;r++) {
				for(int c=0;c<n;c++) {
				System.out.print(path[r][c]+" ");
			}
		System.out.println();
		}
			path[i][j]=0;
			System.out.println("---------------");
			return ;
		}
		solveAllPath(arr, i-1, j, path);
		solveAllPath(arr, i, j+1, path);
		solveAllPath(arr, i+1, j, path);
		solveAllPath(arr, i, j-1, path);
		path[i][j]=0;
		
	}
	
//	public static boolean solveMaze(int arr[][],int i,int j,int path[][]) {
//		int n=arr.length;
//		//check valid
//		if(i<0 || i>=n || j<0|| j>=n || arr[i][j]==0||path[i][j]==1) {
//			return false;
//		}
//		path[i][j]=1;
//		//destination reached
//		if(i==n-1 && j==n-1) { 
//			for(int r=0;r<n;r++) {
//				for(int c=0;c<n;c++) {
//					System.out.print(path[r][c]+" ");
//				}
//				System.out.println();
//			}
//			return true;
//		}
//		//top
//		if(solveMaze(arr, i+1, j, path)) {
//			return true;
//		}
//		//right
//		if(solveMaze(arr, i, j+1, path)) {
//			return true;
//		}
//		if(solveMaze(arr, i-1, j, path)) {
//			return true;
//		}
//		if(solveMaze(arr, i, j-1, path)) {
//			return true;
//		}
//		return false;
//	}

}
