package dp;

public class minDeletion {

	public static void main(String[] args) {
		String a="sea";
		String b="eat";
		System.out.println(minD(a, b));
	}
	public static int minD(String a,String b) {
		if(a.length()==0 && b.length()==0) {
			return 0;
		}
		if(a.length()==0) {
			return b.length();
		}
		if(b.length()==0) {
			return a.length();
		}
		int ans=0;
		if(a.charAt(0)==b.charAt(0)) {
			ans=ans+1;
			return minD(a.substring(1), b.substring(1));
		}
		int first=minD(a.substring(1), b);
		int second=minD(a, b.substring(1));
		return ans+Math.min(first, second);
	}

}
