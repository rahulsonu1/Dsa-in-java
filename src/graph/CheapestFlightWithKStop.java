package graph;
import java.util.*;

public class CheapestFlightWithKStop {
	static class Triple{
		int node;
		int cost;
		int stop;
		Triple(int node,int cost,int stop){
			this.node=node;
			this.cost=cost;
			this.stop=stop;
			
		}
	}
	

	public static void main(String[] args) {
		 int v = 5;
		 int [][]flights = {{0,1,5},{1,2,5},{0,3,2},{3,1,2},{1,4,1},{4,2,1}};
		 int src = 0, dst = 2, k = 2;
		 
		 List<List<int[]>>list=new ArrayList<>();
		 for(int i=0;i<v;i++) {
			 list.add(new ArrayList<>());
		 }
		 for(int flight[]:flights) {
			 list.get(flight[0]).add(new int[]{flight[1],flight[2]});
		 }
		 int distance[]=new int[v];
		 Arrays.fill(distance,Integer.MAX_VALUE);
		 distance[src]=0;
		 Queue<Triple>queue=new LinkedList<>();
		 queue.add(new Triple(src,0,0));
		 
		 while(!queue.isEmpty()) {
			 Triple front=queue.poll();
			 int node=front.node;
			 int cost=front.cost;
			 int stop=front.stop;
			 if(stop>k) continue;
			 for(int neigh[]:list.get(node)) {
				 int neighbour=neigh[0];
				 int edgeWeight=neigh[1];
				 
				 if(cost+edgeWeight<distance[neighbour]) {
					 distance[neighbour]=cost+edgeWeight;
					 queue.add(new Triple(neighbour,distance[neighbour],stop+1));
				 }
			 }
		 }
		 
		 System.out.println(distance[dst]);
		 
		 
		
		 

	}

}
