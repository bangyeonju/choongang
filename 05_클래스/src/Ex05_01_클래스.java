
// 클래스란?
// 사용자가 만들어 쓰는 사용자 정의 자료형
class Person {
	String name; //멤버변수(field)
	int age;//멤버변수(field)
	double height;//멤버변수(field)
}// 
public class Ex05_01_클래스 {
	public static void main(String[] args) {
	int a;
	a=1;
	double b =2.3;
	a=3;
	a=7;
	// man,woman : 참조변수
	// 참조변수.멤버변수
	Person man = new Person(); // 내가 만든 자료형으로 공간을 만드는 과정 => 객체생성
	// man에 주소가 들어옴? 주소가 들어오는 공간은 무조건 4바이트!
	String name;
	name="아이유";
	man.name="철수"; // man변수가 관리하는 name에 철수..?????? 	
	man.age=20;
	man.height=173.8;
	//참조값 => 주소와 연결되어있는값
	System.out.println(name);
	System.out.println(man.name);
	System.out.println(man.age);
	System.out.println(man.height);
	
	
	Person woman = new Person(); //새로운 공간이 만들어짐.woman변수를 통해서 멤버변수 세개에 접근 가능!
	woman.name="영희";
	woman.age=30;
	woman.height=154.3;
	System.out.println(woman.name);
	System.out.println(woman.age);
	System.out.println(woman.height);
	
	
	}
}
