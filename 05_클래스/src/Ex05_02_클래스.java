class Tv { //��������� �Ϲ� ������ �ٸ��� �⺻���� ������ �ִ�.
	
	String color; // String�� �⺻���� null
	int channel; //int�� �⺻���� 0
	boolean power; // boolean�� �⺻����  false
					//double �� �⺻���� 0.0
} //TvŬ����
/*
class Person {
	String name; //�������(field)
	int age;//�������(field)
	double height;//�������(field)
}// PersonŬ����
 --> ���� ������Ʈ���� ���� �̸��� Ŭ������ ����Ҽ�����.
 */
public class Ex05_02_Ŭ���� {
	public static void main(String[] args) {

//		int a;
//		System.out.println(a); �ʱⰪ�� �����Ǿ����� �ʴ�. -->�⺻����� ����
		
		Tv t = new Tv();

		System.out.println(t.color);
		System.out.println(t.channel);
		System.out.println(t.power);
		System.out.println();
		
		t.color = "red";
		t.channel = 11;
		t.power = false; //����

		System.out.println(t.color);
		System.out.println(t.channel);
		System.out.println(t.power);
		System.out.println();
		Tv t2 = new Tv();
		t2.color = "blue";
		t2.channel = 9;
		t2.power = true; //����

		System.out.println(t2.color);
		System.out.println(t2.channel);
		System.out.println(t2.power);
		
		Person p = new Person(); //�ٸ� ���Ͽ��� ���� Ŭ������ ��밡��! -> ���� �̸��� Ŭ������ ������ ���Ѵ�!
		p.name = "ȫ�浿";
		p.age = 40;
		p.height=180.8;
		
		System.out.println();
		System.out.println(p.name);
		System.out.println(p.age);
		System.out.println(p.height);
		
	}
}
