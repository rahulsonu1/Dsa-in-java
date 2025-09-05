package arrays;

public class AllocatePages {

	public static void main(String[] args) {
		int arr[]= {12, 34, 67, 90};
		int k=2;
		int max=arr[0];
		int sum=0;
		for(int i=0;i<arr.length;i++) {
			max=Math.max(max,arr[i]);
			sum=sum+arr[i];
		}
		int low=max;
		int high=sum;
		int ans=high;
		while(low<=high) {
			int mid=(low+high)/2;
			int result=isPossible(arr, mid);
			ans=mid;
			if(result>k) {
				low=mid+1;
			}else {
				high=mid-1;
			}
		}System.out.println(ans);

	}
	public static int isPossible(int arr[],int max) {
		int s=1,page=0;
		for(int i=0;i<arr.length;i++) {
			if(page+arr[i]>max) {
				s++;
				page=arr[i];
			}else {
				page=page+arr[i];
			}
		}
//		System.out.println(s);
		return s;
	}

}
