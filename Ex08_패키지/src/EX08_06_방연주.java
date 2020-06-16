import java.util.Scanner;

public class EX08_06_방연주 {
	public static void main(String[] args) {

		int i,j;
		Scanner sc = new Scanner(System.in);
		int[] my = new int[6];
		int count = 0;
		int[] lotto = new int[6];
		for (i = 0; i < 6; i++) {
			lotto[i] = (int) (Math.random() * 45) + 1;
			System.out.print(lotto[i]+" ");
			
		
			
		//	System.out.print(lotto[i] + " ");

		}
		System.out.println();
		for (i = 0; i < lotto.length; i++) {
			System.out.print("숫자"+(i+1)+":");
			my[i] = sc.nextInt();
		}

		for (i = 0; i < lotto.length; i++) {
			System.out.print(my[i] + " ");
		}
//		for (i = 0; i < lotto.length; i++) {
//			for (j=0;)
//			
//		}

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
