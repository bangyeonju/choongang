class Parent {
	int x = 2;
	void display() {
		System.out.println("P_x:"+x);
	}
}

class Child extends Parent {
	void display() {
		System.out.println("C_x:"+x*x);
	}
}
/*
class Child2 extends Parent {
	void display() {
		System.out.println("C_x:"+x*x*x);
	}
}
*/
class Car2{
	void drive() {
		System.out.println("부릉부르르릉");
	}
	
}
public class Ex07_02_익명 {

	public static void main(String[] args) {
		Parent p = new Parent();
		p.display();
		Child c = new Child();
		c.display();
		Child c2 = new Child();
		c2.x= 5;
		c2.display();
		
		
		//메서드를 한번만 호출해서 사용하면 굳이 클래스를 만들필요없다.
		new Parent() {
			void display() {
				System.out.println(x*x*x);
			}//display
		}.display();
		
		p.display();
		
		new Car2() {
			void drive() {
				System.out.println("따르릉");
			}//drive
		}.drive();
		
	}

}
