package PrQueueHeap;

import java.util.ArrayList;

public class Heap<T extends Comparable<T>> {
	private ArrayList<T> list;
	
	public Heap() {
		list=new ArrayList<>();
	}
	private void swap(int first,int second) {
		T temp=list.get(first);
		list.set(first, list.get(second));
		list.set(second, temp);
	}
	private int parent(int index) {
		return (index-1)/2;
		
	}
	private int leftIndex(int index) {
		return 2*index+1;
	}
	private int rightIndex(int index) {
		return 2* index+2;
	}
	private int size() {
		return list.size();
	}
	public void insert(T value) {
		list.add(value);
		int index=size()-1; 
		
		int parentIndex=parent(index);
		
		while(index>=0 && list.get(index).compareTo(list.get(parentIndex)) > 0) {
			swap(parentIndex,index);
			index=parentIndex;
			parentIndex=parent(index);
		}
	}
	public boolean isEmpty() {
		return size()==0;
	}
	public T remove() throws Exception {
		if(size()==0) {
			throw new Exception("Removing from empty Heap");
		}
		T removedItem=list.get(0);
		T lastItem=list.remove(size()-1);
		if(size()!=0) {
			list.set(0,lastItem);
		}
		int parentIndex=0;
		int leftIndex=leftIndex(parentIndex);
		int rightIndex=rightIndex(parentIndex);
		while(parentIndex<size()) {
			int maxIndex=parentIndex;
			if(leftIndex<size() && list.get(leftIndex).compareTo(list.get(maxIndex)) > 0) {
				maxIndex=leftIndex;
			}
			if(rightIndex<size() && list.get(rightIndex).compareTo(list.get(maxIndex))>0) {
				maxIndex=rightIndex;
			}
			if(maxIndex==parentIndex) {
				break;
			}
			swap(maxIndex,parentIndex);
			parentIndex=maxIndex;
			leftIndex=leftIndex(parentIndex);
			rightIndex=rightIndex(parentIndex);
		}
		return removedItem;
	}
	



}
