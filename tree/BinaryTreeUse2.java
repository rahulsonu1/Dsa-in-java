package tree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeUse2 {

	public static int sizeof(BinaryTree<Integer> root) {
		if(root==null) {
			return 0;
		}
		int left=sizeof(root.left);
		int right=sizeof(root.right);
		return left+right+1;
	}
	public static void lineByLine(BinaryTree<Integer> root) {
		if(root==null) {
			return;
		}
		Queue<BinaryTree<Integer>> queue=new LinkedList<>();
		queue.add(root);
		queue.add(null);
		while(!queue.isEmpty()) {
			BinaryTree<Integer> front=queue.poll();
			if(front==null && queue.isEmpty()) {
				break;
			}
			else if(front==null) {
				if(!queue.isEmpty()) {
					System.out.println();
					queue.add(null);
				}
			}
			else {
				System.out.print(front.data+" ");
				if(front.left!=null) {
					queue.add(front.left);
				}
				if(front.right!=null) {
					queue.add(front.right);
				}
			}
			
		}
	}
	
	public static void printSpiral(BinaryTree<Integer> root) {
		if(root==null) {
			return;
		}
		Queue<BinaryTree<Integer>> queue=new LinkedList<>();
		Stack<BinaryTree<Integer>> stack=new Stack<>();
		boolean reverse=false;
		queue.add(root);
		while(!queue.isEmpty()) {
			int count=queue.size();
			for(int i=0;i<count;i++) {
				BinaryTree<Integer> front=queue.poll();
				if(reverse) {
					stack.push(stack.push(front));
				}
				else {
					System.out.print(front.data+" ");
				}
				
				if(front.left!=null) {
					queue.add(front.left);
				}
				if(front.right!=null) {
					queue.add(front.right);
				}
			}
				if(reverse) {
					while(!stack.isEmpty()) {
						System.out.print(stack.pop().data+" ");
					}
				}
				reverse=!reverse;
				System.out.println();
				}
	}
	
	public static void printspiralTwoS(BinaryTree<Integer> root) {
		if(root==null) {
			return ;
		}
		ArrayList<ArrayList<Integer>> list=new ArrayList<>();
		Stack<BinaryTree<Integer>>s1=new Stack<>();
		Stack<BinaryTree<Integer>>s2=new Stack<>();
		s1.push(root);
		while(!s1.isEmpty()||!s2.isEmpty()) {
			ArrayList<Integer> l1=new ArrayList<Integer>();
			ArrayList<Integer> l2=new ArrayList<Integer>();
			while(!s1.isEmpty()) {
				BinaryTree<Integer> front=s1.pop();
//				System.out.print(front.data+" ");
				l1.add(front.data);
				
				if(front.left!=null) {
					s2.add(front.left);
				}
				if(front.right!=null) {
					s2.add(front.right);
				}
			}
			if(!l1.isEmpty()) {
			list.add(l1);
			}
//			System.out.println();
			while(!s2.isEmpty()) {
//				ArrayList<Integer> l=new ArrayList<>();
				BinaryTree<Integer> front=s2.pop();
//				System.out.print(front.data+" ");
				l2.add(front.data);
				
				if(front.right!=null) {
					s1.add(front.right);
				}
				if(front.left!=null) {
					s1.add(front.left);
				}
				
			}
			if(!l2.isEmpty()) {
			list.add(l2);
			}
//			System.out.println();
			
		}
		System.out.println(list);
		
	}
	
	public static void pathtoK(BinaryTree<Integer>root,int k,String path) {
		if(root==null) {
			return;
		}
		
		if(root.left==null && root.right==null) {
			k=k-root.data;
		}
		if(k==0) {
			System.out.println(path+root.data+" ");
			return ;
		}
		pathtoK(root.left, k-root.data, path+root.data+" ");
		pathtoK(root.right, k-root.data, path+root.data+" ");
		
	}
	
	public static PairReturn constLL(BinaryTree<Integer> root) {
		if(root==null) {
			PairReturn p=new PairReturn();
			return p;
		}
		
	}
	
	
	public static void main(String[] args) {
		BinaryTree<Integer> root=BinaryTreeUse.takeinputLevelwise();
		BinaryTreeUse.printLevewise(root);
//		System.out.println(sizeof(root));
//		lineByLine(root);
//		printSpiral(root);
//		printspiralTwoS(root);
//		pathtoK(root, 22, "");

	}

}
