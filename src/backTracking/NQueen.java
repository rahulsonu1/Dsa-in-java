package backTracking;

public class NQueen {

	public static void main(String[] args) {
		int n=5;
		int board[][]=new int[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
			
		}
		System.out.println("__________");
		printBoard(board,0,n);
	}
	public static void printBoard(int arr[][],int row,int n) {
		
		if(row==n) {
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					System.out.print(arr[i][j]+" ");
				}
				System.out.println();
			}
			System.out.println("_______________");
			
		}
			for(int j=0;j<n;j++) {
			
				if(isSafe(arr, row, j)) {
					arr[row][j]=1;
					printBoard(arr, row+1, n);
					arr[row][j]=0;
				}
			}
			
			}
	public static boolean isSafe(int arr[][],int row,int col) {
		int n=arr.length;
		// right downward diagonal
		for(int i=row, j=col;i<n &&j<n;i++,j++) { 
			if(arr[i][j]==1) {return false;}
		}
		//left upward diagonal
		for(int i=row-1,j=col-1;i>=0 && j>=0 ;i--,j--) {
			if(arr[i][j]==1) {return false;}
		}
		//right upward daigaol
		for(int i=row-1 ,j=col+1;i>=0 && j<n;i--,j++) {
			if(arr[i][j]==1) {return false;}
		}
		// left downward diagonal
		for(int i=row+1,j=col-1;i<n && j>=0;i++,j--) {
			if(arr[i][j]==1) {return false;}
		}
		// upward row 
		for(int i=row-1;i>=0;i--) {
			if(arr[i][col]==1) {return false;}
		}
		// downward row
		for(int i=row+1;i<n;i++) {
			if(arr[i][col]==1) {return false;}
		}
		return true;
		
		
	}
}
