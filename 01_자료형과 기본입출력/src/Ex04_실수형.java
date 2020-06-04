
public class Ex04_실수형 {
	public static void main(String[] args) {

		float f1 = 1.234f;

		double d1 = 1.234;
		double d2 = 1.234f;
		System.out.println("f1=" + f1);
		System.out.println("d1=" + d1);
		System.out.println("d2=" + d2);
		
		float f2 = 123;
		System.out.println("f2=" + f2);
		
//		int i1 = 123.4f;
		int i1 = (int)123.4f;
		System.out.println("i1=" + i1);
		
		double d3 =.789E3;
		System.out.println("d3="+d3);
	
		 d3 =.789E-3;
		System.out.println("d3="+d3);
		
		
		System.out.println();
		int a = 100;
		char b = 'A';
		float c = 123.456f;
		String d = "아이유"; 
		/*
		 * 정수 : %d
		 * char: %c
		 * String : %s
		 * 실수 : %f
		 */
		System.out.printf("a=" + a);
		System.out.println();
		System.out.printf("a=%d입니다.\n",a);
		System.out.printf("a=%5d입니다.\n",a);
		System.out.printf("b=%c입니다.\n",b);
		System.out.printf("b=%d입니다.\n",(int)b);
		System.out.printf("c=%f입니다.\n",c);
		System.out.printf("c=%.2f입니다.\n",c); //소수세번째자리에서 올림
		System.out.printf("c=%8.2f입니다.\n",c); //소수세번째자리에서 올림
		System.out.printf("d=%s입니다.\n",d); 
		
	
	}
}
