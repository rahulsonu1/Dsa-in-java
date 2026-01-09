package recursion;

public class BubbleSort {

	public static void main(String[] args) {
		int arr[]= {1,2,54,6,78,34};
		bubble(arr, 0, arr.length);
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}

	}
	public static void bubble(int arr[],int si,int n) {
		if(n==0) {
			return ;
		}
		else if(si>=n) {
			bubble(arr,0,n-1);
			return ;
		}
		if(si+1<n && arr[si]>arr[si+1]) {
			int  temp=arr[si];
			arr[si]=arr[si+1];
			arr[si+1]=temp;
		}
		bubble(arr,si+1,n);
	}

}
