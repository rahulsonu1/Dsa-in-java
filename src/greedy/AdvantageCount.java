package greedy;

import java.util.Arrays;

public class AdvantageCount {

	public static void main(String[] args) {
		int arr[]= {2,0,4,1,2};
		int arr1[]= {1,3,0,0,2};
		
		int ans[]=advantageCount(arr, arr1);
		for(int i=0;i<ans.length;i++) {
			System.out.println(ans[i]);
		}

	}
	 public static  int[] advantageCount(int[] nums1, int[] nums2) {
	        int n=nums1.length;
	        int ans[]=new int[n];
	        Arrays.fill(ans, -1);
	        Arrays.sort(nums1);
	        int arr[][]=new int[n][2];
	        for(int i=0;i<n;i++) {
	        	arr[i]=new int[] {nums2[i],i};
	        }
	        
	        Arrays.sort(arr,(a,b)->Integer.compare(a[0],b[0]));
	        
	        int left=0;
	        int right=n-1;
	        for(int i=0;i<n;i++) {
	        	if(nums1[i]<=arr[left][0]) {
	        		int originalIndex=arr[right][1];
	        		ans[originalIndex]=nums1[i];
	        		right--;
	        	}else {
	        		int originalIndex=arr[left][1];
	        		ans[originalIndex]=nums1[i];
	        		left++;
	        	}
	        }
	        return ans;
	       
	    
	 }


}
