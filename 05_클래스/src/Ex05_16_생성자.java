class Person3 {
	private String name;
	private int age;
	private double height;

//	 ������ �������̸��� Ŭ������ �̸��� ���� �޼���. 
//	�տ� void�� �����ʴ´�. -> ����Ÿ���� ����
//	��ü�� ����� �ڵ����� ȣ��Ǵ� �޼���
	void setName(String name) {// name�� �޴���
		this.name = name;
	}

	String getName() {// name���� ��´�
		return name;
	}

	Person3() { // ������ (Constructor)
		System.out.println("=====Person3()������=====");
		name = "����";
		age = 20;
		height = 162.7;

	}
	int getAge() {
		return age;
	}
	double getHeight() {
		return height;
	}
}

public class Ex05_16_������ {
	public static void main(String[] args) {
		Person3 p1 = new Person3(); // ��ü����->������ �ڵ����� ȣ��
		p1.setName("������"); // ������ name �����
//
//		String a = p1.getName();
//		System.out.println(a);

		System.out.println(p1.getName());	// ������
		System.out.println(p1.getAge());
		System.out.println(p1.getHeight());
		

	}

}
