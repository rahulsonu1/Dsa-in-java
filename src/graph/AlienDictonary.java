package graph;
import java.util.*;
public class AlienDictonary {

	public static void main(String[] args) {
		String words[] = {"ccd", "cba" ,"dab","a", "ada", "aad", "bad", "baa"};
		int v=26;
		
		List<List<Integer>>list=new ArrayList<>();
		
		for(int i=0;i<v;i++) {
			list.add(new ArrayList<>());
		}
		boolean isPresent[]=new boolean[v];
		for(int i=0;i<words.length;i++) {
			for(int j=0;j<words[i].length();j++) {
				isPresent[words[i].charAt(j)-'a']=true;
			}
		}
		
		
		int indegree[]=new int[v];
		
		for(int i=1;i<words.length;i++) {
			
			String last=words[i-1];
			String curr=words[i];
			int j=0;
			while(j<Math.min(last.length(),curr.length())) {
				if(last.charAt(j)!=curr.charAt(j) && !list.get(last.charAt(j)-'a').contains(curr.charAt(j)-'a')) {
					list.get(last.charAt(j)-'a').add(curr.charAt(j)-'a');
					indegree[curr.charAt(j)-'a']++;
					
					break;
				}
				j++;
			}
		}
		System.out.println(list);
//		for(int i=0;i<indegree.length;i++) {
//			System.out.println(indegree[i]);
//		}
		kanhAglgorith(list, v, indegree,isPresent);
//		System.out.println(list);

	}
	public static void kanhAglgorith(List<List<Integer>>list,int v,int indegree[],boolean isPresent[]) {
		Stack<Integer>stack=new Stack<>();
		for(int i=0;i<v;i++) {
			if(indegree[i]==0 && isPresent[i]) {
				stack.push(i);
			}
		}
//		System.out.println(stack);
		while(!stack.isEmpty()) {
			int top=stack.pop();
			for(int neigh:list.get(top)) {
				indegree[neigh]--;
				if(indegree[neigh]==0) {
					stack.add(neigh);
				}
			}
			System.out.println((char)(top+'a'));
		}

		
	}

}
