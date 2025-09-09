package dp;

import java.util.Arrays;

public class LootHouse2 {

	public static void main(String[] args) {
		int arr[]= {1};
		int ans[]=new int[arr.length+1];
		Arrays.fill(ans, -1);
		int ans1=loot(arr,0,arr.length-2,ans);
		Arrays.fill(ans, -1);
		int ans2=loot(arr,1,arr.length-1,ans);
		System.out.println(ans1);
		System.out.println(ans2);
		

	}
	public static int loot(int arr[],int si,int n,int ans[]) {
		if(arr.length==1) {
			return arr[0];
		}
		if(si>n) {
			return 0;
		}
		if(ans[si]!=-1) {
			return ans[si];
		}
		int ans1=arr[si]+loot(arr,si+2,n,ans);
		int ans2=loot(arr,si+1,n,ans);
		ans[si]=Math.max(ans1, ans2);
		return ans[si];
	}

}
