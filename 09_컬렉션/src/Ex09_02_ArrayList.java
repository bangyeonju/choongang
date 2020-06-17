import java.util.ArrayList;

public class Ex09_02_ArrayList {
	public static void main(String[] args) {
		ArrayList<String> al = new ArrayList<String>(); // ���ڿ��� Ȯ�������!
		System.out.println("al.size():" + al.size());// al:[����, �¾�, ����, ȿ��, ����]
		al.add("����");
		al.add("�¾�");
		al.add("����");// ����
		al.add("ȿ��");
		al.add("����");// �������� �ߺ��� ����Ѵ�. ����
		System.out.println("al:" + al.toString());
		System.out.println("al.size():" + al.size());
		System.out.println(al.get(0));// arrayLish �����ð��ִ�*
		System.out.println(al.get(2));
//		length:�迭�� ���� ����
//		length():���ڿ��ǰ���
//		size():�÷��� ��������� ũ��

		al.add(1, "����");// Ư�� ��ġ�� ���԰��� al:[����, ����, �¾�, ����, ȿ��, ����]
//		al.add(10, "����"); error
		System.out.println("al:" + al.toString());

		String s = "hello";
		System.out.println("s:" + s.toString());// ��Ұ��̾ȳ����� toString�� �������̵����־ ���̳��´�
//		System.out.println(str.length());

		ArrayList<String> add = new ArrayList<String>();
		add.add("������");
		add.add("����");

		al.addAll(add);
		System.out.println(al.toString());
		System.out.println(al.size());

		String str = al.remove(1);// ��ġ�ε���
		boolean b = al.remove("����");//
		System.out.println(al.toString());
		System.out.println(al.size());
		System.out.println(str + "," + b);
		al.add("����");
		System.out.println(al.toString());

		ArrayList<String> rm = new ArrayList<String>();
		rm.add("����");
		
		al.removeAll(rm);
		System.out.println(al.toString());
		System.out.println(al.size());
		
		int pos = al.indexOf("ȿ��");		
		System.out.println("pos"+pos);
		pos = al.indexOf("����");
		System.out.println("pos"+pos);// 0���� �������� ������ ����
		
		boolean isExist = al.contains("ȿ��");
		System.out.println("isExist:"+isExist);
		
		isExist = al.contains("����");
		System.out.println("isExist:"+isExist);
		
		
		al.set(1, "����");
		System.out.println(al.toString());
		System.out.println(al.size());
		
		
		al.clear();
		System.out.println(al.toString());
		System.out.println(al.size());
		
		
		ArrayList<Integer> al2 = new ArrayList<Integer>(); // integer������!
		al2.add(10);
		al2.add(20);
		al2.add(30);
		System.out.println("al2:" + al2.toString());// ArrayList�� ���� �ƹ����� �Ҿƹ������Լ� toString�� ��ӹ޾� �ּҰ��̾ƴϰ� ���̳��´�.
		System.out.println("al2.size():" + al2.size());
		System.out.println(al2.get(1));// �Է°��� ���� integer��string �� return���� �ٸ���.

	}
}
///�÷����� �ڵ����� �޸𸮸� Ȯ���Ҽ����ִ�.
//�������� �޸��� ��Ȯ���Ҽ��̵���.
