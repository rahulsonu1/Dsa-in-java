package backTracking;

import java.util.ArrayList;
import java.util.HashSet;

public class Permutation1 {
	static ArrayList<ArrayList<Integer>>ans=new ArrayList<>();
	static HashSet<ArrayList<Integer>>set=new HashSet<>();

	public static void main(String[] args) {
		int arr[]= {1,1,2};
		ArrayList<Integer>list=new ArrayList<>();
//		permute(arr,list);
		permute1(arr, 0);
		System.out.println(set);

	}
	public static void permute1(int arr[],int index) {
		if(index==arr.length) {
			ArrayList<Integer>list=new ArrayList<>();
			for(int i=0;i<arr.length;i++) {
				list.add(arr[i]);
			}
			set.add(list);
		}
		for(int i=index;i<arr.length;i++) {
			swap(arr,index,i);
			permute1(arr, index+1);
			swap(arr,index,i);
		}
	}
	
	
	public static void permute(int arr[],ArrayList<Integer>list) {
		if(list.size()==arr.length) {
			ans.add(new ArrayList<Integer>(list));
			return;
		}
		for(int i=0;i<arr.length;i++) {
			if(list.contains(arr[i])) continue;
			list.add(arr[i]);
			permute(arr, list);
			list.removeLast();
		}
	}
	public static void swap(int arr[],int i,int j) {
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
}
