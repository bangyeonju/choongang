import java.util.ArrayList;
import java.util.Scanner;

//console
public class ProductMain {

	ProductDao dao = new ProductDao(); // 메인 보다 빨리 1번쨰로 실행 dao객체가 생성 dao 생성자로 호출
	Scanner sc = new Scanner(System.in);

	ProductMain() {
		init();

	}

	public void init() {
		while (true) {
			System.out.println("\n======메뉴 선택하기======");
			System.out.println("1.모든 상품 조회");
			System.out.println("2.특정 상품 조회(id 이용)");
			System.out.println("3.특정 상품 조회(카테고리 이용)");
			System.out.println("4.상품 수정");
			System.out.println("5.상품 삭제");
			System.out.println("6.상품 추가");
			System.out.println("7.프로그램 종료");
			System.out.print("번호 입력>> ");
			int menu = sc.nextInt();

			switch (menu) {
			case 1:

				ArrayList<ProductBean> lists = dao.getAllProduct();
				showProducts(lists);
				break;

			case 2:
				inputId();
				break;

			case 3:
				getProductByCategory();
				break;

			case 4:
				updateData();
				break;

			case 5:
				deleteData();
				break;

			case 6:
				insertData();
				break;

			case 7:
				System.out.println("프로그램 종료");
				System.exit(0);
				break;
			default:
				System.out.println("1~7 사이의 번호만 입력가능합니다.");

			}
		}
	}

	public void showProducts(ArrayList<ProductBean> lists) {
		String title = "아이디\t이름\t재고량\t단가\t카테고리\t입고일자\t";
		System.out.println(title);
		for (ProductBean pb : lists) {
			String result = pb.getId() + "\t" + pb.getName() + "\t" + pb.getStock() + "\t" + pb.getPrice() + "\t"
					+ pb.getCategory() + "\t" + pb.getInputdate() + "\t";

			System.out.println(result);
		}
	}

	public void inputId() {
		System.out.print("찾는 아이디 입력: ");
		int id = sc.nextInt();
		ProductBean pb = dao.getProductbyId(id);
		// 값이 안들어오면 null값
		if (pb == null) {
			System.out.println("해당 아이디를 찾을 수 없습니다.");
		} else {
			String title = "아이디\t이름\t재고량\t단가\t카테고리\t입고일자\t";
			System.out.println(title);

			String result = pb.getId() + "\t" + pb.getName() + "\t" + pb.getStock() + "\t" + pb.getPrice() + "\t"
					+ pb.getCategory() + "\t" + pb.getInputdate() + "\t";

			System.out.println(result);
		}
	}

	public void getProductByCategory() {
		System.out.print("찾는 카테고리 입력  :");
		String category = sc.next();
		ArrayList<ProductBean> lists = dao.getProductByCategory(category);
		if (lists.size() == 0) {
			System.out.println("해당 카테고리 없습니다.");
		} else {
			showProducts(lists);
		}
	}

	public void insertData() {
		System.out.println("id는 시퀀스로 자동 입력됩니다.(생략)");
		System.out.print("이름 입력");
		String name = sc.next();
		System.out.print("재고량 입력");
		int stock = sc.nextInt();
		System.out.print("가격 입력");
		int price = sc.nextInt();
		System.out.print("카테고리 입력");
		String category = sc.next();
		System.out.print("입고일자 입력");
		String inputdate = sc.next();
		ProductBean bean = new ProductBean(0, name, stock, price, category, inputdate);
		
		 int cnt = dao.insertData(bean);
		if(cnt<0) {
			System.out.println("insert 실패");
		}else {
			System.out.println("insert 성공");
		}
	}
	public void updateData() {
		System.out.print("수정하고싶은 아이디 입력하세요 : ");
		int id =sc.nextInt();

		System.out.print("이름 입력");
		String name = sc.next();
		System.out.print("재고량 입력");
		int stock = sc.nextInt();
		System.out.print("가격 입력");
		int price = sc.nextInt();
		System.out.print("카테고리 입력");
		String category = sc.next();
		System.out.print("입고일자 입력");
		String inputdate = sc.next();
		ProductBean bean = new ProductBean(id, name, stock, price, category, inputdate);
		int cnt = dao.updateData(bean);
		if(cnt>0) {
			System.out.println("수정 성공");
		} else if(cnt ==0){
			System.out.println("조건에 맞는 데이터 없음");
		} else {
			System.out.println("수정실패");
		}
	}
	public void deleteData() {
		System.out.print("삭제할 id 입력 : ");
		int id = sc.nextInt();
		int cnt =dao.deleteData(id);
		if(cnt>0) {
			System.out.println("삭제 성공");
		} else if(cnt ==0){
			System.out.println("조건에 맞는 데이터 없음");
		} else {
			System.out.println("삭제 실패");
		}
	}
	public static void main(String[] args) {

		new ProductMain();// 객체만듬 => 생성자 호출

	}
}
