class Car {
	String color = "white";
	int door = 4;

	void drive() {
		System.out.println("Cardrive");

	}

	void stop() {
		System.out.println("Carstop");
	}

}// Car

class FireEngine extends Car {
	int door = 6;
	int wheel = 10;

	void drive() {
		System.out.println("FEdrive");
	}

	void water() {
		System.out.println("water!");
	}
}// fireEngine

public class Ex06_07_������ {
	public static void main(String[] args) {
		double a = (double)1; //(double)��������
		int b=(int)3.2;//(int)�����Ұ���
		
		Car c = null;
		FireEngine fe = new FireEngine();
		FireEngine fe2 = null;
		
		fe.water();
		c =(Car)fe; // �ڽ��� �ڱ���� ������ �ڽŰ� ���ͻ���ϰ�, �ڽ� ���̾����� �θ����� �����ؼ� ����Ѵ�. //(Car)�������� //��ĳ����(�ڽ�Ÿ��->�θ�Ÿ��) �ڵ����� 
		System.out.println(c.door);//4
		System.out.println(c.color);//white
//		System.out.println(c.wheel); �θ�� �ڽĿ��� �����Ҽ�����.
		System.out.println(fe.door);
		System.out.println(fe.color);
		System.out.println(fe.wheel);
		System.out.println("---");
//					*������ �޼����� ū ����*
		c.drive(); //why Cardrive�� �ȳ����°�?
//					�θ� drive�� ������ ���� 
//			 		�θ� drive�� ������  -> �ڽĿ� drive�޼��尡 �ִ��� Ȯ���ϰ� ->�ڽ� driveȣ�� 
		fe.drive();
		
		if (c instanceof FireEngine) {
			System.out.println("�ٿ�ĳ���ð���");
		} else {
			System.out.println("�ٿ�ĳ���� �Ұ���");
		}
		
		fe2=(FireEngine)c; //(FireEngine)���� �Ұ��� //�ڽĿ� �θ� �������� Ÿ���� ���߾� �־���Ѵ�.~
		//�ٿ�ĳ����(�θ�Ÿ��->�ڽ�Ÿ��) �ٿ�ĳ������ ��ĳ�����ؾ� ? ��밡��?
		
		fe2.water();
		fe2.drive();
		
	}
	
} 








