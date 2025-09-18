package greedy;

import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;

import PrQueueHeap.Priority_Queue;

public class ReduceArray {

	public static void main(String[] args) {

		int arr[]= {3,3,3,3,5,5,5,2,2,7};
		System.out.println(minSetSize(arr));

	}
	 public  static int minSetSize(int[] arr) {
		 int n=arr.length;
		 HashMap<Integer,Integer>map=new HashMap<>();
		 for(int i=0;i<n;i++) {
			 map.put(arr[i],map.getOrDefault(arr[i],0)+1);
		 }
		 PriorityQueue<Integer>pq=new PriorityQueue<>(Collections.reverseOrder());
		 for(int i:map.keySet()) {
			 pq.add(map.get(i));
		 }
		 int count=0;
		 int sumOfItem=0;
		 while(!pq.isEmpty() && sumOfItem<(n+1)/2) {
			 count++;
			 sumOfItem=sumOfItem+pq.peek();
			 pq.remove();
		 }
		 return count;
	        
	}

}
