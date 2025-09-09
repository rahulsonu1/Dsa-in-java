package StringProblem;

public class RabinKarp {
	
	private final int PRIME=103;
	
	private long calculateHash(String s) {
		long hash=0;
		for(int i=0;i<s.length();i++) {
			hash=(long) (hash+(s.charAt(i))*Math.pow(PRIME, i));
		}
		return hash;
	}
	private long updateHash(long prevHash,char oldChar,char newChar,int patternLength) {
		long newHash=(prevHash-oldChar)/PRIME;
		newHash=(long)(newHash+(newChar*Math.pow(PRIME,patternLength-1)));
		return newHash;
	}

	public static void main(String[] args) {
		String s="aabaacaadaabaaba";
		String p="aaba";
		int sLen=s.length();
		int pLen=p.length();
		
		RabinKarp rb=new RabinKarp();
		long patternHash=rb.calculateHash(p);
		long textHash=rb.calculateHash(s.substring(0,pLen));
		
		for(int i=0;i<=sLen-pLen;i++) {
			if(patternHash==textHash) {
				if(s.subSequence(i,i+pLen).equals(p)) {
					System.out.println("found at :"+i);
				}
				
			}
			if(i<sLen-pLen) {
				textHash=rb.updateHash(textHash,s.charAt(i),s.charAt(i+pLen),pLen);
				
			}
		}

	}

}
