package arrays;

import java.util.Stack;

public class NextGreater2 {

	public static void main(String[] args) {
		int arr[]= {1,2,3,4,3};
		int n=arr.length;
		int ans[]=new int[n];
		
		Stack<Integer>stack=new Stack<>();
		for(int i=2*n-1;i>=0;i--) {
			int curr=i%n;
			while(!stack.isEmpty() && stack.peek()<=arr[curr]) {
				stack.pop();
			}
			if(i<n) {
				ans[i]=!stack.isEmpty()?stack.peek():-1;
			}
			stack.push(arr[curr]);
		}
		for(int i=0;i<n;i++) {
			System.out.println(ans[i]);
		}
		
	}

}
