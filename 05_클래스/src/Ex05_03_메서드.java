
public class Ex05_03_메서드 {
// 메서드란???
// 한번만들어놓고 재활용(재사용)?하는거??? 
//	하나의 파일에는 여러가지 메소드가 존재가능  main 메서드는 필수 => 항상 main메서드부터 실행!
	public static void main(String[] args) { // main이란 이름을 가지고있는 메서드 => main 메서드 정의
		int a = 1 + 2;
		System.out.printf("a=%d\n", a);

		a = 3 + 4;
		System.out.printf("a=%d\n", a);

		add(10, 20); // add 메서드 호출,파라미터(parameter) (호출하는게 없으면 add메서드는 실행될수없다)
		System.out.println("-----------------------------------------");
		add(100, 200);
		System.out.println("**************************************");

		int returnValue = sub(10, 3, 2); // 메서드는 항상 호출한 자리로 감! return값!
		System.out.println("returnValue=" + returnValue);
		System.out.println(sub(5, 2, 1));

		int mulValue = mul();
		System.out.println("mulValue=" + mulValue);

	} // main

//		   void는 리턴타입 자리 /  return되는 값이 없을경우 void씀!  //매개변수 (int x, int y)
	static void add(int x, int y) { // add 메서드 정의!
		int z = x + y;
		prn();
		System.out.println("z=" + z);
		return; // 생략가능
	}

	static int sub(int x, int y, int z) { // sub 메서드 정의!

		// int result = x-y-z;
		// return x-y-z;
		int result = x - y - z;
		return result;

	}

	static int mul() { // mul 메소드 정의!
		return 3 * 4;
	}

	static void prn() {
		System.out.println("===============");
	}
} // class
