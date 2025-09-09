package hashMap;

import java.util.HashMap;
import java.util.Set;

public class InBuiltMapUse {

	public static void main(String[] args) {
		HashMap<String,Integer> map=new HashMap<>();
		map.put("abc", 1);
		map.put("def", 2);
//		System.out.println(map.get("abc"));
//		System.out.println(map.containsKey("abc"));
//		System.out.println(map.containsValue(2));
//		Set<String> keys=map.keySet();
//		for(String s:keys) {
//			System.out.println(s);
//		}
		System.out.println(map.size());
		Set<String> keys=map.keySet();
		System.out.println(keys);
		System.out.println(map);
	}

}
