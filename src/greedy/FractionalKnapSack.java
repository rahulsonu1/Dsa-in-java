package greedy;

import java.util.ArrayList;

public class FractionalKnapSack {
	
	static class Pair {
		int val;
		int wt;
		double ratio;
		public Pair(int val,int wt,double ratio) {
			this.val=val;
			this.wt=wt;
			this.ratio=ratio;
		}
		
	}

	public static void main(String[] args) {
		 int[] val = {60, 100, 120};
	     int[] wt = {10, 20, 30};
	     int capacity = 50;
	     ArrayList<Pair>list=new ArrayList<>();
	     for(int i=0;i<val.length;i++) {
	    	 list.add(new Pair(val[i],wt[i],(double)val[i]/wt[i]));
	    	 
	     }
	    list.sort((a,b)-> Double.compare(b.ratio, a.ratio));
	    double profit=0;
	    for(int i=0;i<list.size();i++) {
	    	if(list.get(i).wt<=capacity) {
	    		capacity=capacity-list.get(i).wt;
	    		profit=profit+list.get(i).val;
	    	}else {
	    		double c=(list.get(i).val/list.get(i).wt)*capacity;
	    		profit=profit+c;
	    	}
	    }
	    System.out.println(profit);
	}

}
