import java.util.ArrayList;
import java.util.Scanner;

//console
public class ProductMain {

	ProductDao dao = new ProductDao(); // ���� ���� ���� 1������ ���� dao��ü�� ���� dao �����ڷ� ȣ��
	Scanner sc = new Scanner(System.in);

	ProductMain() {
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
				System.out.println("���α׷� ����");
				System.exit(0);
				break;
			default:
				System.out.println("1~7 ������ ��ȣ�� �Է°����մϴ�.");

			}
		}
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

	public void inputId() {
		System.out.print("ã�� ���̵� �Է�: ");
		int id = sc.nextInt();
		ProductBean pb = dao.getProductbyId(id);
		// ���� �ȵ����� null��
		if (pb == null) {
			System.out.println("�ش� ���̵� ã�� �� �����ϴ�.");
		} else {
			String title = "���̵�\t�̸�\t���\t�ܰ�\tī�װ�\t�԰�����\t";
			System.out.println(title);

			String result = pb.getId() + "\t" + pb.getName() + "\t" + pb.getStock() + "\t" + pb.getPrice() + "\t"
					+ pb.getCategory() + "\t" + pb.getInputdate() + "\t";

			System.out.println(result);
		}
	}

	public void getProductByCategory() {
		System.out.print("ã�� ī�װ� �Է�  :");
		String category = sc.next();
		ArrayList<ProductBean> lists = dao.getProductByCategory(category);
		if (lists.size() == 0) {
			System.out.println("�ش� ī�װ� �����ϴ�.");
		} else {
			showProducts(lists);
		}
	}

	public void insertData() {
		System.out.println("id�� �������� �ڵ� �Էµ˴ϴ�.(����)");
		System.out.print("�̸� �Է�");
		String name = sc.next();
		System.out.print("��� �Է�");
		int stock = sc.nextInt();
		System.out.print("���� �Է�");
		int price = sc.nextInt();
		System.out.print("ī�װ� �Է�");
		String category = sc.next();
		System.out.print("�԰����� �Է�");
		String inputdate = sc.next();
		ProductBean bean = new ProductBean(0, name, stock, price, category, inputdate);
		
		 int cnt = dao.insertData(bean);
		if(cnt<0) {
			System.out.println("insert ����");
		}else {
			System.out.println("insert ����");
		}
	}
	public void updateData() {
		System.out.print("�����ϰ���� ���̵� �Է��ϼ��� : ");
		int id =sc.nextInt();

		System.out.print("�̸� �Է�");
		String name = sc.next();
		System.out.print("��� �Է�");
		int stock = sc.nextInt();
		System.out.print("���� �Է�");
		int price = sc.nextInt();
		System.out.print("ī�װ� �Է�");
		String category = sc.next();
		System.out.print("�԰����� �Է�");
		String inputdate = sc.next();
		ProductBean bean = new ProductBean(id, name, stock, price, category, inputdate);
		int cnt = dao.updateData(bean);
		if(cnt>0) {
			System.out.println("���� ����");
		} else if(cnt ==0){
			System.out.println("���ǿ� �´� ������ ����");
		} else {
			System.out.println("��������");
		}
	}
	public void deleteData() {
		System.out.print("������ id �Է� : ");
		int id = sc.nextInt();
		int cnt =dao.deleteData(id);
		if(cnt>0) {
			System.out.println("���� ����");
		} else if(cnt ==0){
			System.out.println("���ǿ� �´� ������ ����");
		} else {
			System.out.println("���� ����");
		}
	}
	public static void main(String[] args) {

		new ProductMain();// ��ü���� => ������ ȣ��

	}
}
