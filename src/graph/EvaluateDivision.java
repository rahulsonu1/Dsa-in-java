package graph;
import java.util.*;
public class EvaluateDivision {
	static class Edge{
		String node;
		double cost;
		Edge(String node,double cost){
			this.node=node;
			this.cost=cost;
		}
	}

	public static void main(String[] args) {
		String [][]eq = {{"a","b"},{"b","c"}};
		double []val = {2.0,3.0};
		String [][]qu = {{"a","c"},{"b","a"},{"a","e"},{"a","a"},{"x","x"}};
		
		HashMap<String,List<Edge>> graph=new HashMap<>();
		for(int i=0;i<eq.length;i++) {
			String u=
		}
		graph.con
	}

}
