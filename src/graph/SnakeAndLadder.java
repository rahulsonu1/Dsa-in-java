package graph;
import java.util.*;

public class SnakeAndLadder {

	public static void main(String[] args) {
		int [][]board = {{-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1},
				{-1,35,-1,-1,13,-1},
				{-1,-1,-1,-1,-1,-1},
				{-1,15,-1,-1,-1,-1}};
		
		int n=board.length;
		int target=n*n;
		boolean visited[]=new boolean[(n*n)+1];
		int ans=0;
		Queue<Integer>queue=new LinkedList<>();
		queue.add(1);
		visited[1]=true;
		while(!queue.isEmpty()) {
			int levelSize=queue.size();
			
			for(int i=0;i<levelSize;i++) {
				int currPosition=queue.poll();
				
				if(currPosition==target) {
					System.out.println(ans);
					return ;
				}
				for(int j=1;j<=6;j++) {
					int nextMove=currPosition+j;
					
					if(nextMove>target) {
						break;
					}
					int row=(nextMove-1)/n;
					int col=(nextMove-1)%n;
					if(row%2==1) {
						col=n-col-1;
					}
					row=n-row-1;
					
					int destination = board[row][col] == -1 ? nextMove : board[row][col];
	                  
                   
                    if (!visited[destination]) {
                        visited[destination] = true;
                        queue.offer(destination);
                    }
				}
			}
			ans++;
		}
		

	}

}
