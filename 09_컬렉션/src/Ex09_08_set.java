import java.util.HashSet;
import java.util.Iterator;

public class Ex09_08_set {
	public static void main(String[] args) {
		//Set 중복을 허용하지 않는다. 순서를 유지하지 않는다
		HashSet<String> hs = new HashSet<String>();
		hs.add("aa");
		hs.add("bb");
		hs.add("cc");
		hs.add("bb");
		hs.add("aa");
		
		System.out.println(hs.size());//중복을 허용하지 않는다
		System.out.println(hs);
		System.out.println(hs.contains("bb")); //hs에 bb가 있으면 true
		System.out.println(hs.contains("dd"));// hs에dd가 없으면 false
		System.out.println(hs.remove("bb"));//bb를 지웠다명 true 
		System.out.println(hs.remove("dd"));//dd를 못지우면 false
		System.out.println(hs);
		Iterator<String> iter = hs.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
	}
}
