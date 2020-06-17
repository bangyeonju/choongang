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

		int i;
//		Person2 p1 = new Person2("kim", "1234", "김연아");
//		Person2 p2 = new Person2("park", "3456", "박나래");
//		Person2 p3 = new Person2("song", "9876", "송중기");

		Person2[] p = { new Person2("kim", "1234", "김연아"), new Person2("park", "3456", "박나래"),
				new Person2("song", "9876", "송중기") };

//		System.out.println(p[0].id);
//		System.out.println(p[1].id);
//		System.out.println(p[2].id);
//		
		Scanner sc = new Scanner(System.in);
		String inputId, pw, retry;
		boolean flag = false;
		do {
			flag = false;//
			System.out.println("아이디 입력");
			inputId = sc.next();
			if (inputId.length() < 3) {
				System.out.println("id는 3글자이상 .");
				continue; // while의조건으로감
			} else if (inputId.length() > 8) {
				System.out.println("id는 8글자이하 .");
				continue; // while의조건으로감
			
			
			}
			
			System.out.println("비밀번호 입력");
			pw = sc.next();
			for (i = 0; i < p.length; i++) {
				if (p[i].id.equals(inputId)) { // 아이디가 일치하면
						flag = true;
					if (p[i].pw.equals(pw)) { // 아이디가 일치하고 비밀번호가 일치할때
						System.out.println(p[i].name + "님 반갑습니다.");
//						flag = true;
						break; // 반복문(for)을 빠져나간다
					} else {
						System.out.println("비밀번호가 틀렸습니다.");
//						flag = true;
					}
				}
//				else {
//					System.out.println("해당아이디가 없습니다."); //==>반복문안에있기때문에 세번 출력이된다. 
//				}

			}//for
			
			if(flag == false) {
				System.out.println("해당아이디가 없습니다");
			}
//	
			System.out.print("계속?");
			retry = sc.next();
			if (retry.equalsIgnoreCase("n"))
				break; // do while문 빠져나감
		} while (true);
		System.out.println("프로그램을 종료합니다.");

	
}}

// do while

//id입력:park
//pw입력:3456
//박나래님 반갑습니다.
//계속?y
//id입력:pa
//id는 3글자~8글자 입력해야 합니다.
//id입력:dlsfjsldfjslf
//id는 3글자~8글자 입력해야 합니다.
//id입력:kim
//pw입력:9999
//비번이 맞지 않습니다.
//계속?y
//id입력:choi
//pw입력:3223
//해당 아이디가 없습니다.
//계속?n
//프로그램을 종료합니다.
