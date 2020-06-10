import java.util.Scanner;

public class Ex05_11_방연주 {
	public static void main(String[] args) {
		int a,b;
		//정수 2개 입력...?
		Scanner sc = new Scanner(System.in);
		System.out.println("정수를 입력하세요");
		a= sc.nextInt();
		System.out.println("정수를 입력하세요");
		b= sc.nextInt();
		
		System.out.printf("%d의%d승 =",a,b);
		System.out.print(dd(a,b));
		
		
	}
	static int dd(int a,int b) {
		if(b==0) {
			return 1;
		}else
			
			return a*dd(a,b-1);
			
			
	}
}
