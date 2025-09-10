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
	
	public static void minimumReversal() {
		String s="]]][[[[";
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
		while(!stack.isEmpty() && stack.size()>1) {
			char c1=stack.pop();
			char c2=stack.pop();
			if(c1!=c2)
				count=count+1;
			else
				count++;
				
		}
		System.out.println(count);
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
	
	public static void evaluatePostfix() {
		String arr[]= {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
		int ans=0;
		Stack<Integer>stack=new Stack<>();
		for(int i=0;i<arr.length;i++) {
			if("+-*/".indexOf(arr[i])!=-1) {
				int second=stack.pop();
				int first=stack.pop();
				int res=0;
				if(arr[i].equals("+")) {
					res=first+second;
				}
				else if(arr[i].equals("-")) {
					res=first-second;
				}else if (arr[i].equals("*")) res=first*second;
				else {
					if(second==0) second=1;
					res=first/second;
				}
				stack.push(res);
			}else {
				stack.push(Integer.parseInt(arr[i]));
			}
		}
		System.out.println(stack.pop());
		
	}
	
	public static void minInsertionTOBalance() {
		String s="((((((";
		int n=s.length();
		int ans=0;
		Stack<Character>stack=new Stack<>();
		for(int i=0;i<n;i++) {
			char ch=s.charAt(i);
			if(ch=='(') stack.push(ch);
			else {
				if(stack.isEmpty()) {
					if(i+1<=n-1 && s.charAt(i+1)==')') {
						ans++;
						i++;
					}else ans=ans+2;
				}else {
					if(i+1<=n-1 && s.charAt(i+1)==')') {
						stack.pop(); i++;
					}else {
						ans++; stack.pop();
					}
					
				}
					
			}
			
		}
		ans=ans+stack.size()*2;
		System.out.println(ans);
	}
	
	public static void min() {
		String s="((((((";
		int n=s.length();
		int ans=0;
		int count=0;
		for(int i=0;i<n;i++) {
			char ch=s.charAt(i);
			if(ch=='(') count++;
			else {
				if(count==0) {
					if(i+1<=n-1 && s.charAt(i+1)==')') {
						ans++;
						i++;
					}else ans=ans+2;
				}else {
					if(i+1<=n-1 && s.charAt(i+1)==')') {
						count--;; i++;
					}else {
						ans++; count--;;
					}
					
				}
			}
		}
		System.out.println(ans+count*2);
		
	}
	
	public static void decodedString() {
		String s=""; int k=1;
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<s.length();i++) {
			char ch=s.charAt(i);
			if(!Character.isDigit(ch)) {
				sb.append(ch);
			}else {
				String t=sb.toString();
				System.out.println(t);
				int num=(int) ch-'0';
				System.out.println(num);
				for(int j=1;j<num;j++) {
					sb.append(t);
				}
			}
		}
//		System.out.println(sb);
		System.out.println(sb.charAt(k-1));
	}
	
	public static void gasFill() {
		int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        int n=gas.length;
        for(int i=0;i<n;i++) {
        	int totalgas=0;
        	boolean flag=true;
        	
        	for(int j=i;j<n;j++) {
        		int index=(i+j)%n;
        		totalgas=totalgas+gas[i]-cost[index];
        		if(totalgas<0) {
        			flag=false;
        			break;
        			
        		}
        	}
        	if(flag) {
        		System.out.println(i);
        	}
        }
	}
	public static void countPermutationGreater() {
		int n=100;
		int count=0;
		
		Stack<Integer>stack=new Stack<>();
		for(int i=1;i<=9;i++) {
			if(i<=n) {
				stack.push(i);
				count++;
			}
			while(!stack.isEmpty()) {
				int top=stack.pop();
				for(int j=top%10;j<=9;j++) {
					int x=top*10+j;
					if(x<=n) {
						stack.push(x);
						count++;
					}
				}
			}
		}
		System.out.println(stack.size());
		System.out.println(count);
	}
	
	public static void celebrity() {
		int arr[][]= {{ 0, 1, 0 },
                { 0, 0, 0 },
                { 0, 1, 0 } };
		Stack<Integer>stack=new Stack<>();
		for(int i=0;i<arr.length;i++) {
			stack.push(i);
		}
		while(stack.size()>=2) {
			int i=stack.pop();
			int j=stack.pop();
			if(arr[i][j]==1) {
				stack.push(j);
			}else {
				stack.push(i);
			}
		}
		int pot=stack.pop();
		for(int i=0;i<arr.length;i++) {
			if(i!=pot) {
				if(arr[i][pot]==0||arr[pot][i]==1) {
					System.out.print("None");
					break;
				}
			}
		}
		System.out.println(pot);
	}

	
	public static void main(String[] args) {
		String s= "geegsforgeeeks";
		int arr[]= {5,15,10,8,6,12,9,18};
//		minimumReversal();
//		System.out.println(count);
//		int add=minAdd(s);
//		System.out.println(add);
//		String res=infixToPostFix(s);
//		System.out.println(res);
//		int arr[]= {1, 5, 0, 3, 4, 5};
//		previousGreater(arr);
//		nextGreater(arr);
//		System.out.println(Reduce(s));
//		longestValidParentheses();
//		evaluatePostfix();
//		minInsertionTOBalance();
//		min();
//		decodedString();
//		gasFill();
//		countPermutationGreater();
		celebrity();
//	}
		
		
	}
	
	}	