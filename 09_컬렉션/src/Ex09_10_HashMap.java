import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Ex09_10_HashMap {
	public static void main(String[] args) {
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		//
		hm.put("���̸�", new Integer(23));
		hm.put("����", new Integer(45));
		hm.put("����", new Integer(73));
		hm.put("����", new Integer(26));
//		hm.put("����",new Integer(63));
		hm.put("����", new Integer(45));
		System.out.println(hm.size());
		System.out.println(hm);

		System.out.println(hm.get("����"));
		System.out.println(hm.get("������"));
		System.out.println(hm.get("26"));
		System.out.println();
		System.out.println(hm.containsKey("����"));
		System.out.println(hm.containsKey("����"));
		System.out.println(hm.containsKey("26"));
		System.out.println();

		System.out.println(hm.containsValue("����"));
		System.out.println(hm.containsValue("26"));
		System.out.println(hm.containsValue(26));
		//Ű��
		Set key = hm.keySet();
		System.out.println(key);
		System.out.println(hm.keySet()); 
		//����
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
