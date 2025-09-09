package queue;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
public class ReverseKElement {
	public static void main(String[] args) {
		Queue<Integer> queue=new LinkedList<>();
		int i=1;
		while(i<=5) {
			queue.add(i);
			i++;
		}
		Queue<Integer> newQueue=rev(queue,3);
		while(!newQueue.isEmpty()) {
			System.out.println(newQueue.poll());
		}
		
	}

	private static Queue<Integer> rev(Queue<Integer> queue, int i) {
		if(queue.isEmpty()|| i<=0) {
			return queue;
		}
		Stack<Integer> stack=new Stack<>();
		 i=i%queue.size();
		 for(int j=0;j<i;j++) {
			 stack.push(queue.poll());
		 }
		 while(!stack.isEmpty()) {
			 queue.add(stack.pop());
		 }
		 for(int j=0;j<queue.size()-i;j++) {
			 queue.add(queue.poll());
		 }
		 return queue;
	}

}
