package queue;

public class QueueUse {
	public static void main(String args[]) throws QueueFullException {
		QueueUsingArray queue=new QueueUsingArray();
		int i=0;
		while(i<3) {
			queue.enqueue(i);
		}
	}

}
