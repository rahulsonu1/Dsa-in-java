package greedy;

import java.util.Arrays;

public class NonOverLappingInterval {

	public static void main(String[] args) {
		int arr[][]= {{1,100},{11,22},{1,11},{2,12}};
		Arrays.sort(arr,(a,b)->Integer.compare(a[0],b[0]));
		int count=0;
		int end=arr[0][1];
		for(int i=1;i<arr.length;i++) {
			if(end>arr[i][0]) {
				count++;
				end=Math.min(end,arr[i][1]);
			}else {
				end=arr[i][1];
			}
		}
		System.out.println(count);

	}

}
