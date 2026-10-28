package graph;
import java.util.*;
public class DetectCycle {
	
	static class Pair{
		int node;
		int parent;
		public Pair(int node,int parent) {
			this.node=node;
			this.parent=parent;
		}
	}
	

	public static void main(String[] args) {
		int v = 4, e = 4;
		int edges[][] = {{0, 1}, {0, 2}, {1, 2}, {2, 3}};
		
		ArrayList<ArrayList<Integer>>list=new ArrayList<>();
		for(int i=0;i<v;i++) {
			list.add(new ArrayList<>());
		}
		
		for(int [] edge:edges) {
			int a=edge[0];
			int b=edge[1];
			list.get(a).add(b);
			list.get(b).add(a);
		}
		boolean visited[]=new boolean[v];
		
		for(int i=0;i<v;i++) {
			if(!visited[i] && isCycleDFS(0, list, visited, -1)) {
				System.out.println("Cycle Detected");
				break;
			}
		}
		
		
		
	}
	public static boolean isCycleDFS(int node,ArrayList<ArrayList<Integer>>list,boolean[]visited,int parent) {
		if(visited[node]) return true;
		
		visited[node]=true;
		for(int neigh:list.get(node)) {
			if(!visited[neigh]) {
				if(isCycleDFS(neigh, list, visited, node)) return true;
			}else if(neigh!=parent) return true;
		}
		return false;
	}
	
	
	
	
	
	
	
	
	public static boolean isCycle(int src,ArrayList<ArrayList<Integer>>list,boolean visited[]) {
		Queue<Pair> queue=new LinkedList<>();
		queue.add(new Pair(src,-1));
		visited[src]=true;
		
		while(!queue.isEmpty()) {
			Pair front=queue.poll();
			int node=front.node;
			int parent=front.parent;
			
			for(int neigh: list.get(node)) {
				if(!visited[neigh]) {
					visited[neigh]=true;
					queue.add(new Pair(neigh,node));
				}else if(neigh!=parent){
					return true;
				}
			}
		}
		return false;
	}

}
