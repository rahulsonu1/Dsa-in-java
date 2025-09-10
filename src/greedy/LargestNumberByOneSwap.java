package greedy;

public class LargestNumberByOneSwap {

	public static void main(String[] args) {
		String s="98368";
		char arr[]=s.toCharArray();
		int maxDigit='0';
		int maxDigitIndex=-1;
		int minDigitIndex=-1;
		int r=-1;
		for(int i=arr.length-1;i>=0;i--) {
			if(arr[i]>maxDigit) {
				maxDigit=arr[i];
				maxDigitIndex=i;
			}else if(arr[i]<maxDigit) {
				minDigitIndex=i;
				r=maxDigitIndex;
			}
		}
		if(minDigitIndex==-1) {
			System.out.println("No change");
		}else {
			char temp=arr[minDigitIndex];
			arr[minDigitIndex]=arr[r];
			arr[r]=temp;
		}
		System.out.println(new String(arr));

	}

}
