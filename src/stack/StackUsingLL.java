package stack;
import linkedlist.Node;
public class StackUsingLL<T> {
	private Node<T> head;
	private int size;
	
	public StackUsingLL() {
		head=null;
		size=0;
	}
	
	public int size() {
		return size;
	}
	public void push(T element) {
		Node<T> newNode=new Node<>(element);
		newNode.next=head;
		head=newNode;
		size++;
		
	}
	public T top() throws StackEmptyException {
		if(head==null) {
			throw new StackEmptyException();
		}
		return head.data;
	}
	
	public T pop() throws StackEmptyException {
		if(head==null) {
			throw new StackEmptyException();
		}
		T temp=head.data;
		head=head.next;
		size--;
		return temp;
	}
	
	public boolean isEmpty() {
		return size()==0;
	}
	

}
