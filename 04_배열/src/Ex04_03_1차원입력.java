import java.util.Scanner;

public class Ex04_03_1차원입력 {
	public static void main(String[] args) {
		// 정수 하나 입력받아 출력
		Scanner sc = new Scanner(System.in);
//		System.out.print("숫자:");
//		int num = sc.nextInt();
//		System.out.println("num:"+num);

		int[] jumsu = new int[5];

//		jumsu[0] = sc.nextInt();
//		jumsu[1] = sc.nextInt();
//		jumsu[2] = sc.nextInt();
//		jumsu[3] = sc.nextInt();
//		jumsu[4] = sc.nextInt();
		int i;
		for (i = 0; i < jumsu.length; i++) {
			System.out.print(i+"번방:");
			jumsu[i] = sc.nextInt();
		} // for
		for (i = 0; i < jumsu.length; i++) {
			// jumsu[i] = sc.nextInt();
			System.out.print(jumsu[i] + " ");
		}
	}// for

}
