import java.util.Scanner;

public class Ex03_06_for {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("╢э ют╥б:");
		
		int dan = sc.nextInt();
		
		int i;		
		for(i=1;i<=9;i++) {
		System.out.println(dan+"*"+i+"="+dan*i);
		}
		
		
	}
}
