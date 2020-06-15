interface Copymachine { // 인터페이스안에는 추상메서드만 쓸수있다. 인터페이스로 객체를 만들수없다.
//public abstract void copy(); //눈에 안보이지만 (public abstract)가 기본적으로 있다. 상속받을때 자식은 부모보다 같거나큰 접근제어자를 사용해야한다.
	void copy();
	//final int abc = 1; 
	int abc = 1; // 자동으로 final이 된다. 
}

interface Printmachine {
	void print();

}

interface Faxmachine {
	void fax();
}
class Ex {
	
}
//인터페이스는 상속받을때 implements 사용한다. //클래스는 상속받을때 extends (다중상속 불가능)
//인터페이스는 한번에 여러가지를 상속받을수 있다.(다중상속가능)
//클래스를 먼저 상속받고 그다음에 인터페이스 상속!
class Compound extends Ex implements Copymachine, Printmachine, Faxmachine {
	
	 public void copy() { // 상속받을때 자식은 부모보다 같거나큰 접근제어자를 사용해야한다.
		System.out.println("복사한다.");
	}

	@Override
	public void print() {
		System.out.println("프린트한다.");

	}

	@Override
	public void fax() {
		System.out.println("팩스보낸다.");
	}
}// Compound

public class Ex06_11_인터페이스 {
	public static void main(String[] args) {
		
		final int a=1; //final 값을 변경할수없다 
//		a= 3; 절대 값을 변경할수없게할때 사용
		
		Compound c = new Compound();
		c.copy();
		c.print();
		c.fax();
		
		Printmachine p = new Compound(); 
		p.print();
		Copymachine copy = new Compound();
		copy.copy();
}
}
