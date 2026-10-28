package graph;
import java.util.*;
import graph.DisJointSet;


public class MakingLargerIsland {

	public static void main(String[] args) {
		int grid[][]= {{1,1,},{1,1}};
		int n=grid.length;
		
		int rows[]= {-1,0,1,0};
		int cols[]= {0,1,0,-1};
		DisJointSet ds=new DisJointSet(n*n);
		int countZero=0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(grid[i][j]==0) countZero++;
				if(grid[i][j]==1) {
					for(int k=0;k<rows.length;k++) {
						int r=i+rows[k];
						int c=j+cols[k];
						
						if(r>=0 && r<n && c>=0 && c<n && grid[r][c]==1) {
							ds.unionBySize(i*n+j,r*n+c);
						}
					}
				}
			}
		}
		int max=0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				HashSet<Integer>set=new HashSet<>();
				if(grid[i][j]==0) {
					for(int k=0;k<rows.length;k++) {
						int r=i+rows[k];
						int c=j+cols[k];
						
						if(r>=0 && r<n && c>=0 && c<n && grid[r][c]==1) {
							int up=ds.findUPar(r*n+c);
							set.add(up);
						}
					}
					int sum=0;
					for(int p:set) {
						sum=sum+ds.size.get(p);
					}
					max=Math.max(sum,max);
				}
			}
		}
		System.out.println(max);

	}

}
