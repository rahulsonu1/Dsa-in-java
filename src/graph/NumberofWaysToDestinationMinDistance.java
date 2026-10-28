package graph;
import java.util.*;
public class NumberofWaysToDestinationMinDistance {
	static class Triple{
		int node;
		int dist;
		
		Triple(int node,int dist){
			this.node=node;
			this.dist=dist;
			
		}
	}
	

	public static void main(String[] args) {
		int roads[][] = { { 0, 6, 7 }, { 0, 1, 2 }, { 1, 2, 3 }, { 1, 3, 3 },
				{ 6, 3, 3 }, { 3, 5, 1 }, { 6, 5, 1 },
				{ 2, 5, 1 }, { 0, 4, 5 }, { 4, 6, 2 } };
		int v=7;
		ArrayList<ArrayList<int []>>list=new ArrayList<>();
		for(int i=0;i<v;i++) {
			list.add(new ArrayList<>());
		}
		
		for(int road[]:roads) {
			list.get(road[0]).add(new int[]{road[1],road[2]});
			list.get(road[1]).add(new int[] {road[0],road[2]});
		}
		int distance[]=new int[v];
		Arrays.fill(distance,Integer.MAX_VALUE);
		int ways[]=new int[v];
		distance[0]=0;
		ways[0]=1;
		PriorityQueue<Triple>pq=new PriorityQueue<>((a,b)-> a.dist-b.dist);
		pq.add(new Triple(0,0));
		while(!pq.isEmpty()) {
			Triple front=pq.poll();
			int node=front.node;
			int dist=front.dist;
			
			for(int neighbour[]:list.get(node)) {
				int neigh=neighbour[0];
				int edgeW=neighbour[1];
				
				if(dist+edgeW<distance[neigh]) {
					distance[neigh]=dist+edgeW;
					ways[neigh]=ways[node];
					pq.add(new Triple(neigh,distance[neigh]));
				}
				else if(dist+edgeW==distance[neigh]) {
					ways[neigh]=ways[node]+ways[neigh];
			
				}
				
			}
			
		}
		for(int i=0;i<v;i++) {
//			System.out.println(i+" dsuitance "+distance[i]);
			System.out.println(ways[i]);
		}
		

	}

}
