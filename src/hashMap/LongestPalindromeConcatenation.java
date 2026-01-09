package hashMap;

import java.util.HashMap;

public class LongestPalindromeConcatenation {

	public static void main(String[] args) {
		String s[]= {"nn","nn","hg","gn","nn","hh","gh","nn","nh","nh"};
		HashMap<String,Integer>map=new HashMap<>();
		for(int i=0;i<s.length;i++) {
			map.put(s[i],map.getOrDefault(s[i], 0)+1);
		}
		System.out.println(map);
		int max=0;
		boolean oddSeen=false;
		for(String key:map.keySet()) {
			int val=map.get(key);
			String op=""+key.charAt(1)+key.charAt(0);
			if(!key.equals(op)) {
				if(map.containsKey(op)) {
					int opVal=map.get(op);
					int min=Math.min(opVal,val);
					max=max+min*4;
					map.put(key, val-min);
					map.put(op,opVal-min);
				}
			}else {
				if(val%2==0) {
					max=max+val*2;
					map.put(key,0);
				}else {
					if(oddSeen==false) {
						max=max+val*2;
						oddSeen=true;
					}else {
						val--;
						max=max+val*2;
					}
				}
				
				
			}
			
		}
		System.out.println(max);

	}

}
