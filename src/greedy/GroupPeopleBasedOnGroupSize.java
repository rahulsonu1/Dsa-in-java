package greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GroupPeopleBasedOnGroupSize {

	public static void main(String[] args) {
	int arr[]= {3,3,3,3,3,1,3};
//	List<List<Integer>>
	group(arr);
	}
	public static List<List<Integer>> group(int arr[]){
		HashMap<Integer,List<Integer>> map=new HashMap<>();
		List<List<Integer>>ans=new ArrayList<>();
		for(int i=0;i<arr.length;i++) {
			if(!map.containsKey(arr[i])) {
				map.put(arr[i], new ArrayList<Integer>());
			}
				List<Integer> list=map.get(arr[i]);
				list.add(i);
				map.put(arr[i], list);
				
				if(arr[i]==list.size()) {
					ans.add(list);
					map.remove(arr[i]);
			}
		
			
		}
		return ans;
	}

}
