package StringProblem;

public class RabinKarp1 {
	private final int PRIME=103;
	public  long calHash(String s) {
		long hash=0;
		for(int i=0;i<s.length();i++) {
			hash=(long) ( hash+s.charAt(i)*Math.pow(PRIME, i));
		}
		return hash;
	}
	
	public long updateHash(long oldHash, char oldChar , char newChar,int pLen) {
		long newHash=(oldHash-oldChar)/PRIME;
		newHash=(long)(newHash+(newChar*Math.pow(PRIME,pLen-1)));
		return newHash;
	}
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		String s="aabaacaadaabaaba";
		String p="aaba";
		int sLen=s.length();
		int pLen=p.length();
		
		RabinKarp1 rk=new RabinKarp1();
		long pat=rk.calHash(p);
		long st=rk.calHash(s.substring(0,pLen));
		
		for(int i=0;i<=sLen-pLen;i++) {
			if(pat==st) {
				if(s.substring(i,i+pLen).equals(p)) {
					System.out.println("Starting Index :"+ i);
				}
			}
			if(i<sLen-pLen)
				st=rk.updateHash(st, s.charAt(i),s.charAt(i+pLen), pLen);
		}
		
	}

}
