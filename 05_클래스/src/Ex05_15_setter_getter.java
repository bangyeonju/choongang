

class Person2 {
	private String name; // �������(field), instance����
	 int age;// �������(field)
	private double height;// �������(field)

	void setName(String name) {//name ��������
		this.name = name; //���� �̸��� �Ȱ��ٸ� ����������name�̶��  �켱������ instance�������� ����
	}						//this.name ==> instance����

	String getName() {
		return name;
	}

	void setAge(int age) {
		this.age = age;
	}

	int getAge() {
		return age;
	}

	void setHeight(double height) {
		this.height = height;
	}

	double getHeight() {
//		double height=1.1;//��������height
		return this.height; // �ν��Ͻ�����height!
	}
	
//	Person2(){ //default ������  => �����ڸ� ������������������ ����Ʈ �����ڰ� ��������� / ����Ʈ�����ڴ� �׻�������! �ƹ��͵� ���ϴ� �� �����ڰ� �ڵ����� �������.
//		
//	}

}//

public class Ex05_15_setter_getter {
	public static void main(String[] args) {
		Person2 p = new Person2();
		p.setName("ȫ�浿"); //setter ���� �޴´�
		p.setAge(20);
		p.setHeight(194.6);
		String a = p.getName();
//		int b=p.getAge();
		System.out.println(a);
		System.out.println(p.getName()); 	//getter ���� ��´�
		System.out.println(p.getAge());
		System.out.println(p.getHeight());
	}
}
