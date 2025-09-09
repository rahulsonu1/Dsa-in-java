package dp;

public class ByteLand {

	public static void main(String[] args) {
		int n=12;
		int arr[]=new int[n+1];
		System.out.println(byteLandI(n));

	}
	public static int byteLandI(int n) {
		if(n<=0) {
			return 0;
		}
		
		int arr[]=new int[n+1];
		arr[0]=0;
		for(int i=1;i<=n;i++) {
			int ans1=arr[i/2];
			int ans2=arr[i/3];
			int ans3=arr[i/4];
			int ans=Math.max(i,ans1+ans2+ans3);
			arr[i]=ans;
		}
		return arr[n];
	}
	public static int byteland(int n,int arr[]) {
		if(n<=0) {
			return n;
		}
		int ans1,ans2,ans3;
		if(arr[n/2]==0) {
			ans1=byteland(n/2, arr);
			arr[n/2]=ans1;
		}else {
			ans1=arr[n/2];
		}
		if(arr[n/3]==0) {
			ans2=byteland(n/3, arr);
			arr[n/3]=ans2;
		}else {
			ans2=arr[n/3];
		}
		if(arr[n/4]==0) {
			ans3=byteland(n/4, arr);
			arr[n/4]=ans1;
		}else {
			ans3=arr[n/4];
		}
		return Math.max(n, ans1+ans2+ans3);
	}

}
