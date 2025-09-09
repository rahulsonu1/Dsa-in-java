package dp;

import java.util.Arrays;

public class LeastComSeq {

	public static void main(String[] args) {
		String a="sea";
		String b="eat";
		int arr[][]=new int[a.length()+1][b.length()+1];
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[0].length;j++) {
				arr[i][j]=-1;
			}
		}
//		int length=a.length()+b.length();
//		int ans=lcs(a,b,0,0,arr);
//		System.out.println(length-2*ans);
//		System.out.println(ans);
		System.out.println(lcsI(a, b));

	}
	public static int lcsI(String a,String b) {
		if(a.length()==0||b.length()==0) {
			return 0;
		}
		int m=a.length();
		int n=b.length();
		int arr[][]=new int[m+1][n+1];
		for(int row[]:arr) {
			Arrays.fill(row,0);
		}
		for(int i=m-1;i>=0;i--) {
			for(int j=n-1;j>=0;j--) {
				int ans=0;
				if(a.charAt(i)==b.charAt(j)) {
					ans=1+arr[i+1][j+1];
				}
				else {
					ans=Math.max(arr[i+1][j],arr[i][j+1]);
				}
				arr[i][j]=ans;
			}
		}
		return arr[0][0];
	}
	
	
	
	public static int lcs(String a ,String b,int i,int j,int arr[][]) {
		if(a.length()==i||b.length()==j) {
			return 0;
		}
		int ans;
		if(a.charAt(i)==b.charAt(j)) {
			int smallAns;
			if(arr[i+1][j+1]==-1) {
				smallAns=lcs(a, b, i+1, j+1, arr);
				arr[i+1][j+1]=smallAns;
			}else {
				smallAns=arr[i+1][j+1];
			}
			ans=1+smallAns;
		}
		else {
			int smallAns1,smallAns2;
			if(arr[i][j+1]==-1) {
				smallAns1=lcs(a,b,i,j+1,arr);
				arr[i][j+1]=smallAns1;
			}else {
				smallAns1=arr[i][j+1];
			}
			if(arr[i+1][j]==-1) {
				smallAns2=lcs(a, b, i+1, j, arr);
				arr[i+1][j]=smallAns2;
			}else {
				smallAns2=arr[i+1][j];
			}
			ans=Math.max(smallAns1, smallAns2);
		}
		return ans;
		
	}

}
