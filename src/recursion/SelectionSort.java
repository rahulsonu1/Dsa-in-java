package recursion;

import java.util.Arrays;

public class SelectionSort {

	public static void main(String[] args) {
		int arr[]= {1,2,54,6,78,34};
		selection(arr,0,0,0);
		System.out.println(Arrays.toString(arr));

	}
	public static void selection(int arr[],int minI,int si,int n) {
		if(n==arr.length) {
			return ;
		}
		if(si==arr.length) {
			int temp=arr[n];
			arr[n]=arr[minI];
			arr[minI]=temp;
			selection(arr,n+1,n+1,n+1);
			return ;
			
		}
		if(si<arr.length && arr[si]<arr[minI]) {
			minI=si;
		}
		selection(arr,minI,si+1,n);
	}

}
