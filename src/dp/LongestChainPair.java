package dp;

import java.util.Arrays;

public class LongestChainPair {

	public static void main(String[] args) {
		int arr[][]= {{1,2},{2,7},{3,4}};
		int n=arr.length;
		Arrays.sort(arr,(a,b)->a[0]-b[0]);
		int ans[]=new int[n];
		ans[0]=1;
		int max=1;
		for(int i=1;i<n;i++) {
			 ans[i]=1;
			for(int j=i-1;j>=0;j--) {
				if(arr[i][0]>arr[j][1]) {
					int small=ans[j]+1;
					ans[i]=Math.max(small, ans[i]);
					max=Math.max(ans[i], small);
				}
			}
			
		}
		System.out.println(max);

	}

}
