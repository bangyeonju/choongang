
abstract class Shape { //�߻�Ŭ���� �̿ϼ��޼��带 ��������
	void make() {
		System.out.println("�����׸���");
	}
	abstract void draw();//-->�̿ϼ� �޼ҵ� (�߻�޼���) 
	abstract void delete();
	Shape(){
		System.out.println("Shape ������");//Circle�����ڿ��� ȣ����
	}
}// Shape

class Circle extends Shape {
//	Circle(){
//		super(); --> �̰��� ���� Shape������ȣ��
//	} �����Ǿ��ִ�
	@Override
	void draw() {
		System.out.println("�����׸���.");
	}
//	void draw() {
//		System.out.println("�����׸���.");
//	}
	void delete() {
		System.out.println("���� �����");
	}
}// Circle

 class Triangle extends Shape {
	 void draw() {
		 System.out.println("�ﰢ���� �׸���");
	 }
	@Override //������̼�(annotation)
	void delete() {
		System.out.println("�ﰢ���� �����.");
	}
	
}// Triangle

public class Ex06_09_�߻�޼��� {
	public static void main(String[] args) {
		
//		Shape s = new Shape(); �߻�Ŭ�����δ� ��ü�� ������� ����.
		
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
