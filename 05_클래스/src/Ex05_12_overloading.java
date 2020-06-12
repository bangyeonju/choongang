
public class Ex05_12_overloading {
	public static void main(String[] args) {
		Ex05_12_overloading ex = new Ex05_12_overloading();
		ex.plus(1,2,3);
		ex.plus(10,20);
		ex.plus(1.1,2.2);
	}
	void plus(int a,int b, int c) { // 오버로딩  // 하나의 클래스 안에서 매개변수의 개수나 자료형을  다르게 하면 같은 이름의 여러개의 메소드를 만들수있다
		System.out.println(a+b+c);
	}

	void plus(int a,int b) {
		System.out.println(a+b);
	}
	
	void plus(double a,double b) {
		System.out.println(a+b);
	}
}
