package dp;

public class SmallestSuperSeq {

	public static void main(String[] args) {
		String a="ab";
		String b="ac";
//		int arr[][]=new int[a.length()+1][b.length()+1];
//		for(int i=0;i<arr.length;i++) {
//			for(int j=0;j<arr[0].length;j++) {
//				arr[i][j]=-1;
//			}
//		}
//		System.out.println(superSeq(a, b,arr,a.length(),b.length()));
//		System.out.println(superSeqI(a, b));
		
		
	}
	public static int superSeqI(String a,String b) {
		int m=a.length();
		int n=b.length();
		int ans[][]=new int[m+1][n+1];
		for(int i=0;i<=m;i++) {
			for(int j=0;j<=n;j++) {
				if(i==0) {
					ans[i][j]=j;
				}
				else if(j==0) {
					ans[i][j]=i;
				}
				else if(a.charAt(i-1)==b.charAt(j-1)) {
					ans[i][j]=1+ans[i-1][j-1];
				}
				else {
					ans[i][j]=1+Math.min(ans[i-1][j],ans[i][j-1]);
				}
			}
		}
		return ans[m][n];
	}
	
	
	
	
	public static int superSeq(String a,String b,int arr[][],int m,int n) {
		if(m==0 && n==0) {
			return 0;
		}
		if(m==0) {
			return n;
		}
		if(n==0) {
			return m;
		}
		if(arr[m][n]!=-1) {
			return arr[m][n];
		}
		if(a.charAt(m-1)==b.charAt(n-1)) {
			int small=superSeq(a, b, arr, m-1, n-1);
			arr[m-1][n-1]=small;
			arr[m][n]=small;
		}else {
			int s1,s2;
			if(arr[m-1][n]!=-1) {
				s1=arr[m-1][n-1];
			}else {
				s1=superSeq(a, b, arr, m-1, n);
				arr[m-1][n]=s1;
			}
			if(arr[m][n-1]!=-1) {
				s2=arr[m][n-1];
			}
			else {
				s2=superSeq(a, b, arr, m, n-1);
				arr[m][n-1]=s2;
						
			}
			arr[m][n]=1+Math.min(s1, s2);
		}
		
		
		return arr[m][n];
	}

}
