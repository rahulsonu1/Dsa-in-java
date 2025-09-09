package dp;

public class MinChocolate {

	public static void main(String[] args) {
		int arr[]= {1,0,2};
		int n=arr.length;
		int left[]=new int[n];
		left[0]=1;
		for(int i=1;i<n;i++) {
			if(arr[i-1]<arr[i]) {
				left[i]=left[i-1]+1;
			}else {
				left[i]=1;
			}
		}
		int sum=0;
		sum=sum+left[n-1];
		for(int i=n-2;i>=0;i--) {
			if(arr[i]>arr[i+1] && left[i]<=left[i+1]) {
				left[i]=left[i+1]+1;
			}
			sum=sum+left[i];
		}
		System.out.println(sum);
			

	}
	

}
