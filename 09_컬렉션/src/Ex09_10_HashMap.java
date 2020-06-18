import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Ex09_10_HashMap {
	public static void main(String[] args) {
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		//
		hm.put("아이린", new Integer(23));
		hm.put("슬기", new Integer(45));
		hm.put("웬디", new Integer(73));
		hm.put("조이", new Integer(26));
//		hm.put("조이",new Integer(63));
		hm.put("예리", new Integer(45));
		System.out.println(hm.size());
		System.out.println(hm);

		System.out.println(hm.get("웬디"));
		System.out.println(hm.get("아이유"));
		System.out.println(hm.get("26"));
		System.out.println();
		System.out.println(hm.containsKey("슬기"));
		System.out.println(hm.containsKey("수지"));
		System.out.println(hm.containsKey("26"));
		System.out.println();

		System.out.println(hm.containsValue("슬기"));
		System.out.println(hm.containsValue("26"));
		System.out.println(hm.containsValue(26));
		//키만
		Set key = hm.keySet();
		System.out.println(key);
		System.out.println(hm.keySet()); 
		//값만
		Collection<Integer> values =hm.values();
		System.out.println(values);
		System.out.println(hm.values());
		int i;
		
		Iterator<String> iter = key.iterator();
		
		while(iter.hasNext()) {
			String name = iter.next();
			System.out.println(name+":"+hm.get(name));
			
		}
//		for(i=0;i<key.size();i++) {
//			System.out.println();
//			
//		}
		

	}
}
