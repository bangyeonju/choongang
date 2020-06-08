
public class Ex04_02_1차원_최대최소 {
	public static void main(String[] args) {

		int[] score = { 79, 88, 91, 33, 100, 55, 95 };
		int i = 0, sum = 0, max, min;
		for (i = 0; i < score.length; i++) {
			System.out.print(score[i] + " ");
			sum += score[i];
//			sum = sum +score[i];

		}
		System.out.println();
		System.out.println("sum:\n" + sum);
		System.out.printf("평균:%d\n",sum/score.length);

		// int[] score = { 79, 88, 91, 33, 100, 55, 95 };
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

		System.out.println("max:" + max);
		System.out.println("min:" + min);
		}

}
