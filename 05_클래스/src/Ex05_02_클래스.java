class Tv { //멤버변수는 일반 변수와 다르게 기본값을 가지고 있다.
	
	String color; // String의 기본값은 null
	int channel; //int의 기본값은 0
	boolean power; // boolean의 기본값은  false
					//double 의 기본값은 0.0
} //Tv클래스
/*
class Person {
	String name; //멤버변수(field)
	int age;//멤버변수(field)
	double height;//멤버변수(field)
}// Person클래스
 --> 같은 프로젝트에서 같은 이름의 클래스를 사용할수없다.
 */
public class Ex05_02_클래스 {
	public static void main(String[] args) {

//		int a;
//		System.out.println(a); 초기값이 설정되어있지 않다. -->기본값없어서 에러
		
		Tv t = new Tv();

		System.out.println(t.color);
		System.out.println(t.channel);
		System.out.println(t.power);
		System.out.println();
		
		t.color = "red";
		t.channel = 11;
		t.power = false; //꺼짐

		System.out.println(t.color);
		System.out.println(t.channel);
		System.out.println(t.power);
		System.out.println();
		Tv t2 = new Tv();
		t2.color = "blue";
		t2.channel = 9;
		t2.power = true; //켜짐

		System.out.println(t2.color);
		System.out.println(t2.channel);
		System.out.println(t2.power);
		
		Person p = new Person(); //다른 파일에서 만든 클래스도 사용가능! -> 같은 이름의 클래스는 만들지 못한다!
		p.name = "홍길동";
		p.age = 40;
		p.height=180.8;
		
		System.out.println();
		System.out.println(p.name);
		System.out.println(p.age);
		System.out.println(p.height);
		
	}
}
