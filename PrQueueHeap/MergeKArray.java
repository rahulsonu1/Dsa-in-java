package PrQueueHeap;

public class MergeKArray implements Comparable<MergeKArray> {
	int value;
	int posInArray;
	int posOfArray;
	public MergeKArray(int value,int posInArray,int posOfArray) {
		this.value=value;
		this.posInArray=posInArray;
		this.posOfArray=posOfArray;
	}
	@Override
	public int compareTo(MergeKArray o) {
		
		return this.value- o.value;
	}
}
