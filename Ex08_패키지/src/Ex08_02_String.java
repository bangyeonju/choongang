import java.util.Scanner;

public class Ex08_02_String {
	public static void main(String[] args) {

		int a = 1, b = 2;
		System.out.println(a == b); // 일반변수는 비교할때 ==사용

		String str1 = new String("Have a nice day"); // 객체생성
		String str2 = new String("Have A nice day");

		System.out.println("str1:" + str1);
		System.out.println("str1의 길이:" + str1.length());
		System.out.println(str1.equals(str2));// String의 equals 문자열비교

		if (str1.equals(str2)) {
			System.out.println("str1과str2문자열 같음");

		} else {
			System.out.println("str1과str2문자열 같지않음");
		}
		System.out.println(str1.equalsIgnoreCase(str2)); // 대소문자 무시하고 문자열 비교 Have a nice day, Have A nice day 비교 ==>true

		System.out.println(str1.concat(str2));// 두문자열을 연결! => Have a nice dayHave A nice day
		System.out.println(str1 + str2);

		System.out.println(str1 == str2);// 요로케 문자열을 비교할때는 주소비교
		System.out.println(str1.compareTo(str2)); // *str1과str2의값을 비교했을때 똑같다면 0리턴* 다르면 달라지는 첫글자를 보고아스키코드값을 str1-str2

		// 위치를 찾을때 indexof사용
		System.out.println(str1.indexOf("nice"));// nice의 n이 7번째 위치에 있다 H:0 a:1 v:2 n:7
		System.out.println(str1.indexOf("happy"));// str1에 happy가 없으므로 -1출력
		System.out.println(str1.lastIndexOf("a"));// 뒤에서부터 a를 찾는다 a:13

		System.out.println(str1.contains("nice")); // str1에 nice가 포함하면 true
		System.out.println(str1.contains("happy"));// 		happy가 없다면 false

		System.out.println(str1.charAt(3));// 3번째위치에 있는 문자 출력
		char c = str1.charAt(3);
		System.out.println("c:" + c);
		System.out.println();

		System.out.println(str1.substring(7, 10));// 7~9까지 10x
		System.out.println(str1.substring(7));// 7부터 끝까지

		System.out.println(str1.replace("a", "x"));// str1에 있는 문자a를 x로변경
		System.out.println("str1:" + str1);// 다시 원래대로 출력

		String s = "   abc  De   Fg     ";
		System.out.println("s:" + s);
		System.out.println(s.trim());// 문자열의 맨앞뒤공백제거
		s = s.trim();
		System.out.println("s:" + s); // 변경된상태를 유지하고 싶다면

		System.out.println();
		System.out.println(s.toUpperCase()); // 대문자로변경
		System.out.println(s.toLowerCase());// 소문자로변경
		System.out.println();

		String fullName = "Hello.java";
		String fileName;// Hello
		String ext;// java
		int pos = fullName.indexOf(".");
		System.out.println("pos:"+pos);
		fileName =  fullName.substring(0,5);
		ext = fullName.substring(pos+1);
		System.out.println("화일명:"+fileName);
		System.out.println("확장자"+ext);

		String id ="kim";
		String pw = "1234";
		
		Scanner sc = new Scanner(System.in);
		System.out.print("아이디 입력");
		String inputId = sc.next();
		System.out.print("비밀번호 입력");
		String inputPw = sc.next();
		
		if(pw.equals(inputPw) && pw.equals(inputPw)) {
			System.out.println("로그인가능");
		}else {
			System.out.println("로그인 불가능");
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
