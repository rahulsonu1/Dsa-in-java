package PrQueueHeap;

public class mergeKReturn implements Comparable<mergeKReturn> {
	int value;
	int vInArray;
	int posArray;
	public mergeKReturn(int value, int vInArray, int posArray) {
		this.value = value;
		this.vInArray = vInArray;
		this.posArray = posArray;
	}
	@Override
	public int compareTo(mergeKReturn o) {
		if(value<o.value) {
			return -1;
		}
		return 0;
	}
	
}
