
class Clac {

	int i = 1; // �������
	static int j = 2;

	int add(int a, int b) { // �ν��Ͻ� �޼ҵ�(�Լ�)
		System.out.println(i);
		System.out.println(j);
		prn1(); // ���� Ŭ�����ȿ��� �޼��忡 ȣ�� �Ҷ� �׳� �ż���ȣ�� c.prn1();,Calc.prn2(); x
		prn2();
		int sum = a + b;
		return sum;
	}

	int sub(int a, int b) {
		return a - b;
	}

	static int mul(int a, int b) { // static �޼ҵ�
		// System.out.println(i); //static �޼ҵ忡���� static������ ��밡��!
		System.out.println(j);
//		prn1(); static �޼���ȿ����� static�޼��常 ȣ���Ҽ� �ִ�. prn1();�� �ν��Ͻ�..?ȣ���氡��
		prn2();
		return a * b;
	}

	void prn1() {
		System.out.println("--------------------------------");
	}

	static void prn2() {
		System.out.println("************************************");
	}
}

public class Ex05_04_�޼��� { // ����Ŭ����

	public static void main(String[] args) {
		Clac c = new Clac();

//		System.out.println(c.add(10, 20));

		int result = c.add(10, 20);
		System.out.println("result:" + result);

		int subresult = c.sub(100, 30);
		System.out.println("subresult:" + subresult);

		int mulresult = Clac.mul(3, 5); // c.mul(3,5)
		System.out.println("mulresult:" + mulresult);
		int returndiv = div(10, 5);// main���� ȣ��� main�޼���� static�޼ҵ��̹Ƿ� div�޼ҵ带 ȣ���Ϸ��� static�� �־���Ѵ�....

		System.out.println("returndiv=" + returndiv);

		Ex05_04_�޼��� ex = new Ex05_04_�޼���(); // 2.��ü������ �ؾ� namergi�޼ҵ带 ȣ�Ⱑ��
		System.out.println("namergi���ϰ�:" + ex.namergi(10, 5));

	}

	static int div(int a, int b) { // main
		int divresult = a / b;
		return divresult;
	}

	int namergi(int a, int b) { // 1.static�� ������ �ʴ´ٸ�
		int naresult = a % b;
		return naresult;

	}

}
