import java.util.ArrayList;
import java.util.Scanner;



public class AlbumsMain {
	AlbumsDao dao = new AlbumsDao();
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		new AlbumsMain();
	}

	AlbumsMain() {
		init();
	}

	public void init() {

		while (true) {
			System.out.println("======�޴� �����ϱ�======");
			System.out.println("1.��� ���� ��ȸ");
			System.out.println("2.���� �˻�");
			System.out.println("3.���� �������� �˻�(����:��������, ����:��������)");
			System.out.println("4.�ٹ� ����");
			System.out.println("5.�ٹ� ����");
			System.out.println("6.�ٹ� �߰�");
			System.out.println("7.����");
			System.out.println("8.���α׷�����");
			int menu = sc.nextInt();
			switch (menu) {
			case 1:
				ArrayList<AlbumsBean> lists = dao.selectAllAlbums();
				showAlbums(lists);
				break;
			case 2:
				searchAlbums();
				break;
			case 3:
				selectRank();

				break;
			case 4:
				updateAlbums();
				break;
			case 5:
				deleteAlbums();
				break;
			case 6:
				insertAlbums();
				break;
			case 7:
				selectClean();
				break;
			case 8:
				System.out.println("���α׷� ����");
				System.exit(0);
				break;
			}
		}
	}

	public void selectClean() {
		System.out.print("������ �׸��� �����Ͻÿ�");
		System.out.print("��ȣ :1 �뷡����:2 ������ :3  ��ȣ�Է�>>");
		int inputColumn = sc.nextInt();
		System.out.print("���Ĺ���� �����Ͻÿ�");
		System.out.print("�������� : 1  �������� :2 ��ȣ�Է�>>");
		int inputNum = sc.nextInt();
		switch (inputNum) {
		case 1 :
			ArrayList<AlbumsBean> lists = dao.selectUp();
			showAlbums(lists);
		break;
		case 2 :
			ArrayList<AlbumsBean> lists2 = dao.selectDown();
			showAlbums(lists2);
		break;
		}
	}

	public void selectRank() {
		System.out.print("������ �Է� >>");
		int sn = sc.nextInt();
		System.out.print("����� �Է� >>");
		int ln = sc.nextInt();
		ArrayList<AlbumsBean> lists=dao.selectRank(sn,ln);
		showAlbums(lists);
	}

	public void searchAlbums() {
		String column = null;
		System.out.println("����˻�:1 �����˻�:2 ȸ��˻�:3");
		int searchNum = sc.nextInt();

		switch (searchNum) {
		case 1:
			System.out.print("��ȸ�� �뷡 : ");
			column = "song";
			break;
		case 2:
			System.out.print("��ȸ�� ����: ");
			column = "singer";
			break;
		case 3:
			System.out.print("��ȸ�� ȸ�� : ");
			column = "company";
			break;
		}
		String inputWord = sc.next();
		ArrayList<AlbumsBean> lists = dao.searchAlbums(column, inputWord);
		showAlbums(lists);

	}

	public void deleteAlbums() {
		System.out.println("������ ��ȣ�� �Է��ϼ���");
		int num = sc.nextInt();
		int cnt = dao.deleteAlbums(num);
		if (cnt < 0) {
			System.out.println("���� ����");
		} else {
			System.out.println("���� ����");
		}

	}

	public void updateAlbums() {
		System.out.print("������ ��ȣ�� �Է��ϼ���:");
		int num = sc.nextInt();
		System.out.print("�뷡���� �Է�");
		String song = sc.next();
		System.out.print("���� �Է�");
		String singer = sc.next();
		System.out.print("ȸ�� �Է�");
		String company = sc.next();
		System.out.print("���� �Է�");
		int price = sc.nextInt();
		System.out.print("�߸��� �Է�");
		String pub_day = sc.next();
		AlbumsBean bean = new AlbumsBean(num, song, singer, company, price, pub_day);
		int cnt = dao.updateAlbums(bean);

		if (cnt < 0) {
			System.out.println("���� ����");
		} else {
			System.out.println("���� ����");
		}
	}

	public void insertAlbums() {
		System.out.println("num�� �������� �ڵ� �Էµ˴ϴ�.(����)");
		System.out.print("�뷡���� �Է�");
		String song = sc.next();
		System.out.print("���� �Է�");
		String singer = sc.next();
		System.out.print("ȸ�� �Է�");
		String company = sc.next();
		System.out.print("���� �Է�");
		int price = sc.nextInt();
		System.out.print("�߸��� �Է�");
		String pub_day = sc.next();
		AlbumsBean bean = new AlbumsBean(0, song, singer, company, price, pub_day);
		int cnt = dao.insertAlbums(bean);

		if (cnt < 0) {
			System.out.println("insert ����");
		} else {
			System.out.println("insert ����");
		}

	}

	public void showAlbums(ArrayList<AlbumsBean> lists) {
		String title = "��ȣ\t�뷡����\t����\tȸ��\t����\t�߸���";
		System.out.println(title);
		for (int i = 0; i < lists.size(); i++) {
			String result = lists.get(i).getNum() + "\t" + lists.get(i).getSong() + "\t" + lists.get(i).getSinger()
					+ "\t" + lists.get(i).getCompany() + "\t" + lists.get(i).getPrice() + "\t"
					+ lists.get(i).getPub_day();
			System.out.println(result);
		}
	}
}
