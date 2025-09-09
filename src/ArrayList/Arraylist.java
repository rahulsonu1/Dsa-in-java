package ArrayList;
import java.util.ArrayList;
public class Arraylist {

	public static void main(String[] args) {
		ArrayList<String> arr=new ArrayList<>();
		arr.add("3");
		arr.add("4");
		arr.add("355");
		arr.set(0, "44444");
		System.out.println(arr.size());
		System.out.println(arr.get(2));
		for(int i=0;i<arr.size();i++) {
			System.out.println(arr.get(i));
		}

	}

}
