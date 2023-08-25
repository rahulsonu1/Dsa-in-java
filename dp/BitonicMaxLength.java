package dp;

public class BitonicMaxLength {

	public static void main(String[] args) {
		int arr[]= {1,11,2,10,4,5,2,1};
		System.out.println(maxbi(arr));
	}
	public static int maxbi(int arr[]) {
		int n=arr.length;
		int ans1[]=new int[n];
		int ans2[]=new int[n];
		ans1[0]=1;
		ans2[n-1]=1;

		for(int i=1;i<n;i++) {
			ans1[i]=1;
			for(int j=i-1;j>=0;j--) {
				if(arr[i]>arr[j]) {
					int small=ans1[j]+1;
					ans1[i]=Math.max(small,ans1[i]);
					
				}
			}
		}
			for(int i=n-2;i>=0;i--) {
				ans2[i]=1;
				for(int j=i+1;j<n;j++) {
					if(arr[i]>arr[j]) {
						int small=ans2[j]+1;
						ans2[i]=Math.max(ans2[i],small);
					
					}
				}
			}
			int max=ans1[0]+ans2[0]-1;
			for(int i=1;i<n;i++) {
				max=Math.max(max, ans1[i]+ans2[i]-1);
			}
			return max;
			
	
	
		
	}

}
