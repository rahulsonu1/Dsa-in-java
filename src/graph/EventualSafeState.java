package graph;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class EventualSafeState {

	public static void main(String[] args) {
		int graph[][]= {{1,2},{2,3},{5},{0},{5},{},{}};
		
		int v=graph.length;
		boolean visited[]=new boolean[v];
		boolean pathVisited[]=new boolean[v];
		boolean check[]=new boolean[v];
		
		for(int i=0;i<v;i++) {
			if(!visited[i]) {
				dfs(graph,i,visited,pathVisited,check);
			}
		}
		
		for(int i=0;i<v;i++) {
			if(check[i]) {
				System.out.print(i+" ");
			}
		}

	}
	

	
	
	
	
	
	
	
	
	
	
	public static boolean dfs(int graph[][],int node,boolean visited[],boolean pathVisited[],boolean check[]) {
		visited[node]=true;
		pathVisited[node]=true;
		check[node]=false;
		
		for(int i=0;i<graph[node].length;i++) {
			if(!visited[graph[node][i]]) {
				if(dfs(graph,graph[node][i],visited,pathVisited,check)) {
	
					return true;
				}
			}
			else if(pathVisited[graph[node][i]]) {
				return true;
			}
		}
		pathVisited[node]=false;
		check[node]=true;
		return false;
	
	}
	

}
