package dp;

public class MinCoin {

	public static void main(String[] args) {
		int arr[]= {25,10,5};
		int value=30;
		System.err.println(minC(arr, value, 0));
	}
	public static int minC(int arr[],int value,int i) {
		if(i>=arr.length) {
			return 0;
		}
		if(value==0) {
			return 0;
		}
		if(arr[i]>value) {
			return minC(arr, value, i+1);		
		}
		int include=1+minC(arr, value-arr[i], i);
		int exclude=minC(arr, value, i+1);
		return Math.min(include, exclude);
	}

}
