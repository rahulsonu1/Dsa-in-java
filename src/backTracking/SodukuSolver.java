package backTracking;

public class SodukuSolver {

	public static void main(String[] args) {
		String [][]board = {{"5","3",".",".","7",".",".",".","."},
		         {"6",".",".","1","9","5",".",".","."},
		         {".","9","8",".",".",".",".","6","."},
		         {"8",".",".",".","6",".",".",".","3"},
		         {"4",".",".","8",".","3",".",".","1"},
		         {"7",".",".",".","2",".",".",".","6"},
		         {".","6",".",".",".",".","2","8","."},
		         {".",".",".","4","1","9",".",".","5"},
		         {".",".",".",".","8",".",".","7","9"}};
		int n=9;
		 solve(board,0,0,9);
		 for(int i=0;i<n;i++) {
			 for(int j=0;j<n;j++) {
				 System.out.print(board[i][j]+" ");
			 }
			 System.out.println();
		 }

	}
	
	public static boolean solve(String board[][],int row,int col,int n) {
		if(row==n) {
			return true;
		}
		if(col==n) {
			return solve(board, row+1, 0, n);
			
		}
		if(!board[row][col].equals(".")) {
			return solve(board,row,col+1,n);
		}
		for(int i=1;i<=9;i++) {
			String val=String.valueOf(i);
			if(isSafe(board, row, col, val, n)) {
				board[row][col]=val;
				if(solve(board, row, col+1, n)) return true;
				board[row][col]=".";
			}
		}
		
		return false;
	}
	public static boolean isSafe(String[][]board,int row,int col,String val,int n) {
		// check cols value repetition
		for(int i=0;i<n;i++) {
			if(board[row][i].equals(val)) return false;
		}
		//check rows value repetition
		for(int i=0;i<n;i++) {
			if(board[i][col].equals(val)) return false;
		}
		int sqrt=(int)Math.sqrt(n);
		int rowStart=row-row%sqrt;
		int colStart=col-col%sqrt;
		
		for(int r=rowStart;r<rowStart+sqrt;r++) {
			for(int c=colStart;c<colStart+sqrt;c++) {
				if(board[r][c].equals(val)) return false;
			}
			
		}
		return true;
	}

}
