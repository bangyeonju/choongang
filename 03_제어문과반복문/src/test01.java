import java.util.Scanner;

public class test01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int su = sc.nextInt();
		System.out.printf("%d\n", su);
		System.out.println("==========================");
		if (su < 10) {
			switch (su) {
			case 1:
				System.out.println("1");
				break;
			case 2:
				System.out.println("2");
				break;
			case 3:
				System.out.println("3");
				break;
			case 4:
				System.out.println("4");
				break;
			case 5:
				System.out.println("5");
				break;
			case 6:
				System.out.println("6");
				break;
			case 7:
				System.out.println("7");
				break;
			case 8:
				System.out.println("8");
				break;
			case 9:
				System.out.println("9");
				break;
			}
		} else {
			System.out.println("다시입력하세요");
		}

	}
}
