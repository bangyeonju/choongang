interface Copymachine { // �������̽��ȿ��� �߻�޼��常 �����ִ�. �������̽��� ��ü�� ���������.
//public abstract void copy(); //���� �Ⱥ������� (public abstract)�� �⺻������ �ִ�. ��ӹ����� �ڽ��� �θ𺸴� ���ų�ū ���������ڸ� ����ؾ��Ѵ�.
	void copy();
	//final int abc = 1; 
	int abc = 1; // �ڵ����� final�� �ȴ�. 
}

interface Printmachine {
	void print();

}

interface Faxmachine {
	void fax();
}
class Ex {
	
}
//�������̽��� ��ӹ����� implements ����Ѵ�. //Ŭ������ ��ӹ����� extends (���߻�� �Ұ���)
//�������̽��� �ѹ��� ���������� ��ӹ����� �ִ�.(���߻�Ӱ���)
//Ŭ������ ���� ��ӹް� �״����� �������̽� ���!
class Compound extends Ex implements Copymachine, Printmachine, Faxmachine {
	
	 public void copy() { // ��ӹ����� �ڽ��� �θ𺸴� ���ų�ū ���������ڸ� ����ؾ��Ѵ�.
		System.out.println("�����Ѵ�.");
	}

	@Override
	public void print() {
		System.out.println("����Ʈ�Ѵ�.");

	}

	@Override
	public void fax() {
		System.out.println("�ѽ�������.");
	}
}// Compound

public class Ex06_11_�������̽� {
	public static void main(String[] args) {
		
		final int a=1; //final ���� �����Ҽ����� 
//		a= 3; ���� ���� �����Ҽ������Ҷ� ���
		
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
