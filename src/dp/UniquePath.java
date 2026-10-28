package dp;

import java.util.Arrays;

public class UniquePath {
	static int count=0;
	public static void main(String[] args) {
		int arr[][]=new int[3][7];
		int ans[][]=new int[arr.length+1][arr[0].length+1];
		for(int[] a:ans)
			Arrays.fill(a, -1);
			
		for(int i=0;i<ans.length;i++) {
			for(int j=0;j<ans[0].length;j++) {
				ans[i][j]=-1;
			}
		}
		System.out.println(path(arr,0,0,ans));
//		int p1=uniquePath(arr, 0, 0, arr.length,arr[0].length);
//		System.out.println(p1);
	}
	public static int uniquePath(int arr[][],int i,int j,int m, int n) {
		if(i>=m||j>=n) {
			return 0;
		}
		if(i==m-1 && j==n-1) {
			return 1;
		}
		int right=uniquePath(arr, i, j+1, m, n);
		int down=uniquePath(arr,i+1,j,m,n);
		return right+down;
		
	}
	
	
	
	
	
	
	
	
	public static int path(int arr[][],int i ,int j,int ans[][]) {
		int m=arr.length;
		int n=arr[0].length;
		if(i>=m ||j>=n) {
			return 0;
		}
		if(i==m-1 && j==n-1) {
			return 1;
		}
		if(ans[i][j]!=-1) {
			return ans[i][j];
		}
		int right,down;
		if(ans[i][j+1]!=-1) {
			right=ans[i][j+1];
		}else {
		   right=path(arr,i,j+1,ans);
		ans[i][j+1]=right;
		}
		if(ans[i+1][j]!=-1) {
			down=ans[i+1][j];
		}else {
		     down=path(arr,i+1,j,ans);
		     ans[i+1][j]=down;
		}
		ans[i][j]=down+right;
		return ans[i][j];
		
		}
		
	}


