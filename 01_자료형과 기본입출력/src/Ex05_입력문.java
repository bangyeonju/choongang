import java.util.Scanner;



public class Ex05_�Է¹� {
	public static void main(String[] args) {
		int a;
		a = 10;
		System.out.println("a=" +a);
		
		a = 20;
		System.out.println("a=" +a);
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("�̸��Է� : ");
		String name = sc.next();
		System.out.println("name=" +name);
		
		System.out.print("�������� �Է� :");
		int kor = sc.nextInt();// �Է��� ������ scanner�� ���� �о���δ�.
		System.out.println("kor="+kor);
		
		System.out.print("�������� �Է� :");
		int eng = sc.nextInt();
		System.out.println("eng="+eng);
		
		System.out.print("�������� �Է� :");
		int math = sc.nextInt();
		System.out.println("math="+math);
		
		int total =	kor + eng + math;
		System.out.println("���� : "+ total);
		
		//�� �Ҽ����Ʒ� 2�ڸ� ��� -> *printf*
		double avg =(double)total / 3;
		System.out.printf("��� : %f\n" , avg);
		System.out.printf("��� : %.2f" , avg);
	}
}
