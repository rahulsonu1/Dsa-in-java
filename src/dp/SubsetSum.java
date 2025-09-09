package dp;

public class SubsetSum {

	public static void main(String[] args) {
		int arr[]= {4,2,5,6,7};
		System.out.println(isPresent(arr, 0, 14));
	}
	public static boolean isPresent(int arr[],int i,int sum) {
		if(i==arr.length) {
			return false;
		}
		if(sum==0) {
			return true;
		}
		Boolean include=isPresent(arr, i+1, sum-arr[i]);
		Boolean exclude=isPresent(arr, i+1, sum);
		if(include || exclude) {
			return true;
		}
		return false;
		
	}

}
