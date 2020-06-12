class Person {
	private String name;
	private int age;

	void display() {
		System.out.println(name + " " + age);

	}

	Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

//	 Person() {
//	}
}

class Student extends Person {
	int kor, eng;

	void display() { // �������̵� (��ӹ޴� �޼����� �������� �����Ѵ�
		super.display();
		System.out.print(kor + " " + eng);
		System.out.println();

	}

	Student(String name, int age, int kor, int eng) {
		super(name, age);
		this.kor = kor;
		this.eng = eng;

	}
}

class Employee extends Person {
	String company;
	String part;

	void display() {
		super.display();
		System.out.println(company + " " + part);
	

	}

	Employee(String name, int age, String company, String part) {
		super(name, age);
//		this.name=name ��ӹ޾����� private�� �����Ҽ�����. 
		this.company = company;
		this.part = part;
	}

}

class Teacher extends Employee {
//	private String name;
//	private int age;
//	private String company;
//	private String part;
	private String subject;

	void display() { //�������̵� (����Ÿ�� �޼����̸� �Ķ����) �� �Ȱ��ƾ��Ѵپƾƾ�
		super.display();
		System.out.println(subject);
	}

	Teacher(String name, int age, String company, String part, String subject) {
		super(name, age, company, part);
//		this.name= name;
//		this.age=age;
//		this.company=company
//		this.part =part
		this.subject = subject;
	}
}

public class Ex06_03_�濬�� {
	public static void main(String[] args) {
		Person p = new Person("ȿ��", 12);
		p.display();
		System.out.println();
		
		Student s = new Student("����", 29, 100, 100);
		s.display();
		System.out.println();
		
		Employee e = new Employee("�̽±�", 42, "�Ｚ", "������");
		e.display();
		System.out.println();
		
		Teacher t = new Teacher("�¿�", 50, "�ѱ�����б�", "��Ȱ������", "����");
		t.display();

	}
}
