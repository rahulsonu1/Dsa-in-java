package queue;
import linkedlist.Node;

public class QueueUsingLL<T>{
	private Node<T> front;
	private Node<T> rear;
	int size;
	public QueueUsingLL() {
		front=null;
		rear=null;
		size=0;
	}
	public int size() {
		return size;
	}
	public boolean isEmpty() {
		return size==0;
	}
	public void enqueue(T ele) {
		Node <T>data=new Node<>(ele);
		size++;
		if(front==null) {
			front=data;
			rear=data;
			return ;
		}
		rear.next=data;
		rear=rear.next;
		
	}
	public T  dequeue() throws QueueEmptyException{
		if(isEmpty()) {
			throw new QueueEmptyException();
		}
		T ans=front.data;
		front=front.next;
		size--;
		return ans;
	}
	public T front() throws QueueEmptyException{
		if(isEmpty()) {
			throw new QueueEmptyException();
		}
		return front.data;
	}
     
	public static void main(String ars[]) throws QueueEmptyException {
		QueueUsingLL<Integer> queue=new QueueUsingLL<>();
		int i=0;
		while(i<6) {
			queue.enqueue(i);
			i++;
		}
		System.out.println(queue.isEmpty());
		int sum=0;
		while(!queue.isEmpty()) {
			sum=sum+queue.dequeue();
		}
		System.out.println(sum);
	}
}
