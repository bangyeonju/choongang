
public class Ex07_04_NullError {

	public static void main(String[] args) {
		int a;
		try {
			String str = "banana";
			System.out.println(str.length()); // ���ܰ� �߻���
			System.out.println("try ���̴�");
			// new NullPointerException(); ->Ŭ���� *��ü�� �ڵ����� �������! *
			a = 3 / 0;
			System.out.println("a:" + a);
			int[] arr = { 1, 2, 3 };
			System.out.println(arr[4]); // new ArrayIndexOutOfBoundsException(); ��ü�� ���������.
			
		} 
	
		catch (NullPointerException e1) {
			System.out.println("null�� �ʱ�ȭ�� ���� ���Ұ�");
			System.out.println(e1.toString());
			System.out.println(e1.getMessage());

		} catch (ArithmeticException e2) {
			System.out.println("0���� ����");
			System.out.println(e2.toString());
			System.out.println(e2.getMessage());
			
		} catch (ArrayIndexOutOfBoundsException e3) {
			System.out.println("@3������ �����ϴ�@");
		}	
		catch(Exception e) { //exception�� nullpointexception,arridextoutofboundsexception��� �θ� ,Exception�� ������ catch����*
			System.out.println(e.toString()); //��� ������ �⤷�����մ�
		}
		 finally { // ���ܰ� �߻� �ϴ� ���ϴ� ������ ó��!
			System.out.println("finally ���� ����");
		}
		System.out.println("����ó��");

	}

}
