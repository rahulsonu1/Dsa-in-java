package graph;

import java.util.*;

public class ShortestDistanceInMAZE {
	static class Triple{
		int row;
		int col;
		int dist;
		Triple(int row,int col,int dist){
			this.row=row;
			this.col=col;
			this.dist=dist;
		}
	}

	public static void main(String[] args) {
		int grid[][]= {{0,0,0},{1,1,0},{1,1,0}};
		int n=grid.length;
		
		int distMatrix[][]=new int[n][n];
		for(int i[]:distMatrix) {
			Arrays.fill(i, Integer.MAX_VALUE);
		}
		distMatrix[0][0]=0;
		
		Queue<Triple>queue=new LinkedList<>();
		
		int rowMov[]= {-1,-1,-1,0,0,1,1,1};
		int colMov[]= {-1,0,1,-1,1,-1,0,1};
		queue.add(new Triple(0,0,0));
		boolean breaking=false;
		while(!queue.isEmpty()) {
			Triple front=queue.poll();
			int row=front.row;
			int col=front.col;
			int dist=front.dist;
			
			for(int i=0;i<rowMov.length;i++) {
				int r=row+rowMov[i];
				int c=col+colMov[i];
				
				if(r>=0 && r<n && c>=0 && c<n && grid[r][c]==0 && dist+1<distMatrix[r][c]) {
					distMatrix[r][c]=dist+1;
					if(r==n-1 && c==n-1) {
						breaking=true;
						
					}
					queue.add(new Triple(r,c,dist+1));
				}
			}
			if(breaking) break;
		}
		System.out.println(distMatrix[n-1][n-1]);
		

	}

}
