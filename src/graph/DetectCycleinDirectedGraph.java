package graph;
import java.util.*;
public class DetectCycleinDirectedGraph {

	public static void main(String[] args) {
		int v=4;
		int edges[][] = {{0, 1}, {1, 2}, {2, 0}, {2, 3}};

		
		List<List<Integer>>list=new ArrayList<>();
		for(int i=0;i<v;i++) {
			list.add(new ArrayList<>());
		}

		for(int [] edge:edges) {
			int a=edge[0];
			int b=edge[1];
			list.get(a).add(b);
		}
		boolean visited[]=new boolean[v];
		boolean pathvisited[]=new boolean[v];
		boolean isCycle=false;
		for(int i=0;i<v;i++) {
			if(visited[i]==false ) {
				if(dfs(list,i,visited,pathvisited)) {isCycle=true;
				
				break;}
			}
			
		}
		System.out.println(isCycle);

	}
	public static boolean dfs(List<List<Integer>>list,int node,boolean visited[],boolean pathvisited[]) {
		visited[node]=true;
		pathvisited[node]=true;
		for(int neigh : list.get(node)) {
			if(pathvisited[neigh]) {
				return true;
			}
			if(!visited[neigh]) {
				
				if(dfs(list,neigh,visited,pathvisited))
					return true;
				}

			}
			
		pathvisited[node]=false;
		return false;
	}
}

