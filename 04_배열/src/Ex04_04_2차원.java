

public class Ex04_04_2차원 {
	public static void main(String[] args) {
		
		int [] a = {1,2,3};
		int [][] score = {
						  {1,2,3},
						  {4,5,6},
						  {7,8,9},
						  {10,11,12}
						  }; //2차원 배열만드는 방법1
		
		int[][] score2 = new int[][]{
									  {1,2,3},
									  {4,5,6},
									  {7,8,9},
									  {10,11,12}
   								  }; //방법2

			  
		int[][] score3 = new int[4][3]; //방법3
		score3[0][0]=11;
		score3[3][2]=32;
		
		System.out.println(score3[0][0]);
		System.out.println(score3[0][1]);
		System.out.println(score3[3][2]);
		
		System.out.println();
		
		int i, j;
		for (i = 0; i < 4; i++) {
			for (j = 0; j < 3; j++) {
				System.out.print(score[i][j] + " ");
			}
			System.out.println();
		}

	} //main
} //class
