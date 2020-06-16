import java.util.Scanner;

public class Ex08_02_String {
	public static void main(String[] args) {

		int a = 1, b = 2;
		System.out.println(a == b); // �Ϲݺ����� ���Ҷ� ==���

		String str1 = new String("Have a nice day"); // ��ü����
		String str2 = new String("Have A nice day");

		System.out.println("str1:" + str1);
		System.out.println("str1�� ����:" + str1.length());
		System.out.println(str1.equals(str2));// String�� equals ���ڿ���

		if (str1.equals(str2)) {
			System.out.println("str1��str2���ڿ� ����");

		} else {
			System.out.println("str1��str2���ڿ� ��������");
		}
		System.out.println(str1.equalsIgnoreCase(str2)); // ��ҹ��� �����ϰ� ���ڿ� �� Have a nice day, Have A nice day �� ==>true

		System.out.println(str1.concat(str2));// �ι��ڿ��� ����! => Have a nice dayHave A nice day
		System.out.println(str1 + str2);

		System.out.println(str1 == str2);// ����� ���ڿ��� ���Ҷ��� �ּҺ�
		System.out.println(str1.compareTo(str2)); // *str1��str2�ǰ��� �������� �Ȱ��ٸ� 0����* �ٸ��� �޶����� ù���ڸ� ����ƽ�Ű�ڵ尪�� str1-str2

		// ��ġ�� ã���� indexof���
		System.out.println(str1.indexOf("nice"));// nice�� n�� 7��° ��ġ�� �ִ� H:0 a:1 v:2 n:7
		System.out.println(str1.indexOf("happy"));// str1�� happy�� �����Ƿ� -1���
		System.out.println(str1.lastIndexOf("a"));// �ڿ������� a�� ã�´� a:13

		System.out.println(str1.contains("nice")); // str1�� nice�� �����ϸ� true
		System.out.println(str1.contains("happy"));// 		happy�� ���ٸ� false

		System.out.println(str1.charAt(3));// 3��°��ġ�� �ִ� ���� ���
		char c = str1.charAt(3);
		System.out.println("c:" + c);
		System.out.println();

		System.out.println(str1.substring(7, 10));// 7~9���� 10x
		System.out.println(str1.substring(7));// 7���� ������

		System.out.println(str1.replace("a", "x"));// str1�� �ִ� ����a�� x�κ���
		System.out.println("str1:" + str1);// �ٽ� ������� ���

		String s = "   abc  De   Fg     ";
		System.out.println("s:" + s);
		System.out.println(s.trim());// ���ڿ��� �Ǿյڰ�������
		s = s.trim();
		System.out.println("s:" + s); // ����Ȼ��¸� �����ϰ� �ʹٸ�

		System.out.println();
		System.out.println(s.toUpperCase()); // �빮�ڷκ���
		System.out.println(s.toLowerCase());// �ҹ��ڷκ���
		System.out.println();

		String fullName = "Hello.java";
		String fileName;// Hello
		String ext;// java
		int pos = fullName.indexOf(".");
		System.out.println("pos:"+pos);
		fileName =  fullName.substring(0,5);
		ext = fullName.substring(pos+1);
		System.out.println("ȭ�ϸ�:"+fileName);
		System.out.println("Ȯ����"+ext);

		String id ="kim";
		String pw = "1234";
		
		Scanner sc = new Scanner(System.in);
		System.out.print("���̵� �Է�");
		String inputId = sc.next();
		System.out.print("��й�ȣ �Է�");
		String inputPw = sc.next();
		
		if(pw.equals(inputPw) && pw.equals(inputPw)) {
			System.out.println("�α��ΰ���");
		}else {
			System.out.println("�α��� �Ұ���");
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
