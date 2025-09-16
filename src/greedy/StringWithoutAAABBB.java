package greedy;

public class StringWithoutAAABBB {

	public static void main(String[] args) {
		int a=4,b=1;
		StringBuilder sb=new StringBuilder();
		while(a>0 ||b>0) {
			boolean writeA=false;
			int l=sb.length();
			if(l>=2 && sb.charAt(l-1)==sb.charAt(l-2)) {
				if(sb.charAt(l-1)=='b') {
					writeA=true;
				}
			}else {
			
			if(a>=b) {
				writeA=true;
			}
			}
			if(writeA) {
				sb.append('a');
				a--;
			}else{
				sb.append('b');
				b--;
			}
		}
		System.out.println(sb);
		
	}

}
