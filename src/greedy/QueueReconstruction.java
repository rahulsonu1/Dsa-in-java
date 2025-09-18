package greedy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class QueueReconstruction {

	public static void main(String[] args) {
		int arr[][]= {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
		Arrays.sort(arr,(a,b)->{
			 if (a[0] != b[0]) {
	                return Integer.compare(a[1], b[1]);
	            }
			 else {
	                return Integer.compare(b[0], a[0]);
	            }
		});
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		
      


	}

}
