import java.util.ArrayList;
import java.util.Scanner;

//consoleâ

public class PersonMain {

	PersonDao dao = new PersonDao(); //������ =>1�ܰ� ����̹��ε�
	Scanner sc = new Scanner(System.in);
	PersonMain() {
		System.out.println("PersonMain()");
		init(); //init ȣ��
		
	}

	void init() {
		while (true) {
			System.out.println("\n=======�޴������ϱ�=======");
			System.out.println("1.��ü ���� ��ȸ");
			System.out.println("2.������ ��ȸ");
			System.out.println("3.���� ����");
			System.out.println("4.���� ���� ");
			System.out.println("5.���� �߰�");
			System.out.println("6.���α׷� ����");
			System.out.print(">>�޴� ��ȣ �Է�:");
			int menu = sc.nextInt();
			switch (menu) {
			case 1:
				ArrayList<PersonBean> lists = dao.getAllPerson();//���ϰ���  lists�� ��´�.
				showPerson(lists);
				
				break;

			case 2:
				inputGender();
			
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				insertData();
				
				break;
			case 6:
				System.out.println("���α׷��� �����մϴ�.");
				System.exit(0);
				break;

			default:
				System.out.println("1~6������ ��ȣ�� �Է°���");
			}
		}
	}//init
	void showPerson(ArrayList<PersonBean> lists) {
		String title="��ȣ\t�̸�\t����\t����\t�������";
				System.out.println(title);
				for(int i=0;i<lists.size();i++) {
					
					String result = lists.get(i).getNum()+"\t"+
							lists.get(i).getName()+"\t"+
							lists.get(i).getAge()+"\t"+
							lists.get(i).getGender()+"\t"+
							lists.get(i).getBirth()+"\t";
							System.out.println(result);
							
					
					
//					System.out.print(lists.get(i).getNum()+"\t");
//					System.out.print(lists.get(i).getName()+"\t");
//					System.out.print(lists.get(i).getAge()+"\t");
//					System.out.print(lists.get(i).getGender()+"\t");
//					System.out.print(lists.get(i).getBirth()+"\t");
				}
	}//showPerson
	 void inputGender() {
		 System.out.print("ã������ ���� �Է� : ");
		 String findGender=sc.next();
			ArrayList<PersonBean> lists = dao.getPersonByGender(findGender);
			if(lists.size()==0) {
				System.out.println("�ش� ������ �������� ����");
			} 
			else {
			showPerson(lists);
			}
		 
	 }
	 void insertData() {
		 System.out.println("��ȣ�� �������� �Էµ˴ϴ�.(����)");
		 System.out.print("�̸��Է�:");
		 String name =sc.next();
		 System.out.print("�����Է�:");
		 int age =sc.nextInt();
		 System.out.print("�����Է�:");
		 String gender=sc.next();
		 System.out.print("������� �Է�:");
		 String birth = sc.next();
		 
		int cnt = dao.insertData(name,age,gender,birth); //dao��insertData�� ����.
		if (cnt<0) {
			System.out.println("insert ����");
			
		}else {
			System.out.println("insert ����");
		}
		
	 }
	public static void main(String[] args) {

		new PersonMain();//��ü����鼭 ������ȣ��

	}

}
