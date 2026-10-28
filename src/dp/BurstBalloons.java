package dp;
import java.util.*;
public class BurstBalloons {

	public static void main(String[] args) {
		int nums[]= {3,1,5,8};
		int n=nums.length;
		ArrayList<Integer>list=new ArrayList<>();
		list.add(1);
		for(int i: nums) list.add(i);
		list.add(1);
		
		System.out.println(maxCoin(list, 1, 4));
	}
	public static int maxCoin(ArrayList<Integer>list ,int start,int end) {
		if(end>start) return 0;
		int ans=Integer.MIN_VALUE;
		for(int i=start;i<=end;i++) {
			int left=maxCoin(list,start,i-1);
			int right=maxCoin(list,i+1,end);
			int cost=list.get(i-1)*list.get(i)*list.get(i+1);
			ans=Math.max(ans, cost+left+right);
			
		}
		return ans;
	}

}
