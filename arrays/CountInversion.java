package arrays;

public class CountInversion {

	public static void main(String[] args) {
		int arr[]= {5,3,2,4,1};
		System.out.println(mergeSort(arr, 0, 4));
		
	}
	public static int mergeSort(int arr[],int start,int end) {
		int res=0;
		if(start<end) {
			int mid=(start+end)/2;
			res=res+mergeSort(arr,start,mid);
			res=res+mergeSort(arr,mid+1,end);
			res=res+countInversion(arr,start,mid,end);
		}
		return res;
	}
	public static int countInversion(int arr[],int start,int mid,int end) {
		int leftLength=mid-start+1, rightLength=end-mid+1;
		int temp[]=new int[end-start+1];
		
		int res=0;
		int i=start,j=mid+1,k=0;
		while(i<=mid && j<=end) {
			if(arr[i]<arr[j]) {
				temp[k++]=arr[i++];
			}else {
				res=res+mid-i+1;
				temp[k++]=arr[j++];
			}
		}
		 while(i<=mid)
         {
             temp[k++]=arr[i++];
         }
         while(j<=end)
         {
             temp[k++] = arr[j++];
         }
        int x=0;
        for(int l=start;l<=end;l++) {
        	arr[l]=temp[x++];
        }
         
		return res;
	}

}
