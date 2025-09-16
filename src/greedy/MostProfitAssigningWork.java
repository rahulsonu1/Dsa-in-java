package greedy;

import java.util.ArrayList;
import java.util.Collections;

public class MostProfitAssigningWork {

	public static void main(String[] args) {
		int []difficulty = {85,47,57};
		int profit[] = {24,66,99};
	    int worker []= {40,25,25};
	    System.out.println(maxProfitAssignment(difficulty, profit, worker));
	    
	}
     public static  int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
    	 ArrayList<int[]>list=new ArrayList<>();
    	 for(int i=0;i<difficulty.length;i++) {
    		 list.add(new int[] {difficulty[i],profit[i]});
    	 }
    	 Collections.sort(list, (a, b) -> {
    		    if (a[0] != b[0]) {
    		        return Integer.compare(a[0], b[0]);  
    		    } else {
    		        return Integer.compare(b[1], a[1]);  
    		    }
    		});
    	 
    	 for(int i=1;i<list.size();i++) {
    		 list.get(i)[1]=Math.max(list.get(i)[1],list.get(i-1)[1]);
    		
    	 }
    	 int totalProfit=0;
    	 for(int i=0;i<worker.length;i++) {
    		 int ability=worker[i];
    		 int low=0,high=list.size()-1,currProfit=0;
    		 while(low<=high) {
    			 int mid=(low+high)/2;
    			 if(list.get(mid)[0]<=ability) {
    				 currProfit=Math.max(list.get(mid)[1],currProfit);
    				 low=mid+1;
    			 }else {
    				 high=mid-1;
    			 }
    		 }
    		 totalProfit+=currProfit;
    	 }
    	 
        return totalProfit;
    }

}
