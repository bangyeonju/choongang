
public class Ex03_11_break_continue {
	public static void main(String[] args) {
		int i, j;

		for (i = 2; i < 10; i++) {
			if (i % 2 == 1) {
				continue; // Ȧ���� �Ʒ� for�� ���� x
//				break;
			}
			for (j = 1; j < 10; j++) {
				if (i < j) {
					break;
				}
				System.out.printf("%d*%d=%d\n", i, j, i * j);

			}
			System.out.println();
		}
	}
}
