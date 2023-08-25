package dp;

public class MagicGrid {

	public static void main(String[] args) {
		int arr[][]= {{0,1,-3},{1,-2,0}};
		System.out.println(magic(arr, 0, 0));
		

	}
	public static int magic(int arr[][],int i,int j) {
		if(i>=arr.length|| j>=arr[0].length) {
			return 0;
		}
		int m=arr.length;
		int n=arr[0].length;
		if(i==m-1 && j==n-1) {
			return 1;
		}
		if(i<m && j+1<n) {
			int right=magic(arr,i,j+1)-arr[i][j+1];
		}
		if(i+1<)
		int down=magic(arr, i+1, j)-arr[i+1][j];
		int need=Math.min(right, down);
		if(need<=0) {
			need=1;
		}
		return need;
	}

}
