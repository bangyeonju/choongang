import java.util.InputMismatchException;
import java.util.Scanner;

public class EX08_06_�濬�� {
	public static void main(String[] args) {

		int i, j;
		Scanner sc = new Scanner(System.in);
		int[] my = new int[6];
		int count = 0;
		int[] lotto = new int[6];

		for (i = 0; i < lotto.length; i++) {
			lotto[i] = (int) (Math.random() * 45) + 1;

			// System.out.print(lotto[i] + " ");
			for (j = 0; j < i; j++) {
				if (lotto[i] == lotto[j]) {
					lotto[i] = (int) (Math.random() * 45) + 1;
					j = -1; // ���������� ���� j++ -> �ٽ� j=0; //�Ǿպ��� ���ϱ�����
				}
			}
		}
		

		System.out.println();
		for (i = 0; i < lotto.length; i++) {

			System.out.print("����" + (i + 1) + ":");
//			try {
			my[i] = sc.nextInt();
//			}
//			catch(InputMismatchException e) {
//				System.out.println("�����Է�");
				
//			}
			for (j = 0; j < i; j++) {

				if (my[i] == my[j]) {
					System.out.println("�ߺ��� �ٽ��Է�" + "����" + (i + 1) + ":");
					my[i] = sc.nextInt();
					j = -1; // ���������� ���� j++ -> �ٽ� 0������� 
				}
			}
			if (my[i] < 1 || my[i] > 45) {
				System.out.println("1~45������ �� �Է��ϼ���");
				i--;
				continue;
			}

		}
		System.out.println("���� �߻���Ų �ζǹ�ȣ");
		for (i = 0; i < 6; i++) {
			System.out.print(lotto[i] + " ");
		}
		System.out.println();
		System.out.println("���� �Է��� �ζǹ�ȣ");
		for (i = 0; i < 6; i++) {
			System.out.print(my[i] + " ");
		}
		
		for(i=0;i<6;i++) {
			for(j=0;j<6;j++) {
				if(lotto[i]== my[j]) {
					count++;
				}
			}
		}
		System.out.println("��������"+count);
		switch(count) {
		case 6: System.out.println("1��");
		case 5: System.out.println("2��");
		case 4: System.out.println("3��");
		default :
		}

	}
}

//����1: 3
//����2: 4
//����3: 12
//����4: 4
//�ߺ��� �ٽ� ����4: 12
//�ߺ��� �ٽ� ����4: 3
//�ߺ��� �ٽ� ����4: 43
//����5: 89
//1~45������ �� �Է��ϼ���.
//����5: 22
//����6: 33
//���� �߻���Ų �ζ� ��ȣ
//2 19 32 15 43 7 
//
//���� ������ �ζ� ��ȣ
//3 4 12 43 22 33 
//
//���� ���� : 1
//��!!
