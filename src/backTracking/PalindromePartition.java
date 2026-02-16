package backTracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartition {

	public static void main(String[] args) {
		String s="aab";
		List<String>small=new ArrayList<>();
		List<List<String>>list=new ArrayList<>();
		partition(s, 0, small, list);
		System.out.println(list);
		
	}
	public static void partition(String s,int index,List<String>small,List<List<String>>list) {
		if(index==s.length()) {
			list.add(new ArrayList<>(small));
			return;
		}
		for(int i=index;i<s.length();i++) {
			if(isPalindrome(s, index, i)) {
				small.add(s.substring(index,i+1));
				partition(s, i+1, small, list);
				small.remove(small.size()-1);
			}
			
		}
	}
	public static boolean isPalindrome(String s,int start,int end) {
		while(start<end) {
			if(s.charAt(start++)!=s.charAt(end--)) {
				return false;
			}
		}
		return true;
	}

}
