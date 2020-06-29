import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex07_07_숫자입력 {

	public static void main(String[] args) {
//		double d = Math.random();
//		System.out.println("d:"+d);
//		(int)(0*100)+1 <=(int)(x*100)+1< (int)(1*100)+1
		int input = 0;
		;
		int count = 0;
		int answer = (int) (Math.random() * 11) + 10;
		System.out.println("answer: " + answer);
		do {
			count++;
			System.out.println("\n1~100사이의 정수값을 입력하세용~");
			Scanner sc = new Scanner(System.in);
			try {
				input = sc.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("유효한 값이 아닙니다.숫자로 다시입력하세용");
				continue; // while의 조건식으로 감! // for문에서는 증감식으로
			}
			if (answer > input) {
				System.out.println("더큰수를 입력하세요");
			} else if (answer < input) {
				System.out.println("더 작은수를입력하세용");
			} else {
				System.out.println("정답입니다");
				System.out.println("시도한 횟수:" + count + "입니다.");
				break;
			}

		} while (true);
		System.out.println("프로그램을 종료합니당");
	}

}
