import java.util.Scanner;

public class Ex03_12_while {
	public static void main(String[] args) {
		// while 1~5까지 출력
		int i = 1;
		while (i <= 5) {
			System.out.println(i);
			i++;

		}
		System.out.println();

		i = 1;
		while (true) {
			System.out.println(i);
			if (i == 5)
				break; // 반복문을 빠져나가는 기능
			i++;
		}
		// break 만나면 여기로 온다.

		System.out.println();
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		int num;
		while (true) {
			System.out.print("숫자입력:");
			num = sc.nextInt();

			if (num < 0) {
				break; // while문 빠져나감
			}
			sum = sum + num;
		}

		System.out.println(sum);
	}
}
