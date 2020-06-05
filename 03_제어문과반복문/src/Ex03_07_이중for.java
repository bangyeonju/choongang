
public class Ex03_07_이중for {
	public static void main(String[] args) {
		int i, j;
		for (i = 1; i <= 3; i++) {

			for (j = 5; j <= 7; j++) {

				System.out.println(i + "," + j);
			} // 안쪽 for문

			System.out.println("==========");
		} // 바깥쪽 for문

		System.out.println("**********************");

		// 2단~9단까지 구구단 출력
		for (i = 2; i < 10; i++) {
			System.out.println(i+"단");
			for (j = 1; j < 10; j++) {
				System.out.println(i + "*" + j + "=" + i * j);
			}
			System.out.println("------------------");
		}
		System.out.println("**************");

	}

}
