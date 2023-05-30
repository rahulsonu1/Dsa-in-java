package tree;

public class BST {
	private BinaryTree<Integer> root;
	int size;
	
	private static boolean isPresentHelper(BinaryTree<Integer> root,int x) {
		if(root==null) {
			return false;
		}
		if(root.data==x) {
			return true;
		}
		else if(root.data<x) {
			return isPresentHelper(root.left, x);
		}
		else { isPresentHelper(root.right, x);
		}
		return false;
	}
	public boolean isPresent(int x) {
		return isPresentHelper(root,x);
	}
	private static BinaryTree<Integer> insertNode(BinaryTree<Integer> root,int x){
		if(root==null) {
			BinaryTree<Integer> newRoot=new BinaryTree<Integer>(x);
			return newRoot;
		}
		if(x>=root.data) {
			root.right=insertNode(root.right, x);
		}
		else {
			root.left=insertNode(root.left, x);
		}
		return root;
	}
	public void insert(int x) {
		root=insertNode(root, x);
		size++;
	}
	private static int minimum(BinaryTree<Integer> root) {
		if(root==null) {
			return Integer.MAX_VALUE;
		}
		int leftSubTree=minimum(root.left);
		int rightSubTree=minimum(root.right);
		return Math.min(root.data, Math.min(leftSubTree, rightSubTree));
	}
	
	private static DeleteBSTReturn deleteDataHelper(BinaryTree<Integer> root,int x) {
		if(root==null) {
			return new DeleteBSTReturn(null, false);
		}
		if(root.data<x) {
			DeleteBSTReturn rightOutput=deleteDataHelper(root.right, x);
			root.right=rightOutput.root;
			return rightOutput;
		}
		if(root.data>x) {
			DeleteBSTReturn leftOutput=deleteDataHelper(root.left, x);
			root.left=leftOutput.root;
			leftOutput.root=root;
			return leftOutput;
		}
		if(root.left==null && root.right==null) {
			return new DeleteBSTReturn(null, true);
		}
		if(root.right!=null &&  root.left==null) {
			return new DeleteBSTReturn(root.right, true);
		}
		if(root.right==null &&  root.left!=null) {
			return new DeleteBSTReturn(root.left, true);
		}
		int rightMin=minimum(root.right);
		root.data=rightMin;
		DeleteBSTReturn rightOutput=deleteDataHelper(root.right, rightMin);
		root.right=rightOutput.root;
		return new DeleteBSTReturn(root, true);
		
	}
	
	public boolean deleteData(int x) {
		DeleteBSTReturn output=deleteDataHelper(root, x);
		if(output.deleted) {
			size--;
		}
		return output.deleted;
	}
	public int size() {
		return size;
	}
	private static void printTreeHelper(BinaryTree<Integer> root) {
		if(root==null) {
			return;
		}
		System.out.print(root.data+": ");
		if(root.left!=null) {
			System.out.print("L "+root.left.data+" ,");
		}
		if(root.right!=null) {
			System.out.print("R "+root.right.data);
		}
		System.out.println();
		printTreeHelper(root.left);
		printTreeHelper(root.right);
	}
	public void printTree() {
		printTreeHelper(root);
	}
}
