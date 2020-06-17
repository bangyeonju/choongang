import java.util.InputMismatchException;
import java.util.Scanner;

public class EX08_06_방연주 {
	public static void main(String[] args) {

		int i, j;
		Scanner sc = new Scanner(System.in);
		int[] my = new int[6];
		int count = 0;
		int[] lotto = new int[6];

		for (i = 0; i < lotto.length; i++) {
			lotto[i] = (int) (Math.random() * 45) + 1;

			// System.out.print(lotto[i] + " ");
			for (j = 0; j < i; j++) {
				if (lotto[i] == lotto[j]) {
					lotto[i] = (int) (Math.random() * 45) + 1;
					j = -1; // 증감식으로 가서 j++ -> 다시 j=0; //맨앞부터 비교하기위해
				}
			}
		}
		

		System.out.println();
		for (i = 0; i < lotto.length; i++) {

			System.out.print("숫자" + (i + 1) + ":");
//			try {
			my[i] = sc.nextInt();
//			}
//			catch(InputMismatchException e) {
//				System.out.println("숫자입력");
				
//			}
			for (j = 0; j < i; j++) {

				if (my[i] == my[j]) {
					System.out.println("중복됨 다시입력" + "숫자" + (i + 1) + ":");
					my[i] = sc.nextInt();
					j = -1; // 증감식으로 가서 j++ -> 다시 0번방부터 
				}
			}
			if (my[i] < 1 || my[i] > 45) {
				System.out.println("1~45사이의 수 입력하세요");
				i--;
				continue;
			}

		}
		System.out.println("컴이 발생시킨 로또번호");
		for (i = 0; i < 6; i++) {
			System.out.print(lotto[i] + " ");
		}
		System.out.println();
		System.out.println("내가 입력한 로또번호");
		for (i = 0; i < 6; i++) {
			System.out.print(my[i] + " ");
		}
		
		for(i=0;i<6;i++) {
			for(j=0;j<6;j++) {
				if(lotto[i]== my[j]) {
					count++;
				}
			}
		}
		System.out.println("맞은개수"+count);
		switch(count) {
		case 6: System.out.println("1등");
		case 5: System.out.println("2등");
		case 4: System.out.println("3등");
		default :
		}

	}
}

//숫자1: 3
//숫자2: 4
//숫자3: 12
//숫자4: 4
//중복됨 다시 숫자4: 12
//중복됨 다시 숫자4: 3
//중복됨 다시 숫자4: 43
//숫자5: 89
//1~45사이의 수 입력하세요.
//숫자5: 22
//숫자6: 33
//컴이 발생시킨 로또 번호
//2 19 32 15 43 7 
//
//내가 선택한 로또 번호
//3 4 12 43 22 33 
//
//맞은 갯수 : 1
//꽝!!
