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
		System.out.println("�θ��θ�����");
	}
	
}
public class Ex07_02_�͸� {

	public static void main(String[] args) {
		Parent p = new Parent();
		p.display();
		Child c = new Child();
		c.display();
		Child c2 = new Child();
		c2.x= 5;
		c2.display();
		
		
		//�޼��带 �ѹ��� ȣ���ؼ� ����ϸ� ���� Ŭ������ �����ʿ����.
		new Parent() {
			void display() {
				System.out.println(x*x*x);
			}//display
		}.display();
		
		p.display();
		
		new Car2() {
			void drive() {
				System.out.println("������");
			}//drive
		}.drive();
		
	}

}
