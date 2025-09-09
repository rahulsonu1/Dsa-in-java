package hashMap;

import java.time.LocalDate;
import java.util.ArrayList;

public class Map<K,V> {
	ArrayList<MapNode<K,V>> buckets;
	int size=0;
	int bucketSize;
	public Map(){
		buckets=new ArrayList<MapNode<K,V>>();
		 bucketSize=5;
		 for(int i=0;i<bucketSize;i++) {
			 buckets.add(null);
		 }
	}
	public int getBucketIndex(K key) {
		int hc=key.hashCode();
		int index=hc%bucketSize;
		return index;
	}
	public int size() {
		return size;
	}
	
	
		 
	public void insert(K key,V value) {
		int index=getBucketIndex(key);
		MapNode<K, V> head=buckets.get(index);
		while(head!=null) {
			if(head.key.equals(key)) {
				head.value=value;
				return;
			}
			head=head.next;
		}
		head=buckets.get(index);
		MapNode<K, V> newNode=new MapNode<K,V>(key, value);
		newNode.next=head;
		buckets.set(index,newNode);
		size++;
		double loadFactor=1.0*(size)/bucketSize;
		if(loadFactor>=0.7) {
			reHash();
		}
	}
	
	
	public V getValue(K key) {
		int index=getBucketIndex(key);
		MapNode<K, V> head=buckets.get(index);
		while(head!=null) {
			if(head.key.equals(key)) {
				return head.value;
			}
			head=head.next;
		}
		return null;
	}
	public void removeKey(K key) {
		int index=getBucketIndex(key);
		MapNode<K, V> head=buckets.get(index);
		MapNode<K,V> prev=null;
		while(head!=null) {
			if(head.key.equals(key)) {
				if(prev!=null) {
					prev.next=head.next;
				}
				else {
					buckets.set(index, head.next);
				}
				size--;
			}
			prev=head;
			head=head.next;
		}
	}
	public void reHash() {
		ArrayList<MapNode<K,V>> temp=buckets;
		buckets=new ArrayList<>();
		for(int i=0;i<2*bucketSize;i++) {
			buckets.add(null);
		}
		size=0;
		bucketSize=2*bucketSize;
		for(int i=0;i<temp.size();i++) {
			MapNode<K,V> head=temp.get(i);
			while(head!=null) {
				insert(head.key, head.value);
				size++;
				head=head.next;
			}
			
		}
	}
	
		
	}

