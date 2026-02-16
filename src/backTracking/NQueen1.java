package backTracking;

import java.util.ArrayList;
import java.util.List;

public class NQueen1 {
	static int count=0;

	public static void main(String[] args) {
		int n=4;
		int board[][]=new int[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				board[i][j]=0;
			}
		}
		List<List<String>>ans=new ArrayList<>();
		solve(board,0,n,ans);
//		System.out.println(ans);
		System.out.println(count);

	}
	public static void solve(int[][]board,int row,int n,List<List<String>>ans) {
		if(row==n) {
			count++;
//			ans.add(printBoard(board, n));
		}
		for(int i=0;i<n;i++) {
			if(isSafe(board, row, i, n)) {
				board[row][i]=1;
				solve(board,row+1,n,ans);
				board[row][i]=0;
			}
		}
	}
	public static boolean isSafe(int board[][],int row ,int col,int n) {
		// diagonal right downward
		for(int i=row+1,j=col+1;i<n && j<n;i++,j++) {
			if(board[i][j]==1) return false;
		}
		// diagonal left downward
		for(int i=row+1,j=col-1;i<n && j>=0;i++,j--) {
			if(board[i][j]==1) return false;
		}
		// diagonal right upward
		for(int i=row-1,j=col+1;i>=0 && j<n;i--,j++) {
			if(board[i][j]==1) return false;
		}
		//diagonal left upward
		for(int i=row-1,j=col-1;i>=0 && j>=0 ;i--,j--) {
			if(board[i][j]==1) return false;
		}
		for(int i=row-1;i>=0;i--) {
			if(board[i][col]==1) return false;
		}
		// downward row
		for(int i=row+1;i<n;i++) {
			if(board[i][col]==1) return false;
		}
		return true;
	}
	public static List<String >printBoard(int arr[][],int n) {
		List<String>list=new ArrayList<>();
		for(int i=0;i<n;i++) {
			StringBuilder sb=new StringBuilder();
			for(int j=0;j<n;j++) {
				if(arr[i][j]==1) {
					sb.append("Q");
				}else sb.append(".");
			}
			list.add(sb.toString());
		}
		return list;
		

	}

}
