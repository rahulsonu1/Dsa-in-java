package dp;

public class MinimumDeletionSort {

	public static void main(String[] args) {
		int arr[]= {13,0,14,7,18,18,18,16,8,15,20};
		int ans=minDel(arr);
		System.out.println(arr.length-ans);
	}
	public static int minDel(int arr[]) {
		int n=arr.length;
		int ans[]=new int[n];
		ans[0]=1;
		int max=1;
		for(int i=1;i<n;i++) {
			ans[i]=1;
			for(int j=i-1;j>=0;j--) {
				if(arr[i]>=arr[j]) {
					int small=ans[j]+1;
					ans[i]=Math.max(small, ans[i]);
					max=Math.max(max,ans[i]);
				}
			}
		}
		return max;
	}

}
