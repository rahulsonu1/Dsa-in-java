package dp;

public class CherryPickup {

	public static void main(String[] args) {
		int arr[][]= {{0,1,-1},{1,0,-1},{1,1,1}};
		System.out.println(maxCherry(arr, 0, 0));

	}
	public static int maxCherry(int arr[][],int i,int j) {
		if(i>=arr.length||j>=arr[i].length|| arr[i][j]==-1) return Integer.MIN_VALUE;
		if(i==arr.length-1 && j==arr[i].length-1) {
			int val=arr[i][j];
			arr[i][j]=0;
			return val;
			}
		
		int bottom=maxCherry(arr,i+1,j);
		int right=maxCherry(arr,i,j+1);
		int val=arr[i][j];
		arr[i][j]=0;
		return val+Math.max(right, bottom);
		
	}
	public static int maxUp(int arr[][],int i,int j) {
		if(i<0||j<0||arr[i][j]==-1) return Integer.MIN_VALUE;
		if(i==0 && j==0) return arr[i][j];
		
		int top=maxUp(arr, i-1, j);
		int left=maxUp(arr,i,j-1);
		int val=arr[i][j];
		arr[i][j]=0;
		return val+Math.max(left,top);
	}

}
