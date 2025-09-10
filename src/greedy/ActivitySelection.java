package greedy;

import java.util.Arrays;
import java.util.Comparator;

public class ActivitySelection {

	public static void main(String[] args) {
		int arr[][]= {{1,2},{3,4},{0,6},{5,7},{8,9},{5,9}};

		
        Arrays.sort(arr, Comparator.comparingInt(a -> a[1]));

		int count=1;
		int last=arr[0][1];
		for(int i=1;i<arr.length;i++) {
			if(arr[i][0]>last) {
				count++;
				last=arr[i][0];
			}
		}
		System.out.println(count);
	
	}
	

}
