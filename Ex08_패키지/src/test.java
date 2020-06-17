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

//		Person3 p1 = new Person3("kim", "1234", "김연아");
//		Person3 p2 = new Person3("park", "3456", "박나래");
//		Person3 p3 = new Person3("song", "9876", "송중기");

		Person3[] p = { new Person3("kim", "1234", "김연아"), new Person3("park", "3456", "박나래"),
				new Person3("song", "9876", "송중기") };
		Scanner sc = new Scanner(System.in);
		int i=0;
		
		do {
			
			System.out.println("아이디 입력");
			String inputId = sc.next();
			
			System.out.println("비밀번호 입력");
			String inputPw = sc.next();
			if (p[i].id.equals(inputId) ==true && p[i].pw.equals(inputPw) ==true ) {
				System.out.println(p[i].id + "반갑습니다.");
			}
			
				
				} 
				}
			
			i++;
		}while(i<p.length);

}

// do while

}

//pw입력:3456
//id입력:park
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
