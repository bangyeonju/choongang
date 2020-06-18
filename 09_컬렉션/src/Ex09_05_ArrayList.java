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
			System.out.println("제목");
			String title = sc.next();
			System.out.println("가수");
			String singer = sc.next();
			System.out.println("가격");
			int price = sc.nextInt();
			System.out.println("계속?");
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
			flag = true; // flag를 다시 초기화해주는 작업 만약 한번 제목을 찾았을때 flag=false값을 가지고 있다.
			System.out.println("찾는 제목 입력 :");
			String searchId = sc.next();
			for (i = 0; i < list.size(); i++) {
				if (searchId.equals(list.get(i).getTitle())) {
					System.out.println(list.get(i).getTitle() + "의 가수명은" + list.get(i).getSinger() + "입니다.");
					flag = false;
					break;
				}
			}
			if (flag == true) {
				System.out.println("찾는 제목이 없습니다.");

			}
			System.out.println("계속?");
			String retry = sc.next();
			if (retry.equals("n")) {

				System.out.println("프로그램을 종료합니다.");

				break;// while문 나감
			}
		}

	}

}
