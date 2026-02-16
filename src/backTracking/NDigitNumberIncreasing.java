package backTracking;

import java.util.ArrayList;

public class NDigitNumberIncreasing {

	public static void main(String[] args) {
		int n=2;
		ArrayList<Integer>small=new ArrayList<>();
		ArrayList<Integer>list=new ArrayList<>();
		increasing(n, small, list);
		System.out.println(list);
		
		
	}
	public static void increasing(int n,ArrayList<Integer>small,ArrayList<Integer>list) {
		if(n==0) {
			int ans=0;
			for(int i=0;i<small.size();i++) {
				ans=ans*10+small.get(i);
			}
			list.add(ans);
			return ;
		}
		if(small.isEmpty()) {
			for(int i=1;i<=9;i++) {
				small.add(i);
				increasing(n-1, small, list);
				small.removeLast();
				
			}
		}else {

			for(int i=small.getLast();i<=9;i++) {
				if(small.getLast()<i) {
				small.add(i);
				increasing(n-1, small, list);
				small.removeLast();
				}
			}
		}
	}

}
