import java.util.Scanner;

class Person2 {
	String id;
	// private String id;
	String pw;
	String name;

	public Person2(String id, String pw, String name) {
		this.id = id;
		this.pw = pw;
		this.name = name;
	}
}

public class Ex08_03_�濬�� {
	public static void main(String[] args) {

		// Person2 p1 = new Person2("kim", "1234", "�迬��");
		// Person2 p2 = new Person2("park", "3456", "�ڳ���");
		// Person2 p3 = new Person2("song", "9876", "���߱�");

		Person2[] p = { new Person2("kim", "1234", "�迬��"), new Person2("park", "3456", "�ڳ���"),
				new Person2("song", "9876", "���߱�") };
		Scanner sc = new Scanner(System.in);
		int i = 0;

		do {

			System.out.println("���̵� �Է�");
			String inputId = sc.next();
			if (inputId.length() < 3) {
				System.out.println("id�� 3����~8���� �Է��ؾ� �մϴ�.");
				continue;
			} else if (inputId.length() > 9) {
				System.out.println("id�� 3����~8���� �Է��ؾ� �մϴ�.");
				continue;
			}
			System.out.println("��й�ȣ �Է�");
			String inputPw = sc.next();
			for (i = 0; i < p.length; i++) {
				if (p[i].id.equals(inputId) && p[i].pw.equals(inputPw)) {
					System.out.println(p[i].id + "�ݰ����ϴ�.");
					System.out.println("���?");
					String a = sc.next();
					switch (a) {
					case "y":
						continue;
					case "n":
						System.out.println("���α׷��� �����մϴ�.");
						System.exit(0);
					}

				} else if (p[i].id.equals(inputId) == true && p[i].pw.equals(inputPw) == false) {
					System.out.println("����� ���� �ʽ��ϴ�.");
					System.out.println("���?");
					String a = sc.next();
					switch (a) {
					case "y":
						continue;
					case "n":
						System.out.println("���α׷��� �����մϴ�.");
						System.exit(0);
					}

				} else if(p[i].id.equals(inputId) == false ) {
					System.out.println("�ش���̵� �����ϴ�.");
					System.out.println("���?");
					String a = sc.next();
					switch (a) {
					case "y":
						continue;
					case "n":
						System.out.println("���α׷��� �����մϴ�.");
						System.exit(0);
					}
				}
			}
		} while (true);

	}

	// do while

}

// pw�Է�:3456
// id�Է�:park
// �ڳ����� �ݰ����ϴ�.
// ���?y
// id�Է�:pa
// id�� 3����~8���� �Է��ؾ� �մϴ�.
// id�Է�:dlsfjsldfjslf
// id�� 3����~8���� �Է��ؾ� �մϴ�.
// id�Է�:kim
// pw�Է�:9999
// ����� ���� �ʽ��ϴ�.
// ���?y
// id�Է�:choi
// pw�Է�:3223
// �ش� ���̵� �����ϴ�.
// ���?n
// ���α׷��� �����մϴ�.
