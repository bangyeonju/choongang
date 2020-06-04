
public class Ex02_04_관계논리 {
	public static void main(String[] args) {

		int a = 10;
		int b = 20;

		boolean c = a <= b;
		System.out.println("c:" + c);

		c = a == b;
		System.out.println("c:" + c);

		c = a != b;
		System.out.println("c:" + c);

		System.out.println();

		// && : 논리 and 연산자
		c = a > 10 && b > 10; // false &&(and) true ==> false
		System.out.println("c:" + c);
		
		// || : 논리 or 연산자
		c = a > 10 || b > 10; // false ||(or) true ==> true
		System.out.println("c:" + c);
		
		// !(not연산자) : T=>f	F=>T
		System.out.println("c:" + !c);
	}
}
