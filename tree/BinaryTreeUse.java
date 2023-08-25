package tree;

import java.util.*;
import java.util.ArrayList;
import java.util.LinkedList;

import java.util.Queue;
import java.util.Scanner;

import javax.naming.BinaryRefAddr;

import ArrayList.Arraylist;
import queue.QueueEmptyException;
import queue.QueueUsingLL;
import java.util.LinkedList;
public class BinaryTreeUse {
	
	public static void printTree(BinaryTree<Integer> root) {
		if(root==null) {
			return;
		}
		System.out.print(root.data+" ");
		printTree(root.left);
		printTree(root.right);
	}
	
	public static void printTreeDetailed(BinaryTree<Integer> root) {
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
		printTreeDetailed(root.left);
		printTreeDetailed(root.right);
	}
	
	public static BinaryTree<Integer> takeInput(){
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the root data");
		int rootdata=sc.nextInt();
		if(rootdata==-1) {
			return null;
		}
		BinaryTree<Integer> root=new BinaryTree<Integer>(rootdata);
		BinaryTree<Integer>leftTree=takeInput();
		BinaryTree<Integer> rightTree=takeInput();
		root.left=leftTree;
		root.right=rightTree;
		return root;
	}
	
	public static BinaryTree<Integer> takeInputBetter(boolean isRoot,int parentData,boolean isLeft){
		Scanner sc=new Scanner(System.in);
		if(isRoot) {
		System.out.println("Enter the root data");
		}
		else {
			if(isLeft) {
				System.out.println("Enter left data of "+parentData);
			}
			else {
				System.out.println("Enter right data of "+parentData);
			}
		}
		int rootdata=sc.nextInt();
		if(rootdata==-1) {
			return null;
		}
		BinaryTree<Integer> root=new BinaryTree<Integer>(rootdata);
		BinaryTree<Integer>leftTree=takeInputBetter(false,rootdata,true);
		BinaryTree<Integer> rightTree=takeInputBetter(false,rootdata,false);
		root.left=leftTree;
		root.right=rightTree;
		return root;
	}
	
	public static int countNode(BinaryTree<Integer> root) {
		if(root==null) {
			return 0;
		}
		int leftCount=countNode(root.left);
		int rightCount=countNode(root.right);
		return leftCount+rightCount+1;
	}
	public static void preoder(BinaryTree<Integer> root) {
		if(root==null) {
			return;
		}
		System.out.print(root.data+" ");
		preoder(root.left);
		preoder(root.right);
	}
	public static void postorder(BinaryTree<Integer> root) {
		if(root==null) {
			return ;
		}
		postorder(root.left);
		postorder(root.right);
		System.out.print(root.data+" ");
	}
	
	public static int largestNode(BinaryTree<Integer> root) {
		if(root==null) {
			return -1;
		}
		int leftLargest=largestNode(root.left);
		int rightLargest=largestNode(root.right);
		return Math.max(root.data, Math.max(leftLargest, rightLargest));
	}
	
	public static int countLarger(BinaryTree<Integer> root,int x) {
		if(root==null) {
			return 0;
		}
		int count=(root.data>x)? 1:0;
//		if(root.left!=null) {
		count=count+countLarger(root.left, x);
//		if(root.right!=null) {
		count=count+countLarger(root.right, x);
		
		return count;
	}
	
	public static int height(BinaryTree<Integer> root) {
		if(root==null) {
			return 0;
		}
		int left=height(root.left);
		int right=height(root.right);
		return Math.max(left, right)+1;
	}
	
	public static int countLeaves(BinaryTree<Integer> root) {
		if(root==null) {
			return 0;
		}
		int count=0;
		if(root.left==null && root.right==null) {
			count++;
		}
		count=count+countLeaves(root.left);
		count=count+countLeaves(root.right);
		return count;
	}
	
	public static void printNodeAtDepthK(BinaryTree<Integer> root,int k) {
		if(root==null) {
			return ;
		}
		if(k==0) {
			System.out.print(root.data+" ");
		}
		printNodeAtDepthK(root.left, k-1);
		printNodeAtDepthK(root.right, k-1);
	}
	public static void replaceDataWithHeight(BinaryTree<Integer> root,int level) {
		if(root==null) {
			return;
		}
		root.data=level;
		replaceDataWithHeight(root.left, level+1);
		replaceDataWithHeight(root.right, level+1);
	}
	
	
	public static void printNodeWithoutSibling(BinaryTree<Integer> root) {
		if(root==null) {
			return ;
		}
		if(root.left==null && root.right!=null) {
			System.out.print(root.right.data+" ");
		}
		else if(root.left!=null && root.right==null) {
			System.out.print(root.left.data+" ");
		}
		printNodeWithoutSibling(root.left);
		printNodeWithoutSibling(root.right);
	}
	
	public static BinaryTree<Integer> removeLeafNode(BinaryTree<Integer> root){
		if(root==null) {
			return null;
		}
		if(root.left==null && root.right==null) {
			return null;
		}
		root.left=removeLeafNode(root.left);
		root.right=removeLeafNode(root.right);
		return root;
	}
	
	public static BinaryTree<Integer> mirrorTree(BinaryTree<Integer> root){
		if(root==null) {
			return root;
		}
		BinaryTree<Integer> templeft=root.left;
		root.left=root.right;
		root.right=templeft;
		mirrorTree(root.left);
		mirrorTree(root.right);
		return root;
	}
	
	public static boolean isBalanced(BinaryTree<Integer> root) {
		if(root==null) {
			return true;
		}
		int leftHeight=height(root.left);
		int rightHeight=height(root.right);
		if(Math.abs(leftHeight-rightHeight)>1) {
			return false;
		}
		boolean leftBalanced=isBalanced(root.left);
		boolean rightBalanced=isBalanced(root.right);
		return leftBalanced && rightBalanced;
		
	}
	
	public static BalancedTreeReturn isBalancedBetter(BinaryTree<Integer> root) {
		if(root==null) {
			int height=0;
			boolean isBalanced=true;
			BalancedTreeReturn ans=new BalancedTreeReturn();
			ans.height=height;
			ans.isBalanced=isBalanced;
			return ans;
		}
		BalancedTreeReturn leftOutput=isBalancedBetter(root.left);
		BalancedTreeReturn rightOutput=isBalancedBetter(root.right);
		Boolean isBal=true;
		int height=1+Math.max(leftOutput.height, rightOutput.height);
		if(!leftOutput.isBalanced||!rightOutput.isBalanced) {
			isBal=false;
		}
		if(Math.abs(leftOutput.height-rightOutput.height)>1) {
			isBal=false;
		}
		BalancedTreeReturn ans=new BalancedTreeReturn();
		ans.height=height;
		ans.isBalanced=isBal;
		return ans;
	}
	
	public static int diameter(BinaryTree<Integer> root) {
		if(root==null) {
			return 0;
		}
		int op1=height(root.left)+height(root.right);
		int op2=diameter(root.left);
		int op3=diameter(root.right);
		return Math.max(Math.max(op2, op3), op1);
	}
	
	public static Pair diameterBetter(BinaryTree<Integer> root) {
		if(root==null) {
			Pair ans=new Pair(0, 0);
			return ans;
		}
		Pair leftOutput=diameterBetter(root.left);
		Pair rightOutput=diameterBetter(root.right);
		int leftDiameter=leftOutput.diameter;
		int rightDiameter=rightOutput.diameter;
		int height=Math.max(leftOutput.height, rightOutput.height)+1;
		int distance=leftOutput.height+rightOutput.height+1;
		int diameter=Math.max(rightDiameter, Math.max(leftDiameter, distance));
		
		Pair ans=new Pair(diameter,height);
		return ans;
		
	}
	
	public static BinaryTree<Integer> takeinputLevelwise(){
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter root data");
		int rootdata=sc.nextInt();
		if(rootdata==-1) {
			return null;
		}
		Queue<BinaryTree<Integer>> pendingQueue=new LinkedList<>();
		BinaryTree<Integer> root=new BinaryTree<Integer>(rootdata);
		pendingQueue.add(root);
		while(!pendingQueue.isEmpty()) {
			BinaryTree<Integer> front=pendingQueue.poll();
			System.out.println("Enter the left child of "+ front.data);
			int leftChildData=sc.nextInt();
			if(leftChildData!=-1) {
				BinaryTree<Integer> leftChild=new BinaryTree<Integer>(leftChildData);
				front.left=leftChild;
				pendingQueue.add(leftChild);
			}
			System.out.println("Enter the right child of " + front.data);
			int rightChildData=sc.nextInt();
			if(rightChildData!=-1) {
				BinaryTree<Integer> rightChild= new BinaryTree<Integer>(rightChildData);
				front.right=rightChild;
				pendingQueue.add(rightChild);
			}
		
		}
		return root;
	}

	public static void printLevewise(BinaryTree<Integer> root) {
		if(root==null) {
			return;
		}
		QueueUsingLL<BinaryTree<Integer>> queue=new QueueUsingLL<>();
		queue.enqueue(root);
		while(!queue.isEmpty()) {
			try {
				BinaryTree<Integer> front= queue.dequeue();
				System.out.print(front.data+" : ");
				if(front.left!=null) {
					queue.enqueue(front.left);
					System.out.print("L "+front.left.data+" , ");
				}
				if(front.right!=null) {
					queue.enqueue(front.right);
					System.out.print(" R "+front.right.data);
				}
				System.out.println();
			} catch (QueueEmptyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("---------------------------");
		System.out.println();
	}
	
	public static BinaryTree<Integer> constTreeFromPreInorder(int inorder[],int preorder[],int startIndexIn,int endIndexIn,int startIndexPre,int endIndexpre){
		if(startIndexIn>endIndexIn) {
			return null;
		}
		int rootdata=preorder[startIndexPre];
		BinaryTree<Integer> root=new BinaryTree<Integer>(rootdata);
		int rootIndex=-1;
		for(int i=startIndexIn;i<=endIndexIn;i++) {
			if(inorder[i]==rootdata) {
				rootIndex=i;
				break;
		}
		}
		int siPreLeft=startIndexPre+1;
		
		int siInLeft=startIndexIn;
		int eiInleft=rootIndex-1;
		
		int eiPreRight=endIndexpre;
		int siInRight=rootIndex+1;
		int eiInRight=endIndexIn;
		
		int lengthLeftSubtree=eiInleft-siInLeft+1;
		
		int eiPreLeft=siPreLeft+lengthLeftSubtree-1;
		int siPreRight=eiPreLeft+1;
		
		BinaryTree<Integer> left=constTreeFromPreInorder(inorder, preorder,siInLeft,eiInleft,siPreLeft,eiPreLeft);
		BinaryTree<Integer> right=constTreeFromPreInorder(inorder, preorder,siInRight,eiInRight,siPreRight,eiPreRight);
		
		root.left=left;
		root.right=right;
		return root;
	}
	
	public static BinaryTree<Integer> constTreeFromPostInorder(int inorder[], int postorder[],int startiIn,int endiIn,int startiPost,int endiPost){
		if(endiIn<startiIn) {
			return null;
		}
		int rootdata=postorder[endiPost];
		BinaryTree<Integer> root=new BinaryTree<Integer>(rootdata);
		int rootIndex=-1;
		for(int i=startiIn;i<=endiIn;i++) {
			if(inorder[i]==rootdata) {
				rootIndex=i;
				break;
			}
		}
		int siInLeft=startiIn;
		int siPostLeft=startiPost;
		int endiInLeft=rootIndex-1;
		
		int siInRight=rootIndex+1;
	
		int endiInRight=endiIn;
		int endiPostRight=endiPost-1;
		
//		int lengthOfLeftSubtree=endiInLeft-siInLeft;
		
	
		int endiPostLeft=rootIndex+;
		int siPostRight=rootIndex+siInRight;
		
		BinaryTree<Integer> right=constTreeFromPostInorder(inorder, postorder, siInRight,endiInRight,siPostRight,endiPostRight);
		BinaryTree<Integer> left= constTreeFromPostInorder(inorder, postorder, siInLeft,endiInLeft,siPostLeft,endiPostLeft);
		root.right=right;
		root.left=left;
		
		return root;
	}
	
	public static void printLevelWiseinNextLine(BinaryTree<Integer> root) {
		if(root==null) {
			return;
		}
		ArrayList<Double> avg=new ArrayList<>();
		Queue<BinaryTree<Integer>> queue=new LinkedList<>();
		queue.add(root);
		queue.add(null);
		
		while(!queue.isEmpty()) {
			int sum=0,c=0;
			BinaryTree<Integer> front=queue.poll();
			if(front==null && queue.isEmpty()) {
				break;
			}
			else if(front==null) {
				
				avg.add((double) (sum/c));
				System.out.println();
				if(!queue.isEmpty()) {
					queue.add(null);
				}
				 
			}
			else {
				System.out.print(front.data + " ");
				sum=sum+front.data;
				c++;
				if(front.left!=null) {
					queue.add(front.left);
				}
				if(front.right!=null) {
					queue.add(front.right);
				}
			}
			
		}
		System.out.println("Avg of "+avg);
		
	}
	
	public static void pathSumRootToLeaf(BinaryTree<Integer> root,int k,String path,int currSum) {
		if(root==null) {
			return;
		}
		if(root.left==null && root.right==null) {
			currSum=currSum+root.data;
		}
		if(currSum==k) {
			System.out.println(path+root.data+" ");
			return;
		}
		pathSumRootToLeaf(root.left, k, (path+root.data+" "), currSum+root.data);
		pathSumRootToLeaf(root.right, k, path+root.data+" ", currSum+root.data);
		
	}
	
	public static void nodeAtDistanceK(BinaryTree<Integer> root,int k) {
		if(root==null) {
			return ;
		}
		if(k==0) {
			System.out.print(root.data+" ");
		}
		nodeAtDistanceK(root.left, k-1);
		nodeAtDistanceK(root.right, k-1);
	}
	public static int nodeAtDisHelper(BinaryTree<Integer> root,int k ,int element) {
		if(root==null) {
			return -1;
		}
		if(root.data==element) {
			nodeAtDistanceK(root, k);
			return 0;
		}
		int ld=nodeAtDisHelper(root.left, k, element);
		if(ld!=-1) {
			if(ld+1==k) {
				System.out.print(root.data+" ");
			}
			else {
				nodeAtDistanceK(root.right, k-(ld+1)-1);
			}
			return ld+1;
		}
		int rd=nodeAtDisHelper(root.right, k, element);
		if(rd!=-1) {
			if(rd+1==k) {
				System.out.print(root.data+" ");
			}
			else {
				nodeAtDistanceK(root.left, k-(rd+1)-1);
			}
			return rd+1;
		}
		return -1;
	}
	
	public static boolean searchInBST(BinaryTree<Integer> root,int ele) {
		if(root==null) {
			return false;
		}
		if(root.data==ele) {
			return true;
		}
		else if(root.data<ele) {
			return searchInBST(root.right, ele);
		}
		
		return	searchInBST(root.left, ele);

	}
	
	public  void bstK1andK2(BinaryTree<Integer> root ,int k1 ,int k2){
		if(root==null) {
			return;
		}
		if(root.data<k1) {
			bstK1andK2(root.right, k1, k2);
		}
		if(root.data>k2) {
			bstK1andK2(root.right, k1, k2);
		}
		else {
			System.out.print(root.data+" ");
			bstK1andK2(root.left, k1, k2);
			bstK1andK2(root.right, k1, k2);
		}
		
	}
	
	public static BinaryTree<Integer> createBstFromSortedArray(int arr[],int low,int high){
		if(low>high) {
			return null;
		}
		int mid=(low+high)/2;
		BinaryTree<Integer> root=new BinaryTree<Integer>(arr[mid]);
		root.left=createBstFromSortedArray(arr, low, mid-1);
		root.right=createBstFromSortedArray(arr, mid+1, high);
		return root;
	}
	
	public static int minimum(BinaryTree<Integer> root) {
		if(root==null) {
			return Integer.MAX_VALUE;
		}
		int leftMin=minimum(root.left);
		int rightMin=minimum(root.right);
		return Math.min(root.data,Math.min(leftMin, rightMin));
	}
	
	public static boolean isBst(BinaryTree<Integer> root) {
		if(root==null) {
			return true;
		}
		int leftMax=largestNode(root.left);
		if(leftMax>root.data) {
			return false;
		}
		int rightMin=minimum(root.right);
		if(rightMin<root.data) {
			return false;
		}
		boolean isBstLeft=isBst(root.left);
		boolean isBstRight=isBst(root.right);
		return isBstLeft && isBstRight;
	}
	
	public static isBSTreturn isBst2(BinaryTree<Integer> root) {
		if(root==null) {
			isBSTreturn ans= new isBSTreturn(Integer.MAX_VALUE, Integer.MIN_VALUE, true);
			return ans;
		}
		isBSTreturn leftans=isBst2(root.left);
		isBSTreturn rightans=isBst2(root.right);
		int min=Math.min(root.data,Math.min(leftans.min,rightans.min));
		int max=Math.max(root.data,Math.max(leftans.max,rightans.max));
		boolean isBst=true;
		if(root.data<=leftans.max) {
			isBst=false;
		}
		if(root.data>rightans.min) {
			isBst=false;
		}
		if(!leftans.isBst) {
			isBst=false;
		}
		if(!rightans.isBst) {
			isBst=false;
		}
		isBSTreturn ans=new isBSTreturn(min, max, isBst);
		return ans;
	}
	
	public static boolean isBst3(BinaryTree<Integer> root,int minrange,int maxrange) {
		if(root==null) {
			return true;
		}
		if(root.data<minrange || root.data>maxrange) {
			return false;
		}
		boolean isleft=isBst3(root.left, minrange,root.data-1);
		boolean isright=isBst3(root.right,root.data,maxrange);
		return isleft && isright;
	}
	
	
	

	
	public static int replaceRootWithSumOfLarger(BinaryTree<Integer>root,int sum){
		if(root==null) {
			return sum;
		}
		 sum=replaceRootWithSumOfLarger(root.right, sum);
		 sum=sum+root.data;
		 root.data=sum;
		 sum=replaceRootWithSumOfLarger(root.left, sum);
		 return sum;
	}
	
	public static BinaryTree<Integer> lowestCommAnc(BinaryTree<Integer> root,int a,int b){
		if(root==null || root.data==a ||root.data==b) {
			return root;
		}
		if(root.data>a && root.data>b) {
			return lowestCommAnc(root.left, a, b);
		}
		else if(root.data<a && root.data<b) {
			return lowestCommAnc(root.right, a, b);
		}
		BinaryTree<Integer> leftSide=lowestCommAnc(root.left, a, b);
		BinaryTree<Integer> rightSide=lowestCommAnc(root.right, a, b);
		if(leftSide!=null && rightSide!=null) {
			return root;
		}
		else if(rightSide!=null) {
			return rightSide;
		}
		return leftSide;
	}
	
	public static ArrayList<Integer> pathNodeToRoot(BinaryTree<Integer> root,int x){
		if(root==null) {
			return null;
		}
		
		if(root.data==x) {
			ArrayList<Integer> list=new ArrayList<>();
			 list.add(root.data);
			 return list;
		}
		ArrayList<Integer> leftOutput=pathNodeToRoot(root.left, x);
		if(leftOutput!=null) {
			leftOutput.add(root.data);
			return leftOutput;
		}
		ArrayList<Integer> rightOutput=pathNodeToRoot(root.right, x);
		if(rightOutput!=null) {
			rightOutput.add(root.data);
			return rightOutput;
		}
		return null;
		
	}
	public static ArrayList<Integer> pathInBstNtoR(BinaryTree<Integer> root,int x){
		if(root==null) {
			return null;
		}
		if(root.data==x) {
			ArrayList<Integer> output=new ArrayList<>();
			output.add(root.data);
			return output;
		}
		if(root.data>x) {
			ArrayList<Integer> leftoutput=pathInBstNtoR(root.left, x);
			if(leftoutput!=null) {
				leftoutput.add(root.data);
				return leftoutput;
			}
		}
		if(root.data<x) {
			ArrayList<Integer> rightoutput=pathInBstNtoR(root.right, x);
			if(rightoutput!=null) {
				rightoutput.add(root.data);
				return rightoutput;
			}
		}
		return null;
	}

	
	public static LBstReturn LargestBST(BinaryTree<Integer> root) {
		if(root==null) {
			LBstReturn ans=new LBstReturn(Integer.MAX_VALUE,Integer.MIN_VALUE,true,0);
			 return ans;
			
		}
		LBstReturn leftans=LargestBST(root.left);
		LBstReturn rightans=LargestBST(root.right);
		int min=Math.min(root.data,Math.min(leftans.min,rightans.min));
		int max=Math.max(root.data, Math.max(leftans.max,rightans.max));
		boolean isBst=false;
		int height;
		if(leftans.isBst && rightans.isBst && root.data>leftans.max && root.data<rightans.min) {
		   isBst=true;
	}
		if(isBst) {
			height=Math.max(rightans.height, rightans.height)+1;
		}
		else {
			height=Math.max(leftans.height,rightans.height);
		}
		return new LBstReturn(min,max,isBst,height);
	}
	
	public static boolean symetric(BinaryTree<Integer> root) {
		if(root==null) {
			return true;
		}
		if(root.left.data!=root.right.data) {
			return false;
		}
		boolean isLeft=symetric(root.left);
		boolean isRight=symetric(root.right);
		return isLeft&&isRight;
	}
	public static boolean isSumTree(BinaryTree<Integer>root) {
		if(root==null) {
			return true;
		}
		if(root.left==null && root.right==null) {
			return true;
		}
		boolean isLeft=isSumTree(root.left);
		boolean isRight=isSumTree(root.right);
		if(root.left!=null && root.right!=null ) {
			if(((root.left.data)+(root.right.data))!=root.data) {
				return false;
			}
		}
		if(root.left!=null && root.right==null && root.left.data!=root.data) {
			return false;
		}
		if(root.left==null && root.right!=null && root.right.data!=root.data) {
			return false;
		}
		return isLeft&&isRight;
	}
	
	
	public static void main(String[] args) {
//	BinaryTree<Integer> root=new BinaryTree<Integer>(1);
//	BinaryTree<Integer> right=new BinaryTree<Integer>(2);
//	BinaryTree<Integer> left=new BinaryTree<Integer>(3);
//	BinaryTree<Integer> right1=new BinaryTree<Integer>(4);
//	BinaryTree<Integer> left1=new BinaryTree<Integer>(5);
//	root.right=left;
//	root.left=right;
//	right.right=right1;
//	left.left=left1;
//	BinaryTree<Integer> root=takeInputBetter(true,0,true);
	BinaryTree<Integer> root=takeinputLevelwise();
	printLevewise(root);
//	printNodeAtDepthK(root, 2);
//	printNodeWithoutSibling(root);
//	root=mirrorTree(root);
//	printTreeDetailed(root);
	BalancedTreeReturn ans=isBalancedBetter(root);
	System.out.println(ans.isBalanced);
//	System.out.println(diameter(root));
	Pair p=diameterBetter(root);
	System.out.println(p.diameter +" "+p.height);
//	int inorder[]= {4 ,2, 7 ,5 ,1 ,8 ,6,3};
//	int postorder[]= {4, 7, 5, 2 ,8 ,6 ,3 ,1};
//	BinaryTree<Integer> root1=constTreeFromPreInorder(inorder,preorder,0,inorder.length-1,0,preorder.length-1);
//	BinaryTree<Integer> root1=constTreeFromPostInorder(inorder, postorder, 0, inorder.length-1, 0,postorder.length-1);
//	printLevewise(root1);
//	printLevelWiseinNextLine(root);
//	nodeAtDisHelper(root, 2, 5);
//	System.out.println(searchInBST(root, 2));
//	bstK1andK2(root, 7, 15);
//	int arr[]= {-10,-3,0,5,9};
//	BinaryTree<Integer> root=createBstFromSortedArray(arr, 0, 4);
//	printLevewise(root);
//	isBSTreturn ans=isBst2(root);
//	System.out.println(ans.min+" "+ans.max+" "+ans.isBst);
//	replaceRootWithSumOfLarger(root, 0);
//	printLevewise(root);
//	root=lowestCommAnc(root, 2, 4);
//	System.out.println(root.data);
//	System.out.println(pathNodeToRoot(root, 5));
//	System.out.println(pathInBstNtoR(root, 4));
//	LBstReturn ans=LargestBST(root);
//	System.out.println(ans.height);
//	System.out.println(symetric(root));
//	System.out.println(isSumTree(root));
//	replaceDataWithHeight(root, 0);
//	removeLeafNode(root);
	printLevewise(root);
}
}
