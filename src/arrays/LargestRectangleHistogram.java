package arrays;
import java.util.*;
public class LargestRectangleHistogram {

	public static void main(String[] args) {
	
		int arr[]= {2,1,5,6,2,3};
		int ans1[]=prevSmaller(arr);
		int ans2[]=nextSmaller(arr);
		int ans=0;
		for(int i=0;i<arr.length;i++) {
			int width=Math.abs(ans1[i]-ans2[i]+1);
			int temp=width*arr[i];
			ans=Math.max(temp,ans);
		}
		System.out.println(ans);
	}
	public static int[] nextSmaller(int arr[]) {
		int n=arr.length;
		int ans[]=new int[n];
		Stack<Integer>stack=new Stack<>();
		for(int i=n-1;i>=0;i--) {
			
			while(!stack.isEmpty() && arr[stack.peek()]>=arr[i]) {
				stack.pop();
			}
			if(!stack.isEmpty()) {
				ans[i]=stack.peek();
			}else ans[i]=n;
			stack.push(i);
		}
		return ans;
	}
	
	public static int[] prevSmaller(int arr[]) {
		int n=arr.length;
		int ans[]=new int[n];
		Stack<Integer>stack=new Stack<>();
		for(int i=0;i<n;i++) {
			while(!stack.isEmpty() && arr[stack.peek()]>=arr[i]) {
				stack.pop();
			}
			if(!stack.isEmpty()) ans[i]=stack.peek();
			else ans[i]=-1;
			stack.push(i);
			
		}
		return ans;
	}

}
