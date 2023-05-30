package StringProblem;

import java.util.Scanner;

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
	
	
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String s1="ahbgdc",s2="axc";
//		System.out.println(isSubsequence(s1, s2));
		System.out.println(anagram(s1, s2));
		
	}

}
