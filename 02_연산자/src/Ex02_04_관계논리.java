
public class Ex02_04_����� {
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

		// && : �� and ������
		c = a > 10 && b > 10; // false &&(and) true ==> false
		System.out.println("c:" + c);
		
		// || : �� or ������
		c = a > 10 || b > 10; // false ||(or) true ==> true
		System.out.println("c:" + c);
		
		// !(not������) : T=>f	F=>T
		System.out.println("c:" + !c);
	}
}
