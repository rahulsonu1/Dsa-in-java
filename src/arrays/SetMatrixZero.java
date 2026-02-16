package arrays;

import java.util.Arrays;

public class SetMatrixZero {

	public static void main(String[] args) {
		int arr[][]= {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
//		setZeroes(arr);
		setZERO(arr);
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[0].length;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}

	}
	public static void setZERO(int [][] matrix) {
		int m=matrix.length;
		int n=matrix[0].length;
		boolean rows=false;
		boolean cols=false;
		for(int i=0;i<m;i++) {
			if(matrix[i][0]==0) cols=true;
		}
		for(int i=0;i<n;i++) {
			if(matrix[0][i]==0)  rows=true;
		}
		for(int i=1;i<m;i++) {
			for(int j=1;j<n;j++) {
				if(matrix[i][j]==0) {
					matrix[i][0]=0;
					matrix[0][j]=0;
				}
			}
		}
		for(int i=1;i<m;i++) {
			if(matrix[i][0]==0) {
				for(int j=0;j<n;j++) {
					matrix[i][j]=0;
				}
			}
		}
		for(int j=1;j<n;j++) {
			if(matrix[0][j]==0) {
				for(int i=1;i<m;i++) {
					matrix[i][j]=0;
				}
			}
		}
		if(cols) {
			for(int i=0;i<m;i++) {
				matrix[i][0]=0;
			}
		}
		if(rows) {
			for(int i=0;i<n;i++) {
				matrix[0][i]=0;
			}
		}
		
		
		
	}
	public static void setZeroes(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        boolean rows[]=new boolean[m];
        boolean cols[]=new boolean[n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0){
                    rows[i]=true;
                    cols[j]=true;
                }
            }
        }
        System.out.println(Arrays.toString(rows));
        System.out.println(Arrays.toString(cols));
        for(int i=0;i<m;i++){
            if(rows[i]){
                for(int j=0;j<n;j++){
                    matrix[i][j]=0;
                }
            }
        }

        for(int j=0;j<n;j++){
            if(cols[j]){
                for(int i=0;i<m;i++){
                    matrix[i][j]=0;
                }
            }
        }
        
    }

}
