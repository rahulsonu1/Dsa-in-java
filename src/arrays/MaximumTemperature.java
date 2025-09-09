package arrays;

public class MaximumTemperature {

	public static void main(String[] args) {
		int arr[]= {73,74,75,71,69,72,76,73};
		int n=arr.length;
		int ans[]=new int[n];
		ans[n-1]=0;
		int max=n-1;
		for(int i=n-2;i>=0;i--) {
			if(arr[i]>arr[max]) {
				ans[i]=0;
				max=i;
			}else {
				ans[i]=max-i;
			}
		}
		for(int i=0;i<n;i++) {
			System.out.print(ans[i]+" ");
		}

	}

}
