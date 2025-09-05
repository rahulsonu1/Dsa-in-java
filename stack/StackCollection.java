package stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class StackCollection {

	private static Stack<Integer> reverse(Stack<Integer> stack) {
		if(stack.size()<=1) {
			return stack;
		}
		Stack <Integer> newStack=new Stack<>();
		int temp=stack.pop();
		reverse(stack);
		while(!stack.isEmpty()) {
			newStack.push(stack.pop());
		}
		stack.push(temp);
		while(!newStack.isEmpty()) {
			stack.push(newStack.pop());
		}
		return stack;
	}

	public static boolean isBalanced(String s) {
		Stack<Character> stack=new Stack<>();
		for(int i=0;i<s.length();i++) {
			char ch=s.charAt(i);
			if(ch=='(' || ch=='{'|| ch=='[') {
				stack.push(ch);
				continue;
			}
			else if(ch==')' ||ch=='}' || ch==']') {
				if(stack.isEmpty()) {
					return false;
				}
				if(stack.peek()=='(' && ch==')') {
					stack.pop();
				}
				else if(stack.peek()=='{' && ch=='}') {
					stack.pop();
				}
				else if(stack.peek()=='[' && ch==']') {
					stack.pop();
				}
				else {
					return false;
				}
			}
		}
		return stack.isEmpty();
	}

	
	public static boolean checkRedundant(String s) {
		Stack <Character> stack =new Stack<>();
		for(int i=0;i<s.length();i++) {
			char ch=s.charAt(i);
			if(ch!=')') {
				stack.push(ch);
			}
			else if(ch==')') {
				boolean hasOperator=false;
				while(!stack.isEmpty() && stack.peek()!='(') {
					hasOperator= true;
					stack.pop();
				}
				if(!hasOperator) {
					return true;
				}
				if(!stack.isEmpty()) {
					stack.pop();
				}
			}
		}
	return false;
	}
	
	public static int minimumReversal(String s) {
		if(s.length()==0) {
			return 0;
		}
		if(s.length()%2==1) {
			return -1;
		}
		Stack<Character> stack=new Stack<>();
		for(int i=0;i<s.length();i++) {
			char ch=s.charAt(i);
			if(ch=='[') {
				stack.push(ch);
			}
			else {
				if( !stack.isEmpty() && stack.peek()=='[') {
					stack.pop();
				}
				else {
					stack.push(ch);
				}
			}
		}
		int count=0;
		while(!stack.isEmpty()) {
			char c1=stack.pop();
			char c2=stack.pop();
			if(c1!=c2)
				count=count+1;
			else
				count++;
				
		}
		return count;
	}
	
	public static int minAdd(String s) {
		Stack<Character> stack=new Stack<>();
		for(int i=0;i<s.length();i++) {
			char ch=s.charAt(i);
			if(ch=='(') {
				stack.push(ch);
			}
			else {
				if(!stack.isEmpty() && stack.peek()=='(' && ch==')') {
					stack.pop();
				}
				else {
					stack.push(ch);
				}
			}
		}
		return stack.size();
	}
	
	public static int[] stockSpan(int price[]) {
		Stack<Integer> stack=new Stack<>();
		int n=price.length;
		int output[]=new int[n];
		output[0]=1;
		stack.push(0);
		for(int i=1;i<price.length;i++) {
			while(!stack.isEmpty() && price[stack.peek()]<price[i]) {
				stack.pop();
			}
			if(stack.isEmpty()) {
				output[i]=i+1;
			}
			else {
				output[i]=i-stack.peek();
			}
			stack.push(i);
		}
		return output;
	}
	 public static int precedence(char ch) {
		 if(ch=='^') {
			 return 2;
		 }
		 else if(ch=='+'||ch=='-') {
			 return 0;
		 }
		 else if(ch=='*'||ch=='/') {
			 return 1;
		 }
		 return -1;
	 }
	public static String infixToPostFix(String s) {
		Stack<Character> stack=new Stack<>();
		String ans="";
		
		for(int i=0;i<s.length();i++) {
			char ch=s.charAt(i);
			if(Character.isAlphabetic(ch)) {
//		
				ans=ans+ch;
			}
			else if(ch=='(') {
				stack.push(ch);
			}
			else if(ch==')') {
				while(!stack.isEmpty() && stack.peek()!='(') {
					ans=ans+stack.pop();
				}
				if(!stack.isEmpty()) {
					stack.pop();
				}
			}
			else {
				while(!stack.isEmpty() && precedence(ch)<=precedence(stack.peek())) {
					ans=ans+stack.pop();
				}
				stack.push(ch);
			}
			
		}
		while(!stack.isEmpty()) {
			ans=ans+stack.pop();
		}
		return ans;
	}
			
	public static void previousGreater(int arr[]) {
		Stack<Integer> stack=new Stack<>();
		ArrayList<Integer> list=new ArrayList<>();
		stack.push(arr[0]);
		list.add(-1);
		for(int i=1;i<arr.length;i++) {
			while(!stack.isEmpty() && arr[i]>=stack.peek()) {
				stack.pop();	
			}
			if(stack.isEmpty()) {
				list.add(-1);
				stack.push(arr[i]);
			}
			else {
				list.add(stack.peek());
				stack.push(arr[i]);
			}
		}
		System.out.println(list);
	}
	
		
	public static String Reduce(String s) {
		Stack<Character> stack=new Stack<>();
		String newS="";
		for(int i=0;i<s.length();i++) {
			char ch=s.charAt(i);
			if(!stack.isEmpty() && stack.peek()==ch) {
				stack.pop();
				while(!stack.isEmpty()) {
					newS=stack.pop()+newS;
				}
				return newS;
			}
			else {
				stack.push(ch);
			}
		}
		return newS;
	
	}
	
	public static void nextGreater(int arr[]) {
		Stack<Integer>stack=new Stack<>();
		ArrayList<Integer>list=new ArrayList<>();
		int n=arr.length;
		stack.push(arr[n-1]);
		list.add(-1);
		for(int i=n-2;i>=0;i--) {
			while(!stack.isEmpty() && arr[i]>stack.peek()) {
				stack.pop();
			}
			if(stack.isEmpty()) {
				list.add(-1);
				stack.push(arr[i]);
			}
			else {
				list.add(stack.peek());
				stack.push(arr[i]);
			}
		}
		Collections.reverse(list);
		System.out.println(list);
	}
	
	public static void longestValidParentheses() {
		String s=")()())";
		Stack<Integer>stack=new Stack<>();
		stack.push(-1);
		int len=0;
		for(int i=0;i<s.length();i++) {
			char ch=s.charAt(i);
			if(ch=='(') {
				stack.push(i);
			}else {
				stack.pop();
				if(stack.isEmpty()) {
					stack.push(i);
				}else {
					len=Math.max(len,i-stack.peek());
				}
			}
		}
		System.out.println(len);
	}
	
	

	
	public static void main(String[] args) {
		String s= "geegsforgeeeks";
		int arr[]= {5,15,10,8,6,12,9,18};
//	int count=minimumReversal(s);
//		System.out.println(count);
//		int add=minAdd(s);
//		System.out.println(add);
//		String res=infixToPostFix(s);
//		System.out.println(res);
//		int arr[]= {1, 5, 0, 3, 4, 5};
//		previousGreater(arr);
//		nextGreater(arr);
//		System.out.println(Reduce(s));
		longestValidParentheses();
//	}
		
		
	}
	
	}	