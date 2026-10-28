package graph;
import java.util.*;
public class TopologicalSort {

	public static void main(String[] args) {
		int v=4;
		int edges[][]= {{3, 0}, {1, 0}, {2, 0}};
		
		List<List<Integer>>list=new ArrayList<>();
		for(int i=0;i<v;i++) {
			list.add(new ArrayList<>());
		}
		int indegree[]=new int[v];
		for(int edge[] :edges) {
			list.get(edge[0]).add(edge[1]);
			indegree[edge[1]]++;
		}
		kanhAglgorith(list, v, indegree);
		boolean visited[]=new boolean[v];
		Stack<Integer>stack=new Stack<>();
		
		for(int i=0;i<v;i++) {
			if(!visited[i]) {
				dfs(list,i,stack,visited);
			}
			
		}
		while(!stack.isEmpty()) {
			System.out.println(stack.pop());
		}

	}
	public static void kanhAglgorith(List<List<Integer>>list,int v,int indegree[]) {
		Stack<Integer>stack=new Stack<>();
		for(int i=0;i<v;i++) {
			if(indegree[i]==0) {
				stack.push(i);
			}
		}
		while(!stack.isEmpty()) {
			int top=stack.pop();
			for(int neigh:list.get(top)) {
				indegree[neigh]--;
				if(indegree[neigh]==0) {
					stack.add(neigh);
				}
			}
			System.out.println(top);
		}
		System.out.println();
		
	}
	
	public static void dfs(List<List<Integer>>list,int node, Stack<Integer>stack,boolean visited[]) {
		visited[node]=true;
		for(int neigh : list.get(node)) {
			if(!visited[neigh]) {
				dfs(list,neigh,stack,visited);
			}
		}
		stack.add(node);
		
	}

}
