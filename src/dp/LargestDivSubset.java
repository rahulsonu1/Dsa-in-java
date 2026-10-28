package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LargestDivSubset {

	public static void main(String[] args) {
		int arr[]= {1,2,3};
		
		System.out.println(lds(arr));

	}
	public static List<Integer> lds(int arr[]) {
		Arrays.sort(arr);
		int n=arr.length;
		
		int dp[]=new int[n];
		int prev[]=new int[n];
		int max=1;
		int index=0;
		for(int i=0;i<n;i++) {
			dp[i]=1;
			prev[i]=i;
			for(int j=0;j<i;j++) {
				if(arr[i]%arr[j]==0 && dp[i]<dp[j]+1) {
					dp[i]=dp[j]+1;
					prev[i]=j;
				}
			}
			if(max<dp[i]) {
				max=dp[i];
				index=i;
			}
		}
		 ArrayList<Integer> list = new ArrayList<>();

		    list.add(arr[index]);

		    while(prev[index] != index) {

		        index = prev[index];

		        list.add(arr[index]);
		    }

		    Collections.reverse(list);

		    return list;;
	}

}
