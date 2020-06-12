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

	void display() { // 오버라이딩 (상속받는 메서드의 ㅐㄴ용을 변경한느
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
//		this.name=name 상속받았지만 private은 접근할수없다. 
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

	void display() { //오버라이딩 (리턴타입 메서드이름 파라미터) 다 똑같아야한다아아아
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

public class Ex06_03_방연주 {
	public static void main(String[] args) {
		Person p = new Person("효연", 12);
		p.display();
		System.out.println();
		
		Student s = new Student("윤아", 29, 100, 100);
		s.display();
		System.out.println();
		
		Employee e = new Employee("이승기", 42, "삼성", "연구부");
		e.display();
		System.out.println();
		
		Teacher t = new Teacher("태연", 50, "한국고등학교", "생활지도부", "음악");
		t.display();

	}
}
