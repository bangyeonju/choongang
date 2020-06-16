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

public class Ex08_03_방연주 {
	public static void main(String[] args) {

		// Person2 p1 = new Person2("kim", "1234", "김연아");
		// Person2 p2 = new Person2("park", "3456", "박나래");
		// Person2 p3 = new Person2("song", "9876", "송중기");

		Person2[] p = { new Person2("kim", "1234", "김연아"), new Person2("park", "3456", "박나래"),
				new Person2("song", "9876", "송중기") };
		Scanner sc = new Scanner(System.in);
		int i = 0;

		do {

			System.out.println("아이디 입력");
			String inputId = sc.next();
			if (inputId.length() < 3) {
				System.out.println("id는 3글자~8글자 입력해야 합니다.");
				continue;
			} else if (inputId.length() > 9) {
				System.out.println("id는 3글자~8글자 입력해야 합니다.");
				continue;
			}
			System.out.println("비밀번호 입력");
			String inputPw = sc.next();
			for (i = 0; i < p.length; i++) {
				if (p[i].id.equals(inputId) && p[i].pw.equals(inputPw)) {
					System.out.println(p[i].id + "반갑습니다.");
					System.out.println("계속?");
					String a = sc.next();
					switch (a) {
					case "y":
						continue;
					case "n":
						System.out.println("프로그램을 종료합니다.");
						System.exit(0);
					}

				} else if (p[i].id.equals(inputId) == true && p[i].pw.equals(inputPw) == false) {
					System.out.println("비번이 맞지 않습니다.");
					System.out.println("계속?");
					String a = sc.next();
					switch (a) {
					case "y":
						continue;
					case "n":
						System.out.println("프로그램을 종료합니다.");
						System.exit(0);
					}

				} else if(p[i].id.equals(inputId) == false ) {
					System.out.println("해당아이디가 없습니다.");
					System.out.println("계속?");
					String a = sc.next();
					switch (a) {
					case "y":
						continue;
					case "n":
						System.out.println("프로그램을 종료합니다.");
						System.exit(0);
					}
				}
			}
		} while (true);

	}

	// do while

}

// pw입력:3456
// id입력:park
// 박나래님 반갑습니다.
// 계속?y
// id입력:pa
// id는 3글자~8글자 입력해야 합니다.
// id입력:dlsfjsldfjslf
// id는 3글자~8글자 입력해야 합니다.
// id입력:kim
// pw입력:9999
// 비번이 맞지 않습니다.
// 계속?y
// id입력:choi
// pw입력:3223
// 해당 아이디가 없습니다.
// 계속?n
// 프로그램을 종료합니다.
