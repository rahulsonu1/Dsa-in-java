package backTracking;

import java.util.Arrays;

public class NKnight {
	static int count=0;

	public static void main(String[] args) {
		int n=10;
		int board[][]=new int[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				board[i][j]=0;
			}
		}
		solve(board,n,5,0,0);
		System.out.println(count);

	}
	public static void solve(int board[][], int n,int knight,int col,int row) {
		if(knight==0) {
//			printBoard(board);
			count++;
			return ;
		}
		
		if(row==n) {
			return ;
		}
		if(col==n) {
			solve(board,n,knight,0,row+1);
			return ;
		}
		if(isSafe(board, row, col, n)) {
			board[row][col]=1;
			solve(board,n,knight-1,col+1,row);
			board[row][col]=0;
		}
		solve(board,n,knight,col+1,row);
		
	}
	public static boolean isSafe(int board[][],int row,int col,int n) {
		if(row-2>=0 && col-1>=0  && board[row-2][col-1]==1) return false;
		if(row-2>=0 && col+1<n && board[row-2][col+1]==1) return false;
		if(row+2<n && col-1>=0 && board[row+2][col-1]==1) return false;
		if(row+2<n && col+1<n && board[row+2][col+1]==1) return false;
		
		if(row-1 >=0 && col-2>=0 && board[row-1][col-2]==1) return false;
		if(row-1>=0 && col+2<n && board[row-1][col+2]==1) return false;
		if(row+1<n && col-2>=0 && board[row+1][col-2]==1)return false;
		if(row+1<n && col+2<n && board[row+1][col+2]==1)return false;
		return true;
		
	}
	public static void printBoard(int arr[][]) {
		int n=arr.length;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("-----------------");
	}

}
