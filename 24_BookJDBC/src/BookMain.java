import java.util.ArrayList;
import java.util.Scanner;


public class BookMain {
	BookDao dao = new BookDao();
	Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {

		new BookMain();
	}

	BookMain() {
		init();
	}

	public void init() {
		while (true) {
			System.out.println("\n====메뉴 선택하기======");
			System.out.println("1.전체 정보 조회");
			System.out.println("2.조건 조회"); //
			System.out.println("3.정보 수정");
			System.out.println("4.정보 삭제");
			System.out.println("5.정보 추가");
			System.out.println("6.프로그램 종료");
			System.out.print("메뉴번호입력:");
			int menu=sc.nextInt();
			switch (menu) {
			
			case 1:
				ArrayList<BookBean> lists = dao.getAllBook();
				showBook(lists);
				break;
			case 2: 
				getBookBySearch();
				
				break;
			case 3:
				updateBook();
				break;
			case 4:
				deleteBook();
				break;
			case 5:
				InsertBook();
				break;
			case 6: 
				System.out.println("프로그램 종료");
				System.exit(0);
				break;
					
			
			}
			
		}//while
	}//init
	
	public void getBookBySearch() {
		System.out.print("제목:1 저자:2 출판사:3 번호입력>>");
		int search_num=sc.nextInt();
		String column = null;
		switch (search_num) {
		
		case 1:
			System.out.print("조회할 제목 : "); //%리%
			//어느칼럼에서 조회하겠냥
			column = "title"; //title에서 조회하겠따
			break;
		case 2:
			System.out.print("조회할 저자 : ");
			column = "author";
			break;
		case 3:
			System.out.print("조회할 출판사 : ");
			column = "publisher";
			break;
		default : System.out.println("1~3사이의 번호만 입력가능");
			return;
		}
		String search_word=sc.next();
		ArrayList<BookBean> lists =dao.getBookBySearch(column,search_word);
		showBook(lists);
		
	}

	public void deleteBook() {
		System.out.print("삭제할 번호를 입력하세요");
		int no = sc.nextInt();
		int cnt = dao.deleteBook(no);
		if(cnt<0) {
			System.out.println("삭제 실패");
		}else {
			System.out.println("삭제 성공");
		}
	}

	public void updateBook() {
		System.out.print("수정 할 번호를 입력하세요");
		int no = sc.nextInt();
		System.out.print("제목 입력");
		String title = sc.next();
		System.out.print("작가 입력");
		String author = sc.next();
		System.out.print("출판사 입력");
		String publisher = sc.next();
		System.out.print("가격 입력");
		int price = sc.nextInt();
		System.out.print("발행일 입력");
		String pub_day = sc.next();
		BookBean book = new BookBean(no,title,author,publisher,price,pub_day);
		int cnt = dao.updateBook(book);
		if(cnt<0) {
			System.out.println("수정실패");
		}else {
			System.out.println("수정 성공");
		}
	}

	public void InsertBook() {
		System.out.println("no는 시퀀스로 자동 입력됩니다.(생략)");
		
		System.out.print("제목 입력");
		String title = sc.next();
		System.out.print("작가 입력");
		String author = sc.next();
		System.out.print("출판사 입력");
		String publisher = sc.next();
		System.out.print("가격 입력");
		int price = sc.nextInt();
		System.out.print("발행일 입력");
		String pub_day = sc.next();
		
		BookBean bean = new BookBean (0,title,author,publisher, price,pub_day); //bookBean에 파라미터 있는 생성자 만들어야함
		int cnt = dao.insertBook(bean);
		if(cnt<0) {
			System.out.println("insert 실패");
		}else {
			System.out.println("insert 성공");
		}
	}

	public void showBook(ArrayList<BookBean> lists) {
		System.out.println("총 " + lists.size()+"권입니다.");
		String title = "번호\t제목\t작가\t출판사\t가격\t발행일";
		System.out.println(title);
		for(int i=0;i<lists.size();i++) {
			String result = lists.get(i).getNo() + "\t" +lists.get(i).getTitle()+ "\t" +lists.get(i).getAuthor()+ "\t" + lists.get(i).getPublisher() + "\t" +lists.get(i).getPrice() + "\t" + lists.get(i).getPub_day();
		
			System.out.println(result);
		}
//				for (BookBean bean : lists) {
//					String result = bean.getNo() + "\t" +bean.getTitle()+ "\t" +bean.getAuthor()+ "\t" + bean.getPublisher() + "\t" + bean.getPrice() + "\t" + bean.getPub_day();
//				
//					System.out.println(result);
//				}
		
	}

}
