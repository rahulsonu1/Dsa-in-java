package tree;

public class BSTuse {

	public static void main(String[] args) {
		BST b=new BST();
		b.insert(5);
		b.insert(3);
		b.insert(6);
		b.insert(2);
		b.insert(4);
		b.insert(7);
		b.printTree();
		System.out.println(b.isPresent(3));
//		b.deleteData(3);
//		System.out.println(b.isPresent(3));
//		b.printTree();

	}

}
