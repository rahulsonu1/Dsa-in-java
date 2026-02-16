package backTracking;

import java.util.ArrayList;
import java.util.HashSet;

public class WordBreak2 {

	public static void main(String[] args) {
		String s="catsanddog";
		String wordDict[] = {"cat","cats","and","sand","dog"};
		HashSet<String>set=new HashSet<>();
		for(String word:wordDict) {
			set.add(word);
		}
		ArrayList<String>list=new ArrayList<>();
		ArrayList<String>ans=new ArrayList<>();
		find(s,0,set,list,ans);
		System.out.println(ans);
		
	}
	public static void find(String s, int index,HashSet<String>set,ArrayList<String>list,
			ArrayList<String>ans) {
		if(index==s.length()) {
			String sent="";
			for(int i=0;i<list.size();i++) {
				sent=sent+list.get(i);
				if(i!=list.size()-1) {
					sent=sent+" ";
				}
				
			}
			ans.add(sent);
		}
		for(int i=index;i<s.length();i++) {
			String part=s.substring(index,i+1);
			if(set.contains(part)) {
				list.add(part);
				find(s, i+1, set, list, ans);
				list.remove(list.size()-1);
			}
		}
		
	}

}
