import java.util.ArrayList;
import java.util.Scanner;

class Card {
	private String name;
	private String tel;

	Card(String name, String tel) {
		this.name = name;
		this.tel = tel;

	}
//	void setName() {
//		this.name = name;
//	}
	String getName() {
		return name;
	}

	String getTel() {
		return tel;
	}
	public String toString() {
		return name +"/" +tel;
	}
}

public class Ex09_06_�濬�� {
	public static void main(String[] args) {
		ArrayList<Card> list = new ArrayList<Card>();
		while(true) {
		Scanner sc = new Scanner(System.in);
		System.out.println("1.�����߰� 2.���Ի��� 3.���Լ��� 4.���Ժ��� 5.����");
		String name;
		String tel;
		int i;
		int select = sc.nextInt();
		switch (select) {
		case 1:
			System.out.println("�̸��� �Է��ϼ���");
			name = sc.next();
			System.out.println("��ȭ��ȣ�� �Է��ϼ���");
			tel = sc.next();
			Card c = new Card(name, tel);
			list.add(c);
			System.out.println(list);
			break;

		case 2:
			System.out.println("�̸��� �Է��ϼ���");
			name = sc.next();
			for (i = 0; i < list.size(); i++) {
				if (name.equals(list.get(i).getName())) {
					list.remove(i);
					
				}
			}
		case 3:
			System.out.println("�̸��� �Է��ϼ���");
			name = sc.next();
			
			for(i=0;i<list.size();i++) {
			if(name.equals(list.get(i).getName())) {
				System.out.println();
				System.out.println("�����Ͻ� ��ȭ��ȣ��?");
				tel = sc.next();
//				list.set(i,);
			}
			}
		case 4:
		case 5:
		}
		}
	}
}

//1.�����߰� 2.���Ի��� 3.���Լ��� 4.���Ժ��� 5.����:1
//�̸��� �Է��ϼ��� : kim
//��ȭ��ȣ�� �Է��ϼ��� : 1234
//
//1.�����߰� 2.���Ի��� 3.���Լ��� 4.���Ժ��� 5.����:1
//�̸��� �Է��ϼ��� : park
//��ȭ��ȣ�� �Է��ϼ��� : 3333
//
//1.�����߰� 2.���Ի��� 3.���Լ��� 4.���Ժ��� 5.����:4
//�̸�		��ȭ��ȣ
//kim		1234
//park		3333
//
//1.�����߰� 2.���Ի��� 3.���Լ��� 4.���Ժ��� 5.����:3
//�̸��� �Է��ϼ��� : park
//�����Ͻ� ��ȭ��ȣ�� : 7777
//�����Ǿ����ϴ�.
//
//1.�����߰� 2.���Ի��� 3.���Լ��� 4.���Ժ��� 5.����:4
//�̸�		��ȭ��ȣ
//kim		1234
//park		7777
//
//1.�����߰� 2.���Ի��� 3.���Լ��� 4.���Ժ��� 5.����:3
//�̸��� �Է��ϼ��� : choi
//�̸��� �߸��Է��ϼ̽��ϴ�.
//
//1.�����߰� 2.���Ի��� 3.���Լ��� 4.���Ժ��� 5.����:2
//�̸��� �Է��ϼ��� : park
//�����Ǿ����ϴ�.
//
//1.�����߰� 2.���Ի��� 3.���Լ��� 4.���Ժ��� 5.����:4
//�̸�		��ȭ��ȣ
//kim		1234
//
//1.�����߰� 2.���Ի��� 3.���Լ��� 4.���Ժ��� 5.����:2
//�̸��� �Է��ϼ��� : hong
//�̸��� �߸��Է��ϼ̽��ϴ�.
//
//1.�����߰� 2.���Ի��� 3.���Լ��� 4.���Ժ��� 5.����:4
//�̸�		��ȭ��ȣ
//kim		1234
//
//1.�����߰� 2.���Ի��� 3.���Լ��� 4.���Ժ��� 5.����:5
//���α׷��� �����մϴ�.
