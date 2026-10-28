package dp;

import java.util.Arrays;

public class FrogJump {

	public static void main(String[] args) {
		int arr[]= {30, 20, 50, 10, 40};
		int n=arr.length;
		int dp[]=new int[n];
		Arrays.fill(dp, -1);
//		System.out.println(min(0, arr, dp));
		System.out.println(minI(arr));

	}
	static int min(int start,int [] height,int arr[]){
        if(start==height.length-1) return 0;
        int diff1=Integer.MAX_VALUE;
        int diff2=Integer.MAX_VALUE;
        if(arr[start]!=-1) return arr[start];
        if(start+1<height.length){
            diff1=Math.abs(height[start]-height[start+1])+min(start+1,height,arr);
        
        }
        if(start+2<height.length){
            diff2=Math.abs(height[start]-height[start+2])+min(start+2,height,arr);
        }
        int ans=Math.min(diff1,diff2);
        arr[start]=ans;
        return arr[start];
    }
	
	public static int minI(int arr[]) {
		int n=arr.length;
		int dp[]=new int[n];
		dp[0]=0;
		for(int i=1;i<n;i++) {
			int one=Math.abs(arr[i]-arr[i-1])+dp[i-1];
			int two=Integer.MAX_VALUE;
			if(i>1) {
			two = Math.abs(arr[i]-arr[i-2])+dp[i-2];}
			dp[i]=Math.min(one, two);
		}
		return dp[n-1];
	}

}
