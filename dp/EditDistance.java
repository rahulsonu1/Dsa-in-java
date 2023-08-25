package dp;

import java.util.Arrays;

public class EditDistance {

	public static void main(String[] args) {
		String a="sea";
		String b="eat";
		int arr[][]=new int[a.length()+1][b.length()+1];
		for(int row[]:arr) {
			Arrays.fill(row, -1);
		}
		System.out.println(edit(a,b,arr));
		System.out.println(editI(a,b));
		
	}
	public static int editI(String a,String b) {
		int arr[][]=new int[a.length()+1][b.length()+1];
		
		int m=a.length(),n=b.length();
		for(int i=0;i<=m;i++) {
			for(int j=0;j<=n;j++) {
				if(i==0) {
					arr[i][j]=j;
				}
				else if(j==0) {
					arr[i][j]=i;
				}
				else if(a.charAt(i-1)==b.charAt(j-1)) {
					arr[i][j]=arr[i-1][j-1];
				}else {
					int re=arr[i-1][j];
					int ins=arr[i][j-1];
					int replace=arr[i-1][j-1];
					arr[i][j]=1+Math.min(re, Math.min(ins, replace));
					
				}
			}
		}
		return arr[m][n];
	}
	
	
	
	public static int edit(String a,String b,int arr[][]) {
		if(a.length()==0 && b.length()==0) {
			return 0;
		}
		if(a.length()==0) {
			return b.length();
		}
		if(b.length()==0) {
			return a.length();
		}
		int m=a.length();
		int n=b.length();
		if(arr[m][n]!=-1) {
			return arr[m][n];
		}
		if(a.charAt(0)==b.charAt(0)) {
			int small=edit(a.substring(1), b.substring(1), arr);
			arr[m-1][n-1]=small;
			arr[m][n]=small;
		}else {
			int remove=edit(a.substring(1),b,arr);
			arr[m-1][n]=remove;
			int insert=edit(a,b.substring(1),arr);
			arr[m][n-1]=insert;
			int replace=edit(a.substring(1),b.substring(1),arr);
			arr[m-1][n-1]=replace;
			arr[m][n]=1+Math.min(remove,Math.min(replace, insert));
		}
		return arr[m][n];
		
	}

}
