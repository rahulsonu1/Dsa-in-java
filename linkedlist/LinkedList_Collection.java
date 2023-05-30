package linkedlist;

import java.util.LinkedList;

public class LinkedList_Collection {

	public static void main(String[] args) {
		LinkedList<Integer> list=new LinkedList<>();
		
		list.add(10);
		list.set(0,34);
		System.out.println(list.get(0));

	}

}
