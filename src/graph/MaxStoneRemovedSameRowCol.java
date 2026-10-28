package graph;
import graph.DisJointSet;
import java.util.*;
public class MaxStoneRemovedSameRowCol {

	public static void main(String[] args) {
		int stones[][]= {{0,0},{0,2},{1,1},{2,0},{2,2}};
		int n=stones.length;
		int r=0;
		int c=0;
		for(int stone[]:stones) {
			r=Math.max(r,stone[0]);
			c=Math.max(c, stone[1]);
		}
		DisJointSet ds=new DisJointSet(r+c+1);
		HashSet<Integer>set=new HashSet<Integer>();
		for(int stone[]:stones) {
			int row=stone[0];
			int col=stone[1]+c+1;
			ds.unionBySize(row, col);
			set.add(row);set.add(col);
		}
		//n-connectedComponent
		int count=0;
		for(int i:set) {
			if(ds.findUPar(i)==i) {
				count++;
			}
		}
		System.out.println(n-count);

	}

}
