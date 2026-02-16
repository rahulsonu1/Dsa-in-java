package backTracking;

import java.util.ArrayList;
import java.util.List;

public class Combination {

	public static void main(String[] args) {
		int n=10;
		int k=3;
		List<List<Integer>>ans=new ArrayList<>();
		List<Integer>list=new ArrayList<>();
		combine(1, n, k, list,ans);
		System.out.println(ans);
	}
	public static void combine(int start,int n,int k,List<Integer>list,List<List<Integer>>ans) {
//		if(start==n) return;
		if(k==0) {
			ans.add(new ArrayList<Integer>(list));
			return;
		}
		for(int i=start;i<=n;i++) {
			list.add(i);
			combine(i+1, n, k-1, list,ans);
			list.removeLast();
		}
		
	}

}
