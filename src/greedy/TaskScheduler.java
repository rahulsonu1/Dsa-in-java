package greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class TaskScheduler {

	public static void main(String[] args) {
		char tasks[]= {'A','A','A','B','B','B'};
		int n=2;
//		System.out.println(usingHeap(tasks, n));
		System.out.println(usingmathematical(tasks, n));
		
	}
	public static int usingmathematical(char tasks[],int n) {
		int freq[]=new int[26];
		int taskLength=tasks.length;
		int max=0;
		for(int i=0;i<taskLength;i++) {
			freq[tasks[i]-'A']++;
			max=Math.max(max,freq[tasks[i]-'A']);
		}
		
		int count=0;
		for(int i=0;i<26;i++) {
			if(freq[i]==max) count++;
		}
		int maxTime=(max-1)*(n+1)+count;
		return Math.max(taskLength, maxTime);
		
		
		
		
		
	}
	public static int usingHeap(char tasks[],int n) {
		int freq[]=new int[26];
		for(int i=0;i<tasks.length;i++) {
			freq[tasks[i]-'A']++;
		}
		PriorityQueue<Integer>pq=new PriorityQueue<>(Collections.reverseOrder());
		for(int i=0;i<freq.length;i++) {
			if(freq[i]>0) pq.add(freq[i]);
		}
//		System.out.println(pq);
		
		int time=0;
		while(!pq.isEmpty()) {
			int cycle=n+1;
			 List<Integer> store = new ArrayList<>();
	         int taskCount = 0;
			while(cycle-->0 && !pq.isEmpty()) {
				int curr=pq.poll();
				if(curr>1) {
					store.add(curr-1);
				}
				taskCount++;
			}
			store.forEach(pq::offer);
			time=time+(pq.isEmpty()?taskCount:n+1);

		}
		return time;
		
	}

}
