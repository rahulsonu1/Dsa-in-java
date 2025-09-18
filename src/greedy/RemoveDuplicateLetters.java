package greedy;

import java.util.Arrays;
import java.util.Stack;

public class RemoveDuplicateLetters {

	public static void main(String[] args) {
		String s = "abacb";
		boolean used[] = new boolean[26];
		Arrays.fill(used,false);
		int lastIndex[] = new int[26];
		for (int i = 0; i < s.length(); i++) {
			lastIndex[s.charAt(i) - 'a'] = i;
		}
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			while (!stack.isEmpty() && stack.peek() > ch && lastIndex[stack.peek() - 'a'] > i && used[stack.peek()-'a']==true && used[ch-'a']==false) {
				used[stack.peek()-'a']=false;

				stack.pop();
			}
			if(!used[ch-'a']) {
				stack.push(ch);
				used[ch-'a']=true;
			}
			
		}
		StringBuilder sb=new StringBuilder();
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		sb.reverse();
		System.out.println(sb);
	}

}
