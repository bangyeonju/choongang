import javax.swing.JOptionPane;

public class Ex10_02_Thread {

	public static void main(String[] args) {
		NumberPrint np = new NumberPrint();
		np.start();
		
		String input = JOptionPane.showInputDialog("�ƹ����̳� �Է��ϼ���");
		System.out.println("�Է��Ѱ��� " + input + " �Դϴ�.");
		
		System.out.println("���γ�");
	}

}
class NumberPrint extends Thread{
	public void run() {
		int i;
		for (i = 10; i > 0; i--) {
		System.out.println(i + " ");
		try {
			sleep(1000);
		} catch (Exception e) {
		}
	}
		
	}
}