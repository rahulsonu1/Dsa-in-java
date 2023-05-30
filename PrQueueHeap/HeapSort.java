package PrQueueHeap;

public class HeapSort {
	
	public static void downheapify(int arr[],int i,int n) {
		int parentIndex=i;
		int leftChild=2*parentIndex+1;
		int rightChild=2*parentIndex+2;
		while(leftChild<n) {
			int minIndex=parentIndex;
			if(leftChild<parentIndex) {
				minIndex=leftChild;
			}
			if(rightChild<n && rightChild<parentIndex) {
				minIndex=rightChild;
			}
			if(minIndex==parentIndex) {
				return;
			}
			int temp=arr[minIndex];
			arr[minIndex]=arr[parentIndex];
			arr[parentIndex]=temp;
		}
	}
	
	public static void heapsortt(int arr[]) {
		int n=arr.length;
		for(int i=(n/2)-1;i>=0;i--) {
			downheapify(arr,i,n);
		}
		for(int i=n-1;i>=0;i--) {
			int temp=arr[i];
			arr[i]=arr[0];
			arr[0]=temp;
			downheapify(arr,i,0);
		}
	}
	


	public static void main(String[] args) {
		int arr[]= {1,0,33,22,3,5,88,44,20,-11,2,3};
		heapsortt(arr);
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}

	}

}
