import java.util.Scanner;

class Person2 {
	String id;
//	private String id;
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
		
		Person2[] p = { new Person2("kim", "1234", "김연아"), 
						new Person2("park", "3456", "박나래"),
						new Person2("song", "9876", "송중기") };
		Scanner sc = new Scanner(System.in);
		System.out.println("아이디 입력");
		String inputId= sc.next();
		System.out.println("비밀번호 입력");
		String inputPw = sc.next();
		
//		for (i=0;i<p.length;i++) {
//			
//		}
		
		if(p.equals(inputPw) && p.equals(inputPw)) {
			System.out.println("로그인가능");
		}else {
			System.out.println("로그인 불가능");
		}
		
		

		
		
	}
	
	
	//do while

}

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

