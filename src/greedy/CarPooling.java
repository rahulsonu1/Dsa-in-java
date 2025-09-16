package greedy;

import java.util.Arrays;

public class CarPooling {

	public static void main(String[] args) {
		int arr[][]= {{2,1,5},{3,3,7}};
		int capacity=4;
		System.out.println(carPooling(arr, capacity));
		

	}
	 public static  boolean carPooling(int[][] trips, int capacity) {
	     int maxTime=0;
	     for(int i=0;i<trips.length;i++) {
	    	 maxTime=Math.max(maxTime,trips[i][2]);
	     }
	     int arr[]=new int[maxTime+1];
	     for(int i=0;i<trips.length;i++) {
	    	 arr[trips[i][1]]+=trips[i][0];
	    	 arr[trips[i][2]]-=trips[i][0];
	     }
	     int count=0;
	     for(int i=0;i<arr.length;i++) {
	    	 count=count+arr[i];
	    	 if(count>capacity) {
	    		 return false;
	    	 }
	     }
	     return true;
	   
	}

}
