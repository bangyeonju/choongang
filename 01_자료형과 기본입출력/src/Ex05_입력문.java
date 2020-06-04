import java.util.Scanner;



public class Ex05_입력문 {
	public static void main(String[] args) {
		int a;
		a = 10;
		System.out.println("a=" +a);
		
		a = 20;
		System.out.println("a=" +a);
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("이름입력 : ");
		String name = sc.next();
		System.out.println("name=" +name);
		
		System.out.print("국어점수 입력 :");
		int kor = sc.nextInt();// 입력한 정수를 scanner를 통해 읽어들인다.
		System.out.println("kor="+kor);
		
		System.out.print("영어점수 입력 :");
		int eng = sc.nextInt();
		System.out.println("eng="+eng);
		
		System.out.print("수학점수 입력 :");
		int math = sc.nextInt();
		System.out.println("math="+math);
		
		int total =	kor + eng + math;
		System.out.println("총점 : "+ total);
		
		//평군 소수점아래 2자리 출력 -> *printf*
		double avg =(double)total / 3;
		System.out.printf("평균 : %f\n" , avg);
		System.out.printf("평균 : %.2f" , avg);
	}
}
