package graph;
import java.util.*;
import graph.DisJointSet;
public class NumberofOpearationToMakeNetworkConnected {

	public static void main(String[] args) {
		int n = 4; 
		int [][]connections = {{0,1},{0,2},{1,2}};
		
		DisJointSet ds=new DisJointSet(n);
		
		int extra=0;
		for(int con[]:connections) {
			if(ds.findUPar(con[0])==ds.findUPar(con[1])) {
				extra++;
			}else {
				ds.unionByRank(con[0],con[1]);
			}
			
		}
		System.out.println(extra);
		int comp=0;
		for(int i=0;i<n;i++) {
			if(ds.findUPar(i)==i) {
				comp++;
			}
		}
		System.out.println(comp);

	}

}
