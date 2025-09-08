package stack;

import java.util.Stack;

public class MinStack {
	Stack<Integer> stack;
	Stack<Integer> min;
	
	public MinStack() {
		stack=new Stack<>();
		min=new Stack<>();
		
	}
	public void push(int x) {
		stack.push(x);
		if(min.isEmpty() || min.peek()>=x) {
			min.push(x);
		}else {
			min.push(min.peek());
		}
		
	}
	public int pop() {
		if(stack.isEmpty()) {
			return -1;
		}
		int ans=stack.pop();
		min.pop();
		return ans;
		
	}
	public int peek() {
		if(stack.isEmpty()) return -1;
		return stack.peek();
	}
	public int getMin() {
		if(min.isEmpty()) return -1;
		return min.peek();
	}
	
	
	
	

	public static void main(String[] args) {
		MinStack m=new MinStack();
		m.push(100);
		m.push(344);
		m.push(44);
		m.push(34);
//		m.push(0);
		m.push(433);
		
		System.out.println(m.getMin());

	}

}
