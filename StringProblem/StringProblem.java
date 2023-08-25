package StringProblem;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class StringProblem {
	
	public static boolean isSubsequence(String s1,String s2) {
		int i=0,j=0;
		while(i<s1.length() && j<s2.length()) {
			char c1=s1.charAt(i);
			char c2=s2.charAt(j);
			if(c1==c2) {
				j++;
			}
			i++;
		}
		if(j!=s2.length()) {
			return false;
		}
		return true;
	} 
	public static boolean anagram(String s1,String s2) {
		if(s1.length()!=s2.length()) {
			return false;
		}
		int arr[]=new int[128];
		int i=0;
		while(i<s1.length()) {
			arr[s1.charAt(i)]++;
			arr[s2.charAt(i)]--;
		}
		for(int j=0;j<arr.length;j++) {
			if(arr[j]!=0) {
				return false;
			}
		}
		return true;
	}
	
	public static int leftmostRepeating(String s) {
		int arr[]=new int[256];
		for(int i=0;i<s.length();i++) {
			arr[s.charAt(i)]++;
		}
		for(int i=0;i<s.length();i++) {
			if(arr[s.charAt(i)]>1) {
				return i;
			}
		}
		return -1;
	}
	
	public static int leftMostRepeating1(String s1) {
		int arr[]=new int[256];
		Arrays.fill(arr, -1);
		int res=Integer.MAX_VALUE;
		for(int i=0;i<s1.length();i++) {
			char ch=s1.charAt(i);
			int indexres=arr[ch];
			if(indexres==-1) {
				arr[ch]=i;
			}
			else {
				res=Math.min(res, indexres);
			}
		}
		return (res==Integer.MAX_VALUE)?-1:res;
	}
	
	public static char appTwice(String s) {
		boolean visited[]=new boolean[26];
		char res=' ';
		for(int i=0;i<s.length();i++) {
			char ch=s.charAt(i);
			if(visited[ch-'a']) {
				res=ch;
				break;
			}
			else {
				visited[ch-'a']=true;
			}
		}
		return res;
	}

	public static String reverseWord(String s) {
		Stack<String>stack=new Stack<>();
		String helper="";
		String newSt="";
		for(int i=0;i<s.length();i++) {
			char ch=s.charAt(i);
			
			if(ch==' ') {
				stack.push(helper);
				helper="";
			}
			else if(ch==' ' && s.lastIndexOf(ch)==i) {
				String sss=s.substring(i,s.length());
				stack.push(sss);
			}
			else {
				helper=helper+ch;
			}
			
		}
		while(!stack.isEmpty()) {
			String ss=stack.pop();
			newSt=newSt+ss+" ";
		}
		return newSt;
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String s1="abc di li",s2="axc",s3="leetcode";
//		System.out.println(isSubsequence(s1, s2));
//		System.out.println(anagram(s1, s2));
//		System.out.println(leftmostRepeating(s1));
//		System.out.println(leftMostRepeating1(s1));
//		System.out.println(firstUnique(s3));
//		System.out.println(appTwice(s1));
		System.out.println(reverseWord(s1));
		
		
	}

}
