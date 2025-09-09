package PrQueueHeap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class InBuiltPQ {
	public static ArrayList<Integer> kLargest(int arr[],int k){
		ArrayList<Integer> list=new ArrayList<>();
		PriorityQueue<Integer> pq=new PriorityQueue<Integer>();
		for(int i=0;i<k;i++) {
			pq.add(arr[i]);
		}
		for(int i=k;i<arr.length;i++) {
			if(arr[i]>pq.peek()) {
				pq.poll();
				pq.add(arr[i]);
		}
	}
		while(!pq.isEmpty()) {
			list.add(pq.remove());
		}
		return list;
	}
	
	public static boolean checkHeap(int arr[]) {
		int n=arr.length;
		if(n==1) {
			return true;
		}
		int parentIndex=0;
		int leftChildIndex=2*parentIndex+1;
		int rightChildIndex=2*parentIndex+2;
		while(leftChildIndex<arr.length) {
			if(leftChildIndex<n && arr[leftChildIndex]>arr[parentIndex]) {
				return false;
			}
			else if(rightChildIndex<n && arr[rightChildIndex]>arr[parentIndex]) {
				return false;
			}
			parentIndex=leftChildIndex;
			leftChildIndex=2*parentIndex+1;
			rightChildIndex=2*parentIndex+2;
		}
		return true;
	}
	
	public static int ticketTime(int arr[],int k) {
		int n=arr.length;
		Queue<Integer> q=new LinkedList<>();
		PriorityQueue<Integer> pq=new PriorityQueue<Integer>( Collections.reverseOrder());
		for(int i=0;i<n;i++) {
			pq.add(arr[i]);
			q.add(i);
		}
		int time=0;
		while(!pq.isEmpty()) {
			
			int element=q.poll();

			if(arr[element]<pq.peek()) {
				q.add(element);
			}
			else if(arr[element]==pq.peek()&& element==k) {
				time++;
				pq.poll();
				return time;
			}
			else if(arr[element]==pq.peek()) {
				time++;
				pq.poll();
			}
		}
		return time;
		
	}
	
	public static ArrayList<Integer> mergeKsortedArray(ArrayList<ArrayList<Integer>> arrlist){
		ArrayList<Integer>list =new ArrayList<>();
		PriorityQueue<mergeKReturn> pq=new PriorityQueue<>();
		for(int i=0;i<arrlist.size();i++) {
			mergeKReturn index=new mergeKReturn(arrlist.get(i).get(0),0,i);
			pq.add(index);
	}
		System.out.println(pq);
		while(!pq.isEmpty()) {
			mergeKReturn ans=pq.poll();
			int value=ans.value;
			int indexInArray=ans.vInArray;
			int posOfArray=ans.posArray;
			list.add(value);
			if(indexInArray+1<arrlist.get(posOfArray).size()) {
				mergeKReturn index=new mergeKReturn(arrlist.get(posOfArray).get(indexInArray+1),indexInArray+1,posOfArray);
				pq.add(index);
			}
			
		}
		return list;
	}
	
	public static int kSmallest(int arr[],int k) {
		PriorityQueue<Integer>pq=new PriorityQueue<>();
		for(int i=0;i<arr.length;i++) {
			pq.add(arr[i]);
		}
		int i=1;
		while(!pq.isEmpty() && i<k) {
			pq.poll();
			i++;
		}
		return pq.peek();
	}
	
	public static ArrayList<Integer> mergeKArray(int arr[][],int k){
		PriorityQueue<MergeKArray> pq=new PriorityQueue<>();
		ArrayList<Integer> list=new ArrayList<Integer>();
		for(int i=0;i<k;i++) {
			pq.add(new MergeKArray(arr[i][0],0, i));
		}
		while(!pq.isEmpty()) {
			MergeKArray ans=pq.poll();
			int value=ans.value;
			int Vindex=ans.posInArray;
			int Aindex=ans.posOfArray;
			list.add(value);
			if(Vindex+1<k) {
				pq.add(new MergeKArray(arr[Aindex][Vindex+1], Vindex+1, Aindex));
			}
			
		}
		return list;
	}
	
	public static void main(String[] args) {
		int arr[]= {7,10,4,3,20, 15};
		int a[][]={{1,2,3},{4,5,6},{7,8,9}};
//		ArrayList<ArrayList<Integer>> arrList=new ArrayList<ArrayList<Integer>>();
//		ArrayList<Integer> a=new ArrayList<Integer>();
//		a.add(3);a.add(5);a.add(9);
//		ArrayList<Integer> b=new ArrayList<Integer>();
//		b.add(1);b.add(2);b.add(3);b.add(8);
//		arrList.add(a);arrList.add(b);
		
		
//		System.out.println(kLargest(arr, 2));
//		System.out.println(checkHeap(arr));
//		System.out.println(ticketTime(arr, 3));
//		System.out.println(mergeKsortedArray(arrList));
//		System.out.println(kSmallest(arr, 3));
		System.out.println(mergeKArray(a, 3));
		
	}

}
