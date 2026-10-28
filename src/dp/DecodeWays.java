package dp;

import java.util.Arrays;

public class DecodeWays {

	public static void main(String[] args) {
		String s="226";
		int n=s.length();
		int arr[]=new int[n+1];
		Arrays.fill(arr,-1);
		int ans=countWays(s,0,arr);
		System.out.println(ans);

	}
	public static int countWays(String s,int i,int arr[]) {
		
		if(i==s.length()) return 1;
		if(s.charAt(i)=='0') return 0;
		
		if(arr[i]!=-1) return arr[i];
		
		int one=countWays(s, i+1, arr);
		int two=0;
		if(s.length()-i>=2 && Integer.parseInt(s.substring(i,i+2))<=26) {
			two=countWays(s, i+2, arr);
			
		}
		return arr[i]=one+two;
		
		
//		if(s.length()==0) return 1;
//		
//		if(s.charAt(0)=='0') return 0;
//		
//		if(arr[i]!=-1) return arr[i];
//		
//		int one=countWays(s.substring(1), i,arr);
//		
//		int two=0;
//		if(s.length()>=2 && Integer.parseInt(s.substring(0,2))<=26) {
//			two=countWays(s.substring(2), i,arr);
//		}
//		return arr[i]=one+two;
	}

}
