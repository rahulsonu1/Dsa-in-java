package graph;
import java.util.*;

public class KosarajuSCC {

	public static void main(String[] args) {
		int v = 6, e = 7;
		int edges[][] = {{0, 1}, {1, 2}, {2, 0}, {2, 3}, {3, 4}, {4, 3}, {4, 5}};
		
		List<List<Integer>>list=new ArrayList<>();
		List<List<Integer>> rev=new ArrayList<>();
		for(int i=0;i<v;i++) {
			list.add(new ArrayList<Integer>());
			rev.add(new ArrayList<Integer>());
		}
		for(int edge[]:edges) {
			list.get(edge[0]).add(edge[1]);
			rev.get(edge[1]).add(edge[0]);
		}
		boolean visited[]=new boolean[v];
		Stack<Integer>ft=new Stack<>();
		for(int i=0;i<v;i++) {
			if(!visited[i]) {
				finishTime(list, ft, visited, i);
			}
			
		}
		
		System.out.println(ft);
		
		int count=0;
		boolean newVisited[]=new boolean[v];
		while(!ft.isEmpty()) {
			int top=ft.pop();
			if(!newVisited[top]) {
				dfs(top,rev,newVisited);
				count++;
			}
		}
		System.out.println(count);
		
	}
	
	public static void dfs(int node , List<List<Integer>> list,boolean visited[]) {
		visited[node]=true;
		for(int neigh:list.get(node)) {
			if(!visited[neigh]) {
				dfs(neigh,list,visited);
			}
		}
		
	}
	public static void finishTime(List<List<Integer>>list, Stack<Integer>stack,boolean visited[],int node) {
		visited[node]=true;
		for(int neigh:list.get(node)) {
			if(!visited[neigh]) {
				finishTime(list, stack, visited, neigh);
			}
		}
		stack.add(node);
	}

}
