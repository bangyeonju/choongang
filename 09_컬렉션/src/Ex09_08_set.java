import java.util.HashSet;
import java.util.Iterator;

public class Ex09_08_set {
	public static void main(String[] args) {
		//Set �ߺ��� ������� �ʴ´�. ������ �������� �ʴ´�
		HashSet<String> hs = new HashSet<String>();
		hs.add("aa");
		hs.add("bb");
		hs.add("cc");
		hs.add("bb");
		hs.add("aa");
		
		System.out.println(hs.size());//�ߺ��� ������� �ʴ´�
		System.out.println(hs);
		System.out.println(hs.contains("bb")); //hs�� bb�� ������ true
		System.out.println(hs.contains("dd"));// hs��dd�� ������ false
		System.out.println(hs.remove("bb"));//bb�� �����ٸ� true 
		System.out.println(hs.remove("dd"));//dd�� ������� false
		System.out.println(hs);
		Iterator<String> iter = hs.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
	}
}
