
// Ŭ������?
// ����ڰ� ����� ���� ����� ���� �ڷ���
class Person {
	String name; //�������(field)
	int age;//�������(field)
	double height;//�������(field)
}// 
public class Ex05_01_Ŭ���� {
	public static void main(String[] args) {
	int a;
	a=1;
	double b =2.3;
	a=3;
	a=7;
	// man,woman : ��������
	// ��������.�������
	Person man = new Person(); // ���� ���� �ڷ������� ������ ����� ���� => ��ü����
	// man�� �ּҰ� ����? �ּҰ� ������ ������ ������ 4����Ʈ!
	String name;
	name="������";
	man.name="ö��"; // man������ �����ϴ� name�� ö��..?????? 	
	man.age=20;
	man.height=173.8;
	//������ => �ּҿ� ����Ǿ��ִ°�
	System.out.println(name);
	System.out.println(man.name);
	System.out.println(man.age);
	System.out.println(man.height);
	
	
	Person woman = new Person(); //���ο� ������ �������.woman������ ���ؼ� ������� ������ ���� ����!
	woman.name="����";
	woman.age=30;
	woman.height=154.3;
	System.out.println(woman.name);
	System.out.println(woman.age);
	System.out.println(woman.height);
	
	
	}
}
