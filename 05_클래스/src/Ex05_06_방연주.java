class Pay {
	String name;
	int bonbong;
	int tax; // 1����
	int silsu;

	// setTex(�����ޱ�)
	/*
	 * ������ 300���� �̻��̸� ������ 3% 300�����̸� 90000�� ������ 200���� �̻��̸� ������ 2% ������ 100���� �����̸� ������
	 * 1% 100���� ���� ����
	 */
	/*
	 * int setTax(int i) { //�޼ҵ� ���� �Ķ���Ͱ� = �Ű����� if (i >= 3000000) { tax = (int) (i
	 * * 0.03); // * (int)90000.0 ==> 90000
	 * 
	 * } else if (i >= 2000000) { tax = (int) (i * 0.02); } else { tax = (int) (i *
	 * 0.01); } return; }
	 */
	void setTax() {
		if (bonbong >= 3000000) {
			tax = (int) (bonbong * 0.03); // (int)90000.0 ==> 90000

		} else if (bonbong >= 2000000) {
			tax = (int) (bonbong * 0.02);
		} else {
			tax = (int) (bonbong * 0.01);
		}
		
	}

	// �Ǽ��ɾ� ���(����, ����) { // silsu = ���� -����
	void setSilsu() {
		silsu = bonbong - tax;

	}

	// ������� 4�� ����ϴ� �޼���() {
	void display() {
		System.out.printf("�̸�=%s\n", name);
		System.out.printf("����=%d\n", bonbong);
		System.out.printf("����=%d\n", tax);
		System.out.printf("�Ǽ���=%d\n", silsu);
		System.out.println();

	}
}

public class Ex05_06_�濬�� {
	public static void main(String[] args) {
		Pay p1 = new Pay(); // ��ü����
		Pay p2 = new Pay();
		Pay p3 = new Pay();

		p1.name = "����";
		p1.bonbong = 1000000;

		p2.name = "�¿�";
		p2.bonbong = 2000000;

		p3.name = "����";
		p3.bonbong = 5000000;

		p1.setTax(); // 2. �Ķ���Ͱ��� �ʿ����...?
		p2.setTax();
		p3.setTax();
		p1.setSilsu();
		p2.setSilsu();
		p3.setSilsu();
		p1.display();
		p2.display();
		p3.display();
		
		
		// p1.setTax(p1.bonbong); //�޼ҵ� ȣ�� --> 1. ������ �̹� ���� �־��� ������
		// p1.silsuSet(p1.bonbong, p1.tax);
		//
	
	}
}