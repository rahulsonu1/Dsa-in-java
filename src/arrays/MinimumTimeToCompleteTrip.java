package arrays;

public class MinimumTimeToCompleteTrip {

	public static void main(String[] args) {
		int arr[]= {1,2,3};
		int trip=5;
		int min=arr[0];
		for(int i=0;i<arr.length;i++) {
			min=Math.min(min,arr[i]);
		}
		int low=1;
		int high=min*trip;
		while(low<=high) {
			int mid=(low+high)/2;
			int res=tripCount(arr, mid);
			if(res>=trip) {
				high=mid-1;
			}else {
				
				low=mid+1;
			}
		}
		System.out.println(high);

	}
	public static int tripCount(int arr[],int time) {
		int count=0;
		for(int i=0;i<arr.length;i++) {
				count=count+(time/arr[i]);
		}
		return count;
	}

}
