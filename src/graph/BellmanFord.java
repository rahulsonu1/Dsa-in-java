package graph;
import java.util.*;

public class BellmanFord {

	public static void main(String[] args) {
		 int v = 5;
		 int edges[][] = {{1, 3, 2}, {4, 3, -1}, {2, 4, 1}, {1, 2, 1}, {0, 1, 5}};
		 int src = 0;
		 int distance[]=new int[v];
		 Arrays.fill(distance,Integer.MAX_VALUE);
		 distance[src]=0;
		 
		 for(int i=0;i<v-1;i++) {
			 for(int edge[]:edges) { 
				 if(distance[edge[0]]!=Integer.MAX_VALUE && distance[edge[0]]+edge[2]<distance[edge[1]]) {
					 distance[edge[1]]=distance[edge[0]]+edge[2];
				 }
			 }
		 }
		 for(int edge[]:edges) {
			 if(distance[edge[0]]!=Integer.MAX_VALUE && distance[edge[0]]+edge[2]<distance[edge[1]]) {
				 System.out.println("Neative cycle Detected");
			 }
		 }
		 

	}

}
