package graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class RottenOrange {
	static  class Triple {
		int row;
		int col;
		int time;
	public  Triple(int row,int col,int time) {
		this.row=row;
		this.col=col;
		this.time=time;
	}
	}

	public static void main(String[] args) {
		int grid[][]= {{2,1,1},{1,1,0},{0,1,1}};
		Queue<Triple> queue=new LinkedList<>();
		
		int m=grid.length;
		int n=grid[0].length;
		int rows[]= {-1,0,1,0};
		int cols[]= {0,1,0,-1};
		
		boolean visited[][]=new boolean[m][n];
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(grid[i][j]==2) {
					visited[i][j]=true;
				Triple t=new Triple(i, j, 0);
				queue.add(t);}
			}
		}
		int max=0;
		while(!queue.isEmpty()) {
			Triple front= queue.poll();
			int row=front.row;
			int col=front.col;
			int time=front.time;
			max=Math.max(max, time);
			for(int i=0;i<4;i++) {
				int newRow=row+rows[i];
				int newCol=col+cols[i];
				
				if(newRow>=0 && newRow<m && newCol>=0 && newCol<n &&  grid[newRow][newCol]==1 &&visited[newRow][newCol]==false) {
					queue.add(new Triple(newRow,newCol,time+1));
					visited[newRow][newCol]=true;
				}
			}
		}
		System.out.println(max);
	}
		
		
	}
	

