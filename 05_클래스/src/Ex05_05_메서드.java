import java.util.Scanner;

public class Ex05_05_�޼��� {
	public static void main(String[] args) {
		
		// ���� 2�� �Է�
		Scanner sc = new Scanner(System.in);
		System.out.print("����1:");
		int a = sc.nextInt();
		System.out.print("����2:");
		int b = sc.nextInt();

		Calculator calc = new Calculator(); // ��ü����

		// ��
		int sumResult = calc.add(a, b);
		System.out.println("sumResult:" + sumResult);

		// ū��
		// int maxResult = calc.max(a, b);
		int maxResult = Calculator.max(a, b);
		System.out.println("maxResult:" + maxResult);

		// ������
		// int minResult = calc.min(a, b);
		int minResult = Calculator.min(a, b);
		System.out.println("minResult:" + minResult);

	}

}

class Calculator {
	// ���� �����ϴ� �޼���
	int add(int a, int b) {
		return a + b;
	}

	// ū���� �����ϴ� �޼���
	static int max(int a, int b) {
		if (a > b) {
			return a;
		} else {
			return b;
		}

	}

	// �������� �����ϴ� �޼���
	static int min(int a, int b) {
		if (a < b) {
			return a;
		} else {
			return b;
		}
	}

}
