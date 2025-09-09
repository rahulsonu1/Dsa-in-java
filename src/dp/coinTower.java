package dp;

import java.util.Arrays;

public class coinTower {

	public static void main(String[] args) {
		int n=10,x=2,y=4;
		boolean arr[]=new boolean[n+1];
		Arrays.fill(arr, false);
		System.out.println(coin(n,x,y));
	}
	public static int coin(int n,int x,int y) {
		if(n==1||n==x||n==y) {
			return 1;
		}
		int ans1=coin(n-1,x,y);
		int ans2=0,ans3=0;
		if(n>=x) {
			ans2=coin(n-x,x,y);
		}
		if(n>=y) {
			ans3=coin(n-y,x,y);
		}
		return (ans1 & ans2 & ans3);
	}


}
