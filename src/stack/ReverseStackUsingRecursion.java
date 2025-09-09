package stack;

import java.util.Stack;


public class ReverseStackUsingRecursion {

	public static void main(String[] args) {
		Stack<Integer>stack=new Stack<>();
		stack.push(10);
		stack.push(5);
		stack.push(34);
		stack.push(1);
		
		sortStack(stack);
		System.out.println(stack);
	}
	public static void sortStack(Stack<Integer> stack) {
		if(stack.isEmpty()) {
			return ;
		}
		int temp=(int) stack.pop();
		sortStack(stack);
		insertAtRightPostion(stack, temp);
		
	}
	public static void insertAtRightPostion(Stack<Integer>stack,int temp) {
		if(stack.isEmpty()|| stack.peek()<=temp) {
			stack.push(temp);
			return ;
		}
		int t=stack.pop();
		insertAtRightPostion(stack, temp);
		stack.push(t);
	}

}
