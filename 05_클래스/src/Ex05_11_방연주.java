import java.util.Scanner;

public class Ex05_11_방연주 {
	public static void main(String[] args) {
	
		//정수 2개 입력...?
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자1:");
		int num1= sc.nextInt();
		System.out.print("숫자2:");
		int num2= sc.nextInt();
		
		int result = recursive(num1, num2);
		System.out.printf("%d의%d승은 =%d",num1,num2,result);
		
	}
	static int recursive(int a,int b) {
		if(b==0) {
			return 1;
		}else
			
			return a*recursive(a,b-1);
			
			
	}
}
