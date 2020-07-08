package test;

import java.util.ArrayList;
import java.util.Scanner;

public class ProductMain {
		ProductDao dao = new ProductDao();
		Scanner sc = new Scanner(System.in);
		
		ProductMain(){
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
				
				break;

			case 3:
				break;

			case 4:
				break;

			case 5:
				break;

			case 6:
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
	public static void main(String[] args) {
		new PersonMain();
		
	}

}
