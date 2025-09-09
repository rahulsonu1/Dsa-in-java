package arrays;

public class MinimiseMaxiumStore {

	public static void main(String[] args) {
		int arr[]= {11,6};
		int n=6;
		int max=arr[0];
		for(int i=0;i<arr.length;i++) {
			max=Math.max(max, arr[i]);
		}
		int low=0;
		int high=max;
		int ans=low;
		while(low<=high) {
			int mid=(low+high)/2;
			if(isPossible(arr, n, mid)) {
				high=mid-1;
				ans=mid;
			}else {
				low=mid+1;
			}
		}
		System.out.println(ans);

	}
	public static boolean isPossible(int arr[],int n,int mid) {
		int j=0;
		int remaining=arr[j];
		for(int i=0;i<n;i++) {
			if(remaining<=mid) {
				j++;
				if(j==arr.length) {
					return true;
				}else {
					remaining=arr[j];
				}
			}else {
				remaining=remaining-mid;
			}
		}
		return false;
	}

}
