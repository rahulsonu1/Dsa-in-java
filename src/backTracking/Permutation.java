package backTracking;
import java.util.*;

public class Permutation {

	public static void main(String[] args) {
		String s="AAA";
		ArrayList<String>list=new ArrayList<>();
		permutation(s, "", list);
		System.out.println(list);
		

	}
	public static void permutation(String s,String output,ArrayList<String> list) {
		if(s.length()==0) {
			list.add(output);
			return;
		}
		HashSet<Character>set=new HashSet<>();
		for(int i=0;i<s.length();i++) {
			char ch=s.charAt(i);
			if(!set.contains(ch)) {
		    set.add(ch);
			String rem=s.substring(0, i)+s.substring(i+1,s.length());
			permutation(rem, output+ch, list);
			}
		}
	}

}
