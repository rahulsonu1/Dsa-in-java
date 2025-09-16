package greedy;

import java.util.ArrayList;

public class PartitionLabel {

	public static void main(String[] args) {
		String s="bobhaspepper";
		int arr[]=new int[26];
		for(int i=0;i<s.length();i++) {
			arr[s.charAt(i)-'a']=i;
		}
		ArrayList<Integer>list=new ArrayList<>();
		int start=0,end=0;
		for(int i=0;i<s.length();i++) {
			char ch=s.charAt(i);
			end=Math.max(end,arr[ch-'a']);
			if(end==i) {
				list.add(i-start+1);
				start=i+1;
			}
			
		}
		System.out.println(list);
		

	}

}
