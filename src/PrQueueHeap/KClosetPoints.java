package PrQueueHeap;

import java.util.ArrayList;

public class KClosetPoints {
	static class Pair {
		int a[];
		float distance;
		Pair(int a[],float distance){
			this.a=a;
			this.distance=distance;
		}
	}
	

	public static void main(String[] args) {
		int arr[][]= {{3,3},{5,-1},{-2,4}};
		int k=2;
		ArrayList<Pair> list=new ArrayList<>();
		
		for(int i=0;i<arr.length;i++) {
		float  distance=(float) Math.sqrt(Math.pow((arr[i][0]-0),2)+Math.pow((arr[i][1]-0),2));
		list.add(new Pair(new int[] {arr[i][0],arr[i][1]},distance));
			
		}
		list.sort((a,b)->Float.compare(a.distance,b.distance));
		int ans[][]=new int[k][2];
		for(int i=0;i<k;i++) {
			Pair p=list.get(i);
			ans[i][0]=p.a[0];
			ans[i][1]=p.a[1];
			
		}
		//prinans;
		
		
		

	}

}
