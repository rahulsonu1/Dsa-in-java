package greedy;

import java.util.Arrays;
import java.util.Comparator;

public class JobSequence {

	public static void main(String[] args) {
		int arr[][]= {{2,100},{1,19},{2,27},{1,25},{1,15}};
		
        Arrays.sort(arr, (a, b) -> Integer.compare(b[1], a[1]));

//		for(int i=0;i<arr.length;i++) {
//			for(int j=0;j<arr[0].length;j++) {
//				System.out.print(arr[i][j]+" ");
//			}
//			System.out.println();
//		}
        int maxDeadLine=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++) {
        	maxDeadLine=Math.max(maxDeadLine, arr[i][0]);
        }
        System.out.println(maxDeadLine);
        int slot[]=new int[maxDeadLine+1];
        Arrays.fill(slot, -1);
        int maxProfit=0;
        int count=0;
        for(int i=0;i<arr.length;i++) {
        	for(int j=arr[i][0];j>0;j--) {
        		if(slot[j]==-1 ) {
        			slot[j]=j*1000;
        			maxProfit=maxProfit+arr[i][1];
        			count++;
        			break;
        		}
        	}
        }
       
        System.out.println(maxProfit);
        System.out.println(count);
        

	}

}
