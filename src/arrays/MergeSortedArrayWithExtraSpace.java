package arrays;

import java.util.Arrays;

public class MergeSortedArrayWithExtraSpace {

	public static void main(String[] args) {
		int a[] = {1, 5, 9, 10, 15, 20};
		int b[] = {2, 3, 8, 13};
		int m=a.length;
		int n=b.length;
		
		int len=m+n;
		int gap=(len/2)+(len%2);
		while(gap>0) {
			int left=0;
			int right=left+gap;
			while(right<len) {
				if(left<m && right>=m) {
					swap(a,b,left,right-m);
				}
				else if(left>=m) {
					swap(b,b,left-m,right-m);
				}else {
					swap(a,a,left,right);
				}
				left++;
				right++;
			}
			if(gap==1) break;
			gap=gap/2+gap%2;
		}
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(b));
	}
	public static void swap(int a[],int b[],int left,int right) {
		if(a[left]>b[right]) {
			int temp=a[left];
			a[left]=b[right];
			b[right]=temp;
		}
	}

}
