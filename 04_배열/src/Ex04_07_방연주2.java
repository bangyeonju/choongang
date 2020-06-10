import java.util.Scanner;

public class Ex04_07_방연주2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int num, stuNum = 0, i, total = 0, max, min, j, temp;
		float avg;
		int[] score = null;
		while (true) {

			System.out.println("-----------------------------------------");
			System.out.println("1.학생수|2.점수입력|3.점수목록|4.분석|5.종료"); // 종료부터 코드 작성할것!
			System.out.println("-----------------------------------------");
			System.out.print("번호선택>>");
			num = sc.nextInt();
			switch (num) {
			case 1:
				System.out.print("학생수 입력 >>");
				stuNum = sc.nextInt();

				score = new int[stuNum];
				break;
			case 2:
				System.out.println("2.점수입력");
				if (score == null) {
					System.out.println("1번 학생수 부터 입력하세용~");
					continue; // *while문에서 continue만나면 밑으로 내려가지 못하게 함 --> 조건식으로 감whil(true)! *for문에서는
								// -->증감식으로감
				}
				for (i = 0; i < score.length; i++) {
					System.out.printf("%d번 학생점수", i + 1);

					score[i] = sc.nextInt();
				}
				break;
			case 3:

				System.out.println("3.점수목록");
				if (score == null) {
					System.out.println("1번 학생수부터 입력하세용~");
					continue;
				}
				for (i = 0; i < score.length; i++) {
					System.out.printf("%d번 학생점수: %d점\n", i + 1, score[i]);
				}
				break;
			case 4:
				if (score == null) {
					System.out.println("1번 학생수부터 입력하세용ㅇ");
					continue;
				}
				System.out.println("4.분석");
				for (i = 0; i < score.length; i++) {
					total = score[i] + total;
				}
				System.out.printf("총점:%d\n", total);
				avg = (float) total / stuNum;
				System.out.printf("평균:%.2f\n", avg);
				max = score[0];
				min = score[0];
				for (i = 1; i < score.length; i++) {
					if (max < score[i]) {
						max = score[i];
					}
					if (min > score[i]) {
						min = score[i];
					}

				}
				System.out.printf("최대값:%d", max);
				System.out.printf("최소값:%d", min);
				System.out.println();

				// 정렬
				for (i = 0; i < score.length - 1; i++) {
					for (j = i + 1; j < score.length; j++) {
						if (score[i] > score[j]) {
							temp = score[j];
							score[j] = score[i];
							score[i] = temp;
						}
					}
				}
				for (i = 0; i < score.length; i++) {
					System.out.print(score[i] + " ");
				}
				System.out.println();
				break;
			case 5:
				System.out.println("5.종료");
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
				
			default:
			
				System.out.println("1~5사이의 번호만 입력 가능합니다.");

			}//switch

			

		}//while

	}
}