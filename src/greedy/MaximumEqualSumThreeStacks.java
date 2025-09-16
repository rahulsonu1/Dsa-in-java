package greedy;

import java.util.ArrayList;
import java.util.List;

public class MaximumEqualSumThreeStacks {

	public static void main(String[] args) {
		 List<Integer> s1 = new ArrayList<>();
	     s1.add(3);s1.add(2);s1.add(1);s1.add(1);s1.add(1);

	     List<Integer> s2 = new ArrayList<>();
	     s2.add(4);s2.add(3);s2.add(2);
	     
	     List<Integer> s3 = new ArrayList<>();
	     s3.add(1);s3.add(1);s3.add(4);s3.add(1);
	     
	     int sum1=sum(s1),sum2=sum(s2),sum3=sum(s3);
	     int top1=0,top2=0,top3=0;
	     
	     while(true) {
	    	 if(top1==s1.size()||top2==s2.size()||top3==s3.size()) {
	    		 break;
	    	 }
	    	 
	    	 if(sum1==sum2 && sum2==sum3) {
	    		 System.out.println(sum1); break;
	    	 }
	    	 else if(sum1>sum2 && sum1>sum3) {
	    		 sum1=sum1-s1.get(top1++);
	    	 }else if(sum2>sum1 && sum2>sum3) {
	    		 sum2=sum2-s2.get(top2++);
	    	 }else {
	    		 sum3=sum3-s3.get(top3++);
	    	 }
	     }
	     
	    

	        
	 }
	public static int sum(List<Integer>list) {
		int sum=0;
		for(int i=0;i<list.size();i++) {
			sum=sum+list.get(i);
		}
		return sum;
	}
}
