import java.util.Enumeration;
import java.util.Vector;

public class Ex09_07_Vector {
	public static void main(String[] args) {
		Vector<String> v = new Vector<String>();
		v.add("��");
		v.add("����");
		v.add("��");
		v.add("�ܿ�");
		
		System.out.println("v:"+v);
		Enumeration<String> en = v.elements(); // enumeration : ������ ������ �����Ҽ��ִ�Ÿ��
		while(en.hasMoreElements()) {//hasMoreElements? en�� �����ϴ� ��Ұ� ������ �� ������ ����!
			String e1 = en.nextElement();
			System.out.println(e1);
		}
		System.out.println();
		
		for(String temp : v) {
			System.out.println(temp);
		}
	}
}
