package graph;

import java.util.LinkedList;
import java.util.Queue;

import graph.RottenOrange.Triple;

public class Nearestcell1 {
	
	static class Triple{
		int row;
		int col;
		int distance;
		public Triple(int row,int col,int distance) {
			this.row=row;
			this.col=col;
			this.distance=distance;
		}
	}
	

	public static void main(String[] args) {
		int arr[][]= {{0, 1, 1, 0}, 
		              {1, 1, 0, 0}, 
		              {0, 0, 1, 1}};
		int m=arr.length;
		int n=arr[0].length;
		int ans[][]=new int[m][n];
		
		Queue<Triple> queue=new LinkedList<>();
		boolean visited[][]=new boolean[m][n];
		
		
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(arr[i][j]==1) {
					queue.add(new Triple(i,j,0));
					visited[i][j]=true;
				}
			}
		}
		int rows[]= {-1,0,1,0};
		int cols[]= {0,1,0,-1};
		while(!queue.isEmpty()) {
			Triple front=queue.poll();
			int row=front.row;
			int col=front.col;
			int dis=front.distance;
			ans[row][col]=dis;
			for(int i=0;i<4;i++) {
				int newRow=row+rows[i];
				int newCol=col+cols[i];
				
				if(newRow>=0 && newRow<m && newCol>=0 && newCol<n &&  arr[newRow][newCol]==0 &&visited[newRow][newCol]==false) {
					queue.add(new Triple(newRow,newCol,dis+1));
					visited[newRow][newCol]=true;
					
				}
			}
		}
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				System.out.print(ans[i][j]+" ");
			}
			System.out.println();
		}
	}

}
