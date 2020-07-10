import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class AlbumsMain {
	AlbumsDao dao = new AlbumsDao();
	Scanner sc = new Scanner(System.in);
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));// 공백 포함한 글자 입력받을때 쓴디ㅏ.

	public static void main(String[] args) throws IOException {
		new AlbumsMain();
	}

	AlbumsMain() throws IOException {
		init();
	}

	public void init() throws IOException {

		while (true) {
			System.out.println("======메뉴 선택하기======");
			System.out.println("1.모든 정보 조회");
			System.out.println("2.조건 검색");
			System.out.println("3.가격 범위조건 검색(가격:내림차순, 가수:오름차순)");
			System.out.println("4.앨범 수정");
			System.out.println("5.앨범 삭제");
			System.out.println("6.앨범 추가");
			System.out.println("7.정렬");
			System.out.println("8.프로그램종료");
			int menu = sc.nextInt();
			switch (menu) {
			case 1: // 모든 상품 조회
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
				System.out.println("프로그램 종료");
				System.exit(0);
				break;
			default:

				System.out.println("1~8까지 숫자를 입력하셔용 ");

			}
		}

	}

	public void selectClean() {
		System.out.println("정렬할 항목을 선택하시오");
		System.out.print("번호 :1 노래제목:2 가수명 :3  번호입력>>");
		int inputColumn = sc.nextInt();
		System.out.print("정렬방법을 선택하시오");
		
		String column = null,way=null;
	
		switch (inputColumn) {
		case 1:
			System.out.println("정렬할 노래");
			column = "num";
			break;
		case 2:
			column = "song";
			break;
		case 3:
			column = "singer";
			break;
		default:
			System.out.println("잘못입력함");
			return;
		}
		System.out.print("오름차순 : 1  내림차순 :2 번호입력>>");
		int align_way =sc.nextInt();
		switch (align_way) {
		case 1 :
			way ="asc";
			break;
		case 2:
			way = "desc";
			break;
		default : System.out.println("잘못 입력하셨음");
		return;		
		}
		ArrayList<AlbumsBean> lists = dao.selectAlign(column,way);
		showAlbums(lists);

	}

	public void selectRank() {
		System.out.print("시장등수 입력 >>");
		int sn = sc.nextInt();
		System.out.print("끝등수 입력 >>");
		int ln = sc.nextInt();
		ArrayList<AlbumsBean> lists = dao.selectRank(sn, ln);
		showAlbums(lists);
	}

	public void searchAlbums() {
		String column = null;
		System.out.println("제목검색:1 가수검색:2 회사검색:3");
		int searchNum = sc.nextInt();

		switch (searchNum) {
		case 1:
			System.out.print("조회할 노래 : ");
			column = "song";
			break;
		case 2:
			System.out.print("조회할 가수: ");
			column = "singer";
			break;
		case 3:
			System.out.print("조회할 회사 : ");
			column = "company";
			break;
		default:
			System.out.println("잘못입력하셨음");
			return;
		}
		String inputWord = sc.next();
		ArrayList<AlbumsBean> lists = dao.searchAlbums(column, inputWord);
		System.out.println(lists.size() + "개");
		showAlbums(lists);

	}

	public void deleteAlbums() {
		System.out.println("삭제할 번호를 입력하세요");
		int num = sc.nextInt();
		int cnt = dao.deleteAlbums(num);
		if (cnt < 0) {
			System.out.println("삭제 실패");
		} else {
			System.out.println("삭제 성공");
		}

	}

	public void updateAlbums() {
		int price = 0, num;
		System.out.print("수정할 번호를 입력하세요:");
		num = sc.nextInt();
		System.out.print("노래제목 입력");
		String song = sc.next();
		System.out.print("가수 입력");
		String singer = sc.next();
		System.out.print("회사 입력");
		String company = sc.next();
		System.out.print("가격 입력");
		price = sc.nextInt();
		System.out.print("발매일 입력");
		String pub_day = sc.next();
		AlbumsBean bean = new AlbumsBean(num, song, singer, company, price, pub_day);
		System.out.println(bean.getNum());
		int cnt = dao.updateAlbums(bean);

		if (cnt < 0) {
			System.out.println("수정 실패");
		} else {
			System.out.println("수정 성공");
		}
	}

	public void insertAlbums() throws IOException {
		int price = 0;
		System.out.println("num는 시퀀스로 자동 입력됩니다.(생략)");
		System.out.print("노래제목 입력");
		String song = br.readLine();
		System.out.print("가수 입력");
		String singer = br.readLine();
		System.out.print("회사 입력");
		String company = br.readLine();
		do {
			try {
				System.out.print("가격 입력");
				price = Integer.parseInt(br.readLine());// 문자열을 정수형으로 바꿔준다
				break;
			} catch (NumberFormatException e) {
				System.out.println("숫자로 입력하세용");
			}
		} while (true);

		System.out.print("발매일 입력");
		String pub_day = br.readLine();

		AlbumsBean bean = new AlbumsBean(0, song, singer, company, price, pub_day);
		int cnt = dao.insertAlbums(bean);

		if (cnt < 0) {
			System.out.println("insert 실패");
		} else {
			System.out.println("insert 성공");
		}

	}

	public void showAlbums(ArrayList<AlbumsBean> lists) {
		String title = "번호\t노래제목\t가수\t회사\t가격\t발매일";
		System.out.println(title);
		for (int i = 0; i < lists.size(); i++) {
			String result = lists.get(i).getNum() + "\t" + lists.get(i).getSong() + "\t" + lists.get(i).getSinger()
					+ "\t" + lists.get(i).getCompany() + "\t" + lists.get(i).getPrice() + "\t"
					+ lists.get(i).getPub_day();
			System.out.println(result);
		}
	}
}