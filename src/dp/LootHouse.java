package dp;

import java.util.Arrays;

public class LootHouse {

	public static void main(String[] args) {
		int arr[]= {2,7,9,3,1};
		int ans[]=new int[arr.length+1];
		Arrays.fill(ans,-1);
//		System.out.println(loot(arr,0,ans));
		System.out.println(lootI(arr));
	}
	public static int lootI(int arr[]) {
		if(arr.length==1) {
			return arr[0];
		}
		int ans[]=new int[arr.length];
		ans[0]=arr[0];
		ans[1]=Math.max(arr[1],arr[0]);
		for(int i=2;i<arr.length;i++) {
			ans[i]=Math.max(arr[i]+ans[i-2],arr[i-1]);
		}
		return ans[arr.length-1];
	}
	
	public static int loot(int arr[],int si,int ans[]) {
		if(si>=arr.length) {
			return 0;
		}
		if(ans[si]!=-1) {
			return ans[si];
		}
		int a1=arr[si]+loot(arr,si+2,ans);
		int a2=loot(arr,si+1,ans);
		ans[si]=Math.max(a1,a2);
		return ans[si];
	}
	

}
