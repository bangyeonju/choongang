
public class Ex05_09_���ȣ�� {
	public static void main(String[] args) {
		show(3);
	}
	static void show(int cnt) {
		System.out.println("Hey~~~"+cnt);
		if (cnt ==1)
			return; // ȣ��Ȱ����� ���ϵ�?
		show(--cnt); // ���ȣ�� ���� ���� �θ��°�!)
		
	}
}
