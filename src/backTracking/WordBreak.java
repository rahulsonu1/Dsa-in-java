package backTracking;

import java.util.ArrayList;
import java.util.HashSet;

public class WordBreak {

	public static void main(String[] args) {
		String s="leetcode";
		String words[]= {"leet","code"};
		HashSet<String>set=new HashSet<>();
		for(int i=0;i<words.length;i++) {
			set.add(words[i]);
		}
		System.out.println(check(0, s, set));
	}
	public static boolean check(int index, String s, HashSet<String> set) {
	    if (index == s.length()) {
	        return true;
	    }

	    for (int i = index; i < s.length(); i++) {
	        if (set.contains(s.substring(index, i + 1))) {
	            if (check(i + 1, s, set)) {
	                return true;
	            }
	        }
	    }
	    return false;
	}

}
