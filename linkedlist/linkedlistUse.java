package linkedlist;
import java.util.HashSet;
import java.util.Scanner;
public class linkedlistUse {
	
	public static Node<Integer> takeInput(){
		Scanner sc=new Scanner(System.in);
		int data=sc.nextInt();
		Node<Integer> head=null,tail=null;
		while(data!=-1) {
			Node <Integer> currNode=new Node<>(data);
			if(head==null) {
				head=currNode;
				tail=currNode;
			}
			else {
				tail.next=currNode;
				tail=tail.next;
			}
			data=sc.nextInt();
		}
		return head;
	}
	
	public static void print(Node<Integer> head) {
		while(head!=null) {
			System.out.print(head.data+ "->");
			head=head.next;
		}
		System.out.print("null");
		System.out.println();
	}
	
	public static Node<Integer> insertAt(Node<Integer> head,int pos,int data){
		if(pos<0|| pos>length(head)) {
			return head;
		}
		Node<Integer> newNode=new Node<>(data);
		int i=0;
		if(pos==0) {
			newNode.next=head;
			head=newNode;
			return head;
		}
		Node<Integer> temp=head;
		while(temp!=null && i<(pos-1)) {
			i++;
			temp=temp.next;
		}
		Node<Integer> pre=temp;
		
		newNode.next=pre.next;
		pre.next=newNode;
		
		
		return head;
	}
	public static int length(Node<Integer> head) {
		int count=0;
		while(head!=null) {
			count++;
			head=head.next;
		}
		return count;
	}
	public static Node<Integer> deletion(Node<Integer> head,int pos){
		if(pos<0 || pos>length(head)-1) {
			return head;
		}
		Node<Integer> prev=head;
		if(pos==0) {
			return prev.next;
		}
		int i=0;
		
		while(prev.next!=null && i<pos-1) {
			i++;
			prev=prev.next;
		}
		prev.next=prev.next.next;
		return head;
	}
	
	public static int findNode(Node <Integer> head,int data ) {
		if(head==null) {
			return -1;
		}
		int count=0;
		while(head!=null) {
			if(head.data==data) {
				return count;
			}
			count++;
			head=head.next;
		}
		return -1;
	}
	
	
	public static Node<Integer> appendLastNtoFirst(Node<Integer> head,int n){
		if(n<1 || n>length(head)) {
			return head;
		}
		int c=1;
		Node<Integer> prev=head;
		Node<Integer> pp=null;
		while(prev.next!=null && c<length(head)-n+1) {
			pp=prev;
			c++;
			prev=prev.next;
		}
		Node<Integer> p=prev;
		while(p.next!=null) {
			p=p.next;
		}
		p.next=head;
		pp.next=null;
		return prev;
	}
	
	
	public static Node<Integer> removeDup(Node<Integer> head){
		if(head==null|| head.next==null) {
			return head;
		}
		Node<Integer> t1=head;
		Node<Integer> t2=head.next;
		while(t1!=null &&t2!=null) {
			if(t1.data!=t2.data) {
				t1.next=t2;
				t1=t2;
				t2=t2.next;
			}
			else {
				t2=t2.next;
			}
		}
		t1.next=t2;
		return head;
	}
	
	public static void printReverse(Node<Integer> head){
		if(head==null) {
			return ;
		}
		
		printReverse(head.next);
		System.out.print(head.data+" ");
		
	}

	public static Node<Integer> insertR(Node<Integer> head,int i,int data){

		if(i<0 ||i>length(head)+1) {
			return head;
		}
		if(i==0) {
			Node<Integer> newnode=new Node<>(data);
			newnode.next=head;
			return newnode;
		}
		if(head==null) {
			return head;
		}
		Node<Integer> num=insertR(head.next,i-1,data);
		head.next=num;
		return head;
	}
	
	public static Node<Integer> deleteR(Node<Integer> head,int i){
		if(i<0 ||i>length(head)|| head==null) {
			return head;
		}
		if(i==0) {
			head=head.next;
			return head;
			
		}
		Node<Integer> smallhead=deleteR(head.next,i-1);
		head.next=smallhead;
		return head;
	}
	public static Node<Integer> reverseR(Node<Integer> head){
		if(head==null ||head.next==null) {
			return head;
		}
		Node<Integer> smallhead=reverseR(head.next);
		Node<Integer> tail=smallhead;
		while(tail.next!=null) {
			tail=tail.next;
		}
		tail.next=head;
		head.next=null;
		return smallhead;
	}
	
	public static Node<Integer> reverseRbetter(Node<Integer> head){
		if(head==null || head.next==null) {
			return head;
		}
		Node<Integer> smallhead=reverseRbetter(head.next);
		Node<Integer> tail=head.next;
		tail.next=head;
		head.next=null;
		return smallhead;
	}
	public static Node<Integer> mergeSorted(Node<Integer> head,Node<Integer> head1){
		if(head==null) {
			return head1;
		}
		if(head1==null) {
			return head;
		}
		Node<Integer> heading=null;
		Node<Integer> tail=null;
		if(head.data<head1.data) {
			heading=head;
			tail=head;
			head=head.next;
		}
		 else if(head.data>=head1.data) {
			heading=head1;
			tail=head1;
			head1=head1.next;
		}
		while(head!=null && head1!=null) {
			if(head.data<head1.data) {
				tail.next=head;
				tail=tail.next;
				head=head.next;
			}
			else {
				tail.next=head1;
				tail=tail.next;
				head1=head1.next;
			}
		}
		if(head!=null) {
			tail.next=head;
			
		}
		if(head1!=null) {
			tail.next=head1;
			
		}
		return heading;
	}
	
	public static Node<Integer> mergeSortedBetter(Node<Integer> head1,Node<Integer> head2){
		if(head1==null) {
			return head1;
		}
		if(head2==null) {
			return head2;
		}
		Node<Integer>dummy=new Node<Integer>(-1);
		Node<Integer>tail=dummy;
		while(head1!=null && head2!=null) {
			if(head1.data<head2.data) {
				tail.next=head1;
				tail=tail.next;
				head1=head1.next;
			}else {
				tail.next=head2;
				tail=tail.next;
				head2=head2.next;
			}
		}
		if(head1!=null) {
			tail.next=head1;
		}else {
			tail.next=head2;
		}
		return dummy.next;
	}
	
	public static Node<Integer> midpoint(Node<Integer> head){
		Node<Integer> slow=head;
		Node<Integer> fast=head;
		while(fast.next!=null && fast.next.next!=null) {
			slow=slow.next;
			fast=fast.next.next;
		}
		return slow;
	}
	
	public static Node<Integer> mergeSort(Node<Integer> head){
		if(head==null || head.next==null) {
			return head;
		}
		Node<Integer> midpart1=midpoint(head);
		Node<Integer> midpart2=midpart1.next;
		midpart1.next=null;
		Node<Integer> part1=mergeSort(head);
		Node<Integer>part2=mergeSort(midpart2);
		Node<Integer> heading=mergeSortedBetter(part1, part2);
		return heading;
		
		
	}
	
	public static Node<Integer> evenAfterOdd(Node<Integer> head){
		if(head==null) {
			return head;
		}
		Node<Integer> evenHead=null;
		Node<Integer> evenTail=null;
		Node<Integer> oddHead=null;
		Node<Integer> oddTail=null;
		while(head!=null) {
			if(head.data%2==0) {
				if(evenHead==null) {
					evenHead=head;
					evenTail=head;
				}
				else {
					evenTail.next=head;
					evenTail=evenTail.next;
				}
			}
			else {
				if(oddHead==null) {
					oddHead=head;
					oddTail=head;
				}
				else {
					oddTail.next=head;
					oddTail=oddTail.next;
				}
			}
			head=head.next;
		}
		if(oddTail!=null) {
		oddTail.next=null;
		}
		if(evenTail!=null) {
		evenTail.next=null;
		}
		if(evenHead==null) {
			return oddHead;
		}
		if(oddHead==null) {
			return evenHead;
		}
		oddTail.next=evenHead;
		return oddHead;
		
		

		
	}
	
	public static Node<Integer> deleteEveryMafterN(Node<Integer> head,int m,int n){
		if(m==0||head==null ) {
			return head;
		}
		if(n ==0) {
			return head;
		}
		Node<Integer> t1=head;
		Node <Integer> temp=null;
		while(t1!=null) {
			int take=0;
			int skip=0;
			while(t1!=null && take<m) {
				if(temp==null) {
					temp=t1;			
				}
				else {
					temp.next=t1;
					temp=temp.next;
				}
				t1=t1.next;
				take++;
			}
			while(t1!=null && skip<n) {
				t1=t1.next;
				skip++;
				
			}
			if(temp!=null) {
				temp.next=null;
			}
			
		}
		return head;
	}
	
	public static Node<Integer> iReverse(Node<Integer> head){
		if(head==null || head.next==null) {
			return head;
	}
	Node <Integer> curr = head;
	Node<Integer> prev=null;
	Node<Integer> temp;
    while(curr!=null) {
    	temp=curr.next;
    	curr.next=prev;
    	prev=curr;
    	curr=temp;
	}
	return prev;
	
	}
	
	public static Node<Integer> reverseK(Node<Integer> head,int k){
		if(k==0|| k==1) {
			return head;
		}
		Node <Integer> curr = head;
		Node<Integer> prev=null;
		Node<Integer> temp=null;
		int count =0;
	    while(curr!=null && count<k) {
	    	temp=curr.next;
	    	curr.next=prev;
	    	prev=curr;
	    	curr=temp;
	    	count++;
		}
	    if(temp!=null) {
	    	head.next=reverseK(temp, k);
	    }
	    return prev;
	}
	
	public static Node<Integer> rotate(Node<Integer> head,int k){
		if(head==null) {
			return head;
		}
		int l=length(head);
		k=k%l;
		if(k==0 || head.next==null) {
			return head;
		}
		
		Node<Integer> prev=null;
		Node<Integer> curr=head;
		int i=0;
		while(i<k && curr!=null) {
			prev=curr;
			curr=curr.next;
			i++;
		}
		Node<Integer> heading =curr;
		if(prev.next!=null) {
		prev.next=null;
		}
		Node<Integer> h1=curr;
		while(h1.next!=null) {
			h1=h1.next;
		}
		h1.next=head;
		return heading;
	}
	
	public static Node<Integer> moveLasttoHead(Node<Integer> head){
		if(head==null || head.next==null) {
			return head;
		}
		Node<Integer> curr=head;
		Node<Integer> prev=null;
		while(curr.next!=null) {
			prev=curr;
			curr=curr.next;
		}
		prev.next=null;
		curr.next=head;
		return curr;
	}
	public static Node<Integer> reverseTwo(Node<Integer> head,int a,int b){
		if(head==null || head.next==null) {
			return head;
		}
		int i=1;
		Node<Integer> curr1=head;
		Node<Integer> prev1=null;
		while(curr1!=null && i<a) {
			prev1=curr1;
			curr1=curr1.next;
			i++;
		}
		if(prev1!=null) {
		prev1.next=null;
		}
		
		int j=0;
		Node<Integer> prev2=null;
		Node<Integer> curr2=curr1;
		while(curr2!=null && j<b-a+1) {
			prev2=curr2;
			curr2=curr2.next;
			j++;
		}
		prev2.next=null;
		Node<Integer> smallHead=reverseRbetter(curr1);
		prev1.next=smallHead;
		while(smallHead.next!=null) {
			smallHead=smallHead.next;
		}
		smallHead.next=curr2;
		return head;
	}
//	public static DoubleNode reverseHeadTail(Node<Integer> head) {
//		if(head==null || head.next==null) {
//			DoubleNode ans=new DoubleNode();
//			ans.head=head;
//			ans.tail=head;
//			return ans;
//		}
//		DoubleNode smallans=reverseHeadTail(head.next);
//		smallans.tail.next=head;
//		head.next=null;
//		DoubleNode ans=new DoubleNode();
//		ans.head=smallans.head;
//		ans.tail=head;
//		return ans;
//	}
	
	public static Node<Integer> removeDuplicate(Node<Integer> head){
		Node<Integer> curr=head;
		Node<Integer>prev=null;
		HashSet<Integer>set=new HashSet<>();
		while(curr!=null) {
			if(set.contains(curr.data)) {
				prev.next=curr.next;
			}else {
				set.add(curr.data);
				prev=curr;
			}
			curr=curr.next;
		}
		return head;
	}
	
	public static Node<Integer> sort012(Node<Integer> head){
		int arr[]= {0,0,0};
		Node<Integer> curr=head;
		while(curr!=null) {
			arr[curr.data]++;
			curr=curr.next;
		}
		int index=0;
		curr=head;
		while(curr!=null) {
			if(arr[index]==0) {
				index++;
			}else {
				curr.data=index;
				arr[index]--;
				curr=curr.next;
			}
		}
		return head;
	}
	
	public static DoubleNode reverseLLHeadTail(Node<Integer> head) {
		if(head==null||head.next==null) {
			return new DoubleNode(head,head);
		}
		DoubleNode reversed=reverseLLHeadTail(head.next);
		reversed.tail.next=head;
		head.next=null;
		return new DoubleNode(reversed.head,head);
	}
	
	public static Node<Integer> reorderList(Node<Integer> head){
		Node<Integer> slow=head;
		Node<Integer>fast=head;
		while(fast!=null && fast.next!=null) {
			slow=slow.next;
			fast=fast.next.next;
		}
		Node<Integer>second=iReverse(slow.next);
		slow.next=null;
//		print(second);
		Node<Integer>first=head;
		while(second!=null) {
			Node<Integer>firstNext=first.next;
			Node<Integer>secondNext=second.next;
			first.next=second;
			second.next=firstNext;
			first=firstNext;
			second=secondNext;
			
		}
		return head;
	}
	public static Node<Integer> removeRightSmaller(Node<Integer> head){
		if(head==null||head.next==null) return head;
		Node<Integer> reverse=iReverse(head);
		Node<Integer> curr=reverse;
		while(curr!=null && curr.next!=null) {
			if(curr.data>curr.next.data) {
				curr.next=curr.next.next;
			}else {
				curr=curr.next;
			}
		}
		reverse=iReverse(reverse);
		return reverse;
	}
	public static Node<Integer> addTwoNumber(Node<Integer> head1,Node<Integer> head2){
		head1=iReverse(head1);
		head2=iReverse(head2);
		int carry=0;
		Node<Integer> dummy=new Node<>(-1);
		Node<Integer>tail=dummy;
		while(head1!=null||head2!=null||carry!=0) {
			int value1=head1!=null?head1.data:0;
			int value2=head2!=null?head2.data:0;
			int sum=(value1+value2+carry);
			carry=sum/10;
			Node<Integer> temp=new Node<>(sum%10);
			tail.next=temp;
			tail=tail.next;
			if(head1!=null) head1=head1.next;
			if(head2!=null) head2=head2.next;
		}
		Node<Integer>ans=iReverse(dummy.next);
		return ans;

	}
	public static Node<Integer> doubleNumber(Node<Integer>head){
		Node<Integer> reverse=iReverse(head);
		Node<Integer> curr=reverse;
		Node<Integer> prev=null;
		int carry=0;
		while(curr!=null) {
			int value=curr.data*2+carry;
			curr.data=value%10;
			carry=value/10;
			prev=curr;
			curr=curr.next;
		}
		if(carry>0) {
			Node<Integer> newNode=new Node<>(carry);
			prev.next=newNode;
		}
		reverse=iReverse(reverse);
		return reverse;
		
	}
	public static Node<Integer> reverseKGroup(Node<Integer>head,int k){
		if(!hasKElement(head, k)) return head;
		Node<Integer> curr=head;
		Node<Integer> prev=null;
		Node<Integer> next=null;
		int count=0;
		while(curr!=null && count<k) {
			count++;
			next=curr.next;
			curr.next=prev;
			prev=curr;
			curr=next;
		}
		head.next=reverseKGroup(curr,k);
		return prev;
		
	}
	public static boolean hasKElement(Node<Integer>head,int k) {
		int count=0;
		while(head!=null && count<k) {
			count++;
			head=head.next;
			
		}
		return count==k;
	}
	
	public static Node<Integer> swapNodeValue(Node<Integer> head,int k){
		Node<Integer>first=head;
		for(int i=1;i<k;i++) {
			first=first.next;
		}
		Node<Integer>fast=head;
		for(int i=0;i<k;i++) {
			fast=fast.next;
			
		}
		Node<Integer>slow=head;
		while(fast!=null) {
			slow=slow.next;
			fast=fast.next;
		}
		int val=first.data;
		first.data=slow.data;
		slow.data=val;
		return head;
	}
	
	
	
	
	public static void main(String[] args) {
		Node <Integer> head=takeInput();
//		Node <Integer> head1=takeInput();
//		print(head);
//		head=insertAt(head,2,45);
//		head=deletion(head,0);
//		int index=findNode(head,2);
//		System.out.println("Index is = "+index);
//		head=appendLastNtoFirst(head, 2);
//		head=removeDup(head);
//		printReverse(head);
//		head=insertR(head, 1, 100);
//		head=deleteR(head, 3);
//		head=reverseR(head);
//		head=reverseRbetter(head);
//		head=midpoint(head);
//		head=mergeSorted(head, head1);
//		head=mergeSort(head);
//		head=evenAfterOdd(head);
//		head=deleteEveryMafterN(head, 2, 3);
//		head=iReverse(head);
//		head=reverseK(head, 3);
//		head=rotate(head, 4);
//		head=moveLasttoHead(head);
//		head=reverseTwo(head,1,2);
//		DoubleNode ans=reverseHeadTail(head);
//		Node<Integer>ans=removeElmement(head, 3);
//		head=removeDuplicate(head);
//		head=sort012(head);
//		DoubleNode rev=reverseLLHeadTail(head);
//		head=reorderList(head);
//		head=removeRightSmaller(head);
//		Node<Integer>head1=takeInput();
//		head=mergeSortedBetter(head, head1);
//		head=addTwoNumber(head, head1);
//		head=doubleNumber(head);
//		head=reverseKGroup(head, 3);
		head=swapNodeValue(head, 2);
		print(head);
	}

}
