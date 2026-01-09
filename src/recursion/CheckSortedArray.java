package recursion;

public class CheckSortedArray {

	public static void main(String[] args) {
		int arr[]= {1,2,4,5,8,23,43};
		int end=arr.length-1;
		int start=0;
		System.out.println(isSorted(arr, start, end));

	}
	public static boolean isSorted(int arr[],int start,int end) {
		if(start==end) {
			return true ;
		}
		if(arr[start]>arr[start+1]) {
			return false;
		}
		return isSorted(arr, start+1, end);
		
	}

}
