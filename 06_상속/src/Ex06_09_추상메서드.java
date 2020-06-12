
abstract class Shape { //추상클래스 미완성메서드를 가지고있
	void make() {
		System.out.println("도형그리기");
	}
	abstract void draw();//-->미완성 메소드 (추상메서드) 
	abstract void delete();
	Shape(){
		System.out.println("Shape 생성자");//Circle생성자에서 호츌함
	}
}// Shape

class Circle extends Shape {
//	Circle(){
//		super(); --> 이것을 통행 Shape생성자호츌
//	} 생략되어있다
	@Override
	void draw() {
		System.out.println("원을그린다.");
	}
//	void draw() {
//		System.out.println("원을그린다.");
//	}
	void delete() {
		System.out.println("원을 지운다");
	}
}// Circle

 class Triangle extends Shape {
	 void draw() {
		 System.out.println("삼각형을 그린다");
	 }
	@Override //어노테이션(annotation)
	void delete() {
		System.out.println("삼각형을 지운다.");
	}
	
}// Triangle

public class Ex06_09_추상메서드 {
	public static void main(String[] args) {
		
//		Shape s = new Shape(); 추상클래스로는 객체를 만들수가 없다.
		
		Circle c = new Circle();
		c.make();
		c.draw();
		c.delete();
		
		Triangle t = new Triangle();
		t.make();
		t.draw();
		t.delete();
	}

}
