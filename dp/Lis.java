package dp;

public class Lis {

	public static void main(String[] args) {
		int arr[]= {1,3,5,7,3,6,4};
		System.out.println(lis(arr));
		
	}
	public static int lis(int arr[]) {
		if(arr.length==0||arr.length==1) {
			return 1;
		}
		
		int output[]=new int[arr.length];
		output[0]=1;
		int max=1;
		for(int i=1;i<arr.length;i++) {
			output[i]=1;
			for(int j=i-1;j>=0;j--) {
				if(arr[j]>arr[i]) {
					continue;
				}
				int ans=output[j]+1;
				if(output[i]<ans) {
					output[i]=ans;
					max=Math.max(max, ans);
				}
			}
		}
		
		return max;
	}
}
