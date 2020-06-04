import java.util.Scanner;

public class Ex02_01_산술 {
	public static void main(String[] args) {

		int num1, num2;

		Scanner sc = new Scanner(System.in);
		
		System.out.print("숫자1:");
		num1 = sc.nextInt();
		
		System.out.print("숫자2:");
		num2 = sc.nextInt();
		
		System.out.println(num1 + "," + num2);
		
		int sum = num1 + num2;
		System.out.println(num1 + "+" + num2 + "=" + sum);
		System.out.println(num1 + "+" + num2 + "=" + (num1 + num2));
		System.out.println(num1 + "-" + num2 + "=" + (num1 - num2));
		System.out.println(num1 + "*" + num2 + "=" + (num1 * num2));
		System.out.println(num1 + "/" + num2 + "=" + (num1 / num2));
		System.out.println(num1 + "%" + num2 + "=" + (num1 % num2));

//		System.out.printf("",출력할대상);
		System.out.printf("%d/%d=%.2f", num1, num2, (double) num1 / num2);
	}
}
