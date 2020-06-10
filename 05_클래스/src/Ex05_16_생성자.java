
class Person3 {
	private String name;
	private int age;
	private double height;
	void setName(String name) {// name를 받눈다
		this.name = name;
	}

	String getName() {// name값을 뱉는다
		return name;
	}

	
//	 생성자 생성자이름은 클래스와 이름이 같은 메서드. 
//	앞에 void도 쓰지않는다. -> 리턴타입이 없다
//	객체를 만들면 자동으로 호출되는 메서드
	/*
	Person3() { // 생성자 (Constructor)
		System.out.println("=====Person3()생성자=====");
		name = "슬기";
		age = 20;
		height = 162.7;

	}*/ //기본생성자는 자동으로 만들어지는 매개변수가 있는 생성자를 만들면 기본생성자는 생기지 않는다. 그래서
	// 기본 생성자 만들어줘야한다.!
	Person3() {
		
	}
	
	Person3(String name,int age, double height) { //생성자 오버로딩
		System.out.println("=====Person3(String n,int a, double h)생성자=====");
		this.name = name;
		this.age = age;
		this.height = height;
		
	}
	int getAge() {
		return age;
	}
	double getHeight() {
		return height;
	}
	void display() {
		System.out.println("이름 " +name);
		System.out.println("나이" +age);
		System.out.println("키"+ height);
		System.out.println();
	}
	String show(){
		return "이름= " +name+ " 나이= "+ age+ " 키= "+ height;
	}
}

public class Ex05_16_생성자 {
	public static void main(String[] args) {
		Person3 p1 = new Person3(); // 객체생성->생성자 자동으로 호츌
		
		p1.setName("아이유"); // 생성자 name 덮어쓰움
//
//		String a = p1.getName();
//		System.out.println(a);

		System.out.println(p1.getName());	// 아이유
		System.out.println(p1.getAge());
		System.out.println(p1.getHeight());
		System.out.println();
		
		Person3 p2 = new Person3("웬디",54,147.2); // 객체생성->생성자 자동으로 호츌
		System.out.println(p2.getName());	// 아이유
		System.out.println(p2.getAge());
		System.out.println(p2.getHeight());
		
		p1.display();
		p2.display();
		System.out.println("****************");
		System.out.println(p1.show());
		System.out.println(p2.show());
	}

}
