import java.util.Enumeration;
import java.util.Vector;

public class Ex09_07_Vector {
	public static void main(String[] args) {
		Vector<String> v = new Vector<String>();
		v.add("봄");
		v.add("여름");
		v.add("봄");
		v.add("겨울");
		
		System.out.println("v:"+v);
		Enumeration<String> en = v.elements(); // enumeration : 열거형 데이터 관리할수있는타입
		while(en.hasMoreElements()) {//hasMoreElements? en이 관리하는 요소가 있으면 참 없으면 거짓!
			String e1 = en.nextElement();
			System.out.println(e1);
		}
		System.out.println();
		
		for(String temp : v) {
			System.out.println(temp);
		}
	}
}
