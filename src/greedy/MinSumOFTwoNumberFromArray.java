package greedy;

public class MinSumOFTwoNumberFromArray {
	
	public static void main(String args[]) {
		int arr[]= {6, 8, 4, 5, 2, 3, 0};
		
		int temp[]=new int[10];
		for(int i=0;i<arr.length;i++) {
			temp[arr[i]]++;
		}
		StringBuilder first=new StringBuilder();
		StringBuilder second=new StringBuilder();
		boolean turn= true;
		
		for(int i=0;i<temp.length;i++) {
			System.out.println(temp[i]);
		}
		
		for(int i=0;i<10;i++) {
			while(temp[i]-->0) {
				if(turn) {
					if(!(first.length()==0 && i==0)) first.append(i);
					turn=false;
				}else {
					if(!(second.length()==0 && i==0)) second.append(i);
					turn=true;
				}
			}
		}
		System.out.println(Integer.parseInt(first.toString())+Integer.parseInt(second.toString()));
	}

}
