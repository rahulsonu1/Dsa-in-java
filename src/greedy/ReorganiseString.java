package greedy;

public class ReorganiseString {

	public static void main(String[] args) {
		String s="bfrbs";
		int n=s.length();
		int arr[]=new int[26];
		for(int i=0;i<n;i++) {
			arr[s.charAt(i)-'a']++;
		}
		int max=0;
		int index=-1;
		for(int i=0;i<26;i++) {
			if(arr[i]>max) {
				max=arr[i];
				index=i;
			}
		}
		char ch[]=new char [n];
		int i=0;
		while(arr[index]>0 && i<n) {
			ch[i]=(char) (index+'a');
			i+=2;
			arr[index]--;
		}
		for(int j=0;j<26;j++) {
	
				while(arr[j]>0 ) {
					if(i>n) {
						i=1;
					}
					ch[i]=(char)(j+'a');
					i+=2;
					arr[j]--;
			}
			
		}
		for(int t=0;t<n;t++) {
			System.out.println(ch[t]+" ");
		}
		
	}  

}
