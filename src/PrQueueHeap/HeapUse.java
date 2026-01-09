package PrQueueHeap;

public class HeapUse {

	public static void main(String[] args) throws Exception {
		Heap<Integer> heap=new Heap<Integer>();
		heap.insert(3);
		heap.insert(34);
		heap.insert(354);
		heap.insert(13);
		heap.insert(354343434);
		
		while(!heap.isEmpty()) {
			System.out.println(heap.remove());
		}
		
		
		
	}

}
