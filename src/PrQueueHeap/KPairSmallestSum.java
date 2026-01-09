package PrQueueHeap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

public class KPairSmallestSum {

	public static void main(String[] args) {
		int arr1[]= {1,1,2};
		int arr2[]= {1,2,3};
		int k=3;
		kPair(arr1, arr2, k);

	}
	public static void kPair(int nums1[],int nums2[],int k) {
		int m=nums1.length;
		int n=nums2.length;
		PriorityQueue<int[]>pq=new PriorityQueue<>( Comparator.comparingInt(element -> element[0]));
		if(m>0 && n>0) {
			pq.add(new int[] {nums1[0]+nums2[0],0,0});
		}
		List<List<Integer>>list=new ArrayList<>();
		HashSet<String> set = new HashSet<>();
		set.add("0"+","+"0");
		while(!pq.isEmpty() && k>0) {
			int lastItem[]=pq.poll();
			int i=lastItem[1];
			int j=lastItem[2];
			list.add(Arrays.asList(nums1[i],nums2[j]));
			k--;
			if(i+1<m && set.add((i+1)+","+j)) {
				pq.add(new int[] {nums1[i+1]+nums2[j],i+1,j});

			}
			if(j+1<n && set.add(i+","+(j+1))) {
				pq.add(new int[] {nums1[i]+nums2[j+1],i,j+1});
			}
		
			
		}
		System.out.println(list);
		
	}

}
