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
			System.out.println("=====메뉴 선택하기======");
			System.out.println("1.모든 정보 조회");
			System.out.println("2.조건 검색");
			System.out.println("3.정보 수정");
			System.out.println("4.정보 삭제");
			System.out.println("5.정보 추가");
			System.out.println("6.산 전화번호");
			System.out.println("7.종료");
			int menu = sc.nextInt();
			switch (menu) {
			case 1: // 모든 상품 조회
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
				System.out.println("프로그램 종료");
				System.exit(0);
				break;
			default:
				System.out.println("1~6까지 숫자를 입력하셔용 ");

			}
		}

	}



	private void showDataAll(ArrayList<MountainBean> lists2) {
		String title = "이름\t위치\t정상\t전화번호";
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
		System.out.println("수정할 번호를 입력하세요");
		no = sc.nextInt();
		System.out.println("산이름");
		name = sc.next();
		System.out.println("위치");
		place = sc.next();
		System.out.println("정상");
		top = sc.next();
		System.out.println("동행");
		who = sc.next();
		MountainBean bean = new MountainBean(no, name, place, top, who);
		int cnt = dao.updateData(bean);
		if (cnt < 0) {
			System.out.println("수정실패");
		} else {
			System.out.println("수정성공");
		}
	}

	public void deleteMountain() {
		System.out.println("1.번호  2.이름 3.위치 4.정상");
		int dno = sc.nextInt();
		String col = null;
		if (dno == 1) {
			System.out.print("삭제할 번호");
			int inputNum = sc.nextInt();
			int cnt = dao.deleteOne(dno);
			if (cnt < 0) {
				System.out.println("삭제 실패");

			} else {
				System.out.println("삭제 성공");
			}
			dao.deleteOne(inputNum);
		} else {
			switch (dno) {
			case 2:
				System.out.print("삭제할 산이름");
				col = "name";
				break;
			case 3:
				System.out.print("삭제할 위치?");
				col = "place";
				break;
			case 4:
				System.out.print("삭제할 정상이름");
				col = "top";
				break;
			default:
				System.out.println("1~4까지 숫자를 입력하세요");
				break;
			}
			
			String inputText = sc.next();

			int cnt = dao.deleteAll(col, inputText);
			if (cnt < 0) {
				System.out.println("삭제 실패");
			} else {
				System.out.println("삭제 성공");
			}
		}

	}

	public void insertData() {
		String name, place, top, who;
		System.out.print("산이름");
		name = sc.next();
		System.out.print("위치");
		place = sc.next();
		System.out.print("정상");
		top = sc.next();
		System.out.print("동행");
		who = sc.next();
		MountainBean bean = new MountainBean(0, name, place, top, who);
		int cnt = dao.insertMountain(bean);
		if (cnt < 0) {
			System.out.println("추가실패");
		} else {
			System.out.println("추가 성공");
		}
	}

	public void searchMountain() {
		System.out.print("1.산이름 2:위치 3.정상");
		int inputNo = sc.nextInt();
		String col = null;
		switch (inputNo) {
		case 1:
			System.out.print("찾으실 산을 입력하세요");
			col = "name";
			break;
		case 2:
			System.out.print("찾으실 위치를입력하세요");
			col = "place";
			break;
		case 3:
			System.out.print("찾으실 정상을 입력하세요");
			col = "top";
			break;

		}
		String searchWord = sc.next();
		ArrayList<MountainBean> lists = dao.searchMountain(col, searchWord);
		System.out.println("검색된 결과는 " + lists.size() + "개 입니다.");
		showData(lists);

	}

	public void showData(ArrayList<MountainBean> lists) {
		String title = "번호\t이름\t위치\t정상\t동행";
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
