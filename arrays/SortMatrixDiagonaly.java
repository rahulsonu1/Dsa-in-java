package arrays;

import java.util.ArrayList;
import java.util.Collections;

public class SortMatrixDiagonaly {

	public static void main(String[] args) {
		int arr[][]= {{1,7,3},{9,8,2},{4,5,6}};
		int m=arr.length;
		int n=arr[0].length;
		for(int i=0;i<m;i++) {
			ArrayList<Integer>list=new ArrayList<>();
			for(int j=0;i+j<n;j++) {
				list.add(arr[i+j][j]);
			}
			Collections.sort(list,Collections.reverseOrder());
			for(int j=0;i+j<n;j++) {
				arr[i+j][j]=list.get(j);
			}
			
		}
		for(int j=1;j<n;j++) {
			ArrayList<Integer>list=new ArrayList<>();
			for(int i=0;i+j<n;i++) {
				list.add(arr[i][i+j]);
			}
			Collections.sort(list);
			for(int i=0;i+j<n;i++) {
				arr[i][i+j]=list.get(i);
			}
		}
		
		
		print(arr);

	}
	public static void print(int arr[][]) {
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[0].length;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}

}
