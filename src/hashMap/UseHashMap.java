package hashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class UseHashMap {
	
	public static ArrayList<Integer> removeDuplicates(int a[]){ 
		ArrayList<Integer> output=new ArrayList<>();
		HashMap<Integer,Boolean> map=new HashMap<>();
		for(int i=0;i<a.length;i++) {
			if(map.containsKey(a[i])) {
				continue;
			}
			output.add(a[i]);
			map.put(a[i], true);
		}
		return output;
	}

	public static void MaxFrequency(int a[]) {
		HashMap<Integer,Integer> map=new HashMap<>();
		for (int i:a) {
			map.put(i,map.getOrDefault(i, 0)+1);
		}
		int max=0,ans=Integer.MIN_VALUE;
		for(int i:a) {
			if(map.get(i)>max) {
				max=map.get(i);
				ans=i;
			}
		}
		System.out.println(ans);
	}

	public static void arrayInterSection(int a[],int b[]) {
		HashMap<Integer,Integer> map=new HashMap<>();
		ArrayList<Integer> arr=new ArrayList<>();
		for(int i=0;i<a.length;i++) {
			if(map.containsKey(a[i])) {
				int freq=map.get(a[i]);
				map.put(a[i], freq+1);
			}
			else {
				map.put(a[i],1);
			}
		}
		for(int i=0;i<b.length;i++) {
			if(map.containsKey(b[i])) {
				int freq=map.get(b[i]);
				if(freq>0) {
					arr.add(b[i]);
					map.put(b[i], freq-1);
				}
				
			}
		}
		System.out.println(arr);
	}

	public static String removeDupChar(String s) {
		if(s.length()==0) {
			return "";
		}
		HashMap<Character,Boolean> map=new HashMap<>();
		String ans="";
		for(int i=0;i<s.length();i++) {
			char ch=s.charAt(i);
			if(!map.containsKey(ch)) {
				map.put(ch, true);
				ans=ans+ch;
			}
			
			
		}
		return ans;
	}
	
	public static void romanToInteger(String s) {
		HashMap<Character,Integer> map=new HashMap<>();
		map.put('I',1);
		map.put('V',5);
		map.put('X',10);
		map.put('L',50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M',1000);
		int ans=0;
		for(int i=0;i<s.length();i++) {
			if(i==s.length()-1) {
				ans=ans+map.get(s.charAt(i));
			}
			else if(map.get(s.charAt(i))<map.get(s.charAt(i+1))) {
				ans=ans-map.get(s.charAt(i));
			}
			else {
				ans=ans+map.get(s.charAt(i));
			}
		}
		System.out.println(ans);
	}
	
	public static void sumTOZero() {
		int arr[]= {1 -1 ,2 ,-2};
		HashMap<Integer, Integer> map=new HashMap<Integer, Integer>();
		for(int i=0;i<arr.length;i++) {
			if(map.containsKey(arr[i])) {
				int value=map.get(arr[i]);
				map.put(arr[i],value+1);
			}
			else {
				map.put(arr[i], 1);
			}
		}
		for(int i=0;i<arr.length;i++) {
			int keys=arr[i];
			if(map.containsKey(-keys) && map.get(keys)!=0 ) {
				System.out.println(keys+" "+-keys);
				map.put(keys,map.get(keys)-1);
				
			}
		}
	}
	
	public static void ExtractUnique() {
		String s="thisisinput";
		String newString="";
		HashMap<Character,Boolean> map=new HashMap<>();
		for(int i=0;i<s.length();i++) {
			char ch=s.charAt(i);
			if(map.containsKey(ch)) {
				continue;
			}
			else {
				map.put(ch,true);
				newString=newString+ch;
			}
		}
		System.out.println(newString);
	}

	public static void LongestConsecutive() {
		int arr[]= {0,3,7,2,5,8,4,6,0,1};
		ArrayList<Integer> list=new ArrayList<Integer>();
		HashMap<Integer,Boolean> map=new HashMap<>();
		for(int i=0;i<arr.length;i++) {
			map.put(arr[i],false);
		}
		int globalCount=1;
		int globalStartIndex=0;
		for(int i=0;i<arr.length;i++) {
			int num=arr[i];
			int currStartIndex=i;
			int tempNum=num;
			int currCount=0;
			while(map.containsKey(tempNum) && !map.get(tempNum)) {
				currCount++;
				map.put(tempNum,true);
				tempNum++;
			}
			tempNum=num-1;
			while(map.containsKey(tempNum) && !map.get(tempNum)) {
				currCount++;
				map.put(tempNum,true);
				tempNum--;
			}
			if(currCount>globalCount) {
				globalCount=currCount;
				globalStartIndex=currStartIndex;
			}
			else if(currCount==globalCount) {
				if(currStartIndex<globalStartIndex) {
					globalStartIndex=currStartIndex;
				}
			}
		}
		list.add(globalStartIndex);
		if(globalCount>1) {
			list.add(globalStartIndex+globalCount-1);
		}
		System.out.println(globalCount);
		System.out.println(list);
	}
	
	public static void pairWithDiff() {
		int arr[]= {1,2,3,4,5};
		int k=1;
		int count=0;
		HashMap<Integer,Integer> map=new HashMap<>();
		for(int i=0;i<arr.length;i++) {
			if(map.containsKey(arr[i])) {
				map.put(arr[i],map.get(arr[i])+1);
			}
			else {
				map.put(arr[i],1);
			}
		}
		for(int i=0;i<arr.length;i++) {
			int c=0;
			if(k==0 && map.get(arr[i])>=2) {
				c++;
			}
			if(map.containsKey(arr[i]+k) && map.get(arr[i])!=0 && map.get(arr[i]+k)!=0) {
				c++;
			}
			if(map.containsKey(arr[i]-k)&& map.get(arr[i])!=0 && map.get(arr[i]-k)!=0) {
				c++;
			}
			count=count+map.get(arr[i])*c;
			map.put(arr[i], 0);
		}
		System.out.println(count);
	}
	
	public static void longSubsetZer() {
		int arr[]={15, -2, 2, -8, 1, 7, 10, 23};
		HashMap<Integer,Integer> map=new HashMap<>();
		for(int i=1;i<arr.length;i++) {
			arr[i]=(arr[i]+arr[i-1]);
//			System.out.print(arr[i]+" ");
		}
		int len=0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==0) {
				if(len<i+1) {
					len=i+1;
				}
			}
			else if(map.containsKey(arr[i])) {
				if(len< i-map.get(arr[i])) {
					len=i-map.get(arr[i]);
				}
			}
			else {
				map.put(arr[i],i);
			}
		}
		System.out.println(len);
		
	}
	
	public static void findPairs() {
		int nums[]= {10,10,10,10,67};
	int k=0;
        int count =0;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++) {
            if(!map.containsKey(nums[i])) {
                if(map.containsKey(nums[i] + k)) count++;
                if(map.containsKey(nums[i] - k)) count++;
                map.put(nums[i], 1);
            } else if (k == 0) {
                   if(map.get(nums[i]) == 1)
                      count++;
                   map.put(nums[i], map.get(nums[i]) + 1);
            }         
        }
       System.out.println(count);
	}
	
	public static boolean anagram(String s,String t) {
		if(s.length()!=t.length()) {
			return false;
		}
		int n=s.length();
		HashMap<Character,Integer>map=new HashMap<>();
		for(int i=0;i<n;i++) {
			if(map.containsKey(s.charAt(i))){
				int value=map.get(s.charAt(i));
				map.put(s.charAt(i),value+1);
			}
			else {
				map.put(s.charAt(i),1);
			}
		}
		for(int i=0;i<n;i++) {
			if((map.containsKey(t.charAt(i))&& map.get(t.charAt(i))<1)) {
				return false;
			}
			else if(map.containsKey(t.charAt(i))) {
				int v=map.get(t.charAt(i));
				map.put(t.charAt(i),v-1);
				if(map.get(t.charAt(i))==0) {
					map.remove(t.charAt(i));
				}
			}
			else if(map.size()!=0) {
				return false;
			}
			
		}
		return true;
	}
	
	public static boolean duplicate(int arr[],int k) {
		HashMap<Integer,Integer> map=new HashMap<>();
		for(int i=0;i<arr.length;i++) {
			if(map.containsKey(arr[i]) && (i-(map.get(arr[i]))<=k)) {
				return true;
			}
			map.put(arr[i],i);
		}
		return false;
	}
	
	public static List<Integer> majority2(int nums[]){
		List<Integer> list=new ArrayList<>();
		HashMap<Integer,Integer>map=new HashMap<>();
		for(int i=0;i<nums.length;i++) {
			if(map.containsKey(nums[i])) {
				int value=map.get(nums[i]);
				map.put(nums[i], value+1);
			}
			else {
				map.put(nums[i], 1);
			}
		}
		return list;
	}
	
	public static void longestBalancedSubString2() {
		String s="abbac";
		HashMap<String,Integer>map=new HashMap<>();
		map.put("0#0",-1);
		int countA=0;
		int countB=0;
		int countC=0;
		int ans=0;
		for(int i=0;i<s.length();i++) {
			char ch=s.charAt(i);
			if(ch=='a')countA++;
			else if(ch=='b')countB++;
			else countC++;
			
			int diffA=countA-countB;
			int diffB=countA-countC;
			String key=diffA+"#"+diffB;
			if(map.containsKey(key)) {
				ans=Math.max(ans, i-map.get(key));
			}else {
				map.put(key, i);
			}
		}
		System.out.println(ans);
	}
	
	public static void reduceXtoZero() {
		int arr[]= {2,3,1,1,1};
		int x=5;
		HashMap<Integer,Integer>map=new HashMap<>();
		int sum=0;
		int ans=0;
		for(int i=0;i<arr.length;i++) sum=sum+arr[i];
		x=sum-x;
		sum=0;
		for(int i=0;i<arr.length;i++) {
			sum=sum+arr[i];
			if(sum==x) {
				ans=i+1;
			}if(map.containsKey(sum-x)) {
				ans=Math.max(ans,i-map.get(sum-x));
				System.out.println(ans);
			}
			if(!map.containsKey(sum)) {
				map.put(sum,i);
	
			}
		}
		System.out.println(arr.length-ans);
	}
	
	
	public static void maxInEleinSubset() {
		int arr[]= {131073,65537,65537};
		HashMap<Long,Integer>map=new HashMap<>();
		for(int i:arr) {
			map.put((long)i,map.getOrDefault((long)i, 0)+1);
		}
		System.out.println(map);
		int ans=1;
		for(long element :map.keySet()) {
			if(element==1) {
				int value=map.get(element);
				ans=Math.max(ans,value-(value%2^1));
			}
			int count=0;
			long num=element;
			while(map.containsKey(num) && map.get(num)>1) {
				num=num*num;
				count=count+2;
			}
			if(map.containsKey(num) && map.get(num)>=1) {
				count=count+1;
			}else {
				count=count-1;
			}
			ans=Math.max(ans, count);
		}
		System.out.println(ans);
	}
	
	public static void fruitInBasket() {
		int arr[]= {1,2,3,2,2};
		int left=0;
		HashMap<Integer,Integer>map=new HashMap<>();
		int ans=0;
		for(int i=0;i<arr.length;i++) {
			map.put(arr[i],map.getOrDefault(arr[i], 0)+1);
			while(map.size()>2) {
				map.put(arr[left],map.get(arr[left])-1);
				if(map.get(arr[left])==0) map.remove(arr[left]);
				left++;
			}
			ans=Math.max(ans, i-left+1);
		}
		System.out.println(ans);
		
	}
	
	public static void main(String[] args) {
		int a[]= {1,0,1,1};
		int b[]= {1,2,4,5,6,8,9,0,11,34};
		int c[]= {1, 5, 7, 1};
		String s="rat";
		String s1="car";
//		ArrayList<Integer> output=removeDuplicates(a);
//		System.out.println(output);
//		MaxFrequency(a);
//		arrayInterSection(a,b);
//		System.out.println(removeDupChar(s));
//		romanToInteger(s1);
//		sumTOZero();
//		ExtractUnique();
//		LongestConsecutive();
//		pairWithDiff();
//		longSubsetZer();
//		findPairs();
//		System.out.println(anagram(s, s1));
//		System.out.println(duplicate(a, 1));
//		System.out.println(majority2(a));
//		longestBalancedSubString2();
//		reduceXtoZero();
//		maxInEleinSubset();
		fruitInBasket();

		
		
		
		

	}

}
