 
public class Ex02_02_복합대입 {
	public static void main(String[] args) {
		int a = 10, b = 20, c = 30, d = 40, e = 50;

		System.out.println("a=" + a);
		// a = a + 3;
		a += 3;
		System.out.println("a=" + a);

		System.out.println("b=" + b);
		// b = b - 5;
		b -= 5;
		System.out.println("b=" + b);

		// c = c * 3;
		c *= 3;
		System.out.println("c=" + c);

		// d = d / 10 ;
		d /= 10;
		System.out.println("d=" + d);

		// e = e % 7;
		e %= 7;
		System.out.println("e=" + e);

		String fruit = "apple";
		// fruit = fruit + "banana";
		fruit += "banana";
		System.out.println("fruit:" + fruit);

	}
}
