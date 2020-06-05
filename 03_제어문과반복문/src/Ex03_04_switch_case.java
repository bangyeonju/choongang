import java.util.Scanner;

public class Ex03_04_switch_case {
	public static void main(String[] args) {

		// 문자열 입력해서 fruit변수에 넣기
		Scanner sc = new Scanner(System.in);
		System.out.print("과일이름입력:");
		String fruit = sc.next();
		System.out.println("fruit:" + fruit);

		switch (fruit) {
			case "apple":
				System.out.println("사과");
				break;
			case "grape":
				System.out.println("포도");
				break;
			case "melon":
				System.out.println("메론");
				break;
			default :
				System.out.println("그밖의 과일");

		} // switch

	}// main

}// class
