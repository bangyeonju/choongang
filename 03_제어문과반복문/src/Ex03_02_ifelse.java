import java.util.Scanner;

public class Ex03_02_ifelse {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("이름입력 : ");
		String name = sc.next();
		System.out.println("name=" + name);

		System.out.print("국어점수 입력 :");
		int kor = sc.nextInt();// 입력한 정수를 scanner를 통해 읽어들인다.
		System.out.println("kor=" + kor);

		System.out.print("영어점수 입력 :");
		int eng = sc.nextInt();
		System.out.println("eng=" + eng);

		System.out.print("수학점수 입력 :");
		int math = sc.nextInt();
		System.out.println("math=" + math);

		int total = kor + eng + math;
		System.out.println("총점 : " + total);

		// 평군 소수점아래 2자리 출력 -> *printf*
		double avg = (double) total / 3;
		System.out.printf("평균 : %f\n", avg);
		System.out.printf("평균 : %.2f\n", avg);

		String hakjum = "";

		if (avg >= 90) {
			hakjum = "A학점";
		} else if (avg >= 80) { // 80~89.xxx
			hakjum = "B학점";

		} else if (avg >= 70) {
			hakjum = "C학점";

		} else if (avg >= 60) {
			hakjum = "D학점";
		} else {
			hakjum = "F학점";
		}

		System.out.println("hakjum:" + hakjum);
		System.out.println("============================================================");

		if (avg >= 90) {
			hakjum = "A학점";
		}

		if (avg >= 80 && avg < 90) {
			hakjum = "B학점";
		}

		if (avg >= 70 && avg < 80) {
			hakjum = "C학점";
		}

		if (avg >= 60 && avg < 70) {
			hakjum = "D학점";
		}
		if (avg < 60) {
			hakjum = "F학점";
		}

		System.out.println("hakjum:" + hakjum);
		System.out.println();
		if (kor % 5 == 0) {
			System.out.println("5의 배수");
		}
		if (kor % 10 == 0) {
			System.out.println("10의 배수");
		}
		switch ((int) avg / 10) {
		case 10:
		case 9:
			System.out.println("A학점입니다.");
			break;
		case 8:
			System.out.println("B학점입니다.");
			break;
		case 7:
			System.out.println("B학점입니다.");
			break;	
		case 6:
			System.out.println("C학점입니다.");
			break;
		default :
			System.out.println("F학점입니다.");
			break;
		}

	}
}
