
public class Ex02_03_증감 {

	public static void main(String[] args) {

		int a = 5, b = 5, c, d;

		System.out.println("a=" + a); // a=5
		++a; // a++; //a = a+1; a+=1;

		System.out.println("a=" + a); // a=6
		System.out.println();
		
		a=5;
		c = ++a; // 변수 앞++ 먼저
		System.out.println("a=" + a);
		System.out.println("c=" + c);
		
		b=5;
		d = b++; // 변수 뒤++ 나중에
		System.out.println("b=" + b);
		System.out.println("d=" + d);
		System.out.println();
		
		
		a=5;
		System.out.println("a="+a);
		System.out.println(++a); //6
		System.out.println(a++); //6 나중에 증가
		System.out.println(a); //7
		
		a=5;
		System.out.println("a="+a);
		c = a--;
		System.out.println("a="+a);
		System.out.println("c=" +c);
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
