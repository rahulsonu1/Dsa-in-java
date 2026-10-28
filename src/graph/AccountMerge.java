package graph;
import graph.DisJointSet;
import java.util.*;

public class AccountMerge {

			
	public static void main(String[] args) {
		String arr[][]={{"John","johnsmith@mail.com","john_newyork@mail.com"},
			{"John","johnsmith@mail.com","john00@mail.com"},
			{"Mary","mary@mail.com"},
			{"John","johnnybravo@mail.com"}};
		int n=arr.length;
		List<List<String>>list=new ArrayList<>();
		for(int i=0;i<arr.length;i++) {
			list.add(new ArrayList<>());
			for(int j=0;j<arr[i].length;j++) {
				list.get(i).add(arr[i][j]);
			}
		}
		DisJointSet ds=new DisJointSet(n);
		
		HashMap<String,Integer> map=new HashMap<>();
		for(int i=0;i<list.size();i++) {
			for(int j=1;j<list.get(i).size();j++) {
				String val=list.get(i).get(j);
				if(map.containsKey(val)) {
					ds.unionByRank(i, map.get(val));
					map.put(val, map.get(val));
				}else {
					map.put(val,i);
				}
			}
		}
		List<List<String>>merged=new ArrayList<>();
		for(int i=0;i<n;i++) {
			merged.add(new ArrayList<>());
//			ans.get(i).add(list.get(i).get(0));
		}
	
		for(String email:map.keySet()) {
			int up=ds.findUPar(map.get(email));
			merged.get(up).add(email);
			
		}
		List<List<String>> ans=new ArrayList<>();
		for(int i=0;i<n;i++) {
			if(merged.get(i).size()==0) {
				continue;
			}
			Collections.sort(merged.get(i));
			List<String>newList=new ArrayList<>();
			
			newList.add(list.get(i).get(0));
			for(int j=0;j<merged.get(i).size();j++) {
				newList.add(merged.get(i).get(j));
			}
			ans.add(newList);
		}
		
		System.out.println(ans);
				 

	}

}
