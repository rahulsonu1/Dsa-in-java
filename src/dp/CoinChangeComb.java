package dp;

public class CoinChangeComb {

	public static void main(String[] args) {
		int arr[]= {1,2,3};
		int target=5;
		int ans[][]=new int[arr.length+1][target+1];
		for(int i=0;i<ans.length;i++) {
			for(int j=0;j<ans[0].length;j++) {
				ans[i][j]=-1;
			}
		}
		
		System.out.println(comb(arr, target, 0,ans));
		System.out.println(combI(arr, target));
	}
	public static int combI(int arr[],int target) {
		int n=arr.length;
		int ans[][]=new int[target+1][n+1];
		for(int i=0;i<=n;i++) {
			ans[0][i]=1;
		}
		for(int i=1;i<=target;i++){
			ans[i][0]=0;
		}
		
		for(int i=1;i<=target;i++) {
			for(int j=1;j<=n;j++) {
				ans[i][j]=ans[i][j-1];
				if(arr[j-1]<=i) {
					ans[i][j]+=ans[i-arr[j-1]][j];
				}
			}
		}
		return ans[target][n];
	
	}
	
	public static int comb(int arr[],int target,int i,int ans[][]) {
		if(target==0) {
			return 1;
		}
		if(i==arr.length || target<0) {
			return 0;
		}
		if(ans[i][target]!=-1) {
			return ans[i][target];
		}
		if(arr[i]>target) {
			return comb(arr, target, i+1,ans);
		}
		int include,exclude;
		if(ans[i][target-arr[i]]!=-1) {
			include=ans[i][target-arr[i]];
		}
		else {
			 include=comb(arr, target-arr[i], i, ans);
			ans[i][target-arr[i]]=include;
			
		}
		if(ans[i+1][target]!=-1) {
			exclude=ans[i+1][target];
		}else {
			exclude=comb(arr, target, i+1, ans);
			ans[i+1][target]=exclude;
		}
		ans[i][target]=exclude+include;
		return ans[i][target];
	}

}
