package queue;
import java.util.Stack;
public class QueueUsingTwoStack {
	Stack<Integer> s1;
	Stack<Integer> s2;
	
	public QueueUsingTwoStack() {
		s1=new Stack<>();
		s2=new Stack<>();
	}
	public void enqueue(int data) {
		s1.push(data);
	}
	public int size() {
		return s1.size();
	}
	public int dequeue() {
		while(!s1.isEmpty()) {
			s2.push(s1.pop());
		}
		int data=s2.pop();
		while(!s2.isEmpty()) {
			s1.push(s2.pop());
		}
		return data;
	}
	public boolean isEmpty() {
		return size()==0;
	}
	public int front() {
		if(isEmpty()) {
			return -1;
		}
		while(!s1.isEmpty()) {
			s2.push(s1.pop());
		}
		int data=s2.peek();
		while(!s2.isEmpty()) {
			s1.push(s2.pop())	;	}
		return data;
	}
	public static void main(String args[]) {
		QueueUsingTwoStack queue=new QueueUsingTwoStack();
		queue.enqueue(34);
		System.out.println(queue.dequeue());
		System.out.println(queue.isEmpty());
	}
}
