package StringProblem;

public class ZigZagConversion {

	public static void main(String[] args) {
		String s="PAYPALISHIRING";
		System.out.println(convert(s, 3));
		
	}
	public static String convert(String s, int numRow) {
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<numRow;i++) {
			int index=i;
			int south=2*(numRow-i-1);
			int north=2*i;
			boolean isGoingSouth=true;
			while(index<s.length()) {
				sb.append(s.charAt(index));
				if(i==0) {
					index+=south;
				}else if(i==numRow-1) {
					index+=north;
				}else {
					if(isGoingSouth) {
						index+=south;
					}
					else {
					index+=north;
				}
			}
				isGoingSouth=!isGoingSouth;
			
		}
	}
		return sb.toString();

	}
}
