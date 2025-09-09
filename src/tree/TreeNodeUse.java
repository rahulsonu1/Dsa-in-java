package tree;
import queue.QueueEmptyException;
import queue.QueueUsingLL;
import java.util.Scanner;

public class TreeNodeUse {
	private static TreeNode<Integer> takeInput(Scanner sc) {
		
		System.out.println("Enter the next data : ");
		int n=sc.nextInt();
		TreeNode<Integer> root=new TreeNode<Integer>(n);
		System.out.println("Enter the number of children of "+ n);
		int childCount=sc.nextInt();
		for(int i=0;i<childCount;i++) {
			TreeNode<Integer> child=takeInput(sc);
			root.children.add(child);
		}
		return root;
	}
	public static void print(TreeNode<Integer> root) {
		String s=root.data+" :";
		for(int i=0;i<root.children.size();i++) {
			s=s+root.children.get(i).data+ "  ";
		}
		System.out.println(s);
		for(int i=0;i<root.children.size();i++) {
			print(root.children.get(i));
		}
	}
	
	public static TreeNode<Integer> takeInputLevelWise(){
		Scanner sc=new Scanner(System.in);
		QueueUsingLL<TreeNode<Integer>> queue=new QueueUsingLL<TreeNode<Integer>>();
		System.out.println("enter data");
		int data=sc.nextInt();
		TreeNode<Integer> root=new TreeNode<>(data);
		queue.enqueue(root);
		while(!queue.isEmpty()) {
			try {
				TreeNode<Integer> frontNode=queue.dequeue();
				System.out.println("Enter the number of child of "+ frontNode.data);
				int childCount=sc.nextInt();
				for(int i=0;i<childCount;i++) {
					System.out.println("Enter "+(i+1)+" child ");
					int child=sc.nextInt();
					TreeNode<Integer> childNode=new TreeNode<Integer>(child);
					frontNode.children.add(childNode);
					queue.enqueue(childNode);
					
				}
			} catch (QueueEmptyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return root;
	}
	
	public static void printLevelWise(TreeNode<Integer> root) {
		QueueUsingLL<TreeNode<Integer>> queue= new QueueUsingLL<>();
		queue.enqueue(root);
		while(!queue.isEmpty()) {
			try {
				TreeNode<Integer> frontNode=queue.dequeue();
				String s=frontNode.data+" : ";
				int n=frontNode.children.size();
				for(int i=0;i<n;i++) {
					TreeNode<Integer> childNode=frontNode.children.get(i);
					s=s+childNode.data+" ";
					queue.enqueue(childNode);
				}
				System.out.println(s);
			} catch (QueueEmptyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

	public static int countNode(TreeNode<Integer> root) {
		if(root==null) {
			return 0;
		}
		int count=1;
		for(int i=0;i<root.children.size();i++) {
			count+=countNode(root.children.get(i));
		}
		return count;
	}
	
	public static int largestNodeData(TreeNode<Integer> root) {
		if(root==null) {
			return Integer.MIN_VALUE;
		}
		int ans=root.data;
		for(int i=0;i<root.children.size();i++) {
			int childLargest=largestNodeData(root.children.get(i));
			if(ans<childLargest) {
				ans=childLargest;
			}
		}
		return ans;
	}
	
	public static int height(TreeNode<Integer> root) {
		if(root==null) {
			return 0;
		}
		int max=1;
		for(int i=0;i<root.children.size();i++) {
			int childheight=height(root.children.get(i));
			max=Math.max(max, childheight)+1;
		}
		return max;
	}
	
	public static void printAtDepthK(TreeNode<Integer> root ,int k) {
		if(root==null || k<0) {
			return ;
		}
		if(k==0) {
			System.out.println(root.data);
		}
		for(int i=0;i<root.children.size();i++) {
			printAtDepthK(root.children.get(i),k-1);
		}
	}
	
	public static int countLeaf(TreeNode<Integer> root) {
		if(root==null) {
			return 0;
		}
		int count=0;
		if(root.children.size()==0) {
			count++;
		}
		for(int i=0;i<root.children.size();i++) {
			count+=countLeaf(root.children.get(i));
		}
		return count;
	}
	
	public static void preorder(TreeNode<Integer> root) {
		if(root==null) {
			return ;
		}
		System.out.print(root.data+" ");
		for(int i=0;i<root.children.size();i++) {
			preorder(root.children.get(i));
		}
	}
	
	public static void postorder(TreeNode<Integer> root) {
		if(root==null) {
			return ;
		}
		
		for(int i=0;i<root.children.size();i++) {
			postorder(root.children.get(i));
		}
		System.out.print(root.data+" ");
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
//		TreeNode<Integer> root=takeInput(sc);
		TreeNode<Integer> root=takeInputLevelWise();
//		print(root);
//		printLevelWise(root);
//		System.out.println(countNode(root));
//		System.out.println(largestNodeData(root));
//		System.out.println(height(root));
//		printAtDepthK(root, 2);
//		System.out.println(countLeaf(root));
//		preorder(root);
		postorder(root);
		

	}

	

}
