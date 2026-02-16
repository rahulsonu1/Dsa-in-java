package backTracking;

public class LargestNumberByKSwap {
	static String max="";

	public static void main(String[] args) {
		String s="45258910";
		int k=4;
		char arr[]=s.toCharArray();
		largest(arr, k, 0);
		System.out.println(max);
	}
	public static void largest(char arr[],int k,int startIndex) {
		if(startIndex==arr.length||k==0) {
			return;
		}
		char maxChar=arr[startIndex];
		for(int i=startIndex+1;i<arr.length;i++) {
			if(maxChar<arr[i]) {
				maxChar=arr[i];
			}
		}
		for(int i=startIndex+1;i<arr.length;i++) {
			if(arr[i]==maxChar) {
				swap(arr,startIndex,i);
				
				String current=new String(arr);
				if(current.compareTo(max)>0) {
					max=current;
				}
				largest(arr, k-1, startIndex+1);
				swap(arr,startIndex,i);
			}
		}
	}
	public static void swap(char arr[],int start,int end) {
			char temp=arr[start];
			arr[start]=arr[end];
			arr[end]=temp;
			
	}

}
