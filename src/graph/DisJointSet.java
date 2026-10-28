package graph;
import java.util.*;

public class DisJointSet {
	ArrayList<Integer>rank=new ArrayList<>();
	ArrayList<Integer>parent=new ArrayList<>();
    ArrayList<Integer> size = new ArrayList<>();

	
	public DisJointSet(int n) {
		n=n+1;
		for(int i=0;i<n;i++) {
			rank.add(0);
			parent.add(i);
			size.add(1);
		}
	}
		
		
		public int findUPar(int node) {
			if(node==parent.get(node)) {
				return node;
			}
			int ultimateParent=findUPar(parent.get(node));
			parent.set(node, ultimateParent);
			return parent.get(node);
			
	}
		public void unionByRank(int u,int v) {
			// ultimate Parent
			int uParent=findUPar(u);
			int vParent=findUPar(v);
			if(uParent==vParent) return ;
			
			if(rank.get(uParent)<rank.get(vParent)) {
				parent.set(uParent, vParent);
			}else if(rank.get(uParent)>rank.get(vParent)) {
				parent.set(vParent,uParent);
			}else {
				parent.set(uParent, vParent);
				int rankU=rank.get(uParent);
				rank.set(vParent, rankU+1);
			}
		}
		
		public void unionBySize(int u, int v) {

	        int uParent = findUPar(u);
	        int vParent = findUPar(v);
	        if (uParent == vParent) {
	            return;
	        }
	        if (size.get(uParent) < size.get(vParent)) {

	            parent.set(uParent, vParent);

	            size.set(
	                vParent,
	                size.get(vParent) + size.get(uParent)
	            );
	        }
	        else {
	            parent.set(vParent, uParent);

	            size.set(
	                uParent,
	                size.get(uParent) + size.get(vParent)
	            );
	        }
	    }
		
		public static void main(String args[]) {
			DisJointSet d=new DisJointSet(7);
			d.unionByRank(1,2);
			d.unionByRank(2, 3);
			d.unionByRank(4,5);
			d.unionByRank(6, 7);
			d.unionByRank(5, 6);
			
			if(d.findUPar(3)==d.findUPar(7)) {
				System.out.println("Same");
			}else {
				System.out.println("Not same");
			}
			d.unionByRank(3, 7);
			if(d.findUPar(3)==d.findUPar(7)) {
				System.out.println("Same");
			}else {
				System.out.println("Not same");
			}
			
		}
	
	

}
