package graph;

import java.util.*;

public class DijkstraAlgo {
	static class Pair{
		int neigh;
		int distance;
		Pair(int neigh,int distance){
			this.neigh=neigh;
			this.distance=distance;
		}
	}

	public static void main(String[] args) {
		int v=5;
		 int edges[][] = {{0, 1, 4}, {0, 2, 8}, {1, 4, 6}, {2, 3, 2}, {3, 4, 10}};
		 int src=0;
		 PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.distance - b.distance);
		 
		List<List<Pair>>list=new ArrayList<>();
		
		for(int i=0;i<v;i++) {
			list.add(new ArrayList<>());
		}
		for(int edge[]:edges) {
			list.get(edge[0]).add(new Pair(edge[1],edge[2]));
			list.get(edge[1]).add(new Pair(edge[0],edge[2]));
		}
		int distance[]=new int[v];
		Arrays.fill(distance,10000000);
		distance[src]=0;
		pq.add(new Pair(src,0));
		int parent[]=new int[v];
		parent[0]=0;
		
		while(!pq.isEmpty()) {
			Pair front=pq.poll();
			int node=front.neigh;
			int curr=front.distance;
			
			for(Pair p:list.get(node)) {
				int neigh=p.neigh;
				int dist=p.distance;
				
				if(curr+dist <distance[neigh]) {
					parent[neigh]=node;
					distance[neigh]=curr+dist;
					pq.add(new Pair(neigh,distance[neigh]));
				}
				
			}
			
			
		}
//		for(int i=0;i<distance.length;i++) {
////			System.out.print(distance[i]+" ");
//			System.out.println(parent[i]+" ");
//		}
		int n=4;
		while(parent[n]!=n) {
			System.out.println(n);
			n=parent[n];
		}
		

	}

}
