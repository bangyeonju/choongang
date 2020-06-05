import java.util.Scanner;

public class Ex03_02_ifelse {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("�̸��Է� : ");
		String name = sc.next();
		System.out.println("name=" + name);

		System.out.print("�������� �Է� :");
		int kor = sc.nextInt();// �Է��� ������ scanner�� ���� �о���δ�.
		System.out.println("kor=" + kor);

		System.out.print("�������� �Է� :");
		int eng = sc.nextInt();
		System.out.println("eng=" + eng);

		System.out.print("�������� �Է� :");
		int math = sc.nextInt();
		System.out.println("math=" + math);

		int total = kor + eng + math;
		System.out.println("���� : " + total);

		// �� �Ҽ����Ʒ� 2�ڸ� ��� -> *printf*
		double avg = (double) total / 3;
		System.out.printf("��� : %f\n", avg);
		System.out.printf("��� : %.2f\n", avg);

		String hakjum = "";

		if (avg >= 90) {
			hakjum = "A����";
		} else if (avg >= 80) { // 80~89.xxx
			hakjum = "B����";
			if (avg >= 85) {
				hakjum = hakjum + "+";
			} else {
				hakjum = hakjum + "-";
			}

		} else if (avg >= 70) {
			hakjum = "C����";

		} else if (avg >= 60) {
			hakjum = "D����";
		} else {
			hakjum = "F����";
		}

		System.out.println("����:" + hakjum);
		System.out.println("============================================================");

		if (avg >= 90) {
			hakjum = "A����";
		}

		if (avg >= 80 && avg < 90) {
			hakjum = "B����";
		}

		if (avg >= 70 && avg < 80) {
			hakjum = "C����";
		}

		if (avg >= 60 && avg < 70) {
			hakjum = "D����";
		}
		if (avg < 60) {
			hakjum = "F����";
		}

		System.out.println("hakjum:" + hakjum);
		System.out.println();

		switch ((int) avg / 10) {
		case 10:
		case 9:
			// System.out.println("A�����Դϴ�.");
			hakjum = "A����";
			break;
		case 8:
			// System.out.println("B�����Դϴ�.");
			hakjum = "B����";
			break;
		case 7:
			// System.out.println("B�����Դϴ�.");
			hakjum = "C����";
			break;
		case 6:
			// System.out.println("C�����Դϴ�.");
			hakjum = "D����";
			break;
		default:
			// System.out.println("F�����Դϴ�.");
			hakjum = "F����";
			break;
		}
		System.out.println("����" + hakjum);

		if (kor % 5 == 0) {
			System.out.println("5�� ���");
		}
		if (kor % 10 == 0) {
			System.out.println("10�� ���");
		}

	}
}
