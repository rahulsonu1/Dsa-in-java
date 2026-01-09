package PrQueueHeap;

import java.util.PriorityQueue;

public class KthSmallestElementinSortedMatrix {

	public static void main(String[] args) {
		int arr[][]= {{1,5,9},{10,11,13},{12,13,15}};
		int k=8;
//		System.out.println(kthSmallest(arr, k));
		System.out.println(KthSmallestBinarySearch(arr, k));

	}
	public static int kthSmallest(int matrix[][],int k) {
		int n=matrix.length;
		PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
		for(int i=0;i<n;i++) {
			int data=matrix[i][0];
			pq.add(new int[] {data,i,0});
		}
		int ans=-1;
		while(!pq.isEmpty() && k-->0) {
			int curr[]=pq.poll();
			ans=curr[0];
			int row=curr[1];
			int col=curr[2];
			if(col+1<n) {
				pq.add(new int[] {matrix[row][col+1],row,col+1});
			}
		}
		return ans;
		
	}
	public static int KthSmallestBinarySearch(int matrix[][],int k) {
		int n=matrix.length;
		int low=matrix[0][0];
		int high=matrix[n-1][n-1];
		
		while(low<high) {
			int mid=low+(high-low)/2;
			int count=count(matrix,mid);
			if(count<k) {
				low=mid+1;
			}else {
				high=mid;
			}
			
		}
		return low;
	}
	public static int count(int matrix[][],int mid) {
		int n=matrix.length;
		int row=n-1;
		int col=0;
		int count=0;
		while(row>=0 && col<=n-1) {
			if(matrix[row][col]<=mid) {
				count=count+row+1;
				col++;
			}
			else {
				row--;
		}
		}
		return count;
	}

}
