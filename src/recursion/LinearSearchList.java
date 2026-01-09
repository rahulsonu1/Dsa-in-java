package recursion;

import java.util.ArrayList;

public class LinearSearchList {

	public static void main(String[] args) {
		int arr[]= {1,2,5,3,5,63,53,6,8,5};
		int end=arr.length-1;
		int target=5;
		System.out.println(search(arr,0,target));

	}
	public static ArrayList<Integer> search(int arr[],int si,int target){
		if(si==arr.length) {
			return new ArrayList<Integer>();
		}
		ArrayList<Integer>list=new ArrayList<>();
		if(arr[si]==target) list.add(si);
		ArrayList<Integer> lowerList=search(arr,si+1,target);
		list.addAll(lowerList);
		return list;
		
	}

}
