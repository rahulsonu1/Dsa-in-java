package graph;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;import java.util.Queue;
import java.util.Scanner;

import ArrayList.Arraylist;



public class Graph {
	
	public static void dfTravsal(int adjMx[][],int currV,boolean visited[]) {
		visited[currV]=true;
		System.out.print(currV+" ");
		for(int i=0;i<adjMx.length;i++) {
			if(adjMx[currV][i]==1 && visited[i]==false) {
				dfTravsal(adjMx, i,visited);
			}
		}
	}
	
	public static void BTravsal(int adjMx[][]) {
		Queue<Integer>queue=new LinkedList<>();
		boolean visited[]=new boolean[adjMx.length];
		for(int j=0;j<adjMx.length;j++) {
			if(!visited[j]) {
		
		visited[j]=true;
		queue.add(j);
		while(!queue.isEmpty()) {
			int curr=queue.poll();
			System.out.print(curr+" ");
			for(int i=0;i<adjMx.length;i++) {
				if(adjMx[curr][i]==1 && !visited[i]) {
					queue.add(i);
					visited[i]=true;
				}
			}
		}
		}
		}
	}
	
	public static boolean hasPath(int adjMat[][],int src,int des,boolean visited[]) {
		if(adjMat[src][des]==1) {
			return true;
		}
		if(adjMat[src][des]==1) {
			return true;
		}
		Queue<Integer>queue=new LinkedList<>();
		queue.add(src);
		while(!queue.isEmpty()) {
			int front=queue.poll();
			for(int i=0;i<adjMat.length;i++) {
				if(adjMat[front][i]==1 && !visited[i]) {
					if(i==des) {
						return true;
					}
					else {
						visited[i]=true;
						queue.add(i);
					}
				}
			}
		}
		return false;
	}
	public static ArrayList<Integer> getPathBFS(int arr[][],int src,int des){
		Queue<Integer> queue=new LinkedList<>();
		HashMap<Integer,Integer> map= new HashMap<>();
		boolean visited[]=new boolean[arr.length];
		ArrayList<Integer> list=new ArrayList<>();
		if(src==des) {
			list.add(src);
			return list;
		}
		queue.add(src);
		visited[src]=true;
		while(!queue.isEmpty()) {
			int cv=queue.poll();
			for(int i=0;i<arr.length;i++) {
				if(arr[cv][i]==1 && !visited[i]) {
					map.put(i, cv);
					queue.add(i);
					visited[i]=true;
					if(i==des) {
						list.add(i);
						int value=map.get(i);
						while(value!=src) {
							list.add(value);
							value=map.get(value);
						}
						list.add(value);
						return list;
					}
				}
			}
		}
		return null;
	}
	
	public static ArrayList<Integer> getPathDFS(int arr[][],int src,int des,boolean visited[]){
		if(src==des) {
			ArrayList<Integer>list=new ArrayList<>();
			list.add(src);
			return list;
		}
		visited[src]=true;
		for(int i=0;i<arr.length;i++) {
			if(arr[src][i]==1 && !visited[i]) {
				ArrayList<Integer> list=getPathDFS(arr, i, des, visited);
				if(list!=null) {
					list.add(src);
					return list;
					
				}
			}
			
		}
		return null;
	}
	
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int e=sc.nextInt();
		int adjM[][]=new int[n][n];
		for(int i=0;i<e;i++) {
			int v1=sc.nextInt();
			int v2=sc.nextInt();
			adjM[v1][v2]=1;
			adjM[v2][v1]=1;
		}
//		for(int i=0;i<n;i++) {
//			for(int j=0;j<n;j++) {
//				System.out.print(adjM[i][j]+" ");
//			}
//			System.out.println();
//		}
		int count=0;
		boolean visited[]=new boolean[n];
//		for(int i=0;i<n;i++) {
//			if(!visited[i]) {
//			dfTravsal(adjM,i,visited);
//			count++;
//			}
//		}
//		System.out.println(count);
//		dfTravsal(adjM,0,visited);
//		BTravsal(adjM);
//		System.out.println(hasPath(adjM, 0, 3,visited));
//		System.out.println(getPathBFS(adjM, 0, 5));
//		System.out.println(getPathDFS(adjM, 0, 2, visited));
	
	}
	
}
