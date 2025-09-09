package stack;

public class StackUseArray {

	public static void main(String[] args) throws StackFullException, StackEmptyException {
//		StackUsingArray stack =new StackUsingArray();
//		for(int i=0;i<10;i++) {
//			stack.push(i);
//		}
//		System.out.println(stack.isEmpty());
//		

		StackUsingLL <Integer> stack=new StackUsingLL<>();
		for(int i=0;i<10;i++) {
			stack.push(i);
		}
		System.out.println(stack.isEmpty());
	}

}
