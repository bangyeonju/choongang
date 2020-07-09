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
			System.out.println("\n======�޴� �����ϱ�======");
			System.out.println("1.��� ��ǰ ��ȸ");
			System.out.println("2.Ư�� ��ǰ ��ȸ(id �̿�)");
			System.out.println("3.Ư�� ��ǰ ��ȸ(ī�װ� �̿�)");
			System.out.println("4.��ǰ ����");
			System.out.println("5.��ǰ ����");
			System.out.println("6.��ǰ �߰�");
			System.out.println("7.���α׷� ����");
			System.out.print("��ȣ �Է�>> ");
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
				break;

			case 4:
				break;

			case 5:
				break;

			case 6:
				break;

			case 7:
				System.out.println("���α׷� ����");
				System.exit(0);
				break;
			default:
				System.out.println("1~7 ������ ��ȣ�� �Է°����մϴ�.");

			}
		}
			
		}
	public void inputId() {
		System.out.print("ã�¾��̵� : ");
		int id = sc.nextInt();
		ProductBean bean = Produc
		dao.getProductbyId(id);
		
		
		
		
	}
	public void showProducts(ArrayList<ProductBean> lists) {
		String title = "���̵�\t�̸�\t���\t�ܰ�\tī�װ�\t�԰�����\t";
		System.out.println(title);
		for (ProductBean pb : lists) {
			String result = pb.getId() + "\t" + pb.getName() + "\t" + pb.getStock() + "\t" + pb.getPrice() + "\t"
					+ pb.getCategory() + "\t" + pb.getInputdate() + "\t";

			System.out.println(result);
		}
		
		
	}
	public static void main(String[] args) {
		new ProductMain();
		
	}

}
