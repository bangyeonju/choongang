import java.util.ArrayList;
import java.util.Scanner;

class Person {
	private String id;
	private String pw;

	Person(String id, String pw) {
		super();
		this.id = id;
		this.pw = pw;
	}

	public String toString() { // Object ->public String toString(�θ�)�� �������ֱ⶧���� �������̵��ϱ����ؼ��� public���� ���ų� ū
		// ���������ڰ��ʿ��ϴ�
		return id + "/" + pw;
	}

	String getId() {
		return id;
	}

	String getPw() {
		return pw;
	}
}

public class Ex09_04_�濬�� {

	public static void main(String[] args) {
		ArrayList<Person> list = new ArrayList<Person>();
		// Person p1 = new Person("kim","1234");
		// Person p2 = new Person("park","5678");
		// Person p3 = new Person("song","9999");
		int i;
		Person[] p = { 
				new Person("park", "5678"),
				new Person("kim", "1234"),
				new Person("choi", "9876") };
		for (i = 0; i < p.length; i++) {
			list.add(p[i]);
		}

		System.out.println(list.toString());
		Person one = list.get(2);
		System.out.println("--");
		System.out.println(one.toString());
		Scanner sc = new Scanner(System.in);

		for (i = 0; i < p.length; i++) {
			System.out.println(list.get(i));
		}
		// list.add(p1);
		// list.add(p2);
		ArrayList<Person> list2 = new ArrayList<Person>();
		// list.add(new Person("song","9999"));
		System.out.println("--");
		System.out.println(list2);
		System.out.println(list.toString());// �ּҰ��� �����⋚���� ...
		// do {
		// System.out.print("id");
		// String inputId = sc.next();
		// System.out.print("pw");
		// String inputPw = sc.next();
		// System.out.println("���?");
		// String answer = sc.next();
		// list2.add(new Person(inputId, inputPw));
		//
		// if(answer.equalsIgnoreCase("n")) {
		//// list2.add(new Person(inputId, inputPw));
		//
		// break;
		// } else {
		//
		// continue;
		// }
		// } while(true);
		// list2.addAll(0, list);
		// System.out.println(list2);
		//
		String answer = sc.next();

		if(answer.equalsIgnoreCase("n")) {
		while (true) {
			System.out.println(list.get(0).getId());
			System.out.println("id");
			String id = sc.next();
			System.out.println("pw");
			String pw = sc.next();
			String retry;
			// Person per =new Person(id,pw);
			// list.add(new Person(id, pw));

			list.add(new Person(id, pw));
			System.out.print("���");
			retry = sc.next();
			if (!retry.contentEquals("y"))
				break;
		}
		System.out.println(list.toString());

		System.out.println(list.size());
		for (i = 0; i < list.size(); i++) {
			// System.out.println(list.get(i));
			// Person aa = list.get(i);
			// System.out.println(aa);
			// System.out.println(aa.id+":"+aa.pw);
			System.out.println(list.get(i).getId() + ":" + list.get(i).getPw());
		}
		String searchId;
		boolean flag=false;
		System.out.print("ã�� ���̵� �Է�:");
		searchId = sc.next();
		for (i = 0; i < list.size(); i++) {
			if (list.get(i).getId().equals(searchId)) {
				System.out.println(searchId + "->"+list.get(i).getPw());
				flag = true;
//			} else {
//				System.out.println("ã�¾��̵����!");
//
//			}
			}
		}
			if(flag == false) {
				System.out.println("ã�¾��̵� ����");
			}
		// [kim/1234, park/5678, choi/9999]
		// park/5678
		// one:park/5678
		// kim/1234
		// park/5678
		// choi/9999
		// ������� ��������
		// ID:jung
		// PW:1212
		// ���?y
		// ID:won
		// PW:9988
		// ���?n
		// [kim/1234, park/5678, choi/9999, jung/1212, won/9988]
	}}

}