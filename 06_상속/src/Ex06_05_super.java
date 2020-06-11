class Parent{
	int x=10;
	void method() {
		System.out.println("P_x:"+x);
	}
}
class Child extends Parent{
	int x = 20;
	void method() {
	int x=30;
		System.out.println("x:"+x);//지역변수 x -> 만약 지역변수가 없다면 멤버변수사용하게된다.
		System.out.println("this.x:"+ this.x);//인스턴스 x
		System.out.println("super.x:"+super.x);
		
		super.method();
		
	}
}
public class Ex06_05_super {
	public static void main(String[] args) {
//		Parent p = new Parent();
		Child c = new Child();
		 c.method();
		
	}

}
