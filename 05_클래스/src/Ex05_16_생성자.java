class Person3 {
	private String name;
	private int age;
	private double height;

//	 생성자 생성자이름은 클래스와 이름이 같은 메서드. 
//	앞에 void도 쓰지않는다. -> 리턴타입이 없다
//	객체를 만들면 자동으로 호출되는 메서드
	void setName(String name) {// name를 받눈다
		this.name = name;
	}

	String getName() {// name값을 뱉는다
		return name;
	}

	Person3() { // 생성자 (Constructor)
		System.out.println("=====Person3()생성자=====");
		name = "슬기";
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
		

	}

}
