//package test;
//
//import java.util.ArrayList;
//import java.util.Scanner;

//class Student {
//	private String name;
//	private int kor;
//	private int eng;
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public int getKor() {
//		return kor;
//	}
//
//	public void setKor(int kor) {
//		this.kor = kor;
//	}
//
//	public int getEng() {
//		return eng;
//	}
//
//	public void setEng(int eng) {
//		this.eng = eng;
//	}
//
//	public Student(String name, int kor, int eng) {
//		super();
//		this.name = name;
//		this.kor = kor;
//		this.eng = eng;
//	}
//
//	@Override
//	public String toString() {
//		return name + "/" + kor + "/" + eng;
//	}
//
//}
//
//public class Test_방연주 {
//	public static void main(String[] args) {
//		String name, retry;
//		int eng, kor, i;
//		ArrayList<Student> list = new ArrayList<Student>();
//		Scanner sc = new Scanner(System.in);
//		while (true) {
//			System.out.println("이름");
//			name = sc.next();
//			System.out.println("국어");
//			kor = sc.nextInt();
//			System.out.println("영어");
//			eng = sc.nextInt();
//			Student s = new Student(name, kor, eng);
//			list.add(s);
//			System.out.println("계속?(y/n)");
//			retry = sc.next();
//			if (retry.equals("n")) {
//				break;
//			}
//		}
//		for (i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i));
//		}
//		System.out.println(list);
//		do {
//			boolean flag = false;
//			System.out.println("찾을이름");
//			name = sc.next();
//			for (i = 0; i < list.size(); i++) {
//				flag = false;
//				if (name.equals(list.get(i).getName())) {
//					System.out.println(list.get(i).getKor());
//					System.out.println(list.get(i).getEng());
//					flag = true;
//					break;
//				}
//			}
//			if (flag == false) {
//				System.out.println("없다");
//			}
//			System.out.println("계속?(y/n)");
//			retry = sc.next();
//			if (retry.equals("n")) {
//				break;
//			}
//		} while (true);
//		System.out.println("종료");
//	}
//}
////
////이름:kim
////국어:33
////영어:44
////계속?(y/n) : y
////이름:park
////국어:77
////영어:88
////계속?(y/n) : n
////[kim/33/44, park/77/88]
////
////kim/33/44
////park/77/88
////
////찾는 이름 : park
////국어:77
////영어:88
////계속?y
////찾는 이름 : choi
////찾는 이름 없음
////계속?n
////프로그램을 종료합니다.
////
////
