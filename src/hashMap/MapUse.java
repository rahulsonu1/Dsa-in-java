package hashMap;

public class MapUse {

	public static void main(String[] args) {
		Map<String, Integer> map=new Map<>();
		for(int i=1;i<=20;i++) {
			map.insert("abc"+i, i+1);
		}
		
		int s=map.size();
		System.out.println(s);
	}

}
