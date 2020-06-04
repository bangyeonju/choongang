import java.util.Scanner;

public class Ex03_01_ifelse {
	public static void main(String[] args) {
		int a, b;
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자1:");
		a = sc.nextInt();
		System.out.print("숫자2:");
		b = sc.nextInt();
		System.out.println(a + "," + b);
		// System.out.printf("%d,%d",a,b);
		
		if (a > b) {
			System.out.println("a가 b보다 크다");

			System.out.println("하하하");
		}
		else if (a < b) {
			System.out.println("b가 a보다 크다");
			System.out.println("호호호");
		} 
		else /*if (a == b) */ {
			System.out.println("a와 b랑 같다");
			System.out.println("헤헤헤");

		}
		System.out.println("if~else공부하는중~~"); // 조건하고 상관없이 무조건 출력!

	}
}
