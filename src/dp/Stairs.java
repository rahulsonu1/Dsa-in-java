package dp;

public class Stairs {

	public static void main(String[] args) {
		int n=0;
		int arr[]=new int[n+1];
		System.out.println(staircase(n, arr));
		

	}
	public static int staircase(int n,int arr[]) {
		if(n==0) {
			return 1;
		}
		if(n==1||n==2) {
			return n;
		}
		int ans1,ans2,ans3;
		if(arr[n-1]==0) {
			ans1=staircase(n-1, arr);
			arr[n-1]=ans1;
		}
		else {
			ans1=arr[n-1];
		}
		if(arr[n-2]==0) {
			ans2=staircase(n-2, arr);
			arr[n-2]=ans2;
		}
		else {
			ans2=arr[n-2];
		}
		if(arr[n-3]==0) {
			ans3=staircase(n-3, arr);
			arr[n-3]=ans3;
		}
		else {
			ans3=arr[n-3];
		}
		return ans1+ans2+ans3;
	}

}
