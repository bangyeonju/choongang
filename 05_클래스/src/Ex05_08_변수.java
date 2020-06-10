class Var {
	static int a; // static변수 = class 변수 //여러객체가 공유해서 쓴다. // static 변수에는 자동으로 0이들어가있는다
	int b; // instance 변수 //instance변수도 자동으로 0이 들어가있는다

	
	
	
	void increment() { //호출되어야 int c가 생성된다!
		int c=0; // 지역 변수
		a++; b++; c++; // c는 자동으로 초기화되지않는다!
		System.out.println("static변수:"+a);
		System.out.println("instance변수:"+b);
		System.out.println("지역변수:"+c);
		System.out.println();

	}
}

public class Ex05_08_변수 {
	public static void main(String[] args) {
		System.out.println("객체1생성");
		Var v1 = new Var();// 객체생성
		v1.increment();
		v1.increment();
		
		System.out.println("객체2생성");
		Var v2 = new Var();// 객체생성
		v2.increment();
		v2.increment();
		
		System.out.println("객체3생성");
		Var v3 = new Var();// 객체생성
		v3.increment();
		v3.increment();
	}
}
