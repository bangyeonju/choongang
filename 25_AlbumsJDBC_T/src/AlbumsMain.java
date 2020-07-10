import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class AlbumsMain {
	AlbumsDao dao = new AlbumsDao();
	Scanner sc = new Scanner(System.in);
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));// ���� ������ ���� �Է¹����� ����.

	public static void main(String[] args) throws IOException {
		new AlbumsMain();
	}

	AlbumsMain() throws IOException {
		init();
	}

	public void init() throws IOException {

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
			case 1: // ��� ��ǰ ��ȸ
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
			default:

				System.out.println("1~8���� ���ڸ� �Է��ϼſ� ");

			}
		}

	}

	public void selectClean() {
		System.out.println("������ �׸��� �����Ͻÿ�");
		System.out.print("��ȣ :1 �뷡����:2 ������ :3  ��ȣ�Է�>>");
		int inputColumn = sc.nextInt();
		System.out.print("���Ĺ���� �����Ͻÿ�");
		
		String column = null,way=null;
	
		switch (inputColumn) {
		case 1:
			System.out.println("������ �뷡");
			column = "num";
			break;
		case 2:
			column = "song";
			break;
		case 3:
			column = "singer";
			break;
		default:
			System.out.println("�߸��Է���");
			return;
		}
		System.out.print("�������� : 1  �������� :2 ��ȣ�Է�>>");
		int align_way =sc.nextInt();
		switch (align_way) {
		case 1 :
			way ="asc";
			break;
		case 2:
			way = "desc";
			break;
		default : System.out.println("�߸� �Է��ϼ���");
		return;		
		}
		ArrayList<AlbumsBean> lists = dao.selectAlign(column,way);
		showAlbums(lists);

	}

	public void selectRank() {
		System.out.print("������ �Է� >>");
		int sn = sc.nextInt();
		System.out.print("����� �Է� >>");
		int ln = sc.nextInt();
		ArrayList<AlbumsBean> lists = dao.selectRank(sn, ln);
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
		default:
			System.out.println("�߸��Է��ϼ���");
			return;
		}
		String inputWord = sc.next();
		ArrayList<AlbumsBean> lists = dao.searchAlbums(column, inputWord);
		System.out.println(lists.size() + "��");
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
		int price = 0, num;
		System.out.print("������ ��ȣ�� �Է��ϼ���:");
		num = sc.nextInt();
		System.out.print("�뷡���� �Է�");
		String song = sc.next();
		System.out.print("���� �Է�");
		String singer = sc.next();
		System.out.print("ȸ�� �Է�");
		String company = sc.next();
		System.out.print("���� �Է�");
		price = sc.nextInt();
		System.out.print("�߸��� �Է�");
		String pub_day = sc.next();
		AlbumsBean bean = new AlbumsBean(num, song, singer, company, price, pub_day);
		System.out.println(bean.getNum());
		int cnt = dao.updateAlbums(bean);

		if (cnt < 0) {
			System.out.println("���� ����");
		} else {
			System.out.println("���� ����");
		}
	}

	public void insertAlbums() throws IOException {
		int price = 0;
		System.out.println("num�� �������� �ڵ� �Էµ˴ϴ�.(����)");
		System.out.print("�뷡���� �Է�");
		String song = br.readLine();
		System.out.print("���� �Է�");
		String singer = br.readLine();
		System.out.print("ȸ�� �Է�");
		String company = br.readLine();
		do {
			try {
				System.out.print("���� �Է�");
				price = Integer.parseInt(br.readLine());// ���ڿ��� ���������� �ٲ��ش�
				break;
			} catch (NumberFormatException e) {
				System.out.println("���ڷ� �Է��ϼ���");
			}
		} while (true);

		System.out.print("�߸��� �Է�");
		String pub_day = br.readLine();

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