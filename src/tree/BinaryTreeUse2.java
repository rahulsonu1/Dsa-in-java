package tree;
import tree.BinaryTreeUse;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
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
	
	public static void zigzagTraversal(BinaryTree<Integer> root){
		ArrayList<ArrayList<Integer>>list=new ArrayList<>();
		if(root==null) {
			return ;
		}
		Queue<BinaryTree<Integer>> queue=new LinkedList<>();
		queue.add(root);
		boolean flag=false;
		while(!queue.isEmpty()) {
			int size=queue.size();
			ArrayList<Integer>ans=new ArrayList<>();
			Stack<Integer>stack =new Stack<>();
			for(int i=0;i<size;i++) {
				BinaryTree<Integer> front=queue.poll();
				if(flag) {
					stack.push(front.data);
				}
				else {
					ans.add(front.data);
				}
				if(front.left!=null) queue.add(front.left);
				if(front.right!=null) queue.add(front.right);
			}
			flag=!flag;
			while(!stack.isEmpty()) {
				ans.add(stack.pop());
			}
			list.add(ans);
		}
		System.out.println(list);
	}
	public static void levelSuccessor(BinaryTree<Integer> root,int key) {
		if(root==null) {
			return ;
		}
		Queue<BinaryTree<Integer>> queue=new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			int size=queue.size();
			for(int i=0;i<size;i++) {
				BinaryTree<Integer> front=queue.poll();
				if(front.data==key) {
					if(!queue.isEmpty() && queue.peek()!=null) {
						System.out.println(queue.poll().data);
					}else {
						System.out.println("null");
					}
					return;
				}
				if(front.left!=null) queue.add(front.left);
				if(front.right!=null) queue.add(front.right);
			}
		}
	}
	
	public static void isCousin(BinaryTree<Integer>root,int x,int y) {
		if(root==null) { System.out.println("False"); return;}
		int levelX=levelOfNode(root, x, 0);
		int levelY=levelOfNode(root, y, 0);
		if(levelX==-1||levelY==-1) {
			System.out.println("False");
			return ;
		}
	    if((levelX == levelY) && !isSibling(root, x, y)){
	    	System.out.println("True");
	    }

	}
	public static int levelOfNode(BinaryTree<Integer>root,int x,int level) {
		if(root==null) return -1;
		if(root.data==x) return level;
		
		int leftans=levelOfNode(root.left, x, level+1);
		if(leftans!=-1) {
			return leftans;
		}
		return levelOfNode(root.right,x,level+1);
	}
	public static Boolean isSibling(BinaryTree<Integer>root,int x,int y) {
		if(root==null) return false;
		if(root.left!=null && root.right!=null) {
			if((root.left.data==x && root.right.data==y)||(root.right.data==x && root.left.data==y)) {
				return true;
			}
		}
		return isSibling(root.left, x, y)||isSibling(root.right, x, y);
	}
	
	public static void rightSideView(BinaryTree<Integer>root) {
		if(root==null) return;
		Queue<BinaryTree<Integer>>queue=new LinkedList<>();
		queue.add(root);
		ArrayList<Integer>list=new ArrayList<>();
		while(!queue.isEmpty()) {
			int size=queue.size();
			for(int i=0;i<size;i++) {
				BinaryTree<Integer>front=queue.poll();
				if(i==size-1) {
					list.add(front.data);
				}
				if(front.left!=null) queue.add(front.left);
				if(front.right!=null) queue.add(front.right);
			}
		}
		System.out.println(list);
	}
	
	public static void verticalTraversal(BinaryTree<Integer>root) {
		HashMap<Integer,ArrayList<Integer>>map=new HashMap<>();
		Queue<VerticalPair>queue=new LinkedList<>();
		queue.add(new VerticalPair(root, 0));
		while(!queue.isEmpty()) {
			int size=queue.size();
			for(int i=0;i<size;i++) {
				VerticalPair front=queue.poll();
				if(!map.containsKey(front.hl)) {
					ArrayList<Integer>list=new ArrayList<>();
					list.add(front.node.data);
					map.put(front.hl,list);
				}else {
					ArrayList<Integer>list=map.get(front.hl);
					list.add(front.node.data);
					map.put(front.hl,list);
				}
				if(front.node.left!=null) {
					queue.add(new VerticalPair(front.node.left, front.hl-1));
				}
				if(front.node.right!=null) {
					queue.add(new VerticalPair(front.node.right,front.hl+1));
				}
			}
			
		}
		System.out.println(map);
	}
	public static void widthOftree(BinaryTree<Integer>root,int hl,int[] minMax) {
		if(root==null) return;
		minMax[0]=Math.min(minMax[0],hl);
		minMax[1]=Math.max(minMax[1], hl);
		widthOftree(root.left, hl-1, minMax);
		widthOftree(root.right, hl+1, minMax);
	}
	
	public static void bottomview(BinaryTree<Integer> root) {// similar for top view
		int minMax[]=new int[2];
		widthOftree(root, 0, minMax);
		int width=minMax[1]-minMax[0]+1;
		Queue<VerticalPair> queue=new LinkedList<>();
		queue.add(new VerticalPair(root, Math.abs(minMax[0])));
		ArrayList<Integer>list=new ArrayList<>();
		for(int i=0;i<width;i++) list.add(0);
		while(!queue.isEmpty()) {
			int size=queue.size();
			for(int i=0;i<size;i++) {
				VerticalPair front=queue.poll();
				list.set(front.hl, front.node.data);
				if(front.node.left!=null) {
					queue.add(new VerticalPair(front.node.left, front.hl-1));
				}
				if(front.node.right!=null) {
					queue.add(new VerticalPair(front.node.right,front.hl+1));
				}
			}
		}
		System.out.println(list);
	}
	public static void diagonalTraversal(BinaryTree<Integer>root) {
		ArrayList<Integer>list=new ArrayList<>();
		Queue<BinaryTree<Integer>>queue=new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			BinaryTree<Integer>front=queue.poll();
			BinaryTree<Integer> curr=front;
			while(curr!=null) {
				list.add(curr.data);
				if(curr.left!=null) {
					queue.add(curr.left);
				}
				curr=curr.right;
			}
		}
		System.out.println(list);
		
	}
	static int sum=0;
	
	public static int maximumPathSum(BinaryTree<Integer> root) {
		if(root==null) return 0;
		int leftAns=Math.max(0, maximumPathSum(root.left));
		int rightAns=Math.max(0,maximumPathSum(root.right));
		sum=Math.max(sum,leftAns+rightAns+root.data);
		System.out.println(sum);
		return Math.max(leftAns, rightAns)+root.data;
		
	}
	public static void pathSum2(BinaryTree<Integer>root, int target) {
		ArrayList<ArrayList<Integer>>list=new ArrayList<>();
		ArrayList<Integer>curr=new ArrayList<>();
		pathSum2Helper(root, target,curr,list);
		System.out.println(list);
		
	}
	public static void  pathSum2Helper(BinaryTree<Integer>root,int target,ArrayList<Integer>curr,ArrayList<ArrayList<Integer>>list){
		if(root==null) {
			return ;
		}
		curr.add(root.data);
		if(root.left==null && root.right==null && root.data==target ) {
			list.add(new ArrayList<Integer>(curr));
		}else {
		pathSum2Helper(root.left, target-root.data, curr, list);
		pathSum2Helper(root.right, target-root.data, curr, list);
		}
		curr.remove(curr.size()-1);
	}
	public static BinaryTree<Integer> cousin2(BinaryTree<Integer>root){
		ArrayList<Integer>list=new ArrayList<>();
		Queue<BinaryTree<Integer>>queue=new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			int size=queue.size();
			int sum=0;
			for(int i=0;i<size;i++) {
				BinaryTree<Integer>front=queue.poll();
				sum=sum+front.data;
				if(front.left!=null) {
					queue.add(front.left);
				}
				if(front.right!=null) {
					queue.add(front.right);
				}
			}
			list.add(sum);
		}
		queue.clear();
		queue.add(root);
		root.data=0;
		int level=1;
		while(!queue.isEmpty()) {
			int size=queue.size();
			for(int i=0;i<size;i++) {
				BinaryTree<Integer>front=queue.poll();
				int siblingSum=(front.left!=null?front.left.data:0)+(front.right!=null?front.right.data:0);
				if(front.left!=null) {
					front.left.data=list.get(level)-siblingSum;
					queue.add(front.left);
				}
				if(front.right!=null) {
					front.right.data=list.get(level)-siblingSum;
					queue.add(front.right);
				}
				
			}
			level++;
		}
		return root;
	}
	static int maxDistance;
	public static void burnTree(BinaryTree<Integer> root, int target) {
		maxDistance=-110;
		burnHelper(root, target);
		System.out.println(maxDistance);
	}
	public static int burnHelper(BinaryTree<Integer> root,int target) {
		if(root==null) return -1;
		if(root.data==target) {
			maxDistance=Math.max(maxDistance,maxDownDistance(root));
			return 0;
		}
		int ld=burnHelper(root.left, target);
		if(ld!=-1) {
			maxDistance=Math.max(maxDistance,ld+1+maxDownDistance(root.right));
			return ld+1;
		}
		int rd=burnHelper(root.right, target);
		if(rd!=-1) {
			maxDistance=Math.max(maxDistance,rd+1+maxDownDistance(root.left));
			return rd+1;
		}
		return -1;
	}
	public static int maxDownDistance(BinaryTree<Integer>root) {
		if(root==null) return 0;
		int leftAns=maxDownDistance(root.left);
		int rightAns=maxDownDistance(root.right);

		return Math.max(leftAns, rightAns)+1;
	}
	public static BinaryTree<Integer> lca(BinaryTree<Integer>root,int a,int b){
		if(root==null||root.data==a||root.data==b) {
			return root;
		}
		BinaryTree<Integer>leftAns=lca(root.left, a, b);
		BinaryTree<Integer>rightAns=lca(root.right,a,b);
		if(leftAns!=null && rightAns!=null) {
			return root;
		}
		if(leftAns==null)return rightAns;
		return leftAns;
	}
	public static int findDistanceHelper(BinaryTree<Integer>root,int a,int distance) {
		if(root==null)return -1;
		if(root.data==a) return distance;
		int leftAns=findDistanceHelper(root.left, a, distance+1);
		if(leftAns!=-1)return distance;
		return findDistanceHelper(root.right, a, distance+1);
	}
	
	public static void minDistanceBetweenNode(BinaryTree<Integer>root,int a,int b) {
		BinaryTree<Integer>lca=lca(root,a,b);
		int leftAns=findDistanceHelper(lca, a, 0);
		int rightAns=findDistanceHelper(lca, b, 0);
		System.out.println(leftAns+rightAns);
		
	}
	public static void boundaryTraversal(BinaryTree<Integer>root) {
		ArrayList<Integer>list=new ArrayList<>();
		list.add(root.data);
		BinaryTree<Integer>curr=root.left;
		while(curr!=null) {
			if(!(curr.left==null && curr.right==null)) {
				list.add(curr.data);
			}
			
			if(curr.left!=null) {
				curr=curr.left;
			}else {
				curr=curr.right;
			}
		}
		Stack<BinaryTree<Integer>> stack = new Stack<>();
		if (root != null) {
		    stack.push(root);
		}
		while (!stack.isEmpty()) {
		    BinaryTree<Integer> current = stack.pop();
		    
		    if (current.left == null && current.right == null && current!=root) {
		        list.add(current.data);
		    }
		    if (current.right != null) {
		        stack.push(current.right);
		    }
		    if (current.left != null) {
		        stack.push(current.left);
		    }
		}
		curr=root.right;
		Stack<Integer>st=new Stack<Integer>();
		while(curr!=null) {
			if(!(curr.left==null && curr.right==null)) {
				st.push(curr.data);
			}
			
			curr=curr.right!=null?curr.right:curr.left;
		}
		while(!st.isEmpty()) list.add(st.pop());
		System.out.println(list);
		
	}
	public static void maximumWidth(BinaryTree<Integer>root) {
		Queue<VerticalPair>queue=new LinkedList<>();
		queue.add(new VerticalPair(root,1));
		int max=0;
		while(!queue.isEmpty()) {
			int size=queue.size();
			int first =0;
			int last=0;
			for(int i=0;i<size;i++) {
				VerticalPair front=queue.poll();
					if(i==0) {
						first=front.hl;
					}if(i==size-1) {
						last=front.hl;
					}
					
					if(front.node.left!=null) {
						queue.add(new VerticalPair(front.node.left, front.hl*2));
					}
					if(front.node.right!=null) {
						queue.add(new VerticalPair(front.node.right,front.hl*2+1));
					}
					
			}
			
			if(last==first) {
				max=Math.max(1, max);
			}else {
				max=Math.max(last-first+1, max);
			}
		}
		System.out.println(max);
	}
	
	public static boolean isIncreasing(int arr[],int size) {
		if(arr[0]%2!=1) return false;
		for(int i=1;i<size;i++) {
			if(arr[i]<=arr[i-1] || arr[i]%2!=1) {
				return false;
			}
		}
		return true;
	}
	public static  boolean isDecreasing(int arr[],int size) {
		if(arr[0]%2!=0) return false;
		for(int i=1;i<size;i++) {
			if(arr[i]>=arr[i-1] || arr[i]%2!=0) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean evenOddTree(BinaryTree<Integer>root) {
		
		boolean even=true;
		Queue<BinaryTree<Integer>>queue=new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			int size=queue.size();
			int arr[]=new int[size];
			for(int i=0;i<size;i++) {
				BinaryTree<Integer>front=queue.poll();
				arr[i]=front.data;
				if(front.left!=null) queue.add(front.left);
				if(front.right!=null) queue.add(front.right);
			}
			if(even) { 
				if(!isIncreasing(arr, size)) {
					return false;
				}
			}
			if(!even) {
				if(!isDecreasing(arr, size)) {
					return false;
				}
			}
			even=!even;
			
		}
		return true;
	}
	
	
	
	
	


	
	public static void main(String[] args) {
		BinaryTree<Integer> root=BinaryTreeUse.takeinputLevelwise();
		BinaryTreeUse.printLevewise(root);
//		isCousin(root, 2, 3);
//		zigzagTraversal(root);
//		levelSuccessor(root, 3);
//		System.out.println(sizeof(root));
//		lineByLine(root);
//		printSpiral(root);
//		printspiralTwoS(root);
//		pathtoK(root, 22, "");
//		rightSideView(root);
//		verticalTraversal(root);
//		bottomview(root);
//		diagonalTraversal(root);
//		maximumPathSum(root);
//		pathSum2(root, 22);
//		root=cousin2(root);
//		BinaryTreeUse.printLevewise(root);
//		burnTree(root, 3);
//		minDistanceBetweenNode(root, maxDistance, maxDistance);
//		boundaryTraversal(root);
//		maximumWidth(root);
//		System.out.println(evenOddTree(root));
		

		
	}

}
