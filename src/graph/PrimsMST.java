package graph;
import java.util.*;

public class PrimsMST {

	public static void main(String[] args) {
		int  v = 3, e = 3;
		int edges[][] = {{0, 1, 5}, {1, 2, 3}, {0, 2, 1}};
		
		ArrayList<ArrayList<int[]>>list=new ArrayList<>();
		for(int i=0;i<v;i++) {
			list.add(new ArrayList<>());
		}
		
		for(int edge[]:edges) {
			list.get(edge[0]).add(new int[] {edge[1],edge[2]});
			list.get(edge[1]).add(new int[] {edge[0],edge[2]});
		}
		PriorityQueue<int []>pq=new PriorityQueue<>((a,b)->a[1]-b[1]);
		pq.add(new int[] {0,0});
		boolean visited[]=new boolean[v];
		int sum=0;
		while(!pq.isEmpty()) {
			int top[]=pq.poll();
			int node=top[0];
			int dist=top[1];
			if(visited[node]) continue;
			visited[node]=true;
			sum=sum+dist;
			for(int neighbour[]:list.get(node)) {
				int neigh=neighbour[0];
				int edgeW=neighbour[1];
				if(!visited[neigh]) {
					pq.add(new int[] {neigh,edgeW});
				}
			}
		}
		System.out.println(sum);
	}

}
