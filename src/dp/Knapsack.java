package dp;

public class Knapsack {

	public static void main(String[] args) {
		int weight[]={10,20,30};
		int profit[]= { 60, 100, 120 };
		int W=50;
//		System.out.println(knapsack(W, weight, profit, 0));
		System.out.println(knapSackI(W, weight, profit));

	}
	public static int knapSackI(int w,int weight[],int profit[]) {
		int n=weight.length;
		int arr[][]=new int[n+1][w+1];
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=w;j++) {
				if(j==0||i==0) {
					arr[i][j]=0;
					continue;
				}
				int ans;
				if(weight[i]<=j) {
					int include=profit[i]+arr[i-1][j-weight[i]];
					int exlude=arr[i-1][j];
					ans=Math.max(include, exlude);
				}
				else {
					ans=arr[i-1][j];
				}
				arr[i][j]=ans;
		}
		
	}
		return arr[n][w];
	}
	
	
	public static int knapsack(int w,int weight[],int profit[],int i) {
		if(i>=weight.length) {
			return 0;
		}
		if(w<weight[i]) {
			return knapsack(w, weight, profit, i+1);
		}
		int include=profit[i]+knapsack(w-weight[i], weight, profit, i+1);
		int exclude=knapsack(w, weight, profit, i+1);
		return Math.max(include, exclude);
	}

}
