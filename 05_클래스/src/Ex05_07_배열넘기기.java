
public class Ex05_07_�迭�ѱ�� {

	public static void main(String[] args) {
		int a = 1;
		int i;
		double b = 2.3;

		int[] src = { 3, 4, 5 };
		sub(a, b);

		for (i = 0; i < src.length; i++) {
			System.out.println(src[i]);
		}
		System.out.println();
		arr(src[0], src[1], src[2]);
		arr2(src);
		for (i = 0; i < src.length; i++) {
			System.out.println(src[i]);
		}
	}

	static void arr2(int[] des) { //�Ķ���Ͱ� ���� int[] src�� �Ȱ��� //des�� src�� ù�ּҸ� �޴´�!!!
		System.out.println("---arr2---");
		int i;
		for(i=0;i<des.length;i++) {
			System.out.println(des[i]);
		}
		des[1]=10;
		System.out.println("----------");
	}

	static void arr(int a, int b, int c) {
		System.out.println(a + "," + b + "," + c);

	}

	static void sub(int a, double b) {// main�޼ҵ�� static �޼ҵ带 �������ִ� static�޼ҵ�� static�޼ҵ常 ȣ�Ⱑ����!
		System.out.println(a + "," + b);
	}
}
