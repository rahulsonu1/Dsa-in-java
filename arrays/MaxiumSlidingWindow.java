package arrays;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaxiumSlidingWindow {

	public static void main(String[] args) {
		int arr[]= {1,3,1,2,0,5};
		int k=3;
		Deque<Integer>dq=new ArrayDeque<>();
		int n=arr.length;
		int ans[]=new int[n-k+1];
		for(int i=0;i<n;i++) {
			if(!dq.isEmpty() && dq.peekFirst()<=i-k) {
				dq.pollFirst();
			}
			while(!dq.isEmpty() && arr[dq.peekLast()]<arr[i]) {
				dq.pollLast();
			}
			dq.offer(i);
			if(i>=k-1) {
				ans[i-k+1]=arr[dq.peekFirst()];
			}
		}
		for(int i=0;i<ans.length;i++) {
			System.out.print(ans[i]+" ");
		}

	}

}
