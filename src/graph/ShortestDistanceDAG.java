package graph;
import java.util.*;
public class ShortestDistanceDAG {
	static class Pair{
		int neigh;
		int weight;
		Pair(int neigh,int weight){
			this.neigh=neigh;
			this.weight=weight;
		}
	}

	public static void main(String[] args) {
		int v = 6;
		int [][]edges = {{0,1,2}, {0,4,1}, {4,5,4}, {4,2,2}, {1,2,3}, {2,3,6}, {5,3,1}};
		
		List<List<Pair>>list=new ArrayList<>();
		for(int i=0;i<v;i++) {
			list.add(new ArrayList<>());
		}
		for(int edge[]:edges) {
			list.get(edge[0]).add(new Pair(edge[1],edge[2]));
		}
		boolean visited[]=new boolean[v];
		Stack<Integer>stack=new Stack<>();
		for(int i=0;i<v;i++) {
			if(!visited[i]) {
				topoSort(list,i,visited,stack);
			}
		}
		int distance[]=new int[v];
		Arrays.fill(distance, Integer.MAX_VALUE);
		
		distance[0]=0;
		while(!stack.isEmpty()) {
			int top=stack.pop();
			for(Pair p :list.get(top)) {
				int neigh=p.neigh;
				int dis=p.weight;
				if(distance[top]+dis<distance[neigh]) {
					distance[neigh]=distance[top]+dis;
				}
			}
		}
		for(int i=0;i<v;i++) {
			System.out.println(distance[i]);
		}
		
		

	}
	public static void topoSort(List<List<Pair>>list,int node,boolean visited[],Stack<Integer>stack) {
		visited[node]=true;
		for(Pair p :list.get(node)) {
			int neigh=p.neigh;
			if(!visited[neigh]) {
				topoSort(list,neigh,visited,stack);
			}
		}
		stack.add(node);
	}

}
