import java.util.ArrayList;
import java.util.Scanner;

class Person {
	String id;
	String pw;

	Person(String id, String pw) {
		super();
		this.id = id;
		this.pw = pw;
	}

	public String toString() { // Object ->public String toString(부모)가 가지고있기때문에 오버라이딩하기위해서는 public보다 같거나 큰
								// 접근제어자가필요하다
		return id + "/" + pw;
	}

}

public class Ex09_04_방연주 {

	public static void main(String[] args) {
		ArrayList<Person> list = new ArrayList<Person>();
//		Person p1 = new Person("kim","1234");
//		Person p2 = new Person("park","5678");
//		Person p3 = new Person("song","9999");
		int i;
		Person[] p = { new Person("park", "5678"),
				new Person("kim", "1234"),
				new Person("choi", "9999") };
		for (i = 0; i < p.length; i++) {
			list.add(p[i]);
		}
		
		System.out.println(list.toString());
		Person one = list.get(1);
		System.out.println(one.toString());
		
		for (i = 0; i < p.length; i++) {
			System.out.println(list.get(i));
		}
//		list.add(p1);
//		list.add(p2);
		ArrayList<Person> list2 = new ArrayList<Person>();
//		list.add(new Person("song","9999"));
		System.out.println("--");
		System.out.println(list2);
		System.out.println(list.toString());// 주소값이 나오기떄문에 ...
		do {
		Scanner sc = new Scanner(System.in);
		System.out.print("id");
		String inputId = sc.next();
		System.out.print("pw");
		String inputPw = sc.next();
		System.out.println("계속?");
		String answer = sc.next();
		list2.add(new Person(inputId, inputPw));

		if(answer.equalsIgnoreCase("n")) {

			break;
		} else {
		
			continue;
		}
		} while(true);
		list2.addAll(0, list);
		System.out.println(list2);		
//		[kim/1234, park/5678, choi/9999]
//		park/5678
//		one:park/5678
//		kim/1234
//		park/5678
//		choi/9999
//		여기부터 과제시작
//		ID:jung
//		PW:1212
//		계속?y
//		ID:won
//		PW:9988
//		계속?n
//		[kim/1234, park/5678, choi/9999, jung/1212, won/9988]

	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
}