package graph;
import java.util.*;
public class MinimumHeightTree {
	static class Pair{
		int node;
		int distance;
		Pair(int node,int distance){
			this.node=node;
			this.distance=distance;
		}
	}

	public static void main(String[] args) {
		int v=6;
		int edges[][]={{3,0},{3,1},{3,2},{3,4},{5,4}};
		
		List<List<Integer>>list=new ArrayList<>();
		
		for(int i=0;i<v;i++) {
			list.add(new ArrayList<>());
		}
		for(int edge[]:edges) {
			list.get(edge[0]).add(edge[1]);
			list.get(edge[1]).add(edge[0]);
		}
		
		int minHeight=Integer.MAX_VALUE;
		int ans[]=new int[v];
		for(int i=0;i<v;i++) {
			boolean visited[]=new boolean[v];
			int height=height(list, i, visited);
			ans[i]=height;
			minHeight=Math.min(minHeight, height);
		}
		List<Integer>answer=new ArrayList<>();
		for(int i=0;i<v;i++) {
			if(ans[i]==minHeight) {
				answer.add(i);
			}
		}
		System.out.println(answer);
		
	}
	public static int height(List<List<Integer>>list, int node,boolean visited[]) {
		visited[node]=true;
		Queue<Pair>queue=new LinkedList<>();
		queue.add(new Pair(node,0));
		int max=0;
		while(!queue.isEmpty()) {
			Pair p=queue.poll();
			int n=p.node;
			int dis=p.distance;
			
			for(int neigh:list.get(n)) {
				if(!visited[neigh]) {
					visited[neigh]=true;
					queue.add(new Pair(neigh,dis+1));
					max=Math.max(max,dis+1);
				}
				
			}
			
		}
		return max;
		
	}
}
