import java.util.Scanner;

class Person3 {
	String id;
//	private String id;
	String pw;
	String name;

	public Person3(String id, String pw, String name) {
		this.id = id;
		this.pw = pw;
		this.name = name;
	}
}

public class test{
	public static void main(String[] args) {

//		Person3 p1 = new Person3("kim", "1234", "�迬��");
//		Person3 p2 = new Person3("park", "3456", "�ڳ���");
//		Person3 p3 = new Person3("song", "9876", "���߱�");

		Person3[] p = { new Person3("kim", "1234", "�迬��"), new Person3("park", "3456", "�ڳ���"),
				new Person3("song", "9876", "���߱�") };
		Scanner sc = new Scanner(System.in);
		int i=0;
		
		do {
			
			System.out.println("���̵� �Է�");
			String inputId = sc.next();
			
			System.out.println("��й�ȣ �Է�");
			String inputPw = sc.next();
			if (p[i].id.equals(inputId) ==true && p[i].pw.equals(inputPw) ==true ) {
				System.out.println(p[i].id + "�ݰ����ϴ�.");
			}
			
				
				} 
				}
			
			i++;
		}while(i<p.length);

}

// do while

}

//pw�Է�:3456
//id�Է�:park
//�ڳ����� �ݰ����ϴ�.
//���?y
//id�Է�:pa
//id�� 3����~8���� �Է��ؾ� �մϴ�.
//id�Է�:dlsfjsldfjslf
//id�� 3����~8���� �Է��ؾ� �մϴ�.
//id�Է�:kim
//pw�Է�:9999
//����� ���� �ʽ��ϴ�.
//���?y
//id�Է�:choi
//pw�Է�:3223
//�ش� ���̵� �����ϴ�.
//���?n
//���α׷��� �����մϴ�.
