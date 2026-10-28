package graph;
import java.util.*;
import graph.DisJointSet;
public class NumberOfIsland2 {

	public static void main(String[] args) {
		 int n = 4, m = 5, k = 4;
		 int arr[][]=new int[n][m];
		 int operators[][] = {{1,1},{0,1},{3,3},{3,4}};
		 ArrayList<Integer>ans=new ArrayList<>();
		 DisJointSet ds=new DisJointSet(n*m);
		 int count=0;
		 for(int op[]:operators) {
			 int row=op[0];
			 int col=op[1];
			 if(arr[row][col]==1) {
				 ans.add(count);
				 continue;
			 }
			 count++;
			 arr[row][col]=1;
			 
			 
			 int rows[]= {-1,0,1,0};
			 int cols[]= {0,1,0,-1};
			 for(int i=0;i<rows.length;i++) {
				 int r=row+rows[i];
				 int c=col+cols[i];
				 if(r>=0 && r<n && c>=0 && c<m &&  arr[r][c]==1) {
					 if(ds.findUPar(r*m+c)!=ds.findUPar(row*m+col)) {
						 count--;
						 ds.unionByRank(r*n+c,row*n+col);
					 }
				 }
			 }
			 ans.add(count);
		 }
		 System.out.println(ans);

	}

}
