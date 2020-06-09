
class Clac {

	int i = 1; // 멤버변수
	static int j = 2;

	int add(int a, int b) { // 인스턴스 메소드(함수)
		System.out.println(i);
		System.out.println(j);
		prn1(); // 같은 클래스안에서 메서드에 호출 할때 그냥 매서드호출 c.prn1();,Calc.prn2(); x
		prn2();
		int sum = a + b;
		return sum;
	}

	int sub(int a, int b) {
		return a - b;
	}

	static int mul(int a, int b) { // static 메소드
		// System.out.println(i); //static 메소드에서는 static변수만 사용가능!
		System.out.println(j);
//		prn1(); static 메서드안에서는 static메서드만 호출할수 있다. prn1();는 인스턴스..?호츌뷸가능
		prn2();
		return a * b;
	}

	void prn1() {
		System.out.println("--------------------------------");
	}

	static void prn2() {
		System.out.println("************************************");
	}
}

public class Ex05_04_메서드 { // 실행클래스

	public static void main(String[] args) {
		Clac c = new Clac();

//		System.out.println(c.add(10, 20));

		int result = c.add(10, 20);
		System.out.println("result:" + result);

		int subresult = c.sub(100, 30);
		System.out.println("subresult:" + subresult);

		int mulresult = Clac.mul(3, 5); // c.mul(3,5)
		System.out.println("mulresult:" + mulresult);
		int returndiv = div(10, 5);// main에서 호출시 main메서드는 static메소드이므로 div메소드를 호출하려면 static가 있어야한다....

		System.out.println("returndiv=" + returndiv);

		Ex05_04_메서드 ex = new Ex05_04_메서드(); // 2.객체생성을 해야 namergi메소드를 호출가능
		System.out.println("namergi리턴값:" + ex.namergi(10, 5));

	}

	static int div(int a, int b) { // main
		int divresult = a / b;
		return divresult;
	}

	int namergi(int a, int b) { // 1.static을 붙이지 않는다면
		int naresult = a % b;
		return naresult;

	}

}
