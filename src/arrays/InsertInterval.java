package arrays;

import java.util.Arrays;

public class InsertInterval {

	public static void main(String[] args) {
		int arr[][]= {{1,2},{3,5},{6,7},{8,10},{12,16}};
		int interval[]= {4,8};
		int ans[][]=insert(arr, interval);
		System.out.println(Arrays.deepToString(ans));
		
	}
	public static int[][] insert(int[][] intervals, int[] newInterval) {
		 int ans[][]=new int[intervals.length+1][2];
		 int i=0,j=0;
		 while(i<intervals.length && intervals[i][1]<newInterval[0]) {
			 ans[j++]=intervals[i++];
		 }
		 while(i<intervals.length && intervals[i][0]<=newInterval[1]) {
			 newInterval[0]=Math.min(newInterval[0],intervals[i][0]);
			 newInterval[1]=Math.max(newInterval[1],intervals[i][1]);
			 i++;
		 }
		 ans[j++]=newInterval;
		 
		 while(i<intervals.length) {
			 ans[j++]=intervals[i++];
		 }
		 return Arrays.copyOf(ans, j);
	}

}
