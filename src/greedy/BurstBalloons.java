package greedy;

import java.util.Arrays;

public class BurstBalloons {

	public static void main(String[] args) {
		int arr[][]= {{-2147483646,-2147483645},{2147483646,2147483647}};
		Arrays.sort(arr,(a,b)-> a[1]-b[1]);
		int count=1;
		int last=arr[0][1];
		for(int i=1;i<arr.length;i++) {
			if(last<arr[i][0]) {
				count++;
				last=arr[i][1];
			}
		}
		System.out.println(count);
	}

}
