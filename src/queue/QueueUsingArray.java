package queue;

public class QueueUsingArray {
private static final Exception QueueEmptyException = null;
private int data[];
private int front;
private int rear;
private int size;
public QueueUsingArray() {
	data=new int[5];
	front=-1;
	rear=-1;
}
public int size() {
	return size;
}
public boolean isEmpty() {
	return size==0;
}
public void enqueue(int element) throws QueueFullException {
	if(size==data.length) {
		throw new QueueFullException();
	}
	if(size==0) {
		front=0;
	}
		rear++;
	data[rear]=element;
	size++;
}
public  int front() throws Exception {
	if(size==0) {
		throw QueueEmptyException;
	}
	return  data[front];
}



}
