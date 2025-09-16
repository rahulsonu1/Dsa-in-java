package greedy;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SingleThread {

	public static void main(String[] args) {
		//enter time and processing time
		int tasks[][] = {{1,2},{2,4},{3,2},{4,1}};
		int m=tasks.length;
		int n=tasks[0].length;
		//{enter time,processing time , id}
		int arr[][]=new int[m][n+1];
		for(int i=0;i<tasks.length;i++) {
			arr[i][0]=tasks[i][0];
			arr[i][1]=tasks[i][1];
			arr[i][2]=i;
		}
		Arrays.sort(arr,(a,b)->Integer.compare(a[0],b[0]));
		
		 PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> 
         a[1] == b[1] ? Integer.compare(a[2], b[2]) : Integer.compare(a[1], b[1])
     );
		 
		 int time=0;
		 int i=0;
		 int ans[]=new int[m];
		 int start=0;
		 while(i<m || !pq.isEmpty()) {
			 if(pq.isEmpty() && time<arr[i][0]) {
				 time=arr[i][0];
			 }
			 while(i<m && time>=arr[i][0]) {
				 pq.add(arr[i]);
				 i++;
			 }
			 int pro[]=pq.poll();
			 ans[start++]=pro[2];
			 time=time+pro[1];
		 }
		 for(int j=0;j<ans.length;j++) {
			 System.out.print(ans[j]+" ");
		 }
		 
		
	}
	

}
