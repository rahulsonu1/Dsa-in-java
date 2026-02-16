package backTracking;

import java.util.*;

public class LetterCombPhone {
	static HashMap<Character,String []> map=new HashMap<>();
	static {
	    map.put('2', new String[]{"a", "b", "c"});
	    map.put('3', new String[]{"d", "e", "f"});
	    map.put('4', new String[]{"g", "h", "i"});
	    map.put('5', new String[]{"j", "k", "l"});
	    map.put('6', new String[]{"m", "n", "o"});
	    map.put('7', new String[]{"p", "q", "r", "s"});
	    map.put('8', new String[]{"t", "u", "v"});
	    map.put('9', new String[]{"w", "x", "y", "z"});
	}
	

	public static void main(String[] args) {
		String s="234";
		ArrayList<String>list=new ArrayList<>();
		comb(s,0,"",list);
		System.out.println(list);
	}
	public static void comb(String s,int index,String curr,ArrayList<String>list) {
		if(index==s.length()) {
			list.add(curr);
			return;
		}
		String t[]=map.get(s.charAt(index));
		for(int i=0;i<t.length;i++) {
			comb(s, index+1, curr+t[i], list);
			
		}
	}

}
