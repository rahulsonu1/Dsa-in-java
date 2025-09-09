package dp;

public class CoinChange {

	public static void main(String[] args) {
		int arr[]= {1,2,5,6};
		int target=11;
		System.out.println(coin(arr, target, arr.length-1));
	}
	public static int coin(int arr[],int target ,int n) {
		if(target==0) {
			return 0;
		}
		if(n==0) {
			return arr[0];
		}
		
		if(arr[n]>target) {
			return coin(arr,target,n-1);
		}
		int include=(target/arr[n])+coin(arr, target%arr[n], n-1);
		int exclude=coin(arr, target, n-1);
		int ans=Math.min(include, exclude);
		return ans;
	}

}
