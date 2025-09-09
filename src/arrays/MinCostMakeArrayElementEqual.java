package arrays;

public class MinCostMakeArrayElementEqual {

	public static void main(String[] args) {
		int arr[]= {2,2,2,2,2};
		int cost[]= {4,2,8,1,3};
		int min=Integer.MAX_VALUE;
		int max=Integer.MIN_VALUE;
		for(int i=0;i<arr.length;i++) {
			min=Math.min(min, arr[i]);
			max=Math.max(max, arr[i]);
		}
		int ans=max;
		while(min<=max) {
			int mid=(min+max)/2;
			int value=minArray(arr,mid,cost);
			int value1=minArray(arr,mid-1,cost);
			if(value<value1) {
				ans=value; 
				min=mid+1;
			}else {
				ans=value1;
				max=mid-1;
			}
		}
		System.out.println(ans);

	}
	public static int minArray(int arr[],int mid,int cost[]) {
		int sum=0;
		for(int i=0;i<arr.length;i++) {
			sum=sum+(Math.abs(arr[i]-mid)*cost[i]);
		}
		return sum;
	}

}
