package dp;



public class MinCost {

	public static void main(String[] args) {
		int arr[][]= {{2,4,6},
				      {5,7,8}};
		int ans[][]=new int[arr.length+1][arr[0].length+1];
		for(int i=0;i<arr.length+1;i++) {
			for(int j=0;j<arr[0].length+1;j++) {
				ans[i][j]=-1;
			}
		}
		System.out.println(minC(0, 0, arr,ans));
		System.out.println(minCI(arr));
		
	}
	public static int minCI(int arr[][]) {
		int m=arr.length;
		int n=arr[0].length;
		int ans[][]=new int[m+1][n+1];
		for(int i=0;i<ans.length;i++) {
			for(int j=0;j<ans[0].length;j++) {
				ans[i][j]=Integer.MAX_VALUE;
			}
		}
		for(int i=m-1;i>=0;i--) {
			for(int j=n-1;j>=0;j--) {
				if(i==m-1 && j==n-1) {
					ans[i][j]=arr[i][j];
					continue;
				}
				int right=ans[i][j+1];
				int diagonal=ans[i+1][j+1];
				int down=ans[i+1][j];
				ans[i][j]=arr[i][j]+Math.min(right,Math.min(diagonal, down));
			}
		}
		return ans[0][0];
	}
	
	
	
	
	public static int minC(int i,int j,int arr[][],int ans[][]) {
		int m=arr.length-1;
		int n=arr[0].length-1;
		if(i>m ||j>n) {
			return Integer.MAX_VALUE;
		}
		if(i==m && j==n) {
			return arr[i][j];
		}
		int right;
		
			if(ans[i][j+1]!=-1) {
				right=ans[i][j+1];
			
			}
			else {
				right=minC(i, j+1, arr,ans);
				ans[i][j+1]=right;
			}
		
		int diagonal;
		
			if(ans[i+1][j+1]!=-1) {
				diagonal=ans[i+1][j+1];
			
			}
			else {
				diagonal=minC(i+1, j+1, arr,ans);
				ans[i+1][j+1]=diagonal;
			}

		int down;
		
			if(ans[i+1][j]!=-1) {
				down=ans[i+1][j];

			}else {
				down=minC(i+1, j, arr,ans);
				ans[i+1][j]=down;
			}

		return arr[i][j]+Math.min(right,down);
	}

}
