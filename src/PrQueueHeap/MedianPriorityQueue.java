package PrQueueHeap;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianPriorityQueue {
	private PriorityQueue<Integer>left;
	private PriorityQueue<Integer>right;
	
	public MedianPriorityQueue() {
		left=new PriorityQueue<Integer>(Collections.reverseOrder());
		right=new PriorityQueue<>();
	}
	public void add(int x) {
		if(!right.isEmpty() && x>right.peek()) {
			right.add(x);
		}else {
			left.add(x);
		}
		while(left.size()-right.size()>1) {
			int element=left.poll();
			right.add(element);
		}
		while(right.size()-left.size()>1) {
			int element=right.poll();
			left.add(element);
		}
		
		
	}
	public int size() {
		return left.size()+right.size();
	}
	
	public int peak() {
		if(size()==0) {
			return Integer.MIN_VALUE;
		}
		if(left.size()>=right.size()) {
			return left.peek();
		}
		return right.peek();
	}
	
	public void remove() {
		if(size()==0) {
			System.out.println("UnderFlow");
		}
		if(left.size()>=right.size()) {
			left.remove();
		}
		right.remove();
		
	}

	public static void main(String[] args) {
		MedianPriorityQueue pq=new MedianPriorityQueue();
		pq.add(34);
		pq.add(3);
		pq.add(435);
		pq.add(435453);
		pq.add(45);
		
		System.out.println(pq.peak());

	}

}
