package graph;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Graph {

	public static void dfs(int matrix[][],int currentV,boolean visited[]) {
		visited[currentV]=true;
		System.out.print(currentV+" ");
		for(int i=0;i<matrix.length;i++) {
			if(matrix[currentV][i]==1 && visited[i]==false) {
				dfs(matrix,i,visited);
			}
		}
	}
	public static void bfs(int matrix[][],int i) {
		Queue<Integer> queue=new LinkedList<Integer>();
		boolean visited[]=new boolean[matrix.length];
		queue.add(i);
		visited[i]=true;
		while(!queue.isEmpty()) {
			int front=queue.poll();
			visited[front]=true;
			System.out.print(front+" ");
			for(int j=0;j<matrix.length;j++) {
				if(matrix[front][j]==1 &&visited[j]==false) {
					queue.add(j);
					visited[j]=true;
				}
			}
		}
	}

	
	public static boolean hasPath(int matrix[][],int s,int d) {
		Queue<Integer> queue=new LinkedList<Integer>();
		boolean visited[]=new boolean[matrix.length];
		queue.add(s);
		visited[s]=true;
		while(!queue.isEmpty()) {
			int front=queue.poll();
			for(int i=0;i<matrix.length;i++) {
				if(matrix[front][i]==1 && visited[i]==false ) {
					if(i==d) {
						return true;
					}
				}
				else {
					visited[i]=true;
					queue.add(i);
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int e=sc.nextInt();
		int matrix[][] =new int[n][n];
		for(int i=1;i<=e;i++) {
			int v1=sc.nextInt();
			int v2=sc.nextInt();
			matrix[v1][v2]=1;
			matrix[v2][v1]=1;
		}
		boolean visited[]=new boolean[n];
//		for(int i=0;i<matrix.length;i++) {
//			if(visited[i]==false) {
//		dfs(matrix,i,visited);
//			}
//		}
//			bfs(matrix,0);
	
		
//		System.out.println(hasPath(matrix, 0, 3));
	}

}
