
public class Ex05_03_�޼��� {
// �޼����???
// �ѹ��������� ��Ȱ��(����)?�ϴ°�??? 
//	�ϳ��� ���Ͽ��� �������� �޼ҵ尡 ���簡��  main �޼���� �ʼ� => �׻� main�޼������ ����!
	public static void main(String[] args) { // main�̶� �̸��� �������ִ� �޼��� => main �޼��� ����
		int a = 1 + 2;
		System.out.printf("a=%d\n", a);

		a = 3 + 4;
		System.out.printf("a=%d\n", a);

		add(10, 20); // add �޼��� ȣ�� (ȣ���ϴ°� ������ add�޼���� ����ɼ�����)
		System.out.println("-----------------------------------------");
		add(100, 200);
		System.out.println("**************************************");

		int returnValue = sub(10, 3, 2); // �޼���� �׻� ȣ���� �ڸ��� ��! return��!
		System.out.println("returnValue=" + returnValue);
		System.out.println(sub(5, 2, 1));

		int mulValue = mul();
		System.out.println("mulValue=" + mulValue);

	} // main

//		   void�� ����Ÿ�� �ڸ� /  return�Ǵ� ���� ������� void��!  //�Ű����� (int x, int y)
	static void add(int x, int y) { // add �޼��� ����!
		int z = x + y;
		prn();
		System.out.println("z=" + z);
		return; // ��������
	}

	static int sub(int x, int y, int z) { // sub �޼��� ����!

		// int result = x-y-z;
		// return x-y-z;
		int result = x - y - z;
		return result;

	}

	static int mul() { // mul �޼ҵ� ����!
		return 3 * 4;
	}

	static void prn() {
		System.out.println("===============");
	}
} // class
