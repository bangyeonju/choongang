import java.util.ArrayList;
import java.util.Scanner;

public class MountainMain {
	MountainDao dao = new MountainDao();
	Scanner sc = new Scanner(System.in);

	MountainMain() {
		init();
	}

	public void init() {

		while (true) {
			System.out.println("=====�޴� �����ϱ�======");
			System.out.println("1.��� ���� ��ȸ");
			System.out.println("2.���� �˻�");
			System.out.println("3.���� ����");
			System.out.println("4.���� ����");
			System.out.println("5.���� �߰�");
			System.out.println("6.�� ��ȭ��ȣ");
			System.out.println("7.����");
			int menu = sc.nextInt();
			switch (menu) {
			case 1: // ��� ��ǰ ��ȸ
				ArrayList<MountainBean> lists = dao.allMountainInfo();
				showData(lists);
				break;
			case 2:
				searchMountain();
				break;
			case 3:
				updateMountain();
				break;
			case 4:
				deleteMountain();
				break;
			case 5:
				insertData();
				break;
			case 6:
				ArrayList<MountainBean> lists2 = dao.allMountainPhone();
				showDataAll(lists2);
				break;
			case 7:
				System.out.println("���α׷� ����");
				System.exit(0);
				break;
			default:
				System.out.println("1~6���� ���ڸ� �Է��ϼſ� ");

			}
		}

	}



	private void showDataAll(ArrayList<MountainBean> lists2) {
		String title = "�̸�\t��ġ\t����\t��ȭ��ȣ";
		System.out.println(title);
		for (int i = 0; i < lists2.size(); i++) {
			String result =  lists2.get(i).getName() + "\t" + lists2.get(i).getPlace() + "\t"
					+ lists2.get(i).getTop() + "\t" + lists2.get(i).getPhone();
			System.out.println(result);
		}
		
	}

	public void updateMountain() {
		int no;
		String name, place, top, who;
		System.out.println("������ ��ȣ�� �Է��ϼ���");
		no = sc.nextInt();
		System.out.println("���̸�");
		name = sc.next();
		System.out.println("��ġ");
		place = sc.next();
		System.out.println("����");
		top = sc.next();
		System.out.println("����");
		who = sc.next();
		MountainBean bean = new MountainBean(no, name, place, top, who);
		int cnt = dao.updateData(bean);
		if (cnt < 0) {
			System.out.println("��������");
		} else {
			System.out.println("��������");
		}
	}

	public void deleteMountain() {
		System.out.println("1.��ȣ  2.�̸� 3.��ġ 4.����");
		int dno = sc.nextInt();
		String col = null;
		if (dno == 1) {
			System.out.print("������ ��ȣ");
			int inputNum = sc.nextInt();
			int cnt = dao.deleteOne(dno);
			if (cnt < 0) {
				System.out.println("���� ����");

			} else {
				System.out.println("���� ����");
			}
			dao.deleteOne(inputNum);
		} else {
			switch (dno) {
			case 2:
				System.out.print("������ ���̸�");
				col = "name";
				break;
			case 3:
				System.out.print("������ ��ġ?");
				col = "place";
				break;
			case 4:
				System.out.print("������ �����̸�");
				col = "top";
				break;
			default:
				System.out.println("1~4���� ���ڸ� �Է��ϼ���");
				break;
			}
			
			String inputText = sc.next();

			int cnt = dao.deleteAll(col, inputText);
			if (cnt < 0) {
				System.out.println("���� ����");
			} else {
				System.out.println("���� ����");
			}
		}

	}

	public void insertData() {
		String name, place, top, who;
		System.out.print("���̸�");
		name = sc.next();
		System.out.print("��ġ");
		place = sc.next();
		System.out.print("����");
		top = sc.next();
		System.out.print("����");
		who = sc.next();
		MountainBean bean = new MountainBean(0, name, place, top, who);
		int cnt = dao.insertMountain(bean);
		if (cnt < 0) {
			System.out.println("�߰�����");
		} else {
			System.out.println("�߰� ����");
		}
	}

	public void searchMountain() {
		System.out.print("1.���̸� 2:��ġ 3.����");
		int inputNo = sc.nextInt();
		String col = null;
		switch (inputNo) {
		case 1:
			System.out.print("ã���� ���� �Է��ϼ���");
			col = "name";
			break;
		case 2:
			System.out.print("ã���� ��ġ���Է��ϼ���");
			col = "place";
			break;
		case 3:
			System.out.print("ã���� ������ �Է��ϼ���");
			col = "top";
			break;

		}
		String searchWord = sc.next();
		ArrayList<MountainBean> lists = dao.searchMountain(col, searchWord);
		System.out.println("�˻��� ����� " + lists.size() + "�� �Դϴ�.");
		showData(lists);

	}

	public void showData(ArrayList<MountainBean> lists) {
		String title = "��ȣ\t�̸�\t��ġ\t����\t����";
		System.out.println(title);
		for (int i = 0; i < lists.size(); i++) {
			String result = lists.get(i).getNo() + "\t" + lists.get(i).getName() + "\t" + lists.get(i).getPlace() + "\t"
					+ lists.get(i).getTop() + "\t" + lists.get(i).getWho();
			System.out.println(result);
		}

	}
	

	public static void main(String[] args) {
		new MountainMain();
	}

}
