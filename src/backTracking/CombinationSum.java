package backTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class CombinationSum {

	public static void main(String[] args) {
		int arr[]= {2,3,6,7};
		int target=7;
		List<Integer>list=new ArrayList<>();
		List<List<Integer>>ans=new ArrayList<>();
		combineSum(arr, 0, target, list,ans);
		System.out.println(ans);
		

	}
	public static void combineSum(int arr[],int index,int target,List<Integer>list,
			List<List<Integer>> ans) {
		if(target==0) {
			ans.add(new ArrayList<Integer>(list));
			return ;
		}
		for(int i=index;i<arr.length;i++) {
			if(arr[i]<=target) {
				list.add(arr[i]);
				combineSum(arr, i, target-arr[i], list,ans);
				list.removeLast();
			}
		}
		
	}

}
