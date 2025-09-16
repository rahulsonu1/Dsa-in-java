package greedy;

public class JumpGame {

	public static void main(String[] args) {
		int arr[]= {3,2,1,0,4};
		System.out.println(isPossible(arr));
		
	}
	public static boolean isPossible(int arr[]) {
		int maxReach=0;
		for(int i=0;i<arr.length;i++) {
			if(i>maxReach) return false;
			maxReach=Math.max(maxReach, i+arr[i]);
			
		}
		return true;
	}

}
