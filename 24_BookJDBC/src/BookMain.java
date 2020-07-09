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
			System.out.println("\n====�޴� �����ϱ�======");
			System.out.println("1.��ü ���� ��ȸ");
			System.out.println("2.���� ��ȸ"); //
			System.out.println("3.���� ����");
			System.out.println("4.���� ����");
			System.out.println("5.���� �߰�");
			System.out.println("6.���α׷� ����");
			System.out.print("�޴���ȣ�Է�:");
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
				System.out.println("���α׷� ����");
				System.exit(0);
				break;
					
			
			}
			
		}//while
	}//init
	
	public void getBookBySearch() {
		System.out.print("����:1 ����:2 ���ǻ�:3 ��ȣ�Է�>>");
		int search_num=sc.nextInt();
		String column = null;
		switch (search_num) {
		
		case 1:
			System.out.print("��ȸ�� ���� : "); //%��%
			//���Į������ ��ȸ�ϰڳ�
			column = "title"; //title���� ��ȸ�ϰڵ�
			break;
		case 2:
			System.out.print("��ȸ�� ���� : ");
			column = "author";
			break;
		case 3:
			System.out.print("��ȸ�� ���ǻ� : ");
			column = "publisher";
			break;
		default : System.out.println("1~3������ ��ȣ�� �Է°���");
			return;
		}
		String search_word=sc.next();
		ArrayList<BookBean> lists =dao.getBookBySearch(column,search_word);
		showBook(lists);
		
	}

	public void deleteBook() {
		System.out.print("������ ��ȣ�� �Է��ϼ���");
		int no = sc.nextInt();
		int cnt = dao.deleteBook(no);
		if(cnt<0) {
			System.out.println("���� ����");
		}else {
			System.out.println("���� ����");
		}
	}

	public void updateBook() {
		System.out.print("���� �� ��ȣ�� �Է��ϼ���");
		int no = sc.nextInt();
		System.out.print("���� �Է�");
		String title = sc.next();
		System.out.print("�۰� �Է�");
		String author = sc.next();
		System.out.print("���ǻ� �Է�");
		String publisher = sc.next();
		System.out.print("���� �Է�");
		int price = sc.nextInt();
		System.out.print("������ �Է�");
		String pub_day = sc.next();
		BookBean book = new BookBean(no,title,author,publisher,price,pub_day);
		int cnt = dao.updateBook(book);
		if(cnt<0) {
			System.out.println("��������");
		}else {
			System.out.println("���� ����");
		}
	}

	public void InsertBook() {
		System.out.println("no�� �������� �ڵ� �Էµ˴ϴ�.(����)");
		
		System.out.print("���� �Է�");
		String title = sc.next();
		System.out.print("�۰� �Է�");
		String author = sc.next();
		System.out.print("���ǻ� �Է�");
		String publisher = sc.next();
		System.out.print("���� �Է�");
		int price = sc.nextInt();
		System.out.print("������ �Է�");
		String pub_day = sc.next();
		
		BookBean bean = new BookBean (0,title,author,publisher, price,pub_day); //bookBean�� �Ķ���� �ִ� ������ ��������
		int cnt = dao.insertBook(bean);
		if(cnt<0) {
			System.out.println("insert ����");
		}else {
			System.out.println("insert ����");
		}
	}

	public void showBook(ArrayList<BookBean> lists) {
		System.out.println("�� " + lists.size()+"���Դϴ�.");
		String title = "��ȣ\t����\t�۰�\t���ǻ�\t����\t������";
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
