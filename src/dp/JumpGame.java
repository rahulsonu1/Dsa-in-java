package dp;

public class JumpGame {

	public static void main(String[] args) {
		int arr[]= {2,3,1,1,4};
		System.out.println(jump(arr));
	}
	public static  boolean jump(int arr[]) {
		int a=arr[0];
		if(arr[a]>=arr.length-1) {
			return true;
		}
		return false;
	}

}
