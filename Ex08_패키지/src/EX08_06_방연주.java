import java.util.Scanner;

public class EX08_06_�濬�� {
	public static void main(String[] args) {

		int i,j;
		Scanner sc = new Scanner(System.in);
		int[] my = new int[6];
		int count = 0;
		int[] lotto = new int[6];
		for (i = 0; i < 6; i++) {
			lotto[i] = (int) (Math.random() * 45) + 1;
			System.out.print(lotto[i]+" ");
			
		
			
		//	System.out.print(lotto[i] + " ");

		}
		System.out.println();
		for (i = 0; i < lotto.length; i++) {
			System.out.print("����"+(i+1)+":");
			my[i] = sc.nextInt();
		}

		for (i = 0; i < lotto.length; i++) {
			System.out.print(my[i] + " ");
		}
//		for (i = 0; i < lotto.length; i++) {
//			for (j=0;)
//			
//		}

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
