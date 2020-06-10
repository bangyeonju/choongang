

class Person2 {
	private String name; // 멤버변수(field), instance변수
	 int age;// 멤버변수(field)
	private double height;// 멤버변수(field)

	void setName(String name) {//name 지역변수
		this.name = name; //변수 이름이 똑같다면 지역변수가name이라면  우선순위가 instance변수보다 높다
	}						//this.name ==> instance변수

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
//		double height=1.1;//지역변수height
		return this.height; // 인스턴스변수height!
	}
	
//	Person2(){ //default 생성자  => 생성자를 따로정의하지않으면 디폴트 생성자가 만들어진다 / 디폴트생성자는 항상존재함! 아무것도 안하는 빈 생성자가 자동으로 만들어짐.
//		
//	}

}//

public class Ex05_15_setter_getter {
	public static void main(String[] args) {
		Person2 p = new Person2();
		p.setName("홍길동"); //setter 값을 받는다
		p.setAge(20);
		p.setHeight(194.6);
		String a = p.getName();
//		int b=p.getAge();
		System.out.println(a);
		System.out.println(p.getName()); 	//getter 값을 뱉는다
		System.out.println(p.getAge());
		System.out.println(p.getHeight());
	}
}
