package graph;
import java.util.*;
public class NumberOfDistinctIsland {

	public static void main(String[] args) {
		char grid[][]= {{'L', 'L', 'W', 'L', 'L'},
				       {'L', 'W', 'W', 'W', 'W'}, 
                       {'W', 'W', 'L', 'W', 'L'},
                       {'L', 'W', 'W', 'L', 'L'}};
		
		int m=grid.length;
		int n=grid[0].length;
		HashSet<List<String>>set=new HashSet<>();
		boolean visited[][]=new boolean[m][n];
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				List<String>list=new ArrayList<>();
				if(grid[i][j]=='L' && !visited[i][j]) {
					dfs(grid,i,j,visited,list,i,j);
					set.add(list);
				}
				
				
			}
		}
		System.out.println(set.size());

	}
	public static void dfs(char grid[][],int row,int col,boolean visited[][],List<String>list,int a,int b) {
		list.add(Integer.toString(row-a)+" "+ Integer.toString(col-b));
		visited[row][col]=true;
		
		int rows[]= {-1,0,1,0};
		int cols[]= {0,1,0,-1};
		
		for(int i=0;i<4;i++) {
			int r=row+rows[i];
			int c=col+cols[i];
			
			if(r>=0 && r<grid.length && c>=0 && c<grid[0].length && grid[r][c]=='L' && !visited[r][c]) {
				dfs(grid,r,c,visited,list,a,b);
			}
		}
		
	}

}
