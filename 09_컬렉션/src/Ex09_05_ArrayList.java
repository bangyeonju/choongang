import java.util.ArrayList;
import java.util.Scanner;

class Music {
	private String title;
	private String singer;
	private int price;

	Music(String title, String singer, int price) {
		super();
		this.title = title;
		this.singer = singer;
		this.price = price;

	}

	String getTitle() {
		return title;
	}

	String getSinger() {
		return singer;
	}

	int getInt() {
		return price;
	}

	public String toString() {
		return title + "/" + singer + "/" + price;
	}
}

public class Ex09_05_ArrayList {

	public static void main(String[] args) {
		ArrayList<Music> list = new ArrayList<Music>();
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("����");
			String title = sc.next();
			System.out.println("����");
			String singer = sc.next();
			System.out.println("����");
			int price = sc.nextInt();
			System.out.println("���?");
			String retry = sc.next();
//			m.add(new Music(title, singer, price));
			Music m = new Music(title, singer, price);
			list.add(m);
			if (retry.equals("n")) {
				System.out.println(list.toString());
				break;
			}
		}
		int i;
		boolean flag = true;
		while (true) {
			flag = true; // flag�� �ٽ� �ʱ�ȭ���ִ� �۾� ���� �ѹ� ������ ã������ flag=false���� ������ �ִ�.
			System.out.println("ã�� ���� �Է� :");
			String searchId = sc.next();
			for (i = 0; i < list.size(); i++) {
				if (searchId.equals(list.get(i).getTitle())) {
					System.out.println(list.get(i).getTitle() + "�� ��������" + list.get(i).getSinger() + "�Դϴ�.");
					flag = false;
					break;
				}
			}
			if (flag == true) {
				System.out.println("ã�� ������ �����ϴ�.");

			}
			System.out.println("���?");
			String retry = sc.next();
			if (retry.equals("n")) {

				System.out.println("���α׷��� �����մϴ�.");

				break;// while�� ����
			}
		}

	}

}
