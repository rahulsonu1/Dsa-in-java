package arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;
import java.util.TreeSet;

public class AvoidFlood {

	public static void main(String[] args) {
		int arr[]= {1,2,0,2,3,0,1};
		System.out.println(Arrays.toString(avoidFlood(arr)));
		

	}
	//true-filled
     public static int[] avoidFlood(int[] rains) {
        HashMap<Integer,Integer>map=new HashMap<>();
        TreeSet<Integer>set=new TreeSet<Integer>();
        int n=rains.length;
        int ans[]=new int[n];
        Arrays.fill(ans,1);
        for(int i=0;i<n;i++) {
        	if(rains[i]>0) {
        		ans[i]=-1;
        		if(map.containsKey(rains[i])) {
        			Integer index=set.higher(map.get(rains[i]));
        			if(index==null) {
        				return new int[0];
        			}else {
        				ans[index]=rains[i];
        				set.remove(index);
        			}
        			
        		}
        		map.put(rains[i], i);
        	}else {
        		set.add(i);
        		
        	}
       
        	
        }
        return ans;
    }
    

}
