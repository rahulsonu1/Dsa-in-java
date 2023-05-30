package dynamicPrograming;

public class fibonacci {
	
	public static int fibo(int n) {
		int arr[]=new int[n+1];
		int ans1,ans2;
		if(n==0||n==1) {
			return n;
		}
		if(arr[n-1]==0) {
			 ans1=fibo(n-1);
			arr[n-1]=ans1;
		}
		else {
			return arr[n-1];
		}
		if(arr[n-2]==0) {
			 ans2=fibo(n-2);
			arr[n-2]=ans2;
		}
		else {
			return arr[n-2];
		}
		return ans1+ans2;
	}
	public static int fiboI(int n) {
//		if(n==0||n==1) {
//			return  n;
//		}
		int arr[]=new int[n+1];
		arr[0]=0;
		arr[1]=1;
		for(int i=2;i<=n;i++) {
			arr[i]=(arr[i-1]+arr[i-2]);
		}
		return arr[n];
	}
	public static int stairCase(int n) {
		int arr[]=new int[n+1];
		if(n==1||n==2) {
			return n;
		}
		arr[1]=1;
		arr[2]=2;
		for(int i=3;i<=n;i++) {
			arr[i]=(arr[i-1])+(arr[i-2]);
			
		}
		return arr[n];
	}
	//Recursive
	public static int minSteptoOne(int n) {
		if(n==1) {
			return 0;
		}
		int ans1,ans2=Integer.MAX_VALUE,ans3=Integer.MAX_VALUE;
		int arr[]=new int[n+1];
		if(arr[n-1]>0) {
			ans1=arr[n-1];
		}
		else {
		 ans1=minSteptoOne(n-1);
		}
		if(n%2==0) {
			if(arr[n/2]>0) {
				ans2=arr[n/2];
			}
			else {
			ans2=minSteptoOne(n/2);
			}
		}
		if(n%3==0) {
			if(arr[n/3]>0) {
				ans3=arr[n/3];
			}
			else {
			ans3=minSteptoOne(n/3);
		}
		}
		int output= Math.min(ans1, Math.min(ans2, ans3))+1;
		arr[n]=output;
		return arr[n];
	}
	//Iterative Approach
	public static int minSteptoOneI(int n) {
		if(n==1) {
			return 0;
		}
		int arr[]=new int[n+1];
		arr[1]=0;
		for(int i=2;i<=n;i++) {
			int minusOne;
			int divTwo=Integer.MAX_VALUE;
			int divThree=Integer.MAX_VALUE;
			minusOne=arr[i-1];
			if(i%2==0) {
				divTwo=arr[i/2];
			}
			if(i%3==0) {
				divThree=arr[i/3];
			}
			arr[i]=Math.min(minusOne ,Math.min(divTwo, divThree))+1;
		}
		return arr[n];
	}
	// recursive approach//O(n^(3/2))
	public static int minSquare(int n,int arr[]) {
		if(n==0) {
			return 0;
		}
		int minAns=Integer.MAX_VALUE;
		for(int i=1;i*i<=n;i++) {
			int currAns;
			if(arr[n-(i*i)]==-1) {
				currAns=minSquare(n-(i*i), arr);
				arr[n-(i*i)]=currAns;
			}
			else {
				currAns=arr[n-(i*i)];
			}
			
			minAns=Math.min(minAns, currAns);
		}
		return minAns+1;
		
	}
	public static int minSquareI(int n,int arr[]) {
		 arr[0]=0;
		 
		 for(int i=1;i<=n;i++) {
			 int minAns=Integer.MAX_VALUE;

			 for(int j=1;j*j<=i;j++) {
				 int  currAns=arr[i-(j*j)];
				  minAns=Math.min(currAns,minAns);
			 }
			 arr[i]=1+minAns;
		 }
		 return arr[n];
	}
	
	public static int byteGold(int n,int arr[]) {
		if(n<=1) {
			return n;
		}
		if(arr[n]!=-1) {
			int a= arr[n];
			return a;
		}
		int Breakdown=byteGold(n/2,arr)+byteGold(n/4, arr)+byteGold(n/3, arr);
		arr[n]=Math.max(n, Breakdown);
		return arr[n];
	}
	public static int robberP(int a[],int n,int dp[]) {
		if(n<0) {
			return 0;
		}
		else if(n==0) {
			return a[0];
		}
		if(dp[n]!=-1) {
			return dp[n];
		}
		int sum=a[n]+robberP(a, n-2,dp);
		int sum2=robberP(a, n-1,dp);
		dp[n]=Math.max(sum, sum2);
		return dp[n];
		
	}
	
	public static int robberPI(int arr[],int n) {
		if(n<0) {
			return 0;
		}
		else if(n==0) {
			return arr[0];
		}
		int storage[]=new int[n+1];
		storage[0]=arr[0];
		storage[1]=Math.max(arr[0],arr[1]);
		for(int i=2;i<=n;i++) {
			storage[i]=Math.max(storage[i-1],arr[i]+storage[i-2]);
		}
		return storage[n-1];
	}
	
	public static int tribonacci(int n) {
		int arr[]=new int[n+1];
		arr[0]=0;
		arr[1]=1;
		arr[2]=1;
		for(int i=3;i<=n;i++) {
			arr[i]=(arr[i-1]+arr[i-2]+arr[i-3]);
		}
		return arr[n];
	}
	
	
	public static void main(String[] args) {
		int n=8;
		int arr[]=new int[n+1];
		for(int i=0;i<=n;i++) {
			arr[i]=-1;
		}
		int a[]= {1,2,3,1};
//		int res=fiboI(n);
//		System.out.println(res);
//		System.out.println(stairCase(n));
//		System.out.println(minSteptoOneI(n));
//		System.out.println(minSquareI(n, arr));
//		System.out.println(byteGold(n,arr));
//		System.out.println(robberP(a,a.length-1,arr));
		System.out.println(tribonacci(4));

	}

}
