package tree;

public class BinaryTree<T>{
	T data;
	BinaryTree<T> right;
	BinaryTree<T> left;
	
	public BinaryTree(T data) {
		this.data=data;
	}
}
