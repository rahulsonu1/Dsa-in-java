package graph;
import java.util.*;

public class BipartiteGraph {
	
	static class Pair{
		int node;
		int color;
		Pair(int node,int color){
			this.node=node;
			this.color=color;
		}
	}

	public static void main(String[] args) {
		int v=3;
		int edges[][]= {{0, 1}, {1,2}};
		
		List<List<Integer>>list=new ArrayList<>();
		for(int i=0;i<v;i++) {
			list.add(new ArrayList<>());
		}
		
		for(int [] edge:edges) {
			int a=edge[0];
			int b=edge[1];
			list.get(a).add(b);
			list.get(b).add(a);
		}
		Queue<Pair>queue=new LinkedList<>();
		
		queue.add(new Pair(0,1));
		boolean visited[]=new boolean[v];
		visited[0]=true;
		int colors[]=new int[v];
		Arrays.fill(colors, -1);
		colors[0]=1;
		
		// DFS starts 
		boolean visit[]=new boolean[v];
		int colorsdfs[]=new int[v];
		visit[0]=true;
		colorsdfs[0]=1;
		System.out.println(dfs(list,0,visit,colorsdfs));
		
		while(!queue.isEmpty()) {
			Pair front=queue.poll();
			int node=front.node;
			int color=front.color;
			
			for(int neigh:list.get(node)) {
				if(!visited[neigh] && colors[neigh]==-1) {
					int c=color;
					if(color==1) c=2;
					else if(color==2) c=1;
					queue.add(new Pair(neigh,c));
					visited[neigh]=true;
					colors[neigh]=c;
				}
				else if(visited[neigh] && colors[neigh]==color) {
					System.out.println("NB ");
					return;
				}
			}
		}
		
	}
	public static boolean dfs(List<List<Integer>>list,int node ,boolean visited[],int colors[]) {
		
		for(int neigh:list.get(node)) {
			if(!visited[neigh] && colors[neigh]==-1) {
				int c=colors[node];
				if(colors[node]==1) c=2;
				else if(colors[node]==2) c=1;
				visited[neigh]=true;
				colors[neigh]=c;
				dfs(list,neigh,visited,colors);
			}
			else if(visited[neigh] && colors[neigh]==colors[node]) {
				return false;
			}
		}
		return true;
	}

}
