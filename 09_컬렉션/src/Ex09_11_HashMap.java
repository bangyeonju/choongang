import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Ex09_11_HashMap {
	public static void main(String[] args) {
		HashMap<String, String> dic = new HashMap<String, String>();
		dic.put("pencil", "����");
		dic.put("sky", "�ϴ�");
		dic.put("desk", "å��");
		dic.put("face", "��");
		System.out.println("dic" + dic);
		Scanner sc = new Scanner(System.in);
		String word;

		do {

			System.out.print("ã�� �ܾ��?(q�Է½� ����)");
			word = sc.next();

			if (word.equals("q")) {// ����������(�����ϴ�)���� ���� �ۼ�!!!
				break;
			}
			if (dic.get(word) == null) { // ���� �Է��� ���� dic�ؽ� value�� ���� ���϶�
//			if(dic.containsKey(word)==false) { //���� �Է��Ѱ��� dic�� ����x 
				System.out.println("�߸��Է��ϼ���!");
			} else {
				System.out.println("��:"+dic.get(word));
				
			}

		} while (true);
		System.out.println("���α׷��� �����մϴ�.");

	}
}
