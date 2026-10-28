package hashMap;

import java.util.HashSet;

public class ValidSoduku {

	public static void main(String[] args) {
//		String board[][]= {
//				{"8","3",".",".","7",".",".",".","."},
//				{"6",".",".","1","9","5",".",".","."},
//				{".","9","8",".",".",".",".","6","."},
//			    {"8",".",".",".","6",".",".",".","3"},
//			    {"4",".",".","8",".","3",".",".","1"},
//				{"7",".",".",".","2",".",".",".","6"},
//			    {".","6",".",".",".",".","2","8","."},
//				{".",".",".","4","1","9",".",".","5"},
//				{".",".",".",".","8",".",".","7","9"}};
		
		char[][] board = {
		        {'8','3','.','.','7','.','.','.','.'},
		        {'6','.','.','1','9','5','.','.','.'},
		        {'.','9','8','.','.','.','.','6','.'},
		        {'8','.','.','.','6','.','.','.','3'},
		        {'4','.','.','8','.','3','.','.','1'},
		        {'7','.','.','.','2','.','.','.','6'},
		        {'.','6','.','.','.','.','2','8','.'},
		        {'.','.','.','4','1','9','.','.','5'},
		        {'.','.','.','.','8','.','.','7','9'}
		};

		
		int n=9;
		System.out.println(hashCheck(board, n));

	}
	public static boolean hashCheck(char board[][],int n) {
		HashSet<Character>[]rows=new HashSet[n];
		HashSet<Character>[]cols=new HashSet[n];
		HashSet<Character>[]boxes=new HashSet[n];
		for(int i=0;i<n;i++) {
			rows[i]=new HashSet<Character>();
			cols[i]=new HashSet<Character>();
			boxes[i]=new HashSet<Character>();
		}
		
		for(int row=0;row<n;row++) {
			for(int col=0;col<n;col++) {
				char ch=board[row][col];
				if(ch!='.') {
	                int boxIndex = (row / 3) * 3 + (col / 3);
	                if(rows[row].contains(ch)||cols[col].contains(ch)||boxes[boxIndex].contains(boxIndex)) {
	                	return false;
	                }
	                rows[row].add(ch);
	                cols[col].add(ch);
	                boxes[boxIndex].add(ch);
	                
	                

				}
			}
		}
		return true;
		
	}
	
	
	
	
	public static boolean check(String[][] board,int n) {
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(!isSafe(board, i, j, n)) {
					return false;
				}
			}
		}
		return true;
	}
	public static boolean isSafe(String board[][],int row ,int col,int n) {
		boolean colItems[]=new boolean[9];
		for(int i=0;i<n;i++) {
			if(!board[row][i].equals(".")) {
			int num=Integer.parseInt(board[row][i])-1;
			if(colItems[num]) {
				return false;
			}
			colItems[num]=true;
			}
		}
		
		boolean rowItems[]=new boolean[9];
		for(int i=0;i<n;i++) {
			if(!board[i][col].equals(".")) {
			int num=Integer.parseInt(board[i][col])-1;
			if(rowItems[num]) return false;
			rowItems[num]=true;
			}
		}
		int sqrt=(int)Math.sqrt(n);
		int rowStart=row-row%sqrt;
		int colStart=col-col%sqrt;
		
		boolean squareItems[]=new boolean[9];
		for(int r=rowStart;r<rowStart+sqrt;r++) {
			for(int c=colStart;c<colStart+sqrt;c++) {
			if(!board[r][c].equals(".")) {
				int num=Integer.parseInt(board[r][c])-1;
				if(squareItems[num]) return false;
				squareItems[num]=true;

			}
			}
		}
		return true;
		
	}
}
