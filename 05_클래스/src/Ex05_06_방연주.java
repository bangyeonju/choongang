class Pay {
	String name;
	int bonbong;
	int tex; // 1����
	int silsu;

	// setTex(�����ޱ�)
	/*
	 * ������ 300���� �̻��̸� ������ 3% 300�����̸� 90000�� ������ 200���� �̻��̸� ������ 2% ������ 100���� �����̸� ������
	 * 1% 100���� ���� ����
	 */
	int setTex(int bonbong) {
		if (bonbong >= 3000000) {
			tex = (int) (bonbong * 0.03);

		} else if (bonbong >= 2000000) {
			tex = (int) (bonbong * 0.02);
		} else {
			tex = (int) (bonbong * 0.01);
		}
		return tex;

	}

	// �Ǽ��ɾ� ���(����, ����) {
//	silsu = ���� -����
	int silsuSet(int bonbong, int tex) {
		silsu = bonbong - tex;
		return silsu;
	}

	// ������� 4�� ����ϴ� �޼���() {
	String infor(String name){
		name = name;
		bonbong=bonbong;
		setTex(bonbong);
		silsuSet(bonbong, tex);
		return name;
		
		
	}
	
	
}

public class Ex05_06_�濬�� {
	public static void main(String[] args) {
		Pay p1 = new Pay();
		Pay p2 = new Pay();
		Pay p3 = new Pay();

		p1.name = "����";
		p1.bonbong = 4000000;
		
//		p2.name = "�ξ�";
//		p2.bonbong = 2000000;
//		
//		p3.name = "����";
//		p3.bonbong = 1000000;
		int money = p1.setTex(p1.bonbong);
		int silmoney = p1.silsuSet(p1.bonbong, p1.tex);
		System.out.println(money);
		System.out.println(silmoney);
		
//		int money2 = p2.setTex(p2.bonbong);
//		int silmoney2 = p2.silsuSet(p2.bonbong, p2.tex);
//		System.out.println(money2);
//		System.out.println(silmoney2);
//		
//		int money3 = p3.setTex(p1.bonbong);s
//		int silmoney3 = p3.silsuSet(p3.bonbong, p3.tex);
//		System.out.println(money3);
//		System.out.println(silmoney3);
		String nameInfor = p1.infor("����");
		System.out.println(nameInfor);

	}
}
