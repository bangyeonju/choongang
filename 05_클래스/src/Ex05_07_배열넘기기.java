
public class Ex05_07_배열넘기기 {

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

	static void arr2(int[] des) { //파라미터값 형식 int[] src와 똑같이 //des는 src의 첫주소를 받는다!!!
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

	static void sub(int a, double b) {// main메소드는 static 메소드를 가지고있다 static메소드는 static메소드만 호출가능함!
		System.out.println(a + "," + b);
	}
}
