
public class Ex03_07_����for {
	public static void main(String[] args) {
		int i, j;
		for (i = 1; i <= 3; i++) {

			for (j = 5; j <= 7; j++) {

				System.out.println(i + "," + j);
			} // ���� for��

			System.out.println("==========");
		} // �ٱ��� for��

		System.out.println("**********************");

		// 2��~9�ܱ��� ������ ���
		for (i = 2; i < 10; i++) {
			System.out.println(i+"��");
			for (j = 1; j < 10; j++) {
				System.out.println(i + "*" + j + "=" + i * j);
			}
			System.out.println("------------------");
		}
		System.out.println("**************");

	}

}
