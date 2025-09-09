package dp;

public class MaximumCut {

	public static void main(String[] args) {
		int n=5,a=1,b=2,c=3;
		int arr[]=new int[n+1];
		for(int i=0;i<arr.length;i++) {
			arr[i]=-1;
		}
		System.out.println(maxCut(n, a, b, c,arr,0));

	}
	public static int maxCut(int n,int a,int b,int c,int arr[],int i) {
		if(n<0) {
			return -1;
		}
		if(n==0 ||i==arr.length) {
			return 0;
		}
		int x=Integer.MIN_VALUE;
		int y=Integer.MIN_VALUE;
		int z=Integer.MIN_VALUE;
		if(i-a>=0) {
			if(arr[i-a]==-1) {
				x=maxCut(n, a, b, c, arr, i-a);
				arr[i-a]=x;
			}else {
				x=arr[i-a];
			}
		}
		if(i-b>=0) {
			if(arr[i-b]==-1) {
				y=maxCut(n, a, b, c, arr, i-b);
				arr[i-b]=y;
			}else {
				y=arr[i-b];
			}
		}
		if(i-c>=0) {
			if(arr[i-c]==-1) {
				z=maxCut(n, a, b, c, arr, i-c);
				arr[i-c]=z;
			}
			else {
				z=arr[i-c];
			}
		}
		int ans=Math.max(x, Math.max(y,z));
		if(ans==-1) {
			arr[i]=-1;
		}
		arr[i]=1+ans;
		return arr[i];
		
	}

}
