package graph;

public class SurrondedOwithX {

	public static void main(String[] args) {
		char [][]board= {{'X','X','X','X'},
				{'X','O','O','X'},
				{'X','X','O','X'},
				{'X','O','X','X'}};
		
		int m=board.length;
		int n=board[0].length;
		boolean visited[][]=new boolean[m][n];
		
		for(int i=0;i<n;i++) {
			if(board[0][i]=='O' && !visited[0][i]) {
				dfs(board,0,i,visited);
			}
			if(board[m-1][i]=='O' && !visited[m-1][i]) {
				dfs(board,m-1,i,visited);
			}
		}
		
		for(int j=0;j<m;j++) {
			if(board[j][0]=='O' && !visited[j][0]) {
				dfs(board,j,0,visited);
			}
			if(board[j][n-1]=='O' && !visited[j][n-1]) {
				dfs(board,j,n-1,visited);
			}
		}
		
		
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(board[i][j]=='O' && !visited[i][j]) {
					board[i][j]='X';
				}
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
		

	}
	public static void dfs(char board[][],int row,int col,boolean visited[][]) {
		visited[row][col]=true;
		
		int rows[]= {-1,0,1,0};
		int cols[]= {0,1,0,-1};
		
		for(int i=0;i<4;i++) {
			int r=row+rows[i];
			int c=col+cols[i];
			
			if(r>=0 && r<board.length && c>=0 && c<board[0].length && board[r][c]=='O' && !visited[r][c]) {
				dfs(board,r,c,visited);
			}
		}
	}

}
