import java.util.Scanner;

public class Ex05_05_메서드 {
	public static void main(String[] args) {
		
		// 정수 2개 입력
		Scanner sc = new Scanner(System.in);
		System.out.print("정수1:");
		int a = sc.nextInt();
		System.out.print("정수2:");
		int b = sc.nextInt();

		Calculator calc = new Calculator(); // 객체생성

		// 합
		int sumResult = calc.add(a, b);
		System.out.println("sumResult:" + sumResult);

		// 큰값
		// int maxResult = calc.max(a, b);
		int maxResult = Calculator.max(a, b);
		System.out.println("maxResult:" + maxResult);

		// 작은값
		// int minResult = calc.min(a, b);
		int minResult = Calculator.min(a, b);
		System.out.println("minResult:" + minResult);

	}

}

class Calculator {
	// 합을 리턴하는 메서드
	int add(int a, int b) {
		return a + b;
	}

	// 큰값을 리턴하는 메서드
	static int max(int a, int b) {
		if (a > b) {
			return a;
		} else {
			return b;
		}

	}

	// 작은값을 리턴하는 메서드
	static int min(int a, int b) {
		if (a < b) {
			return a;
		} else {
			return b;
		}
	}

}
